package Formularios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class UsuarioTest {

    private static final String TEST_PROPERTIES_FILE = "test_usuario.properties";
    private static final String CORRUPTED_PROPERTIES_FILE = "corrupted_usuario.properties";
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        // Ensure a clean state before each test by deleting potential leftover files
        deleteTestFile(TEST_PROPERTIES_FILE);
        deleteTestFile(CORRUPTED_PROPERTIES_FILE);
    }

    @AfterEach
    void tearDown() {
        // Clean up files after each test
        deleteTestFile(TEST_PROPERTIES_FILE);
        deleteTestFile(CORRUPTED_PROPERTIES_FILE);
    }

    private void deleteTestFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSumarPts() {
        usuario.pts = 10;
        usuario.sumar_pts(5, usuario.pts); // This is a bit unusual, typically it would be usuario.sumar_pts(5) and internally it would do pts += 5
        assertEquals(15, usuario.pts, "Los puntos deberían ser 15 después de sumar 5 a 10.");

        // Test with current implementation: sumar_pts(newValue, currentValue) -> pts = newValue + currentValue
        // This means the method is more like a "set sum of two numbers" rather than "add to current points"
        // Let's test according to its actual behavior:
        usuario.pts = 0; // Reset
        usuario.sumar_pts(5, 10); // pts should become 5+10 = 15
        assertEquals(15, usuario.pts, "Los puntos deberían ser 15.");

        usuario.sumar_pts(0, 5); // pts should become 0+5 = 5
        assertEquals(5, usuario.pts, "Los puntos deberían ser 5.");

        usuario.sumar_pts(-5, 10); // pts should become -5+10 = 5
        assertEquals(5, usuario.pts, "Los puntos deberían ser 5.");
        
        // If sumar_pts was intended to be additive like: public void sumar_pts(int pointsToAdd) { this.pts += pointsToAdd; }
        // Then the tests would be:
        // Usuario u = new Usuario();
        // u.pts = 10;
        // u.sumar_pts(5);
        // assertEquals(15, u.pts);
        // u.sumar_pts(0);
        // assertEquals(15, u.pts);
        // u.sumar_pts(-2);
        // assertEquals(13, u.pts);
    }

    @Test
    void testCambiarNom() {
        usuario.cambiar_nom("NuevoNombre");
        assertEquals("NuevoNombre", usuario.nombre, "El nombre debería ser 'NuevoNombre'.");
    }

    @Test
    void testGuardarYCargarDatos() {
        Usuario usuario1 = new Usuario();
        usuario1.setPropertiesFilename(TEST_PROPERTIES_FILE);
        usuario1.cambiar_nom("TestUser");
        usuario1.pts = 0; // Ensure starting from a known state before "sumar_pts"
        usuario1.sumar_pts(100, 0); // pts = 100 + 0 = 100

        usuario1.guardar_datos();

        Usuario usuario2 = new Usuario();
        usuario2.setPropertiesFilename(TEST_PROPERTIES_FILE);
        usuario2.cargar_datos();

        assertEquals("TestUser", usuario2.nombre, "El nombre cargado debería ser 'TestUser'.");
        assertEquals(100, usuario2.pts, "Los puntos cargados deberían ser 100.");
    }

    @Test
    void testCargarDatosFileNotFound() {
        usuario.setPropertiesFilename("non_existent_usuario.properties");
        usuario.cargar_datos();
        assertEquals("Invitado", usuario.nombre, "El nombre debería ser 'Invitado' si el archivo no existe.");
        assertEquals(0, usuario.pts, "Los puntos deberían ser 0 si el archivo no existe.");
    }

    @Test
    void testCargarDatosNumberFormatException() {
        // Create a corrupted properties file
        Properties props = new Properties();
        props.setProperty("nombre", "CorruptedUser");
        props.setProperty("pts", "not_a_number");
        try (OutputStream output = new FileOutputStream(CORRUPTED_PROPERTIES_FILE)) {
            props.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false, "No se pudo crear el archivo de propiedades corrupto para el test.");
        }

        usuario.setPropertiesFilename(CORRUPTED_PROPERTIES_FILE);
        usuario.cargar_datos();

        // Behavior based on Usuario.java: nombre should load, pts should default to 0
        assertEquals("CorruptedUser", usuario.nombre, "El nombre debería cargarse desde el archivo corrupto.");
        assertEquals(0, usuario.pts, "Los puntos deberían ser 0 debido a NumberFormatException.");
    }
}
