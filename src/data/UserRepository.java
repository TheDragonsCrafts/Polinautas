package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import Formularios.Usuario;

public class UserRepository {

    public void saveUsuario(Usuario usuario) {
        Properties properties = new Properties();
        properties.setProperty("nombre", usuario.nombre);
        properties.setProperty("pts", String.valueOf(usuario.pts));

        try (FileOutputStream out = new FileOutputStream("usuario.properties")) {
            properties.store(out, "User Data");
        } catch (IOException e) {
            System.err.println("Error saving user data: " + e.getMessage());
            e.printStackTrace(); // Or a more sophisticated error handling
        }
    }

    public Usuario loadUsuario() {
        Usuario usuario = new Usuario(); // Create a new Usuario with default values
        Properties properties = new Properties();

        try (FileInputStream in = new FileInputStream("usuario.properties")) {
            properties.load(in);
            usuario.nombre = properties.getProperty("nombre", "Invitado"); // Default to "Invitado" if not found
            // Safely parse points, defaulting to 0 if there's an error or it's not found
            try {
                usuario.pts = Integer.parseInt(properties.getProperty("pts", "0"));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing points from properties: " + e.getMessage());
                usuario.pts = 0; // Default to 0 if parsing fails
            }
        } catch (IOException e) {
            // File might not exist on first run, or other IO error
            // In this case, the default values of the new Usuario("Invitado", 0) will be used.
            System.out.println("No user data file found or error loading: " + e.getMessage());
            // Ensure defaults are set if file not found or error (already handled by Usuario constructor and above defaults)
             usuario.nombre = "Invitado";
             usuario.pts = 0;
        }
        return usuario;
    }
}
