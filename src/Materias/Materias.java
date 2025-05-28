package Materias;

public class Materias {
    public int id_materia; // Stores the global ID of the currently selected subject
    public String Materia;  // Stores the name of the currently selected subject
    // public int id_pregunta; // Index for the current question, to be set externally

    private Materias_troncoComun materiasTroncoComun;
    private Materias_informatica materiasInformatica;

    public Materias() {
        materiasTroncoComun = new Materias_troncoComun();
        materiasInformatica = new Materias_informatica();
    }

    public SubjectData getSubjectData(int globalIdMateria) {
        this.id_materia = globalIdMateria; // Store the selected subject ID
        if (globalIdMateria >= 1 && globalIdMateria <= 9) {
            this.Materia = materiasInformatica.materia[globalIdMateria - 1]; // Adjust index for array
            return materiasInformatica.mostrar_p(globalIdMateria);
        } else if (globalIdMateria >= 10 && globalIdMateria <= 15) {
             // Adjust index for array: globalId 10 is index 0 in materiasTroncoComun.materia
            int troncoComunIndex = globalIdMateria - 10;
            if (troncoComunIndex < materiasTroncoComun.materia.length) {
                 this.Materia = materiasTroncoComun.materia[troncoComunIndex];
            } else {
                this.Materia = "Unknown Tronco Común Subject";
            }
            return materiasTroncoComun.mostrar_p(globalIdMateria);
        } else {
            System.out.println("Invalid global subject ID: " + globalIdMateria);
            this.Materia = "Unknown Subject";
            return null;
        }
    }
    
    // Method to get subject name without necessarily loading all data yet
    public String getNombreMateria(int globalIdMateria) {
        if (globalIdMateria >= 1 && globalIdMateria <= 9) {
            // Assuming IDs 1-9 match the order in materiasInformatica.materia array (0-8)
            if (globalIdMateria -1 < materiasInformatica.materia.length) {
                 return materiasInformatica.materia[globalIdMateria - 1];
            }
        } else if (globalIdMateria >= 10 && globalIdMateria <= 15) {
            // Assuming IDs 10-15 match the order in materiasTroncoComun.materia array (0-5)
            int index = globalIdMateria - 10;
            if (index < materiasTroncoComun.materia.length) {
                return materiasTroncoComun.materia[index];
            }
        }
        return "Unknown Subject";
    }


    public String reg_M(int idGlobal, int questionIndex) {
        SubjectData subjectData = getSubjectData(idGlobal); // This also sets this.Materia and this.id_materia
        if (subjectData != null && subjectData.preguntas != null && questionIndex >= 0 && questionIndex < subjectData.preguntas.length) {
            return subjectData.preguntas[questionIndex];
        }
        return "Question not found"; // Or throw an exception
    }

    public String[] reg_R(int idGlobal, int questionIndex) {
        SubjectData subjectData = getSubjectData(idGlobal);
        if (subjectData != null && subjectData.resc != null && subjectData.res2 != null &&
            subjectData.res3 != null && subjectData.res4 != null &&
            questionIndex >= 0 && questionIndex < subjectData.resc.length) {
            // Ensure all answer arrays have this index
            if (questionIndex < subjectData.res2.length && 
                questionIndex < subjectData.res3.length && 
                questionIndex < subjectData.res4.length) {
                return new String[]{
                    subjectData.resc[questionIndex],
                    subjectData.res2[questionIndex],
                    subjectData.res3[questionIndex],
                    subjectData.res4[questionIndex]
                };
            }
        }
        return null; // Or an empty array / error indicator
    }

    public int reg_Pts(int idGlobal, int questionIndex) {
        SubjectData subjectData = getSubjectData(idGlobal);
        if (subjectData != null && subjectData.ptsp != null && questionIndex >= 0 && questionIndex < subjectData.ptsp.length) {
            return subjectData.ptsp[questionIndex];
        }
        return 0; // Default points or error indicator
    }
}