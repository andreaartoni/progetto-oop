package __ProgettoEsameOOP;

import java.awt.*;
import javax.swing.*;

public class Errore extends JFrame{
	private static final long serialVersionUID = 1L;

		public Errore (String str){
			super("Errore");
			this.setLayout(new FlowLayout());
			JLabel img = new JLabel(new ImageIcon("immagini/errore.png"));	
			JLabel msg = new JLabel(str, JLabel.RIGHT);
			this.add(img);
			this.add(msg);
			this.setMinimumSize(new Dimension(400, 100));
			this.setVisible(true);
		}
		
		public Errore (String str1, String str2){
			this(str1);
			JLabel msg = new JLabel(str2, JLabel.RIGHT);
			this.add(msg);
		}

}
