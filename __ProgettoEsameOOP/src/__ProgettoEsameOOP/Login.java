package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JTextField password;
	private JButton login;
	private JButton registrazione;
	
	public Login(){
		super("Salute");
		this.colo
		this.setLayout(new BorderLayout());
		
		JLabel intro = new JLabel("Benvenuto", JLabel.CENTER);
		intro.setFont(new Font("", Font.BOLD, 40));
		this.add(intro, BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 0));
		
		JLabel descr1 = new JLabel("Inserisci le tue credenziali per effettuare l'accesso", JLabel.CENTER);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		
		JLabel user = new JLabel("username:");
		username = new JTextField(20);
		JLabel psw = new JLabel("password:");
		password = new JTextField(20);
		login = new JButton("Login");
		login.addActionListener(this);
		
		
		p2.add(user);
		p2.add(username);
		p2.add(psw);
		p2.add(password);
		p2.add(login);
		
		p1.add(descr1);
		p1.add(p2);
		
		this.add(p1, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		
		JLabel descr2 = new JLabel("Non sei iscritto?");
		registrazione = new JButton("Registrati");
		registrazione.addActionListener(this);
		
		p3.add(descr2);
		p3.add(registrazione);
		
		this.add(p3, BorderLayout.SOUTH);
		
		
		
		this.setSize(50, 50);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == login){	
			try {
				ResultSet rs;
				rs = Database.query("SELECT * from UTENTE where userid = '" +username.getText()+ "' AND psw = '" +password.getText()+ "'");
				if (rs.next()){
					/* fai qualcosa*/
				}
				else {
					JFrame errore = new JFrame("Errore");
					JLabel msg = new JLabel("Username o Password errati", JLabel.CENTER);
					errore.add(msg);
					errore.setVisible(true);
				}	
			}
			catch (SQLException ex) {
				System.out.println("Errore nell' interrogazione al DB");
			}
		}
		else {
			new Registrazione();
		}
	}

	public static void main(String[] args) {
		new Login();
	}
	
	
}
