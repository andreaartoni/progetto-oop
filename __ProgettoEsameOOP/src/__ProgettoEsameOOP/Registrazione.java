package __ProgettoEsameOOP;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registrazione extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cognome;
	private JTextField username;
	private JTextField password;
	private JComboBox<String> sesso;
	private JTextField altezza;
	private JTextField peso;
	private JComboBox<String> attivit‡;
	
	public Registrazione() {
		super("Registrazione");
		this.setMinimumSize(new Dimension(1380, 500));
		this.setLayout(new GridLayout(8, 1));
	
		
		JPanel p1 = pannello1("Nome:", nome);
		JPanel p2 = pannello1("Cognome:", cognome);
		JPanel p3 = pannello1("UserName:", username);
		JPanel p4 = pannello1("Password:", password);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		
		String [] genderStr = {"uomo", "donna"};
		JPanel p5 = pannello3("Sesso:", genderStr, sesso);
		
		this.add(p5);
		
		JPanel p6 = pannello2("Altezza (cm):", altezza);
		JPanel p7 = pannello2("Peso (kg):", peso);
		
		this.add(p6);
		this.add(p7);
		
		String [] attivit‡Str = {"Da scarsa ad assente", "Attivit‡ leggera", "Attivit‡ moderata", "Attivit‡ pesante"};
		JPanel p8 = pannello3("Livello di attivit‡:", attivit‡Str, attivit‡);
		
		this.add(p8);
		
		this.setVisible(true);
	}
	
	
	private JPanel pannello(String str){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		JLabel l = new JLabel(str);
		p.add(l);	
				
		return p;
	}
	
	private JPanel pannello1(String str, JTextField obj){
		JPanel p = pannello(str);
			
		obj = new JTextField(25);
		p.add(obj);
			
		return p;
	}
	
	private JPanel pannello2(String str, JTextField obj){
		JPanel p = pannello(str);
		
		obj = new JTextField(25);
		obj.addKeyListener(this);
		p.add(obj);
		
		return p;
	}
	
	private JPanel pannello3(String str, String [] lista, JComboBox<String> jcb){
		JPanel p = pannello(str);
		
		jcb = new JComboBox<String>(lista);
		p.add(jcb);
		
		return p;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		if(c < '0' || c > '9'){
			new Errore("Inserito un carattere non numerico");
			JTextField tf = (JTextField)e.getSource();
		    tf.setText("");
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}