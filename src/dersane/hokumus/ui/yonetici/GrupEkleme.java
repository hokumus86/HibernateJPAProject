package dersane.hokumus.ui.yonetici;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import dersane.hokumus.dao.yonetici.SinifDAO;
import dersane.hokumus.yonetici.model.Sinif;
import dersane.hokumus.yonetici.model.SinifTipi;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GrupEkleme extends JFrame{
	private JTextField txtGrupAdi;
	private JComboBox cmbOgretmen;
	private JComboBox cmbSinif;

	public GrupEkleme() {
		initialize();
	}

	private void initialize() {
		setBounds(300, 300, 350, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblGurupAd = new JLabel("Gurup Ad\u0131");
		lblGurupAd.setBounds(43, 47, 112, 14);
		getContentPane().add(lblGurupAd);
		
		txtGrupAdi = new JTextField();
		txtGrupAdi.setBounds(175, 44, 143, 20);
		getContentPane().add(txtGrupAdi);
		txtGrupAdi.setColumns(10);
		
		JLabel lblSinif = new JLabel("Sinif");
		lblSinif.setBounds(43, 83, 112, 14);
		getContentPane().add(lblSinif);
		
		cmbSinif = new JComboBox();
		cmbSinif.setBounds(175, 79, 143, 22);
		getContentPane().add(cmbSinif);
		comboDoldur(0);
		
		JLabel lblretmen = new JLabel("\u00D6\u011Fretmen");
		lblretmen.setBounds(43, 114, 112, 14);
		getContentPane().add(lblretmen);
		
		cmbOgretmen = new JComboBox();
		cmbOgretmen.setBounds(175, 108, 143, 22);
		getContentPane().add(cmbOgretmen);
		comboDoldur(1);
		
		JLabel lblBalangTarihi = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		lblBalangTarihi.setBounds(43, 148, 112, 14);
		getContentPane().add(lblBalangTarihi);
		
		JDateChooser dtChBaslangic = new JDateChooser();
		dtChBaslangic.setBounds(175, 141, 143, 20);
		getContentPane().add(dtChBaslangic);
		
		JLabel lblNewLabel = new JLabel("Biti\u015F Tarihi");
		lblNewLabel.setBounds(43, 174, 96, 14);
		getContentPane().add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 168, 143, 20);
		getContentPane().add(dateChooser);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(43, 229, 91, 23);
		getContentPane().add(btnIptal);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(227, 229, 91, 23);
		getContentPane().add(btnKaydet);
		setTitle("Grup Ekleme Ekraný");
		
	}
	
	private void comboDoldur(int deger) {
		if(deger ==0) {
			
			SinifDAO db = new SinifDAO();
			List<Sinif> siniflar = db.listele(new Sinif());
			DefaultComboBoxModel model = new DefaultComboBoxModel(siniflar.toArray());
			cmbSinif.setModel(model);	
		}
		else if(deger==1) {
			DefaultComboBoxModel model = new DefaultComboBoxModel(SinifTipi.values());
			cmbOgretmen.setModel(model);	
		}
			
	}
}
