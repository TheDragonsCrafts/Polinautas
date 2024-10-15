/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Rodol
 */
public class Usuario {
    public String nombre, email, Pass;
    public int pts, id;
    //Conexion_base_de_datos conn=new Conexion_base_de_datos();
    
    public void cambiar_pts(int puntos){
        pts=puntos;
        //conn.escribir_pts(pts, id);
    }
    public void mostrar_pts(){
        
    }
    public void cambiar_Pass(String Pass,String newPass){
        
    }
    public void buscar_U(String nombre, String email, String Pass){
        //conn.buscar_usuario(nombre, email, Pass);
    }
    public void registrar_U(String nombre, String email, String Pass){
        //conn.registrar_usuario(nombre, email, Pass);
    }
}
