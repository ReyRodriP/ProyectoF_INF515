/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelos.Title;
import com.mycompany.libros.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para interactuar con la tabla de títulos en la base de datos.
 *
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de títulos,
 * incluyendo inserción, actualización, eliminación y selección.
 */
public class TitleDao {
    /**
     * Inserta un nuevo título en la base de datos.
     *
     * @param title El objeto Title que representa el título a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insert(Title title) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "INSERT INTO pubs.titles (title_id, title, type, pub_id, price, advance, royalty, ytd_sales, notes, pubdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, title.getTitle_id());
            ps.setString(2, title.getTitle());
            ps.setString(3, title.getType());
            ps.setString(4, title.getPub_id());
            ps.setBigDecimal(5, title.getPrice());
            ps.setBigDecimal(6, title.getAdvance());
            ps.setInt(7, title.getRoyalty());
            ps.setInt(8, title.getYtd_sales());
            ps.setString(9, title.getNotes());
            ps.setDate(10, new java.sql.Date(title.getPubdate().getTime()));
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
     * Actualiza la información de un título en la base de datos.
     *
     * @param title El objeto Title con la información actualizada del título.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(Title title) {
        boolean flag = false;
        String sql = "UPDATE pubs.titles SET title = ?, type = ?, pub_id = ?, price = ?, advance = ?, royalty = ?, ytd_sales = ?, notes = ?, pubdate = ? WHERE title_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, title.getTitle());
            ps.setString(2, title.getType());
            ps.setString(3, title.getPub_id());
            ps.setBigDecimal(4, title.getPrice());
            ps.setBigDecimal(5, title.getAdvance());
            ps.setInt(6, title.getRoyalty());
            ps.setInt(7, title.getYtd_sales());
            ps.setString(8, title.getNotes());
            ps.setDate(9, new java.sql.Date(title.getPubdate().getTime()));
            ps.setString(10, title.getTitle_id());
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
     * Elimina un título de la base de datos.
     *
     * @param title_id El ID del título a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(String title_id) {
        boolean flag = false;
        String sql = "DELETE FROM pubs.titles WHERE title_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, title_id);
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
     * Obtiene la información de un título específico de la base de datos.
     *
     * @param title_id El ID del título a buscar.
     * @return Un objeto Title que representa el título encontrado, o null si no se encontró ningún título con ese ID.
     */
    public Title oneTitle(String title_id) {
        Title title = null;
        String sql = "SELECT * FROM pubs.titles WHERE title_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, title_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                title = new Title();
                title.setTitle_id(rs.getString("title_id"));
                title.setTitle(rs.getString("title"));
                title.setType(rs.getString("type"));
                title.setPub_id(rs.getString("pub_id"));
                title.setPrice(rs.getBigDecimal("price"));
                title.setAdvance(rs.getBigDecimal("advance"));
                title.setRoyalty(rs.getInt("royalty"));
                title.setYtd_sales(rs.getInt("ytd_sales"));
                title.setNotes(rs.getString("notes"));
                title.setPubdate(rs.getDate("pubdate"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return title;
    }

     /**
     * Obtiene una lista de todos los títulos en la base de datos.
     *
     * @return Una lista de objetos Title que representan todos los títulos en la base de datos.
     */
    public List<Title> selectAll() {
        List<Title> Lista = new LinkedList<>();
        String sql = "SELECT * FROM pubs.titles;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Title title = new Title();
                title.setTitle_id(rs.getString("title_id"));
                title.setTitle(rs.getString("title"));
                title.setType(rs.getString("type"));
                title.setPub_id(rs.getString("pub_id"));
                title.setPrice(rs.getBigDecimal("price"));
                title.setAdvance(rs.getBigDecimal("advance"));
                title.setRoyalty(rs.getInt("royalty"));
                title.setYtd_sales(rs.getInt("ytd_sales"));
                title.setNotes(rs.getString("notes"));
                title.setPubdate(rs.getDate("pubdate"));
                Lista.add(title);
            }
            if (!Lista.isEmpty()) {
                System.out.println("Lista llena");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Lista;
    }
}
