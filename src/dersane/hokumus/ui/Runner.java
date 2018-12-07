package dersane.hokumus.ui;

import dersane.hokumus.dao.KitapDAO;
import dersane.hokumus.model.kitap;
import dersane.hokumus.model.yazar;

public class Runner {
	
	public static void main(String[] args) {
		KitapDAO db = new KitapDAO();
		kitap temp = new kitap();
		temp.setAdi("Java EE");
		temp.setBasimYili("2020");
		temp.setSayfaSayisi(250);
		temp.setYazar(new yazar());
		temp.setYevi("Vektörel YE");
		db.kaydet(new kitap());
	}

}
