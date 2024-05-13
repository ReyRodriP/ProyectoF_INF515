/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa un autor con sus respectivos atributos como au_id, au_lname, au_fname, etc.
 * Los métodos incluyen constructores, getters y setters para acceder y manipular los datos del autor.
 */

package Modelos;
public class Authors {
    private String au_id;
    private String au_lname;
    private String au_fname;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private boolean contract;

    public Authors() {
        
    }

    public Authors(String au_id, String au_lname, String au_fname, String phone, String address, String city, String state, String zip, boolean contract) {
        this.au_id = au_id;
        this.au_lname = au_lname;
        this.au_fname = au_fname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contract = contract;
    }

    public String getAu_id() {
        return au_id;
    }

    public void setAu_id(String au_id) {
        this.au_id = au_id;
    }

    public String getAu_lname() {
        return au_lname;
    }

    public void setAu_lname(String au_lname) {
        this.au_lname = au_lname;
    }

    public String getAu_fname() {
        return au_fname;
    }

    public void setAu_fname(String au_fname) {
        this.au_fname = au_fname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }
}


