/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dersane.hokumus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "ktp")
public class kitap {
    
    
    private int id;   
    private String adi;
    private yazar yazar;
    private String yevi;
    private int sayfaSayisi;
    private String basimYili;

    @Id
    @SequenceGenerator(name = "seq_kitap", allocationSize = 1, sequenceName = "seq_kitap_id")
    @GeneratedValue(generator = "seq_kitap", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @ManyToOne
    @JoinColumn(name = "yazar_id")
    public yazar getYazar() {
        return yazar;
    }

    public void setYazar(yazar yazar) {
        this.yazar = yazar;
    }

   

    public String getYevi() {
        return yevi;
    }

    public void setYevi(String yevi) {
        this.yevi = yevi;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getBasimYili() {
        return basimYili;
    }

    public void setBasimYili(String basimYili) {
        this.basimYili = basimYili;
    }
    
    
}
