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
		System.out.println(str1);
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
}


