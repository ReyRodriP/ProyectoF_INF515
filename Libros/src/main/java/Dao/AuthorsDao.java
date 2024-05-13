/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelos.Authors;
import com.mycompany.libros.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para interactuar con la tabla de autores en la base de datos.
 *
 * Autor: Reynaldo Rodriguez Polanco 100655341
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de autores,
 * incluyendo inserción, actualización, eliminación y selección.
 */

public class AuthorsDao {
    /**
     * Inserta un nuevo autor en la base de datos.
     *
     * @param author El objeto Authors que representa al autor a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    
    public boolean insert(Authors author) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "INSERT INTO pubs.authors (au_id, au_lname, au_fname, phone, address, city, state, zip, contract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, author.getAu_id());
            ps.setString(2, author.getAu_lname());
            ps.setString(3, author.getAu_fname());
            ps.setString(4, author.getPhone());
            ps.setString(5, author.getAddress());
            ps.setString(6, author.getCity());
            ps.setString(7, author.getState());
            ps.setString(8, author.getZip());
            ps.setBoolean(9, author.isContract());
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
     * Actualiza la información de un autor en la base de datos.
     *
     * @param author El objeto Authors con la información actualizada del autor.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(Authors author) {
        boolean flag = false;
        String sql = "UPDATE pubs.authors SET au_lname = ?, au_fname = ?, phone = ?, address = ?, city = ?, state = ?, zip = ?, contract = ? WHERE au_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, author.getAu_lname());
            ps.setString(2, author.getAu_fname());
            ps.setString(3, author.getPhone());
            ps.setString(4, author.getAddress());
            ps.setString(5, author.getCity());
            ps.setString(6, author.getState());
            ps.setString(7, author.getZip());
            ps.setBoolean(8, author.isContract());
            ps.setString(9, author.getAu_id());
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
     * Elimina un autor de la base de datos.
     *
     * @param au_id El ID del autor a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(String au_id) {
        boolean flag = false;
        String sql = "DELETE FROM pubs.authors WHERE au_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, au_id);
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
     * Obtiene la información de un autor específico de la base de datos.
     *
     * @param au_id El ID del autor a buscar.
     * @return Un objeto Authors que representa al autor encontrado, o null si no se encontró ningún autor con ese ID.
     */
    public Authors oneAuthor(String au_id) {
        Authors author = null;
        String sql = "SELECT * FROM pubs.authors WHERE au_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, au_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                author = new Authors(rs.getString("au_id"),
                                     rs.getString("au_lname"),
                                     rs.getString("au_fname"),
                                     rs.getString("phone"),
                                     rs.getString("address"),
                                     rs.getString("city"),
                                     rs.getString("state"),
                                     rs.getString("zip"),
                                     rs.getBoolean("contract"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return author;
    }

    /**
     * Obtiene una lista de todos los autores en la base de datos.
     *
     * @return Una lista de objetos Authors que representan a todos los autores en la base de datos.
     */
    public List<Authors> selectAll() {
        List<Authors> Lista = new LinkedList<Authors>();
        String sql = "SELECT * FROM pubs.authors;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Authors author;
            while (rs.next()) {
                author = new Authors(rs.getString("au_id"),
                                     rs.getString("au_lname"),
                                     rs.getString("au_fname"),
                                     rs.getString("phone"),
                                     rs.getString("address"),
                                     rs.getString("city"),
                                     rs.getString("state"),
                                     rs.getString("zip"),
                                     rs.getBoolean("contract"));
                Lista.add(author);
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
