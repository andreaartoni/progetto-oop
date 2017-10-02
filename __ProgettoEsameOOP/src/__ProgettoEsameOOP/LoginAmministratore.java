package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginAmministratore extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	private JButton	indietro;
	
	public LoginAmministratore(){
		super("Login Amministratore");
		this.setLayout(new GridLayout(2, 1));
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		JLabel user = new JLabel("username:");
		username = new JTextField(20);
		JLabel psw = new JLabel("password:");
		password = new JPasswordField(20);
		p.add(user);
		p.add(username);
		p.add(psw);
		p.add(password);
		this.add(p);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		login = new JButton("Login");
		login.addActionListener(this);
		indietro = new JButton("Indietro");
		indietro.addActionListener(this);
		p1.add(login);
		p1.add(indietro);
		this.add(p1);
		
		this.setMinimumSize(new Dimension(380, 170));
		this.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login)
			new Amministratore();
		else{
			this.dispose();
			new Login();
		}
			
	}
}
