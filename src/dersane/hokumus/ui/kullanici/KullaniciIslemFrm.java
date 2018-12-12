package dersane.hokumus.ui.kullanici;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dersane.hokumus.dao.KullaniciDAO;
import dersane.hokumus.model.kullanici.Kullanici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class KullaniciIslemFrm extends JFrame {
	private JTable table;
	public KullaniciIslemFrm() {
		intialize();

		
	}

	private void intialize() {
		setBounds(100, 100, 609, 492);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 572, 267);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tabloDoldur();
		
		JButton btnKulGetir = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
		btnKulGetir.setSelectedIcon(null);
		btnKulGetir.setIcon(null);
		btnKulGetir.setBounds(10, 352, 572, 23);
		getContentPane().add(btnKulGetir);
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
