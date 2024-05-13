/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Modelos.sales_log;
import com.mycompany.libros.CConexion;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * Clase para interactuar con la tabla de registro de ventas en la base de datos.
 *
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de registro de ventas,
 * incluyendo inserción, actualización, eliminación y selección.
 */

public class sales_logDao {
    
    /**
     * Inserta un nuevo registro de venta en la base de datos.
     *
     * @param salesLog El objeto sales_log que representa el registro de venta a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insert(sales_log salesLog) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "INSERT INTO sales_log (stor_id, ord_num, title_id, au_id, log_fecha, price, quantity) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, salesLog.getStorId());
            ps.setString(2, salesLog.getOrdNum());
            ps.setString(3, salesLog.getTitleId());
            ps.setString(4, salesLog.getAuId());
            ps.setTimestamp(5, new java.sql.Timestamp(salesLog.getLogFecha().getTime()));
            ps.setDouble(6, salesLog.getPrice());
            ps.setInt(7, salesLog.getQuantity());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Insertado");
            } else {
                System.out.println("No se pudo insertar");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            
        }
        return flag;
    }
    /**
     * Actualiza la información de un registro de venta en la base de datos.
     *
     * @param salesLog El objeto sales_log con la información actualizada del registro de venta.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(sales_log salesLog) {
        boolean flag = false;
        String sql = "UPDATE sales_log SET stor_id = ?, ord_num = ?, title_id = ?, au_id = ?, log_fecha = ?, price = ?, quantity = ? WHERE sales_log_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, salesLog.getStorId());
            ps.setString(2, salesLog.getOrdNum());
            ps.setString(3, salesLog.getTitleId());
            ps.setString(4, salesLog.getAuId());
            ps.setTimestamp(5, new java.sql.Timestamp(salesLog.getLogFecha().getTime()));
            ps.setDouble(6, salesLog.getPrice());
            ps.setInt(7, salesLog.getQuantity());
            ps.setInt(8, salesLog.getSalesLogId());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Actualizado");
            } else {
                System.out.println("No se pudo actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return flag;
    }
    /**
     * Elimina un registro de venta de la base de datos.
     *
     * @param salesLogId El ID del registro de venta a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(int salesLogId) {
        boolean flag = false;
        String sql = "DELETE FROM sales_log WHERE sales_log_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setInt(1, salesLogId);
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Eliminado");
            } else {
                System.out.println("No se pudo eliminar");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return flag;
    }
    /**
     * Obtiene la información de un registro de venta específico de la base de datos.
     *
     * @param salesLogId El ID del registro de venta a buscar.
     * @return Un objeto sales_log que representa el registro de venta encontrado, o null si no se encontró ningún registro con ese ID.
     */
    public sales_log oneSalesLog(int salesLogId) {
        sales_log salesLog = new sales_log();
        String sql = "SELECT * FROM sales_log WHERE sales_log_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setInt(1, salesLogId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                salesLog = new sales_log(
                        rs.getInt("sales_log_id"),
                        rs.getString("stor_id"),
                        rs.getString("ord_num"),
                        rs.getString("title_id"),
                        rs.getString("au_id"),
                        rs.getTimestamp("log_fecha"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return salesLog;
    }
    /**
     * Obtiene una lista de todos los registros de venta en la base de datos.
     *
     * @return Una lista de objetos sales_log que representan todos los registros de venta en la base de datos.
     */
    public List<sales_log> selectAll() {
        List<sales_log> lista = new LinkedList<>();
        String sql = "SELECT * FROM sales_log;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sales_log salesLog = new sales_log(
                        rs.getInt("sales_log_id"),
                        rs.getString("stor_id"),
                        rs.getString("ord_num"),
                        rs.getString("title_id"),
                        rs.getString("au_id"),
                        rs.getTimestamp("log_fecha"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
                lista.add(salesLog);
            }
            if (!lista.isEmpty()) {
                System.out.println("Lista llena");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }
}
