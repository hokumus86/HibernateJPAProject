package dersane.hokumus.ogretmen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ogretmen")
public class Ogretmen {

	private int id;

	private String adiSoyadi;

	@Id
	@SequenceGenerator(name = "sq_ogretmen", sequenceName = "sq_ogretmen_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sq_ogretmen", strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "adisoyadi")
	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

}
