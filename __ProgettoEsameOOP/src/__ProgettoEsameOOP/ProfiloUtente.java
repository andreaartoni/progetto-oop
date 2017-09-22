package __ProgettoEsameOOP;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class ProfiloUtente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel username;
	private JLabel dataDiNascita;
	private JLabel Sesso;
	private JLabel Altezza;
	private JLabel Peso;
	
	
	public ProfiloUtente(){
		super("Il mio profilo");
		this.setLayout(new BorderLayout());
		
		username = new JLabel("Nome_Utente", JLabel.CENTER);
		username.setFont(new Font("Arial Bold",Font.ITALIC, 60));;
		this.add(username, BorderLayout.NORTH);
		
	
		this.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new ProfiloUtente();
	}*/
	
	
	
}
