package dersane.hokumus.ui.kullanici;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import dersane.hokumus.dao.KullaniciDAO;
import dersane.hokumus.model.kullanici.Kullanici;
import dersane.hokumus.model.kullanici.Rol;
import dersane.hokumus.ui.main.AnaFrm;
import dersane.hokumus.util.DersanUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

public class GirisFrm extends JFrame {
	private JTextField txtKulAdi;
	private JTextField txtSifre;
	KullaniciDAO db = new KullaniciDAO();

	public GirisFrm() {
		setBounds(300, 300, 355, 255);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Dersane Uygulamasý Giriþ Ekraný");

		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi");
		lblKullaniciAdi.setBounds(42, 91, 90, 14);
		getContentPane().add(lblKullaniciAdi);

		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setBounds(42, 116, 90, 14);
		getContentPane().add(lblifre);

		txtKulAdi = new JTextField();
		txtKulAdi.setBounds(142, 88, 142, 20);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		txtKulAdi.setText("hokumus");

		txtSifre = new JTextField();
		txtSifre.setBounds(142, 113, 142, 20);
		getContentPane().add(txtSifre);
		txtSifre.setColumns(10);
		txtSifre.setText("1");

		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnIptal.setBounds(41, 155, 91, 23);
		getContentPane().add(btnIptal);

		JButton btnGiri = new JButton("Giri\u015F");
		btnGiri.setBounds(179, 155, 91, 23);
		getContentPane().add(btnGiri);

		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Kullanici> liste = db.listele(new Kullanici());
				if (liste.size() <= 0) {
					kullaniciEkle(liste);
					liste = db.listele(new Kullanici());
				}
				boolean durum = false;
				for (Kullanici k : liste) {
					if (k.getKullaniciAdi().equals(txtKulAdi.getText()) && k.getSifre().equals(txtSifre.getText())) {
						DersanUtil.kullaniciRol = k.getRol();
						AnaFrm frm = new AnaFrm();
						frm.setVisible(true);
						GirisFrm.this.dispose();
						durum = true;
						break;
					}
				}
				if (!durum) {
					JOptionPane.showMessageDialog(GirisFrm.this, "Giriþ Baþarýsýz...!");
				}

			}

		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GirisFrm.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(67, 11, 242, 74);

		getContentPane().add(lblNewLabel);
	}

	private void kullaniciEkle(List<Kullanici> liste) {
		Kullanici temp = new Kullanici();
		temp.setAd("Hüseyin");
		temp.setEmail("lgsdklsdjfdj");
		temp.setKullaniciAdi("hokumus");
		temp.setRol(Rol.ADMIN);
		temp.setSifre("1");
		temp.setSoyad("Okumuþ");
		temp.setUyelikTarihi(new Date());
		db.kaydet(temp);

	}
}
