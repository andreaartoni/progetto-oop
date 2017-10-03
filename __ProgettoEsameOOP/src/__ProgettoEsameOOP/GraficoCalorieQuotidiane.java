package __ProgettoEsameOOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;

/*le calorie riportate nei Label f1, f2, f3, f4 (cioè le calorie assunte a colazione pranzo, merenda e cena) andrebbero
 *di volta in volta salvate nel database (la chiave è composta da username e data) 
 *Quindi la classe Grafico (che riceve l'username e la data) legge i dati salvati nel DB e crea un diagramma a torta*/
public class GraficoCalorieQuotidiane extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> selezionaGiornata;
	private JButton visualizzaGrafico;
	private JPanel pannello;
	private String username;
	private static String salute;

	public GraficoCalorieQuotidiane(String username){
		super("Calorie Giornaliere");
		this.setLayout(new BorderLayout());
		this.username=username;
		
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		selezionaGiornata = new JComboBox<String>();
		diario();
		
		visualizzaGrafico = new JButton("Grafico");
		visualizzaGrafico.addActionListener(this);
		
		p.add(new JLabel("Seleziona giornata"));
		p.add(selezionaGiornata);
		p.add(visualizzaGrafico);
		
		pannello = new JPanel();
		
		this.add(p, BorderLayout.NORTH);
		this.add(pannello, BorderLayout.CENTER);
		
		this.setMinimumSize(new Dimension(700, 530));
		this.setVisible(true);
	}
	
	private void diario(){
		ResultSet rs = Database.query("SELECT data FROM Diario WHERE username='"+username+"'");
		try {
			while(rs.next()){
				selezionaGiornata.addItem(rs.getString("data"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private JPanel creaGrafico(){
		JFreeChart torta = ChartFactory.createPieChart("Calorie", creaDataset(), true, false, false);
		return new ChartPanel(torta);
	}
	
	private PieDataset creaDataset(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		ResultSet rs = Database.query("SELECT * FROM Diario WHERE username='"+username+"' AND data='"+selezionaGiornata.getSelectedItem()+"'");
		try {
			if(rs.next()){
					if(rs.getInt("kcal_colazione")!=0)
						dataset.setValue("Prima Colazione", new Double(rs.getInt("kcal_colazione")));
					if(rs.getInt("kcal_pranzo")!=0)
						dataset.setValue("Pranzo", new Double(rs.getInt("kcal_pranzo")));
					if(rs.getInt("kcal_cena")!=0)
						dataset.setValue("Cena", new Double(rs.getInt("kcal_cena")));
					if(rs.getInt("kcal_snack")!=0)
						dataset.setValue("Snack", new Double(rs.getInt("kcal_snack")));
					salute=rs.getString("salute");
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}		
		return dataset;
	}

	public void actionPerformed(ActionEvent e) {
		pannello.removeAll();
		pannello.add(creaGrafico());
		pannello.validate();
		this.add(new JLabel(salute, JLabel.CENTER), BorderLayout.SOUTH);
	}
}
