package Formularios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IdiomaTest {

    @BeforeEach
    void setUp() {
        // Ensure language is reset to Spanish before each test
        // The default is Spanish (idiomaIngles = false)
        if (Idioma.esIngles()) {
            Idioma.cambiarIdioma(); // Change from English back to Spanish
        }
    }

    @Test
    void testInitialLanguageIsSpanish() {
        assertFalse(Idioma.esIngles(), "Idioma.esIngles() should be false initially (Spanish).");
        assertEquals("Menú Principal", Idioma.getTexto("menu_principal"), "Initial text for 'menu_principal' should be in Spanish.");
    }

    @Test
    void testCambiarIdioma() {
        // Initial state is Spanish (verified by setUp and testInitialLanguageIsSpanish)
        assertFalse(Idioma.esIngles(), "Should be Spanish before first change.");
        assertEquals("Menú Principal", Idioma.getTexto("menu_principal"), "Text should be Spanish.");

        // Change to English
        Idioma.cambiarIdioma();
        assertTrue(Idioma.esIngles(), "Idioma.esIngles() should be true after first change (English).");
        assertEquals("Main Menu", Idioma.getTexto("menu_principal"), "Text for 'menu_principal' should be in English after first change.");

        // Change back to Spanish
        Idioma.cambiarIdioma();
        assertFalse(Idioma.esIngles(), "Idioma.esIngles() should be false after second change (Spanish).");
        assertEquals("Menú Principal", Idioma.getTexto("menu_principal"), "Text for 'menu_principal' should be in Spanish after second change.");
    }

    @Test
    void testGetTextoValidKeySpanish() {
        // setUp ensures language is Spanish
        assertFalse(Idioma.esIngles(), "Language should be Spanish for this test.");
        assertEquals("Ajustes", Idioma.getTexto("ajustes"), "Text for 'ajustes' should be in Spanish.");
        assertEquals("Informática", Idioma.getTexto("informatica"), "Text for 'informatica' should be in Spanish.");
    }

    @Test
    void testGetTextoValidKeyEnglish() {
        // Change to English for this test
        Idioma.cambiarIdioma();
        assertTrue(Idioma.esIngles(), "Language should be English for this test.");
        assertEquals("Settings", Idioma.getTexto("ajustes"), "Text for 'ajustes' should be in English.");
        assertEquals("Informatics", Idioma.getTexto("informatica"), "Text for 'informatica' should be in English.");
    }

    @Test
    void testGetTextoInvalidKey() {
        // Language is Spanish by default from setUp
        assertFalse(Idioma.esIngles(), "Language should be Spanish for the first part of this test.");
        assertEquals("Texto no encontrado", Idioma.getTexto("clave_invalida"), "Text for 'clave_invalida' should be 'Texto no encontrado' in Spanish.");

        // Change to English
        Idioma.cambiarIdioma();
        assertTrue(Idioma.esIngles(), "Language should be English for the second part of this test.");
        assertEquals("Texto no encontrado", Idioma.getTexto("clave_invalida_ingles"), "Text for 'clave_invalida_ingles' should be 'Texto no encontrado' in English.");
    }

    @Test
    void testGetTextoAfterMultipleLanguageChanges() {
        // Initial state is Spanish (from setUp)

        // 1. Spanish -> English
        Idioma.cambiarIdioma();
        assertTrue(Idioma.esIngles(), "After 1 change, should be English.");

        // 2. English -> Spanish
        Idioma.cambiarIdioma();
        assertFalse(Idioma.esIngles(), "After 2 changes, should be Spanish.");

        // 3. Spanish -> English
        Idioma.cambiarIdioma();
        assertTrue(Idioma.esIngles(), "After 3 changes, should be English.");
        assertEquals("Credits", Idioma.getTexto("creditos"), "Text for 'creditos' should be 'Credits' (English).");

        // 4. English -> Spanish
        Idioma.cambiarIdioma();
        assertFalse(Idioma.esIngles(), "After 4 changes, should be Spanish.");
        assertEquals("Créditos", Idioma.getTexto("creditos"), "Text for 'creditos' should be 'Créditos' (Spanish).");
    }
}
