package dersane.hokumus.model.kullanici;

public enum Rol {
	YONETICI(0), MUHASEBE(1), OGRENCI(2), OGRETMEN(3), ADMIN(4), VELI(5);

	private int deger ;
	public int getDeger() {
		return deger;
	}

	public void setDeger(int deger) {
		this.deger = deger;
	}

	Rol(int param){
		deger= param;
	}
	
	public static String getVeriFromDeger(int deger) {
		String veri = "";
		switch (deger) {
		case 0:
			veri ="YONETICI";
			break;
		case 1:
			veri ="MUHASEBE";
			break;
		case 2:
			veri ="OGRENCI";
			break;
		case 3:
			veri ="OGRETMEN";
			break;
		case 4:
			veri ="ADMIN";
			break;
		case 5:
			veri ="VELI";
			break;

		default:
			break;
		}
		
		return veri;
	}
}


