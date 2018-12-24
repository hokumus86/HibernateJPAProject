package dersane.hokumus.ui.main;

import javax.swing.JFrame;

import dersane.hokumus.model.kullanici.Rol;
import dersane.hokumus.ui.kullanici.KullaniciIslemFrm;
import dersane.hokumus.ui.yonetici.YoneticiAna;
import dersane.hokumus.util.DersanUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AnaFrm extends JFrame{
	
	public AnaFrm() {
		intialize();
	}

	private void intialize() {
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Dersane Uygulamasý Ana Ekran");
		
	
		JButton btnKullaniciIslem = new JButton("Kullanici \u0130\u015Flemleri");
		btnKullaniciIslem.setBounds(61, 54, 194, 57);
		getContentPane().add(btnKullaniciIslem);
		btnKullaniciIslem.setEnabled(false);
		btnKullaniciIslem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KullaniciIslemFrm frm = new KullaniciIslemFrm();
				frm.setVisible(true);				
			}
		});
		
		if(DersanUtil.kullaniciRol==Rol.ADMIN) {
			btnKullaniciIslem.setEnabled(true);
		}
		
		JButton btnOgrtmnIslem = new JButton("\u00D6\u011Fretmen \u0130\u015Flemleri");
		btnOgrtmnIslem.setBounds(337, 54, 181, 57);
		getContentPane().add(btnOgrtmnIslem);
		
		JButton btnOgrnciIslem = new JButton("\u00D6\u011Frenci \u0130\u015Flemleri");
		btnOgrnciIslem.setBounds(61, 153, 194, 57);
		getContentPane().add(btnOgrnciIslem);
		
		JButton btnYoneticiIslem = new JButton("Y\u00F6netici \u0130\u015Flemleri");
		btnYoneticiIslem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiAna temp = new YoneticiAna();
				temp.setVisible(true);
			}
		});
		btnYoneticiIslem.setBounds(337, 153, 181, 57);
		getContentPane().add(btnYoneticiIslem);
		
		JButton btnMuhasebe = new JButton("Muhasebeci \u0130\u015Flemleri");
		btnMuhasebe.setBounds(61, 253, 194, 57);
		getContentPane().add(btnMuhasebe);
		
		JButton btnVeliIslem = new JButton("Veli \u0130\u015Flemleri");
		btnVeliIslem.setBounds(337, 253, 181, 57);
		getContentPane().add(btnVeliIslem);
		
	}
}
