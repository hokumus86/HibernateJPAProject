package dersane.hokumus.ui.yonetici;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dersane.hokumus.dao.yonetici.SinifDAO;
import dersane.hokumus.model.kullanici.Rol;
import dersane.hokumus.yonetici.model.Sinif;
import dersane.hokumus.yonetici.model.SinifTipi;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinifEkle extends JFrame{
	private JTextField txtSinifAdi;
	private JTextField txtBilgSayisi;
	private JTextField txtKapasite;
	private JComboBox cmbSinifTipi;
	private JCheckBox chcBoxPrjVarYok;
	public SinifEkle() {
		initialize();
	}

	private void initialize() {
		setBounds(300, 300, 350, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSinifAdi = new JLabel("S\u0131n\u0131f Ad\u0131");
		lblSinifAdi.setBounds(27, 24, 125, 14);
		getContentPane().add(lblSinifAdi);
		
		txtSinifAdi = new JTextField();
		txtSinifAdi.setBounds(154, 21, 125, 20);
		getContentPane().add(txtSinifAdi);
		txtSinifAdi.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("S\u0131n\u0131f Tipi");
		lblNewLabel_1.setBounds(27, 56, 125, 14);
		getContentPane().add(lblNewLabel_1);
		
		cmbSinifTipi = new JComboBox();
		cmbSinifTipi.setBounds(154, 52, 125, 22);
		comboDoldur();
		getContentPane().add(cmbSinifTipi);
		
		JLabel lblBilgisayarSayisi = new JLabel("Bilgisayar Say\u0131s\u0131");
		lblBilgisayarSayisi.setBounds(27, 88, 125, 14);
		getContentPane().add(lblBilgisayarSayisi);
		
		txtBilgSayisi = new JTextField();
		txtBilgSayisi.setBounds(154, 85, 125, 20);
		getContentPane().add(txtBilgSayisi);
		txtBilgSayisi.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Projecsion Varm\u0131");
		lblNewLabel_3.setBounds(27, 122, 125, 14);
		getContentPane().add(lblNewLabel_3);
		
		chcBoxPrjVarYok = new JCheckBox("Var-Yok");
		chcBoxPrjVarYok.setBounds(154, 118, 97, 23);
		chcBoxPrjVarYok.setSelected(true);
		getContentPane().add(chcBoxPrjVarYok);
		
		JLabel lblKapasite = new JLabel("Kapasite");
		lblKapasite.setBounds(27, 147, 125, 14);
		getContentPane().add(lblKapasite);
		
		txtKapasite = new JTextField();
		txtKapasite.setBounds(154, 144, 125, 20);
		getContentPane().add(txtKapasite);
		txtKapasite.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean prjVarYok = chcBoxPrjVarYok.isSelected();
				Sinif sinif = new Sinif();
				sinif.setAdi(txtSinifAdi.getText());
				sinif.setBlgSayisi(Integer.parseInt(txtBilgSayisi.getText()));
				sinif.setKapasite(Integer.parseInt(txtKapasite.getText()));
				sinif.setProjection(prjVarYok);
				sinif.setSinifTipi((SinifTipi)cmbSinifTipi.getSelectedItem());
				SinifDAO dao = new SinifDAO();
				if(dao.kaydet(sinif))
					JOptionPane.showMessageDialog(SinifEkle.this, "Sýnýf Baþarýyla Eklendi...");
				else
					JOptionPane.showMessageDialog(SinifEkle.this, "Sýnýf Ekleme Baþarýsýz Oldu...!!!");					
				
			}
		});
		btnKaydet.setBounds(188, 193, 91, 23);
		getContentPane().add(btnKaydet);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinifEkle.this.dispose();
			}
		});
		btnIptal.setBounds(27, 193, 91, 23);
		getContentPane().add(btnIptal);
		setTitle("Sinif Ekleme Ekraný");
	}
	
	private void comboDoldur() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(SinifTipi.values());
		cmbSinifTipi.setModel(model);		
	}

}
