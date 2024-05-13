/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Modelos.Store;
import com.mycompany.libros.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * Clase para interactuar con la tabla de tiendas en la base de datos.
 *
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase proporciona métodos para realizar operaciones CRUD en la tabla de tiendas,
 * incluyendo inserción, actualización, eliminación y selección.
 */
public class StoreDao {
    /**
     * Inserta una nueva tienda en la base de datos.
     *
     * @param store El objeto Store que representa la tienda a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
     public boolean insert(Store store) {
        boolean flag = false;
        CConexion conexion = new CConexion();
        String sql = "insert into pubs.stores (stor_id, stor_name, stor_address, state, city, zip) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, store.getstor_id());
            ps.setString(2, store.getstor_name());
            ps.setString(3, store.getstor_address());
            ps.setString(4, store.getstate());
            ps.setString(5, store.getcity());
            ps.setString(6, store.getzip());
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
     * Actualiza la información de una tienda en la base de datos.
     *
     * @param store El objeto Store con la información actualizada de la tienda.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(Store store) {
        boolean flag = false;
        String sql= "update pubs.stores set stor_name = ?, stor_address = ?, state = ?, city = ?, zip = ? where stor_id = ?;";
        try {
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ps.setString(1, store.getstor_name());
            ps.setString(2, store.getstor_address());
            ps.setString(3, store.getstate());
            ps.setString(4, store.getcity());
            ps.setString(5, store.getzip());
            ps.setString(6, store.getstor_id());
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
     * Elimina una tienda de la base de datos.
     *
     * @param stor_id El ID de la tienda a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(String stor_id) {
        boolean flag = false;
        String sql = "delete from pubs.stores where stor_id = ?;";
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
     * Obtiene la información de una tienda específica de la base de datos.
     *
     * @param stor_id El ID de la tienda a buscar.
     * @return Un objeto Store que representa la tienda encontrada, o null si no se encontró ninguna tienda con ese ID.
     */
    public Store oneStore(String stor_id) {
    Store store = null; 
    String sql = "select * from pubs.stores where stor_id = ?;";
    try {
        CConexion conexion = new CConexion();
        PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
        ps.setString(1, stor_id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            store = new Store(rs.getString("stor_id"),
                              rs.getString("stor_name"),
                              rs.getString("stor_address"),
                              rs.getString("state"),
                              rs.getString("city"),
                              rs.getString("zip"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return store;
}
     /**
     * Obtiene una lista de todas las tiendas en la base de datos.
     *
     * @return Una lista de objetos Store que representan todas las tiendas en la base de datos.
     */
    public List<Store> selectAll() {
       List<Store> Lista = new LinkedList<Store>();
       String sql = "select * from pubs.stores;";
       try{
            CConexion conexion = new CConexion();
            PreparedStatement ps = conexion.ConectarBD().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Store store;
            while (rs.next()) {
                store = new Store(rs.getString("stor_id"), rs.getString("stor_name"), rs.getString("stor_address"), rs.getString("state"), rs.getString("city"), rs.getString("zip"));
                Lista.add(store);
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
