package dersane.hokumus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tbldersane")
public class Dersane {
	
	private int id;
	private String dersaneAdi;
	private String misyon;
	private String vizyon;
	private String kurucu;
	@Id
	@SequenceGenerator(name="seq_tbldersane",allocationSize=1,sequenceName="seq_tbldersane_id")
	@GeneratedValue(generator="seq_tbldersane",strategy=GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="dersaneadi")
	public String getDersaneAdi() {
		return dersaneAdi;
	}
	public void setDersaneAdi(String dersaneAdi) {
		this.dersaneAdi = dersaneAdi;
	}
	public String getMisyon() {
		return misyon;
	}
	public void setMisyon(String misyon) {
		this.misyon = misyon;
	}
	public String getVizyon() {
		return vizyon;
	}
	public void setVizyon(String vizyon) {
		this.vizyon = vizyon;
	}
	public String getKurucu() {
		return kurucu;
	}
	public void setKurucu(String kurucu) {
		this.kurucu = kurucu;
	}
	

}
