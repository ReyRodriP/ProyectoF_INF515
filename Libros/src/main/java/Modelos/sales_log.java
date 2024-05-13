/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa un registro de ventas con atributos como sales_log_id, stor_id, ord_num, etc.
 * Incluye constructores, getters y setters para acceder y manipular los datos del registro de ventas.
 */

package Modelos;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class sales_log {

    private int sales_log_id;
    private String stor_id;
    private String ord_num;
    private String title_id;
    private String au_id;
    private Date log_fecha;
    private double price;
    private int quantity;
    
    public sales_log(){
        
    }
    
    public sales_log(int sales_log_id, String stor_id, String ord_num, String title_id, String au_id, Date log_fecha, double price, int quantity) {
        this.sales_log_id = sales_log_id;
        this.stor_id = stor_id;
        this.ord_num = ord_num;
        this.title_id = title_id;
        this.au_id = au_id;
        this.log_fecha = log_fecha;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getSalesLogId() {
        return sales_log_id;
    }

    public void setSalesLogId(int sales_log_id) {
        this.sales_log_id = sales_log_id;
    }

    public String getStorId() {
        return stor_id;
    }

    public void setStorId(String stor_id) {
        this.stor_id = stor_id;
    }

    public String getOrdNum() {
        return ord_num;
    }

    public void setOrdNum(String ord_num) {
        this.ord_num = ord_num;
    }

    public String getTitleId() {
        return title_id;
    }

    public void setTitleId(String title_id) {
        this.title_id = title_id;
    }

    public String getAuId() {
        return au_id;
    }

    public void setAuId(String au_id) {
        this.au_id = au_id;
    }

    public Date getLogFecha() {
        return log_fecha;
    }
    
    public String getLogFechaString() {
        String fecha = "";
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(formato);
        fecha = df.format(this.getLogFecha());
        return fecha;
    }

    public void setLogFecha(Date log_fecha) {
        this.log_fecha = log_fecha;
    } 
    
    public void setLogFecha(String log_fecha) {
        try {
            this.log_fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(log_fecha);
        } catch (Exception e) {
            System.out.println("Error al poner la fecha: "+e);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
