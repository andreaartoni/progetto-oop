package __ProgettoEsameOOP;

import java.awt.*;
import javax.swing.*;

public class Amministratore extends JFrame {
	private static final long serialVersionUID = 1L;
	/* Imposto la menubar */
	private JMenuBar b = new JMenuBar();

	/* Dichiaro i menu principali */
	private JMenu utenti = new JMenu("Gestione Utenti");
	private JMenu libri = new JMenu("Gestione Libri");
	private JMenu prestiti = new JMenu("Gestione Prestiti");

	/* Dichiaro i sottomenu, in ordine di menu */

	private JMenuItem nutente = new JMenuItem("Nuovo Utente");
	private JMenuItem eutenti = new JMenuItem("Elenco Utenti");
	private JMenuItem cutenti = new JMenuItem("Cerca Utente");

	private JMenuItem nlibro = new JMenuItem("Inserisci Libro");
	private JMenuItem llibro = new JMenuItem("Elenco Libri");
	private JMenuItem clibro = new JMenuItem("Cerca libro");

	private JMenuItem vplibro = new JMenuItem("Per Libro");
	private JMenuItem vputente = new JMenuItem("Per Utente");

	private JPanel content = new JPanel();

	private JLabel welcome = new JLabel("<html><b>Benvenuto amministratore</b><br>" +
			"Sei nel pannello di amministrazione, seleziona una delle voci dal menu");

	/**Costruttore del pannello di amministratore, aggiunge la menubar e un JPanel per i contenuti **/
	public Amministratore() {
		
		

		super();
		BorderLayout layout = new BorderLayout();
		layout.setVgap(20);
		setLayout(layout);

		/* 1 menu */
		b.add(utenti);
		utenti.add(nutente);
		utenti.add(eutenti);
		utenti.add(cutenti);

		/* 2 menu */
		b.add(libri);
		libri.add(nlibro);
		libri.add(llibro);
		libri.add(clibro);
			
		
		/* 3 menu */
		b.add(prestiti);
		prestiti.add(vplibro);
		prestiti.add(vputente);

		/* Inserisco gli actionListener */

		/*nutente.addActionListener(this);
		eutenti.addActionListener(this);
		cutenti.addActionListener(this);

		nlibro.addActionListener(this);
		llibro.addActionListener(this);
		clibro.addActionListener(this);

		vplibro.addActionListener(this);
		vputente.addActionListener(this);*/

		/* Aggiungo barra e contenuto al pannello principale */
		add(b, BorderLayout.NORTH);

		/* Immagine del pannello */
		ImageIcon image = new ImageIcon("image/admin.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		
		content.add(img);
		content.add(welcome);

		this.add(content,BorderLayout.CENTER);
		this.setVisible(true);

	}
	
	public static void main(String args[]) {
		new Amministratore();
	}

}	
