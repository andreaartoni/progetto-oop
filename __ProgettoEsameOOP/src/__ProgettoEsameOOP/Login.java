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
		this.setMinimumSize(new Dimension(1380, 500));
		//this.getContentPane().setBackground(Color.);
		this.setLayout(new BorderLayout());
		
		JLabel intro = new JLabel("Benvenuto", JLabel.CENTER);
		//intro.setForeground(Color.);
		intro.setFont(new Font("", Font.BOLD, 40));
		this.add(intro, BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();
		//p1.setBackground(Color.);
		p1.setLayout(new GridLayout(2, 1));
		
		JLabel descr1 = new JLabel("Inserisci le tue credenziali per effettuare l'accesso", JLabel.CENTER);
		
		JPanel p2 = new JPanel();
		//p2.setBackground(Color.);
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
		//p3.setBackground(Color.);
		p3.setLayout(new FlowLayout());
		
		JLabel descr2 = new JLabel("Non sei iscritto?");
		registrazione = new JButton("Registrati");
		registrazione.addActionListener(this);
		
		p3.add(descr2);
		p3.add(registrazione);
		this.add(p3, BorderLayout.SOUTH);
		
	
		JLabel img1 = new JLabel(new ImageIcon("immagini/fitness.png"));	
		this.add(img1, BorderLayout.EAST);
		
		JLabel img2 = new JLabel(new ImageIcon("immagini/bilancia.png"));	
		this.add(img2, BorderLayout.WEST);
		
     
		this.setSize(50, 50);
		this.setVisible(true);
	}
	
	/*metodo che determina l'azione da eseguire alla pressione del bottone di login o di registrazione*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == login){	
			try {
				ResultSet rs;
				rs = Database.query("SELECT * from Utente where username = '" +username.getText()+ "' AND password = '" +password.getText()+ "'");
				if (rs.next()){
					/* fai qualcosa*/
				}
				else {
					new Errore("Username o Password errati");
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
		new Database();
		new Login();
	}
	
	
}
