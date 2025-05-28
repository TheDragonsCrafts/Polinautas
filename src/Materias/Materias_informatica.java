package Materias;

import java.util.Map;
import java.util.HashMap;

public class Materias_informatica {
    // public int id_materia[]={1,2,3,4,5,6,7,8,9}; // Can be inferred from map keys or materia array
    public String[] materia = {"Teleinformatica", "Modelado de Sistemas", "PDDM", "Sistemas Operativos", "Herramientas de Programacion", "Interaccion Usuario Computadora", "POO", "Base de Datos", "Ensamblado y Mantenimiento de PC's"};
    // Note: Original materia array had "Interaccion Usuario Computadora" first, then "Modelado de Sistemas".
    // The IDs used in MainPage for ForP were:
    // Teleinformática: 1
    // Modelado de sistemas: 2
    // PDDM: 3
    // Sistemas Operativos: 4
    // Herramientas de Programación: 5
    // Interacción Usuario Computadora: 6
    // POO: 7
    // Base de Datos: 8
    // Ensamblado: 9
    // Re-ordering materia array to match typical ID assignments for clarity, if this class's materia array is the source of truth for names.
    // Or, we can keep the original order and map IDs carefully. Let's stick to IDs 1-9 for the map as per instruction.

    private Map<Integer, SubjectData> subjects = new HashMap<>();

    public Materias_informatica() {
        // Populate the subjects map with empty SubjectData objects
        // IDs 1 through 9 correspond to the subjects in Informatica
        for (int i = 1; i <= 9; i++) {
            subjects.put(i, new SubjectData());
            // Later, actual question data would be loaded into these SubjectData objects
        }
        // Example: To load actual data for subject ID 1 (Teleinformática)
        // SubjectData teleinformaticaData = subjects.get(1);
        // teleinformaticaData.preguntas = new String[]{"Pregunta1?", "Pregunta2?"};
        // ... and so on for other fields and subjects.
    }

    public SubjectData mostrar_p(int id) {
        SubjectData data = subjects.get(id);
        if (data != null) {
            System.out.println("SubjectData for Informatica ID " + id + " retrieved.");
            // Here you would typically populate the 'data' object with actual questions/answers
            // For now, it returns an empty SubjectData shell.
        } else {
            System.out.println("SubjectData for Informatica ID " + id + " not found.");
        }
        return data;
    }
}