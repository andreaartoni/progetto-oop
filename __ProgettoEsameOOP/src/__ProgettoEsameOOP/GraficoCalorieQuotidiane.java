package __ProgettoEsameOOP;

import java.util.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;

/*le calorie riportate nei Label F1, F2, F3, F4 (cioè le calorie assunte a colazione pranzo, merenda e cena) andrebbero
 *di volta in volta salvate nel database (la chiave è composta da user e data) 
 *Quindi la classe Grafico (che riceve l'user e la data) legge i dati salvati nel DB e crea un diagramma a torta*/
public class GraficoCalorieQuotidiane extends JFrame{
	private static final long serialVersionUID = 1L;
	private String user;
	private Date data;

	public GraficoCalorieQuotidiane(String user, Date data){
		super("Calorie Giornaliere");
		this.user=user;
		this.data=data;
		this.add(creaGrafico());
		this.setVisible(true);
	}
	
	private JPanel creaGrafico(){
		JFreeChart torta = ChartFactory.createPieChart("Calorie", creaDataset(), true, false, false);
		return new ChartPanel(torta);
	}
	
	private PieDataset creaDataset(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Prima Colazione", new Double(Modello.F1.getText()));
		dataset.setValue("Pranzo", new Double(Modello.F2.getText()));
		dataset.setValue("Cena", new Double(Modello.F3.getText()));
		dataset.setValue("Snack", new Double(Modello.F4.getText()));
		return dataset;
		
		/*dovremmo avere 
		 * 
		 * DefaultPieDataset dataset = new DefaultPieDataset();
		 * dataset.setValue("Prima Colazione", new Double(Database.query.("SELECT Kcal_colazione 
		 * 																	FROM CalorieGiornaliere 
		 * 																	WHERE Utente = '" +user+ "'
		 * 																	AND Data = '" +data+ "'"));
		 * dataset.setValue("Pranzo", new Double(Modello.F2.getText()));
		 * dataset.setValue("Cena", new Double(Modello.F3.getText()));
		 * dataset.setValue("Snack", new Double(Modello.F4.getText()));
		 * return dataset;
		 */
	}
}
