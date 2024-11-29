package Materias;
public class Materias {//clase encargarda de adninistrar y mostrar cualquier cosa de las clases Materias_toncoComun y Materias_informatica
    public int id_materia;
    public String Materia;
    Materias_troncoComun MT=new Materias_troncoComun();//se hace llamado a la clase Materias_troncoComun
    Materias_informatica MF=new Materias_informatica();//se hace llamado a la clase Materias_informatica
    public void imprimir_P(int id, int ptsp,String pre,String rc,String r2,String r3,String r4){//metodo para indicar que hacer dependiendo el id de la materia seleccionada
        int p;
        switch(id){
            case 1,2,3,4,5,6,7,8,9:
                MF.mostrar_p(id);
                System.out.println(id);
                
                break;
            case 10,11,12,13,14,15:
                MT.mostrar_p(id);
                System.out.println(id);
                
                break;
        }
    }
}
