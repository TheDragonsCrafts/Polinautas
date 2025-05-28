package Materias;

public class SubjectData {
    public String[] preguntas = {};
    public String[] resc = {}; // Correct answers
    public String[] res2 = {}; // Option 2
    public String[] res3 = {}; // Option 3
    public String[] res4 = {}; // Option 4
    public int[] ptsp = {};   // Points per question

    public SubjectData() {
        // Default constructor
    }

    // Optional: A constructor to initialize data directly, though not strictly required by the task
    // public SubjectData(String[] preguntas, String[] resc, String[] res2, String[] res3, String[] res4, int[] ptsp) {
    //     this.preguntas = preguntas;
    //     this.resc = resc;
    //     this.res2 = res2;
    //     this.res3 = res3;
    //     this.res4 = res4;
    //     this.ptsp = ptsp;
    // }
}
