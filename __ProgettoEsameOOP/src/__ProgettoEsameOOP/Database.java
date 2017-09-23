package __ProgettoEsameOOP;

import java.sql.*;

public class Database {
	public static Connection con = null;
	
	/*costruttore: carica il driver e apre una connessione al DB*/
	public Database (){
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:utente.db");
		}
		catch (ClassNotFoundException e){
			System.out.println("Errore nel caricamento del driver");
		}
		catch (SQLException e){
			System.out.println("Errore di connessione ad DB");	
		}
	}
	
	/*metodo per l'interagire con il DB ed eseguire delle query*/
	public static ResultSet query(String qry){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Errore nella creazione di uno Statement");
		}
		try {
			rs = stmt.executeQuery(qry);
		}
		catch (SQLException e){
			System.out.println("Errore nell'interazione con il DB");	
		}
		return rs;		
	}
	
	/*metodo per l'interagire con il DB ed eseguire delle operazioni di INSERT, UPDATE or DELETE*/
	public static void update(String qry){
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Errore nella creazione di uno Statement");
		}
		try {
			stmt.executeUpdate(qry);
		}
		catch (SQLException e){
			System.out.println("Errore nell'interazione con il DB");	
		}
			
	}
	
	public void closeConnection() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Errore nella chiusura della connessione ad DB");
			}
	}


}
