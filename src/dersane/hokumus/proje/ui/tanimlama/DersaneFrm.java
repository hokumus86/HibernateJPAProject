package dersane.hokumus.proje.ui.tanimlama;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DersaneFrm extends JFrame{
	private JTextField txtSahibi;
	private JTextField txtDeraneAdi;
	
	public DersaneFrm() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u0130ptal");
		btnNewButton.setBounds(152, 258, 91, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(391, 246, 91, 23);
		getContentPane().add(btnKaydet);
		
		txtSahibi = new JTextField();
		txtSahibi.setBounds(112, 23, 207, 20);
		getContentPane().add(txtSahibi);
		txtSahibi.setColumns(10);
		
		txtDeraneAdi = new JTextField();
		txtDeraneAdi.setBounds(386, 23, 178, 20);
		getContentPane().add(txtDeraneAdi);
		txtDeraneAdi.setColumns(10);
		
		JTextArea txtMisyon = new JTextArea();
		txtMisyon.setBounds(386, 73, 185, 122);
		getContentPane().add(txtMisyon);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(112, 73, 207, 122);
		getContentPane().add(textArea);
		setTitle("Dersane Tanýmlama Ekraný");
	}
}
