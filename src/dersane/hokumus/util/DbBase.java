package dersane.hokumus.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dersane.hokumus.model.logtbl;

public class DbBase<T> implements IDbIslem<T> {

	Session ss;
	Transaction tt;

	public void sesionOpen() {
		ss = hbUtil.getSessionFactory().openSession();
		tt = ss.beginTransaction();
	}

	public void sesionClose() {
		tt.commit();
		ss.close();
	}

	public boolean kaydet(T temp) {
		try {
			sesionOpen();
			ss.save(temp);
			sesionClose();
			return true;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("Kaydet");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return false;
		}

	}

	public boolean guncelle(T temp) {
		try {
			sesionOpen();
			ss.update(temp);
			sesionClose();
			return true;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("guncelle");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return false;
		}
		
	}

	public boolean sil(T temp) {
		try {
			sesionOpen();
			ss.delete(temp);
			sesionClose();
			return true;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("sil");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return false;
		}
	}

	public List<T> listele(T temp) {
		List<T> liste;
		try {
			sesionOpen();
			Criteria cr = ss.createCriteria(temp.getClass());
			liste = cr.list();
			sesionClose();
			return liste;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("listele");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return null;
		}
	}

	public T bul(T temp, int id) {
		try {
			sesionOpen();
			Criteria cr = ss.createCriteria(temp.getClass());
			cr.add(Restrictions.eq("id", id));
			T t = (T)cr.list().get(0);
			sesionClose();
			return t;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("bul");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return null;
		}
	}

	public List<T> ara(String kolonadi, String veri, T temp) {
		try {
			sesionOpen();
			Criteria cr = ss.createCriteria(temp.getClass());
			cr.add(Restrictions.eq(kolonadi, veri));
			List<T> liste = cr.list();
			sesionClose();
			return liste;
		} catch (Exception e) {
			logtbl log = new logtbl();
			log.setHataicerigi(e.toString());
			log.setMethod("ara");
			log.setSinif(temp.getClass().toString());
			Date date = new Date();
			log.setTarih(date);
			LogIslem lg = new LogIslem();
			lg.kaydet(log);
			return null;
		}
	}

}
