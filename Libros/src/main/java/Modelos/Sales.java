/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa una venta con sus respectivos atributos como stor_id, ord_num, ord_date, etc.
 * Los métodos incluyen constructores, getters y setters para acceder y manipular los datos de la venta.
 */
package Modelos;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author rodri
 */
public class Sales {

    private String stor_id;
    private String ord_num;
    private Date ord_date;
    private int qty;
    private String payterms;
    private String title_id;
    
    public Sales(){
        
    }
    
    public Sales(String stor_id, String ord_num, String ord_date, int qty, String payterms, String title_id) {
        this.stor_id = stor_id;
        this.ord_num = ord_num;
        this.qty = qty;
        this.payterms = payterms;
        this.title_id = title_id;
        try {
            this.ord_date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(ord_date);
        } catch (Exception e) {
            System.out.println("Error al poner la fecha");
        }
    }
    
    public Sales(String stor_id, String ord_num, Date ord_date, int qty, String payterms, String title_id) {
        this.stor_id = stor_id;
        this.ord_num = ord_num;
        this.qty = qty;
        this.payterms = payterms;
        this.title_id = title_id;
        this.ord_date = ord_date;
    }
    
    
    public String getstor_id(){
        return stor_id;
    }
    
    public void setstor_id(String stor_id){
        this.stor_id = stor_id;
    }
    
    public String getord_num(){
        return ord_num;
    }
    
    public void setord_num(String ord_num){
        this.ord_num = ord_num;
    }
    
    public int getqty(){
        return qty;
    }
    
    public void setqty(int qty){
        this.qty = qty;
    }
    
    public String getpayterms(){
        return payterms;
    }
    
    public void setpayterms(String payterms){
        this.payterms = payterms;
    }

    public String gettitle_id(){
        return title_id;
    }
    
    public void settitle_id(String title_id){
        this.title_id = title_id;
    }
    
    public Date getord_date(){
        return ord_date;
    }
    
    public String getord_dateString() {
        String fecha = "";
        String formato = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(formato);
        fecha = df.format(this.getord_date());
        return fecha;
    }
    
    public void setord_date(Date ord_date) {
        this.ord_date = ord_date;
    } 
    
    public void setord_date(String ord_date) {
        try {
            this.ord_date = new SimpleDateFormat("dd/MM/yyyy").parse(ord_date);
        } catch (Exception e) {
            System.out.println("Error al poner la fecha: "+e);
        }
    }
}
