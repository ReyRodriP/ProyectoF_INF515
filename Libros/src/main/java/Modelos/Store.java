/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa la tienda con sus atributos como stor_id, stor_name, stor_address, etc.
 * Incluye constructores, getters y setters para acceder y manipular los datos de la tienda.
 */
package Modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Store {
    private String stor_id;
    private String stor_name;
    private String stor_address;
    private String state;
    private String city;
    private String zip;

    
    public Store(){
        
    }
    
    public Store(String stor_id, String stor_name, String stor_address, String state, String city, String zip) {
        this.stor_id = stor_id;
        this.stor_name = stor_name;
        this.stor_address = stor_address;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }
        
    public String getstor_id(){
        return stor_id;
    }
    
    public void setstor_id(String stor_id){
        this.stor_id = stor_id;
    }
    
    public String getstor_name(){
        return stor_name;
    }
    
    public void setstor_name(String stor_name){
        this.stor_name = stor_name;
    }
    
    public String getstor_address(){
        return stor_address;
    }
    
    public void setstor_address(String stor_address){
        this.stor_address = stor_address;
    }
    
    public String getstate(){
        return state;
    }
    
    public void setstate(String state){
        this.state = state;
    }

    public String getcity(){
        return city;
    }
    
    public void setcity(String city){
        this.city = city;
    }
    
    public String getzip(){
        return zip;
    }
    
    public void setzip(String zip) {
        this.zip = zip;
    } 
    
    }

