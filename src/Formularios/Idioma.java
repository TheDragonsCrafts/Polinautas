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

public class Idioma {
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
        textosEspanol.put("informatica", "Informática");
        textosEspanol.put("contabilidad", "Contabilidad");
        textosEspanol.put("mercadotecnia_digital", "Mercadotecnia digital");
        textosEspanol.put("tronco_comun", "Tronco Común");
        textosEspanol.put("retroceder", "Retroceder");
        textosEspanol.put("idioma", "Idioma");
        
        textosEspanol.put("modelado_sistemas", "Modelado de sistemas");
        textosEspanol.put("pddm", "PDDM");
        textosEspanol.put("herramientas_programacion", "Herramientas de Programación");
        textosEspanol.put("teleinformactica", "Teleinformáctica");
        textosEspanol.put("sistemas_operativos", "Sistemas Operativos");
        textosEspanol.put("iu_computadora", "Interacción Usuario Computadora");
        textosEspanol.put("ensamblado", "Ensamblado y Mantenimiento de pc´s");
        textosEspanol.put("base_datos", "Base de Datos");
        textosEspanol.put("poo", "POO");
        
        textosEspanol.put("orientacion_juv_prof", "Orientacion Juvenil y Profecional III");
        textosEspanol.put("calculo_integral", "Cálculo Integral");
        textosEspanol.put("inglés_v", "Inglés V");
        textosEspanol.put("contabilidad_iii", "Contabilidad III");
        textosEspanol.put("microeconomia", "Microeconomía");
        textosEspanol.put("derecho_mercantil", "Derecho Mercantil");

        // Mensaje de próx.
        textosEspanol.put("proximamente", "Próximamente");

        // Definir textos en inglés
        textosIngles.put("menu_principal", "Main Menu");
        textosIngles.put("ajustes", "Settings");
        textosIngles.put("creditos", "Credits");
        textosIngles.put("informatica", "Informatics");
        textosIngles.put("contabilidad", "Accounting");
        textosIngles.put("mercadotecnia_digital", "Digital Marketing");
        textosIngles.put("tronco_comun", "Common Core");
        textosIngles.put("retroceder", "Back");
        textosIngles.put("idioma", "Language");
        
        textosIngles.put("modelado_sistemas", "Systems Modeling");
        textosIngles.put("pddm", "PDDM");
        textosIngles.put("herramientas_programacion", "Programming Tools");
        textosIngles.put("teleinformactica", "Teleinformatics");
        textosIngles.put("sistemas_operativos", "Operating Systems");
        textosIngles.put("iu_computadora", "User-Computer Interaction");
        textosIngles.put("ensamblado", "PC Assembly & Maintenance");
        textosIngles.put("base_datos", "Database");
        textosIngles.put("poo", "OOP");
        
        textosIngles.put("orientacion_juv_prof", "Professional Guidance III");
        textosIngles.put("calculo_integral", "Integral Calculus");
        textosIngles.put("inglés_v", "English V");
        textosIngles.put("contabilidad_iii", "Accounting III");
        textosIngles.put("microeconomia", "Microeconomics");
        textosIngles.put("derecho_mercantil", "Business Law");

        // Mensaje de próximamente en inglés
        textosIngles.put("proximamente", "Coming soon");
    }

    // Cambiar entre español e inglés
    public static void cambiarIdioma() {
        idiomaIngles = !idiomaIngles; 
        actualizarTextos();
    }

    // Registrar un componente y su clave de texto
    public static void registrarComponente(String clave, JComponent componente) {
        componentes.put(clave, componente);
    }

    public static void quitarComponente(String clave) {
        componentes.remove(clave);
    }

    // Obtener texto según el idioma actual sin registrar componente
    public static String getTexto(String clave){
        String texto = esIngles() ? textosIngles.get(clave) : textosEspanol.get(clave);
        if (texto == null) {
            texto = "Texto no encontrado";
        }
        return texto;
    }

    // Actualizar los textos en los componentes registrados
    public static void actualizarTextos() {
        for (Map.Entry<String, JComponent> entry : componentes.entrySet()) {
            String clave = entry.getKey();
            JComponent componente = entry.getValue();
            String texto = esIngles() ? textosIngles.get(clave) : textosEspanol.get(clave);

            if (texto == null) {
                System.err.println("Texto no encontrado para la clave: " + clave);
                continue;
            }

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

    public static boolean esIngles() {
        return idiomaIngles; 
    }
}
