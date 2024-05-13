/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Modelos.Sales;
import com.mycompany.libros.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para interactuar con la tabla de ventas en la base de datos.
 *
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de ventas,
 * incluyendo inserción, actualización, eliminación y selección.
 */

public class SalesDao {
     /**
     * Inserta una nueva venta en la base de datos.
     *
     * @param sales El objeto Sales que representa la venta a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insert(Sales sales) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "insert into pubs.sales (stor_id, ord_num, ord_date, qty, payterms, title_id) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, sales.getstor_id());
            ps.setString(2, sales.getord_num());
            ps.setString(3, sales.getord_dateString());
            ps.setInt(4, sales.getqty());
            ps.setString(5, sales.getpayterms());
            ps.setString(6, sales.gettitle_id());
            if (ps.executeUpdate()==1){
                flag = true;
                System.out.println("Insertado");
            }else{
                System.out.println("No se a podido insertar");
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
        return flag;
    }
    
    /**
     * Actualiza la información de una venta en la base de datos.
     *
     * @param sales El objeto Sales con la información actualizada de la venta.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(Sales sales) {
        boolean flag = false;
        String sql= "update pubs.sales set ord_num = ?, ord_date = ?, qty = ?, payterms = ?, title_id = ? where stor_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, sales.getstor_id());
            ps.setString(2, sales.getord_num());
            ps.setString(3, sales.getord_dateString());
            ps.setInt(4, sales.getqty());
            ps.setString(5, sales.getpayterms());
            ps.setString(6, sales.gettitle_id());
            if (ps.executeUpdate()==1){
                flag = true;
                System.out.println("Actualizado");
            }else{
                System.out.println("No se llego a actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error: " +e);
        }
        return flag;
    }
    
    /**
     * Elimina una venta de la base de datos.
     *
     * @param stor_id El ID de la venta a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(String stor_id) {
        boolean flag = false;
        String sql = "delete from pubs.sales where stor_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, stor_id);
            if(ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Eliminado");
            }else{
                System.out.println("No se pudo eliminar");
            }
        } catch (Exception e) {
          System.out.println("Error: " +e);
        }
        return flag;
    }
    
    
    /**
     * Obtiene la información de una venta específica de la base de datos.
     *
     * @param stor_id El ID de la venta a buscar.
     * @return Un objeto Sales que representa la venta encontrada, o null si no se encontró ninguna venta con ese ID.
     */
    public Sales oneSales(String stor_id){
        Sales sales = new Sales();
        String sql = "select * from pubs.sales where stor_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, stor_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sales = new Sales(rs.getString("stor_id"),
                        rs.getString("ord_num"),
                        rs.getDate("ord_date"),
                        rs.getInt("qty"),
                        rs.getString("payterms"),
                        rs.getString("title_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return sales;
    }
    
    /**
     * Obtiene una lista de todas las ventas en la base de datos.
     *
     * @return Una lista de objetos Sales que representan todas las ventas en la base de datos.
     */
    public List<Sales> selectAll() {
       List<Sales> Lista = new LinkedList<Sales>();
       String sql = "select * from pubs.sales;";
       try{
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Sales sale;
            while (rs.next()) {
                sale = new Sales(rs.getString("stor_id"), rs.getString("ord_num"), rs.getDate("ord_date"), rs.getInt("qty"), rs.getString("payterms"), rs.getString("title_id"));
                Lista.add(sale);
            }
            if (Lista.size() > 0) {
                System.out.println("Lista llena");
            }
       } catch (Exception e) {
         System.out.println("Error: "+e);
       }
       return Lista;
    }
        
}
