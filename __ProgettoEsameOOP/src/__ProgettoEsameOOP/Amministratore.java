package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Amministratore extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField inserisciAlimento;
	private JTextField inserisciKcalAlimento;
	private JButton aggiungiAlimento;
	private JButton rimuoviAlimento;
	private JTextField inserisciSport;
	private JTextField inserisciKcalSport;
	private JButton aggiungiSport;
	private JButton rimuoviSport;
	
	public Amministratore(){
		super("Admin");
		this.setLayout(new GridLayout(2,1));
		
		JPanel p1 = new JPanel(new GridLayout(3, 1));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		JLabel alimento = new JLabel("Alimento:");
		JLabel kcalAlimento = new JLabel("Calorie per 100 grammi:");
		inserisciAlimento = new JTextField(15);
		inserisciKcalAlimento = new JTextField(5);
		p2.add(alimento);
		p2.add(inserisciAlimento);
		p2.add(kcalAlimento);
		p2.add(inserisciKcalAlimento);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		aggiungiAlimento = new JButton("Aggiungi alimento");
		aggiungiAlimento.addActionListener(this);
		rimuoviAlimento = new JButton("Rimuovi alimento");
		rimuoviAlimento.addActionListener(this);
		p3.add(aggiungiAlimento);
		p3.add(rimuoviAlimento);
		
		p1.add(new JLabel("Alimenti"));
		p1.add(p2);
		p1.add(p3);
		
		JPanel p4 = new JPanel(new GridLayout(3, 1));
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		JLabel sport = new JLabel("Sport:");
		JLabel kcalSport = new JLabel("Calorie per 1h:");
		inserisciSport = new JTextField(15);
		inserisciKcalSport = new JTextField(5);
		p5.add(sport);
		p5.add(inserisciSport);
		p5.add(kcalSport);
		p5.add(inserisciKcalSport);
		
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout());
		aggiungiSport = new JButton("Aggiungi sport");
		aggiungiSport.addActionListener(this);
		rimuoviSport = new JButton("Rimuovi sport");
		rimuoviSport.addActionListener(this);
		p6.add(aggiungiSport);
		p6.add(rimuoviSport);
		
		p4.add(new JLabel("Sport"));
		p4.add(p5);
		p4.add(p6);
		
		this.add(p1);
		this.add(p4);
		
		this.setMinimumSize(new Dimension(600, 300));
		this.setVisible(true);		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aggiungiAlimento){
			if(inserisciAlimento.getText()!=null && inserisciKcalAlimento.getText()!=null)
				Database.update("INSERT INTO alimenti (nome, kcal_100g) VALUES('"+
						inserisciAlimento.getText()+"','"+inserisciKcalAlimento.getText()+"')");
			else
				new Errore("Inserire un alimento con le rispettive calorie");
		}
		if(e.getSource()==aggiungiSport){
			if(inserisciSport.getText()!=null && inserisciKcalSport.getText()!=null)
				Database.update("INSERT INTO sport (nome, kcal_ora) VALUES('"+
						inserisciSport.getText()+"','"+inserisciKcalSport.getText()+"')");
			else
				new Errore("Inserire uno sport con le rispettive calorie");
		}
		if(e.getSource()==rimuoviAlimento){
			ResultSet rs= Database.query("SELECT * FROM alimenti WHERE nome='"+inserisciAlimento.getText()+"'");
			try {
				if(rs.next())
					Database.update("DELETE FROM alimenti where nome='"+inserisciAlimento.getText()+"'");
				else
					new Errore("Impossibile rimuovere un alimento non presente nel database");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==rimuoviSport){
			ResultSet rs= Database.query("SELECT * FROM sport WHERE nome='"+inserisciSport.getText()+"'");
			try {
				if(rs.next())
					Database.update("DELETE FROM sport where nome='"+inserisciSport.getText()+"'");
				else
					new Errore("Impossibile rimuovere uno sport non presente nel database");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
	}
	

}	
