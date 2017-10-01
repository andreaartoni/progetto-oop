package __ProgettoEsameOOP;

import java.sql.*;

public class Diario {
    
	public static void colazione() throws SQLException{
		String str1 = Modello.primaColazione.getText();
		ResultSet rs = Database.query("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
		if(rs.next()){
			int kcalParziale = rs.getInt("kcal_100g");
			int quantit‡ = Integer.parseInt(Modello.quantit‡1.getText());
			Modello.f1.setText(String.valueOf(quantit‡*kcalParziale));
		}
		else{
			new Errore("Alimento non disponibile");
		}
	}
	
	public static void pranzo() throws SQLException{
		String str1 = Modello.pranzo.getText();
		ResultSet rs = Database.query("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 + "'");
		if(rs.next()){
			int kcalParziale = rs.getInt("kcal_100g");
			int quantit‡ = Integer.parseInt(Modello.quantit‡2.getText());
			Modello.f2.setText(String.valueOf(quantit‡*kcalParziale));
		}
		else{
			new Errore("Alimento non disponibile");
		}
	}
	
	public static void cena() throws SQLException{
		String str1 = Modello.cena.getText();
		ResultSet rs = Database.query("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
		if(rs.next()){
			int kcalParziale = rs.getInt("kcal_100g");
			int quantit‡ = Integer.parseInt(Modello.quantit‡3.getText());
			Modello.f3.setText(String.valueOf(quantit‡*kcalParziale));
		}
		else{
			new Errore("Alimento non disponibile");
		}
	}
	
	public static void snack() throws SQLException{
		String str1 = Modello.snack.getText();
	    ResultSet rs = Database.query("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
	    if(rs.next()){
			int kcalParziale = rs.getInt("kcal_100g");
			int quantit‡ = Integer.parseInt(Modello.quantit‡4.getText());
			Modello.f4.setText(String.valueOf(quantit‡*kcalParziale));
		}
		else{
			new Errore("Alimento non disponibile");
		}
	}
	
	public static void sport() throws SQLException{
		String str1 = Modello.attivit‡Fisica.getText();
		ResultSet rs = Database.query("SELECT kcal_ora FROM sport WHERE nome='"+str1+"'");
		if(rs.next()){
				int kcalSportOra = rs.getInt("kcal_ora");
				int oreTotali = Integer.parseInt(Modello.numeroOre.getText());
				Modello.f5.setText(String.valueOf(oreTotali*kcalSportOra));
			}
		else{
			new Errore("Sport non disponibile");
		}
	}
	
	public static void calorieAssunte(String dt, String username){
		ResultSet rs = Database.query("SELECT * FROM Diario WHERE username='"+username+"' AND data='"+dt+"'");
		try {
			if(rs.next()){
					Modello.totColazione.setText(String.valueOf(rs.getInt("kcal_colazione")));
					Modello.totPranzo.setText(String.valueOf(rs.getInt("kcal_pranzo")));
					Modello.totCena.setText(String.valueOf(rs.getInt("kcal_cena")));
					Modello.totSnack.setText(String.valueOf(rs.getInt("kcal_snack")));
					Modello.totSport.setText(String.valueOf(rs.getInt("kcal_sport")));
			}
			else{
				Database.update("INSERT INTO Diario (username, data) VALUES ('"+username+"','"+dt+"')");
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void aggiorna(String dt, String username){
		String msg = null;
		if(Integer.parseInt(Modello.tot.getText())<Integer.parseInt(Modello.fab.getText()))
			msg = "Hai assunto meno calorie del necessario";
		if(Integer.parseInt(Modello.tot.getText())==Integer.parseInt(Modello.fab.getText()))
			msg = "Hai assunto le calorie necessarie";
		if(Integer.parseInt(Modello.tot.getText())==Integer.parseInt(Modello.fab.getText()))
			msg = "Hai assunto pi˘ calorie del necessario";
		
		Database.update("UPDATE Diario "
				+"SET kcal_colazione='"+Modello.totColazione.getText()
				+"', kcal_pranzo='"+Modello.totPranzo.getText()
				+"', kcal_cena='"+Modello.totCena.getText()
				+"', kcal_snack='"+Modello.totSnack.getText()
				+"', kcal_sport='"+Modello.totSport.getText()
				+"', salute='"+msg
				+"' WHERE username='"+username+"' AND data='"+dt+"'");
	}
}


