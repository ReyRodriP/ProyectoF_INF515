/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa un título de publicación con sus atributos como title_id, title, type, etc.
 * Incluye constructores, getters y setters para acceder y manipular los datos del título.
 */

package Modelos;

import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author rodri
 */
public class Title {
    private String title_id;
    private String title;
    private String type;
    private String pub_id;
    private BigDecimal price;
    private BigDecimal advance;
    private int royalty;
    private int ytd_sales;
    private String notes;
    private Date pubdate;

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public int getRoyalty() {
        return royalty;
    }

    public void setRoyalty(int royalty) {
        this.royalty = royalty;
    }

    public int getYtd_sales() {
        return ytd_sales;
    }

    public void setYtd_sales(int ytd_sales) {
        this.ytd_sales = ytd_sales;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }
}

