package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private String username;
	private JPanel griglia;
	private JLabel diarioView;
	private JLabel diarioUpdate;
	private Utente user; //
	private JMenuItem logout;
	int fb;
	
	public HomePage(String u){
		super("Home");
		
		username = u;
		
		this.setLayout(new BorderLayout());
		
		JLabel welcome = new JLabel(new String("ciao " +username)/*, JLabel.*/);
		this.add(welcome, BorderLayout.NORTH);
		
		griglia = new JPanel();
		griglia.setLayout(new GridLayout(1, 2));
		
		diarioView = pannello("Visualizza il tuo diario", "immagini/visualizza.png");
		diarioUpdate = pannello("Aggiorna il tuo diario", "immagini/diario.png");
	
		this.add(griglia, BorderLayout.SOUTH);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		p.add(new JLabel("Il tuo profilo:", JLabel.CENTER), BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 2));
		
		user = new Utente(u);
		
		p1.add(pannello(new JLabel(user.getSesso())));
		p1.add(pannello(new JLabel(new String(String.valueOf(user.getEt‡())) + " anni")));
		p1.add(pannello(new JLabel(new String(String.valueOf(user.getAltezza())) + " cm")));
		p1.add(pannello(new JLabel(new String(String.valueOf(user.getPeso())) + " kg")));
		
		double mb = user.metabolismoBasale();
		double laf = user.livelloAttivit‡Fisica();
		fb = (int)(mb*laf);
		
		p1.add(pannello(new JLabel(new String("Metabolismo Basale: " +String.valueOf(mb)))));
		p1.add(pannello(new JLabel(new String("LAF: " +String.valueOf(laf)))));
		
		p.add(new JLabel(new String("Fabbisogno calorico giornaliero: " +String.valueOf(fb)), JLabel.CENTER), BorderLayout.SOUTH);
		p.add(p1, BorderLayout.CENTER);
		
		this.add(p, BorderLayout.CENTER);
		
		JMenuBar mbar = new JMenuBar();
		JMenu m = new JMenu("Opzioni");
		logout = new JMenuItem("Logout");
	
		logout.addActionListener(this);
		
		mbar.add(m);
		m.add(logout);
		
		this.setJMenuBar(mbar);
		
		this.setMinimumSize(new Dimension(550, 370));
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
	
	private JPanel pannello(JLabel l){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(l);
		return p;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout){
			this.dispose();
			new Login();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == diarioView){
			//new ...
		}
		if(e.getSource() == diarioUpdate){
			new Modello(fb);
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
