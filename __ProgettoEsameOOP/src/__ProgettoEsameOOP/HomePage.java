package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	String username;
	JPanel griglia;
	JLabel diarioView;
	JLabel diarioUpdate;
	JMenuItem logout;
	JMenuItem modificaProfilo;
	
	public HomePage(String u){
		super("Home");
		
		username = u;
		
		this.setLayout(new BorderLayout());
		
		JLabel welcome = new JLabel(new String("ciao "+username)/*, JLabel.*/);
		this.add(welcome, BorderLayout.NORTH);
		
		griglia = new JPanel();
		griglia.setLayout(new GridLayout(1, 2));
		
		diarioView = pannello("Visualizza il tuo diario", "immagini/visualizza.png");
		diarioUpdate = pannello("Aggiorna il tuo diario", "immagini/diario.png");
	
		this.add(griglia, BorderLayout.SOUTH);
		
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Opzioni");
		logout = new JMenuItem("Logout");
		modificaProfilo = new JMenuItem("Modifica Profilo");
		
		logout.addActionListener(this);
		
		mb.add(m);
		m.add(logout);
		m.add(modificaProfilo);
		
		this.setJMenuBar(mb);
		
		this.setVisible(true);
	}

	private JLabel pannello(String str, String image){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		
		JLabel l = new JLabel(str, JLabel.CENTER);
		p.add(l);	
		
		JLabel img = new JLabel(new ImageIcon(image));
		img.addMouseListener(this);
		p.add(img);
		
		griglia.add(p);
		
		return img;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout){
			this.dispose();
			new Login();
		}
		if(e.getSource() == modificaProfilo){
			//
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == diarioView){
			//new ...
		}
		if(e.getSource() == diarioUpdate){
			//new ...
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
