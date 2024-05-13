/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos estáticos para establecer una conexión a la base de datos MySQL.
 * Incluye un método estático para conectar a la base de datos utilizando el controlador JDBC de MySQL.
 * También incluye un bloque estático para cargar el controlador JDBC cuando la clase se carga por primera vez.
 */

package com.mycompany.libros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el controlador JDBC de MySQL", e);
        }
    }

    public static Connection ConectarBD() {
        Connection conectar;
        String host = "jdbc:mysql://localhost/";
        String usuario = "root";
        String contrasenia = "Polanco108";
        String bd = "pubs";

        System.out.println("Conectando");

        try {
            conectar = DriverManager.getConnection(host + bd, usuario, contrasenia);
            System.out.println("Se conecto correctamente.");
        } catch (SQLException e) {
            System.out.println("Problemas al conectar: " + e.toString());
            throw new RuntimeException(e);
        }
        return conectar;
    }
    
    /*
    public void desconectar() {
        System.out.println("Desconectado");
        try {
            conectar.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: "+e);
        }
    }
*/
}
