/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dersane.hokumus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author vektorel
 */

@Entity
public class yazar {
    
    
    private int id;
    private String yadi;
    private String soyadi;    

    @Id
    @SequenceGenerator(name = "seq_yazar", allocationSize = 1, sequenceName = "seq_yazar_id")
    @GeneratedValue(generator = "seq_yazar", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="yazaradi",length=100)
    public String getYadi() {
        return yadi;
    }

    public void setYadi(String yadi) {
        this.yadi = yadi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

  
}
