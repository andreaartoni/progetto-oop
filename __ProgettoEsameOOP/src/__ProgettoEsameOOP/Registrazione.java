package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class Registrazione extends JFrame implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cognome;
	private JTextField username;
	private JTextField password;
	private JComboBox<String> sesso;
	private JTextField annoDiNascita;
	private JTextField altezza;
	private JTextField peso;
	private JComboBox<String> attivit‡;
	private JButton signin;
	
	public Registrazione() {
		super("Registrazione");
		this.setMinimumSize(new Dimension(420, 500));
		this.setLayout(new GridLayout(11, 1));
	
		nome = pannello1("         Nome:", 25);
		cognome = pannello1("  Cognome: ", 25);
		username = pannello1("*UserName:", 25);
		password = pannello1("*Password: ", 25);
		
		String [] genderStr = {"uomo", "donna"};
		sesso = pannello3("Sesso:", genderStr);
		
		annoDiNascita = pannello2("*Anno di nascita (yyyy):", 5);
		altezza = pannello2("*Altezza (cm):", 5);
		peso = pannello2("    *Peso (kg):", 5);
		
		String [] attivit‡Str = {"Leggera", "Moderata", "Pesante"};
		attivit‡ = pannello3("Livello di attivit‡:", attivit‡Str);
		
		JPanel p9 = pannello(null);
		signin = new JButton("Iscriviti");
		signin.addActionListener(this);
		p9.add(signin);
		this.add(p9);
		
		JPanel p10 = pannello("* indica i campi obbligatori");
		this.add(p10);
				
		this.setVisible(true);
	}
	
	/*metodo per la costruzione di un pannello*/
	private JPanel pannello(String str){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		JLabel l = new JLabel(str);
		p.add(l);	
				
		return p;
	}
	
	/*metodo per la costruzione di una pannello, inoltre, Ë usato per inizializzare i JTextField*/
	private JTextField pannello1(String str, int dim){
		JPanel p = pannello(str);
		JTextField o = new JTextField(dim);
		
		p.add(o);
			
		this.add(p);
		return o;
	}
	
	private JTextField pannello2(String str, int dim){
		JPanel p = pannello(str);
		JTextField o = new JTextField(dim);
		
		o = new JTextField(dim);
		o.addKeyListener(this);
		p.add(o);
		
		this.add(p);
		return o;
	}
	
	/*metodo per la costruzione di una pannello, inoltre, Ë usato per inizializzare i JComboBox*/
	private JComboBox<String> pannello3(String str, String [] lista){
		JPanel p = pannello(str);
		JComboBox<String> jcb = new JComboBox<String>(lista);
		
		p.add(jcb);
		
		this.add(p);
		return jcb;
	}

	/*metodo che determina l'azione da eseguire quando viene inserito un carattere non numerico 
	 *nei TextField annoDiNascita, peso e altezza*/
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		if((c < '0' || c > '9') && c != '\b'){
			new Errore("Inserito un carattere non numerico");
			JTextField tf = (JTextField)e.getSource();
		    tf.setText(null);
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

	/*metodo che determina l'azione da eseguire quando viene premuto il bottone per l'iscrizione
	 * (i campi username, password, annoDiNascita, altezza e peso non possono essere vuoti, 
	 * l'altezza non puÚ superare i 300 cm, 
	 * il peso non puÚ superare i 500 kg,
	 * l'iscrizione Ë consentita a utenti di almento 14 anni e massimo 100
	 * --->pertanto l'anno di nascita dovr‡ essere compreso tra "l'anno corrente-14" e "l'anno corrente-100"
	 * )
	 * si cerca nel DB se lo username scelto puÚ essere accettato o meno*/
	public void actionPerformed(ActionEvent e) {
		boolean cont = true;
		if(username.getText().isEmpty() || password.getText().isEmpty() || annoDiNascita.getText().isEmpty() || altezza.getText().isEmpty() || peso.getText().isEmpty()){
			new Errore("Riempire i campi obbligatori");
			cont = false;
		}
		if(Integer.parseInt(altezza.getText())>300){
			new Errore("Inserire un'altezza non superiore ai 300 cm", "Impossibile procedere con la registrazione");
			cont = false;
		}
		if(Integer.parseInt(peso.getText())>500){
			new Errore("Inserire un peso non superiore ai 500 kg", "Impossibile procedere con la registrazione");
			cont = false;
		}
		if(Integer.parseInt(annoDiNascita.getText())<(Calendar.getInstance().get(Calendar.YEAR)-100) 
				|| Integer.parseInt(annoDiNascita.getText())>(Calendar.getInstance().get(Calendar.YEAR)-14)){
			new Errore("Inserire un anno di nascita valido", "Iscrizione consentita ad utenti di et‡ compresa tra 14 e 100 anni", "Impossibile procedere con la registrazione");
			cont = false;
		}
		
		if(cont){
			try {
				ResultSet rs;
				rs = Database.query("SELECT * FROM Utente U where U.username = '" +username.getText()+ "'");
				if (rs.next()){
					new Errore("Username non valido");
				}
				else {
					Database.update("INSERT INTO Utente VALUES ('" +username.getText()+ "','" + password.getText()+ "','"
						+nome.getText()+ "','" + cognome.getText() + "','" +sesso.getSelectedItem()+ "','"  +annoDiNascita.getText()+ "','"
						+peso.getText()+ "','" +altezza.getText()+ "','" +attivit‡.getSelectedItem()+ "')");
		
					JFrame p = new JFrame();
					p.setMinimumSize(new Dimension(250, 70));
					p.add(new JLabel("Registrazione avvenuta con successo", JLabel.CENTER));
					this.dispose();
					p.setVisible(true);
				}	
			}
			catch (SQLException ex) {
				System.out.println("Errore nell' interrogazione al DB");
			}
		}
	}

}