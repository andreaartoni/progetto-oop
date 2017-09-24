package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	String username;
	
	public HomePage(String u){
		super("Home");
		
		username = u;
		
		this.setLayout(new GridLayout(5, 1));
		
		JLabel l = new JLabel(new String("ciao "+username), JLabel.LEADING);
		this.add(l);
		
		/*JPanel p = new JPanel();
		JButton view = new JButton("Visualizza il tuo diario");
		view.addActionListener(this);
		p.add(view);
		this.add(p);*/
				
		/*JLabel l1 = new JLabel(new ImageIcon("immagini/bilanciapiccola.png"), JLabel.LEADING);
		l1.addMouseListener(this);
		this.add(l1);*/
		
	
		
		
		
		//provare a fare una jlabel a cui agg
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//new Diario();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("peso ideale");
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
