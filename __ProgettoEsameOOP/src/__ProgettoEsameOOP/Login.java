package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	private JButton registrazione;
	private JMenuItem admin;
	
	public Login(){
		super("Salute");
		this.setMinimumSize(new Dimension(1380, 500));
		this.setLayout(new BorderLayout());
		
		JLabel intro = new JLabel("Benvenuto", JLabel.CENTER);
		intro.setFont(new Font("", Font.BOLD, 40));
		this.add(intro, BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 1));
		
		JLabel descr1 = new JLabel("Inserisci le tue credenziali per effettuare l'accesso", JLabel.CENTER);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		
		JLabel user = new JLabel("username:");
		username = new JTextField(20);
		JLabel psw = new JLabel("password:");
		password = new JPasswordField(20);
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
		
		
		JMenuBar mbar = new JMenuBar();
		JMenu m = new JMenu("Opzioni");
		admin = new JMenuItem("Admin");
		admin.addActionListener(this);
		mbar.add(m);
		m.add(admin);

		this.setJMenuBar(mbar);
		
		
		this.setSize(50, 50);
		this.setVisible(true);
	}
	
	/*metodo che determina l'azione da eseguire alla pressione del bottone di login o di registrazione*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == login){	
			try {
				ResultSet rs = Database.query("SELECT * from Utente where username = '" +username.getText()+ "' AND password = '" +String.valueOf(password.getPassword())+ "'");
				if (rs.next()){
					this.setVisible(false);
					new HomePage(rs.getString("username"));
					
				}
				else {
					new Errore("Username o Password errati");
				}	
			}
			catch (SQLException ex) {
				System.out.println("Errore nell' interrogazione al DB");
			}
		}
		if(e.getSource() == registrazione){
			new Registrazione();
		}
		if(e.getSource() == admin){
			this.dispose();
			new LoginAmministratore();
		}
	}

	public static void main(String[] args) {
		Database db = new Database();
		db.testInsert();

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		new Login();	
	}
}
