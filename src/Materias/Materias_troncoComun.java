package Materias;

import java.util.Map;
import java.util.HashMap;

public class Materias_troncoComun {
    // public int id_materia[]={1,2,3,4,5,6}; // Original IDs were local to this class.
    // We will use global IDs 10-15 as established in MainPage.
    public String[] materia = {"Ingles V", "Orientacion Juvenil y Profecional III", "Contabilidad III", "Microeconomia", "Calculo Integral", "Derecho Mercantil"};
    
    private Map<Integer, SubjectData> subjects = new HashMap<>();

    public Materias_troncoComun() {
        // Populate the subjects map with empty SubjectData objects
        // IDs 10 through 15 correspond to the subjects in Tronco Comun
        // These IDs match the M.id_materia values used in MainPage
        subjects.put(10, new SubjectData()); // Inglés V
        subjects.put(11, new SubjectData()); // Orientacion Juvenil y Profecional III
        subjects.put(12, new SubjectData()); // Contabilidad III
        subjects.put(13, new SubjectData()); // Microeconomía
        subjects.put(14, new SubjectData()); // Cálculo Integral
        subjects.put(15, new SubjectData()); // Derecho Mercantil
        
        // Later, actual question data would be loaded into these SubjectData objects
        // Example: To load actual data for subject ID 10 (Inglés V)
        // SubjectData inglesData = subjects.get(10);
        // inglesData.preguntas = new String[]{"Question1?", "Question2?"};
        // ... and so on for other fields and subjects.
    }

    public SubjectData mostrar_p(int id) {
        SubjectData data = subjects.get(id);
        if (data != null) {
            System.out.println("SubjectData for Tronco Comun ID " + id + " retrieved.");
            // Here you would typically populate the 'data' object with actual questions/answers
            // For now, it returns an empty SubjectData shell.
        } else {
            System.out.println("SubjectData for Tronco Comun ID " + id + " not found.");
        }
        return data;
    }
}