/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelos.Publishers;
import java.sql.PreparedStatement;
import com.mycompany.libros.CConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para interactuar con la tabla de editores en la base de datos.
 *
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de editores,
 * incluyendo inserción, actualización, eliminación y selección.
 */
public class PublishersDao {
    
    /**
     * Inserta un nuevo editor en la base de datos.
     *
     * @param publisher El objeto Publishers que representa al editor a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insert(Publishers publisher) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "INSERT INTO pubs.publishers (pub_id, pub_name, city, state, country) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, publisher.getPub_id());
            ps.setString(2, publisher.getPub_name());
            ps.setString(3, publisher.getCity());
            ps.setString(4, publisher.getState());
            ps.setString(5, publisher.getCountry());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Insertado");
            } else {
                System.out.println("No se ha podido insertar");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return flag;
    }

    /**
     * Actualiza la información de un editor en la base de datos.
     *
     * @param publisher El objeto Publishers con la información actualizada del editor.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(Publishers publisher) {
        boolean flag = false;
        String sql = "UPDATE pubs.publishers SET pub_name = ?, city = ?, state = ?, country = ? WHERE pub_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, publisher.getPub_name());
            ps.setString(2, publisher.getCity());
            ps.setString(3, publisher.getState());
            ps.setString(4, publisher.getCountry());
            ps.setString(5, publisher.getPub_id());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Actualizado");
            } else {
                System.out.println("No se ha podido actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return flag;
    }
    
    /**
     * Elimina un editor de la base de datos.
     *
     * @param pub_id El ID del editor a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(String pub_id) {
        boolean flag = false;
        String sql = "DELETE FROM pubs.publishers WHERE pub_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, pub_id);
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Eliminado");
            } else {
                System.out.println("No se ha podido eliminar");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return flag;
    }

     /**
     * Obtiene la información de un editor específico de la base de datos.
     *
     * @param pub_id El ID del editor a buscar.
     * @return Un objeto Publishers que representa al editor encontrado, o null si no se encontró ningún editor con ese ID.
     */
    public Publishers onePublisher(String pub_id) {
        Publishers publisher = null;
        String sql = "SELECT * FROM pubs.publishers WHERE pub_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, pub_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                publisher = new Publishers(rs.getString("pub_id"),
                                           rs.getString("pub_name"),
                                           rs.getString("city"),
                                           rs.getString("state"),
                                           rs.getString("country"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return publisher;
    }

     /**
     * Obtiene una lista de todos los editores en la base de datos.
     *
     * @return Una lista de objetos Publishers que representan a todos los editores en la base de datos.
     */
    public List<Publishers> selectAll() {
        List<Publishers> Lista = new LinkedList<Publishers>();
        String sql = "SELECT * FROM pubs.publishers;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Publishers publisher;
            while (rs.next()) {
                publisher = new Publishers(rs.getString("pub_id"),
                                           rs.getString("pub_name"),
                                           rs.getString("city"),
                                           rs.getString("state"),
                                           rs.getString("country"));
                Lista.add(publisher);
            }
            if (Lista.size() > 0) {
                System.out.println("Lista llena");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Lista;
    }
}
