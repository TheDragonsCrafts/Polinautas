/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

/**
 *
 * @author Rodol
 */
public class Usuario {//clase para guardar los datos y atributos del usuario
        public String nombre="Invitado"; 
        public int pts=0, vida, calif_gen;
        public void sumar_pts(int newpts, int ptsa){
            pts=newpts+ptsa;
        }
        
        public void cambiar_nom(String newnom){
            this.nombre=newnom;
        }
}
