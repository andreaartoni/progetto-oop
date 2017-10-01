package __ProgettoEsameOOP;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;

/*le calorie riportate nei Label f1, f2, f3, f4 (cioè le calorie assunte a colazione pranzo, merenda e cena) andrebbero
 *di volta in volta salvate nel database (la chiave è composta da username e data) 
 *Quindi la classe Grafico (che riceve l'username e la data) legge i dati salvati nel DB e crea un diagramma a torta*/
public class GraficoCalorieQuotidiane extends JFrame{
	private static final long serialVersionUID = 1L;
	private String username;
	private String data;
	private static String salute;

	public GraficoCalorieQuotidiane(String username, String data){
		super("Calorie Giornaliere");
		this.setLayout(new BorderLayout());
		this.username=username;
		this.data=data;
		this.add(creaGrafico(), BorderLayout.CENTER);
		this.add(new JLabel(salute, JLabel.CENTER), BorderLayout.NORTH);
		this.setMinimumSize(new Dimension(550, 370));
		this.setVisible(true);
	}
	
	private JPanel creaGrafico(){
		JFreeChart torta = ChartFactory.createPieChart("Calorie", creaDataset(), true, false, false);
		return new ChartPanel(torta);
	}
	
	private PieDataset creaDataset(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		ResultSet rs = Database.query("SELECT * FROM Diario WHERE username='"+username+"' AND data='"+data+"'");
		try {
			if(rs.next()){
					dataset.setValue("Prima Colazione", new Double(rs.getInt("kcal_colazione")));
					dataset.setValue("Pranzo", new Double(rs.getInt("kcal_pranzo")));
					dataset.setValue("Cena", new Double(rs.getInt("kcal_cena")));
					dataset.setValue("Snack", new Double(rs.getInt("kcal_snack")));
					salute=rs.getString("salute");
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}		
		return dataset;
	}
}
