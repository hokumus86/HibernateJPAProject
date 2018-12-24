package dersane.hokumus.yonetici.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sinif")
public class Sinif {

	
	private int id;
	private String adi;
	private  SinifTipi sinifTipi;
	private int blgSayisi;	
	private boolean projection;
	private int kapasite;
	

	@Id
	@SequenceGenerator(name="sq_sinif",sequenceName="sq_sinif_id",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_sinif",strategy=GenerationType.SEQUENCE)
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
	@Enumerated
	@Column(name="siniftipi_id")
	public SinifTipi getSinifTipi() {
		return sinifTipi;
	}
	public void setSinifTipi(SinifTipi sinifTipi) {
		this.sinifTipi = sinifTipi;
	}
	public int getBlgSayisi() {
		return blgSayisi;
	}
	public void setBlgSayisi(int blgSayisi) {
		this.blgSayisi = blgSayisi;
	}
	
	public boolean isProjection() {
		return projection;
	}
	public void setProjection(boolean projection) {
		this.projection = projection;
	}
	
	public int getKapasite() {
		return kapasite;
	}
	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}
	
	@Override
	public String toString() {
		return adi;
	}

}
