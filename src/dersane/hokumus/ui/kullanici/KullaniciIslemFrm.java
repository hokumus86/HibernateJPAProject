package dersane.hokumus.ui.kullanici;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dersane.hokumus.dao.KullaniciDAO;
import dersane.hokumus.model.kullanici.Kullanici;
import dersane.hokumus.model.kullanici.Rol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KullaniciIslemFrm extends JFrame {
	private JTable table;
	private JTextField txtKuladi;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JComboBox cmbRol;
	private int id;
	public KullaniciIslemFrm() {
		intialize();

		
	}

	private void intialize() {
		setBounds(100, 100, 609, 492);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 572, 179);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKuladi.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
				txtAdi.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
				txtEmail.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				txtSoyadi.setText(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
				cmbRol.setSelectedIndex(3);
				id=Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
		scrollPane.setViewportView(table);
		tabloDoldur();
		
		JButton btnKulGetir = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
		btnKulGetir.setSelectedIcon(null);
		btnKulGetir.setIcon(null);
		btnKulGetir.setBounds(10, 352, 572, 23);
		getContentPane().add(btnKulGetir);
		
		txtKuladi = new JTextField();
		txtKuladi.setBounds(113, 21, 123, 20);
		getContentPane().add(txtKuladi);
		txtKuladi.setColumns(10);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setBounds(10, 24, 78, 14);
		getContentPane().add(lblKullancAd);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(272, 24, 78, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(375, 21, 149, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblAd = new JLabel("Ad\u0131");
		lblAd.setBounds(10, 70, 78, 14);
		getContentPane().add(lblAd);
		
		txtAdi = new JTextField();
		txtAdi.setColumns(10);
		txtAdi.setBounds(113, 67, 123, 20);
		getContentPane().add(txtAdi);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131");
		lblSoyad.setBounds(272, 73, 78, 14);
		getContentPane().add(lblSoyad);
		
		txtSoyadi = new JTextField();
		txtSoyadi.setColumns(10);
		txtSoyadi.setBounds(375, 70, 149, 20);
		getContentPane().add(txtSoyadi);
		
		JLabel lblRol = new JLabel("Rol\u00FC");
		lblRol.setBounds(10, 113, 78, 14);
		getContentPane().add(lblRol);
		
		
		
		cmbRol = new JComboBox();
		cmbRol.setBounds(113, 109, 123, 22);
		getContentPane().add(cmbRol);
		
		comboDoldur();
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciDAO db = new KullaniciDAO();
				Kullanici temp = new Kullanici();
				temp.setAd(txtAdi.getText());
				temp.setEmail(txtEmail.getText());
				temp.setKullaniciAdi(txtKuladi.getText());
				temp.setRol((Rol)cmbRol.getSelectedItem());
				temp.setSoyad(txtSoyadi.getText());
				temp.setId(id);
				if(db.guncelle(temp)) {
					JOptionPane.showMessageDialog(KullaniciIslemFrm.this, "Güncelleme Baþarýlý Oldu..!");
				}
				else 
					JOptionPane.showMessageDialog(KullaniciIslemFrm.this, "Güncelleme Baþarýsýz Oldu..!");
			}
		});
		btnGuncelle.setBounds(382, 113, 91, 23);
		getContentPane().add(btnGuncelle);
		setTitle("Dersane Uygulamasý Ana Ekran");
		
		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);
		
		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);
		
		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciEkleFrm frm = new KullaniciEkleFrm();
				frm.setVisible(true);
			}
		});
		menuKullaniciIslem.add(menuItemKEkle);
		btnKulGetir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tabloDoldur();
				
			}
		});
		
	}
	
	private void comboDoldur() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(Rol.values());
		cmbRol.setModel(model);		
	}

	private void tabloDoldur() {
		KullaniciDAO db = new KullaniciDAO();
		List<Kullanici> liste =db.listele(new Kullanici());
		String[][] data = new String[liste.size()][7];
		String [] columns = {"Id", "Kullanýcý Adý","Uyelik Tarihi","E-Mail","Adý","Soyadý","Rolü"};
		for(int i = 0; i<liste.size();i++) {
			data[i][0]=String.valueOf(liste.get(i).getId());
			data[i][1]=liste.get(i).getKullaniciAdi();
			data[i][2]=String.valueOf(liste.get(i).getUyelikTarihi());
			data[i][3]=liste.get(i).getEmail();
			data[i][4]=liste.get(i).getAd();
			data[i][5]=liste.get(i).getSoyad();
			data[i][6]=liste.get(i).getRol().toString();			
		}
		DefaultTableModel model = new DefaultTableModel(data,columns);
		table.setModel(model);
		
	}
}
