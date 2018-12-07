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
public class uyeler {
    
    @Id
    @SequenceGenerator(name = "seq_uyeler", allocationSize = 1, sequenceName = "seq_uyeler_id")
    @GeneratedValue(generator = "seq_uyeler",strategy =GenerationType.SEQUENCE)
    private int id;
    @Column(name ="uadi",length = 255,nullable = false)
    private String uyeadi;
    private String uyeliktarihi;
    private String kitapadi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUyeadi() {
        return uyeadi;
    }

    public void setUyeadi(String uyeadi) {
        this.uyeadi = uyeadi;
    }

    public String getUyeliktarihi() {
        return uyeliktarihi;
    }

    public void setUyeliktarihi(String uyeliktarihi) {
        this.uyeliktarihi = uyeliktarihi;
    }

    public String getKitapadi() {
        return kitapadi;
    }

    public void setKitapadi(String kitapadi) {
        this.kitapadi = kitapadi;
    }
    
}
