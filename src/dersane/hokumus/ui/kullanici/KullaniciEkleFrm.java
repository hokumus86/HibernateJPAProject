package dersane.hokumus.ui.kullanici;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dersane.hokumus.dao.KullaniciDAO;
import dersane.hokumus.model.kullanici.Kullanici;
import dersane.hokumus.model.kullanici.Rol;

import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

public class KullaniciEkleFrm extends JFrame{
	private JTextField txtKulAdi;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JPasswordField txtSifre;
	private JComboBox cmbRol;
	private JDateChooser dateUyelikTarihi;
	
	public KullaniciEkleFrm() {
		initialize();
	}

	private void initialize() {
		setBounds(300, 300, 542, 341);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 *");
		lblNewLabel.setBounds(23, 24, 67, 14);
		getContentPane().add(lblNewLabel);
		
		txtKulAdi = new JTextField();
		txtKulAdi.setBounds(100, 21, 132, 20);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		
		JLabel lblifre = new JLabel("\u015Eifre *");
		lblifre.setBounds(282, 27, 67, 14);
		getContentPane().add(lblifre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 75, 67, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 72, 132, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblyelikTarihi = new JLabel("\u00DCyelik Tarihi");
		lblyelikTarihi.setBounds(282, 78, 67, 14);
		getContentPane().add(lblyelikTarihi);
		
		JLabel lblAd = new JLabel("Ad\u0131");
		lblAd.setBounds(23, 128, 67, 14);
		getContentPane().add(lblAd);
		
		txtAdi = new JTextField();
		txtAdi.setColumns(10);
		txtAdi.setBounds(100, 125, 132, 20);
		getContentPane().add(txtAdi);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131");
		lblSoyad.setBounds(282, 128, 67, 14);
		getContentPane().add(lblSoyad);
		
		cmbRol = new JComboBox();
		cmbRol.setBounds(359, 170, 130, 22);
		comboDoldur();
		getContentPane().add(cmbRol);
		
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(276, 251, 91, 23);
		getContentPane().add(btnIptal);
		btnIptal.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KullaniciEkleFrm.this.dispose();				
			}
		});
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(398, 251, 91, 23);
		getContentPane().add(btnKaydet);
		btnKaydet.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				kullaniciKaydet();				
			}
		});
		
		txtSoyadi = new JTextField();
		txtSoyadi.setColumns(10);
		txtSoyadi.setBounds(359, 125, 130, 20);
		getContentPane().add(txtSoyadi);
		
		JLabel lblRol = new JLabel("Rol\u00FC *");
		lblRol.setBounds(282, 174, 67, 14);
		getContentPane().add(lblRol);
		
		txtSifre = new JPasswordField();
		txtSifre.setBounds(358, 21, 131, 20);
		getContentPane().add(txtSifre);
		
		dateUyelikTarihi = new JDateChooser();
		dateUyelikTarihi.setBounds(359, 75, 130, 20);
		getContentPane().add(dateUyelikTarihi);
		setTitle("Kullanýcý Ekleme");
		
	}

	private void comboDoldur() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(Rol.values());
		cmbRol.setModel(model);		
	}

	protected void kullaniciKaydet() {
		KullaniciDAO db = new KullaniciDAO();
		Kullanici temp = new Kullanici();
		temp.setAd(txtAdi.getText());
		temp.setRol((Rol)cmbRol.getSelectedItem());
		temp.setEmail(txtEmail.getText());
		temp.setKullaniciAdi(txtKulAdi.getText());
		temp.setSifre(txtSifre.getText());
		temp.setUyelikTarihi(dateUyelikTarihi.getDate());
		temp.setSoyad(txtSoyadi.getText());
		if(db.kaydet(temp))
			JOptionPane.showMessageDialog(KullaniciEkleFrm.this, "Kullanýcý Baþarýyla Eklendi...!");
		else
			JOptionPane.showMessageDialog(KullaniciEkleFrm.this, "Kullanýcý Baþarýsýz Oldu...!");
		
	}
}
