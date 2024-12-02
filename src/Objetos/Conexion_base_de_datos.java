/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Formularios.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rodol
 */
public class Conexion_base_de_datos {
    private static final String URL = "jdbc:mysql://<ip_del_servidor>:3306/tu_basedatos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";
    private Connection conn = null;
    public boolean us=false, pr=false;
    Usuario U=new Usuario();
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
    public void buscar_materia(String m, String t, String p){
        String sql = "SELECT * FROM materias WHERE materia=? AND tema=? AND pregunta=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, m);
            pst.setString(2, t);
            pst.setString(3, p);
            ResultSet rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void buscar_pregunta(int id,String p){
        String sql = "SELECT * FROM materias WHERE id_materia=? AND pregunta=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, p);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                /*
                    P.id_materia=rs.getInt("id");
                    P.pregunta=rs.getString("pregunta");
                    P.res1=rs.getString("res1");
                    P.res2=rs.getString("res4");
                    P.res3=rs.getString("res3");
                    P.res4=rs.getString("res4");
                    P.pts=rs.getInt("pts");
                    pr=true;*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean registrar_usuario(String name, String email, String Pass){
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, Pass);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void buscar_usuario(String name, String email, String Pass){
        String sql = "SELECT * FROM users WHERE name = ? AND email = ? AND password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, Pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                    U.id=rs.getInt("id");
                    U.nombre=rs.getString("nombre");
                    U.email=rs.getString("email");
                    U.pass=rs.getString("Pass");
                    U.pts=rs.getInt("pts");
                    us=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean escribir_pts(int pts, int id){
        String sql = "UPDATE users SET pts=? WHERE id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, pts);
            pst.setInt(2, id); 
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
