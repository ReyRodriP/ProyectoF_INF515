/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa un editor (publisher) con sus respectivos atributos como pub_id, pub_name, city, etc.
 * Los métodos incluyen constructores, getters y setters para acceder y manipular los datos del editor.
 */

public class Publishers {
    private String pub_id;
    private String pub_name;
    private String city;
    private String state;
    private String country;

    public Publishers() {
        // Constructor vacío
    }

    public Publishers(String pub_id, String pub_name, String city, String state, String country) {
        this.pub_id = pub_id;
        this.pub_name = pub_name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
