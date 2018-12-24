package dersane.hokumus.ui.yonetici;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YoneticiAna extends JFrame {
	
	public YoneticiAna() {
		initialize();
	}

	private void initialize() {
		setBounds(300, 300, 500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JMenuBar menuBarDosya = new JMenuBar();
		menuBarDosya.setBounds(0, 0, 492, 21);
		getContentPane().add(menuBarDosya);
		
		JMenu menuDosya = new JMenu("Dosya");
		menuBarDosya.add(menuDosya);
		
		JMenuItem menuItemSinifEkle = new JMenuItem("S\u0131n\u0131f Ekle");
		menuItemSinifEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinifEkle temp = new SinifEkle();
				temp.setVisible(true);
			}
		});
		menuDosya.add(menuItemSinifEkle);
		
		JMenuItem menuItemKursEkle = new JMenuItem("Kurs Ekle");
		menuItemKursEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupEkleme grb = new GrupEkleme();
				grb.setVisible(true);
			}
		});
		menuDosya.add(menuItemKursEkle);
		setTitle("Dersane Uygulamasý Yönetici Ekraný");
		
	}
}
