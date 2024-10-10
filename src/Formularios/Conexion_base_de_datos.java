/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodol
 */
public class Conexion_base_de_datos {
    private static final String URL = "jdbc:mysql://<ip_del_servidor>:3306/tu_basedatos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";
    private Connection conn = null; 
    
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
    }
    public boolean buscar_materia(String materia, String tema, String pregunta){
        String sql = "SELECT * FROM materias WHERE materia=? AND tema=? AND pregunta=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, materia);
            pst.setString(2, tema);
            pst.setString(3, pregunta);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Devuelve true si encuentra una coincidencia
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void escribir_pregunta(String m, String t, String p, String r1, String r2, String r3, String r4, String pts){
        String sql = "SELECT * FROM materias WHERE materia=? AND tema=? AND pregunta=? AND res1=? AND res2=? AND res3=? AND res4=? AND pts=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, m);
            pst.setString(2, t);
            pst.setString(3, p);
            pst.setString(4, r1);
            pst.setString(5, r2);
            pst.setString(6, r3);
            pst.setString(7, r4);
            pst.setString(8, pts);
            ResultSet rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean registrar_usuario(String name, String email, String password){
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0; // Devuelve true si se afectaron filas, indicando que la inserción fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean buscar_usuario(String name, String email, String password, String id){
        String sql = "SELECT * FROM users WHERE name = ? AND email = ? AND password = ? AND id_name=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, id);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Devuelve true si encuentra una coincidencia
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean escribir_pts(String pts, String id){
        String sql = "UPDATE users SET pts=? WHERE "+id+"=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, pts);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0; // Devuelve true si se afectaron filas, indicando que la inserción fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
