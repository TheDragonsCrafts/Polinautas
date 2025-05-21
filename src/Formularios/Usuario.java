/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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
        public void guardar_datos(){
            Properties properties = new Properties();
            properties.setProperty("nombre", this.nombre);
            properties.setProperty("pts", String.valueOf(this.pts));
            try (FileOutputStream out = new FileOutputStream("usuario.properties")) {
                properties.store(out, "User Data");
            } catch (IOException e) {
                e.printStackTrace(); // Or a more sophisticated error handling
            }
        }
        
        public void cargar_datos(){
            Properties properties = new Properties();
            try (FileInputStream in = new FileInputStream("usuario.properties")) {
                properties.load(in);
                this.nombre = properties.getProperty("nombre", "Invitado");
                this.pts = Integer.parseInt(properties.getProperty("pts", "0"));
            } catch (IOException e) {
                // File might not exist on first run, or other error
                System.out.println("No user data file found or error loading: " + e.getMessage());
                this.nombre = "Invitado"; // Ensure defaults
                this.pts = 0;
            } catch (NumberFormatException e) {
                System.out.println("Error parsing points: " + e.getMessage());
                this.pts = 0; // Default to 0 if parsing fails
            }
        }
        
        public void calcular_calif(){
            
        }
        public void cambiar_nom(String newnom){
            this.nombre=newnom;
        }
}
