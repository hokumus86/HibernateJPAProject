package dersane.hokumus.model.kullanici;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tblusr")
public class Kullanici {

	private int id;
	private String kullaniciAdi;
	private String sifre;
	private Date uyelikTarihi;
	private String email;
	private String ad;
	private String soyad;
	private Rol rol;

	@Id
	@SequenceGenerator(name="seq_tblusr",allocationSize=1,sequenceName="seq_tblusr_id")
	@GeneratedValue(generator="seq_tblusr",strategy=GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public Date getUyelikTarihi() {
		return uyelikTarihi;
	}
	public void setUyelikTarihi(Date uyelikTarihi) {
		this.uyelikTarihi = uyelikTarihi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	@Enumerated
	@Column(name="rol_id")
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
