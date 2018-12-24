package dersane.hokumus.yonetici.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dersane.hokumus.ogretmen.model.Ogretmen;


@Entity
@Table(name="grup")
public class Grup {
	private int id;
	private String grupadi;
	private Sinif sinif;
	private Date baslangic;
	private Date bitis;
	private Ogretmen ogretmen;
	
	@Id
	@SequenceGenerator(name = "sq_grup", sequenceName = "sq_grup_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sq_grup", strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrupadi() {
		return grupadi;
	}
	public void setGrupadi(String grupadi) {
		this.grupadi = grupadi;
	}
	
	@ManyToOne
	@JoinColumn(name="sinif_id")
	public Sinif getSinif() {
		return sinif;
	}
	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
	}
	public Date getBaslangic() {
		return baslangic;
	}
	public void setBaslangic(Date baslangic) {
		this.baslangic = baslangic;
	}
	public Date getBitis() {
		return bitis;
	}
	public void setBitis(Date bitis) {
		this.bitis = bitis;
	}
	
	@ManyToOne
	@JoinColumn(name="ogr_id")
	public Ogretmen getOgretmen() {
		return ogretmen;
	}
	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}
	

}
