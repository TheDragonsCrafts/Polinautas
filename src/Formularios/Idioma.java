/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Rodol
 */
public class Idioma {//clase para guardar y cambiar los datos del idioma
    private static boolean idiomaIngles = false; // false = Español, true = Inglés

    // Mapas para los textos en español e inglés
    private static final Map<String, String> textosEspanol = new HashMap<>();
    private static final Map<String, String> textosIngles = new HashMap<>();

    // Mapa que relaciona claves con componentes
    private static final Map<String, JComponent> componentes = new HashMap<>();

    static {
        // Definir textos en español
        textosEspanol.put("menu_principal", "Menú Principal");
        textosEspanol.put("ajustes", "Ajustes");
        textosEspanol.put("creditos", "Créditos");
        textosEspanol.put("seleccionar_materia", "Seleccionar Materia");
        textosEspanol.put("guardar_datos", "Guardar Datos");

        // Definir textos en inglés
        textosIngles.put("menu_principal", "Main Menu");
        textosIngles.put("ajustes", "Settings");
        textosIngles.put("creditos", "Credits");
        textosIngles.put("seleccionar_materia", "Select Subject");
        textosIngles.put("guardar_datos", "Save Data");
    }

    // Cambiar entre español e inglés
    public static void cambiarIdioma() {
        idiomaIngles = !idiomaIngles; // Cambia entre español e inglés
        actualizarTextos(); // Actualizar textos en todos los componentes registrados
    }

    // Registrar un componente y su clave de texto
    public static void registrarComponente(String clave, JComponent componente) {
        componentes.put(clave, componente); // Vincula la clave con el componente
    }

    // Actualizar los textos en los componentes registrados
    public static void actualizarTextos() {
        for (Map.Entry<String, JComponent> entry : componentes.entrySet()) {
            String clave = entry.getKey();
            JComponent componente = entry.getValue();

            // Obtener el texto según el idioma
            String texto = idiomaIngles ? textosIngles.get(clave) : textosEspanol.get(clave);

            // Validar que el texto exista
            if (texto == null) {
                System.err.println("Texto no encontrado para la clave: " + clave);
                continue; // Evitar errores si no se encuentra la clave
            }

            // Asignar el texto según el tipo de componente
            if (componente instanceof JButton) {
                ((JButton) componente).setText(texto);
            } else if (componente instanceof JLabel) {
                ((JLabel) componente).setText(texto);
            } else if (componente instanceof JRadioButton) {
                ((JRadioButton) componente).setText(texto);
            } else if (componente instanceof JToggleButton) {
                ((JToggleButton) componente).setText(texto);
            } else if (componente instanceof JTextField) {
                ((JTextField) componente).setText(texto);
            } else {
                System.err.println("Componente no soportado: " + componente.getClass().getSimpleName());
            }
        }
    }

    // Método para verificar si el idioma actual es inglés
    public static boolean esIngles() {
        return idiomaIngles; // Devuelve true si el idioma es inglés
    }
}
