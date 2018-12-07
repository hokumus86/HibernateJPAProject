package dersane.hokumus.util;

import java.util.List;

public interface IDbIslem<T> {
	
	public boolean kaydet(T temp);
	public boolean guncelle(T temp);
	public boolean sil(T temp);
	public List<T> listele(T temp);
	public T bul(T temp, int id);
	public List<T> ara(String kolonadi, String veri, T temp);

}
