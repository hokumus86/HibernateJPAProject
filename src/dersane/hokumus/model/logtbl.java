package dersane.hokumus.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class logtbl {
	 @Id
	    @SequenceGenerator(name = "sq_log",sequenceName = "sq_tbllog_id",
	                        initialValue = 1,allocationSize = 1)
	    @GeneratedValue(generator = "sq_log")
	    private long id;
	    private Date tarih;
	    private String sinif;
	    private String method;
	    @Column(length = 500)
	    private String hataicerigi;
	    private long userid;

	    
	    
	    
	    
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public Date getTarih() {
	        return tarih;
	    }

	    public void setTarih(Date tarih) {
	        this.tarih = tarih;
	    }

	    public String getSinif() {
	        return sinif;
	    }

	    public void setSinif(String sinif) {
	        this.sinif = sinif;
	    }

	    public String getMethod() {
	        return method;
	    }

	    public void setMethod(String method) {
	        this.method = method;
	    }

	    public String getHataicerigi() {
	        return hataicerigi;
	    }

	    public void setHataicerigi(String hataicerigi) {
	        this.hataicerigi = hataicerigi;
	    }

	    public long getUserid() {
	        return userid;
	    }

	    public void setUserid(long userid) {
	        this.userid = userid;
	    }

}
