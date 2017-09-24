package __ProgettoEsameOOP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Diario {
	public static Statement statement;
	public static Connection connection;
    static int g=0;
    static int p=0;
    static int t=0;
    static int h=0;
    static int l=0;
    static int m=0;
    //static String str;
	public Diario(String db) throws ClassNotFoundException, SQLException {
		if (db.equals("sqlite")) {
			// load the sqlite-JDBC driver using the current class loader
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:utente.db");
		} else if (db.equals("postgres")) {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql:///dbname", "username", "password");
		} else {
			throw new ClassNotFoundException("database not found");
		}
		statement = connection.createStatement();
		statement.setQueryTimeout(30);
	}

	/*public void getColumnNames() throws SQLException {
		StringBuilder sb = new StringBuilder();
		System.out.println("- reading database (column names)...");
		ResultSet rs = statement.executeQuery("SELECT * FROM person LIMIT 1 OFFSET 0");

		while (rs.next()){
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) { 
				sb.append(rs.getMetaData().getColumnName(i));
				sb.append(",");
			}
		}
		System.out.println(sb.toString());
	}*/

	

	

	public void testInsert() throws SQLException {
		System.out.println("- building database...");
		statement.executeUpdate("DROP TABLE IF EXISTS alimenti");
		statement.executeUpdate("DROP TABLE IF EXISTS sport");
        try{
		statement.executeUpdate("CREATE TABLE alimenti (nome VARCHAR(50) PRIMARY KEY ,kcal_100g INTEGER)");
		statement.executeUpdate("CREATE TABLE sport (nome VARCHAR(50) PRIMARY KEY , kcal_ora INTEGER)");
		
		statement.executeUpdate("INSERT INTO alimenti (nome, kcal_100g) VALUES('carota','12')");
		statement.executeUpdate("INSERT INTO alimenti (nome, kcal_100g) VALUES('panino','120')");
		statement.executeUpdate("INSERT INTO alimenti (nome, kcal_100g) VALUES('pizza','400')");
		
		statement.executeUpdate("INSERT INTO sport (nome, kcal_ora) VALUES('basket','500')");
		statement.executeUpdate("INSERT INTO sport (nome, kcal_ora) VALUES('calcio','600')");
        }
		catch (SQLException e){ 
			e.printStackTrace();
		}
	}

	/*public void testUpdate() throws SQLException {
		System.out.println("- updating database...");
		statement.executeUpdate("UPDATE person SET name='pippo' WHERE name='leo'");
	}

	public void testSelect() throws SQLException {
		System.out.println("- reading database...");
		ResultSet rs = statement.executeQuery("SELECT * FROM person LIMIT 1000 OFFSET 0");
		while(rs.next()) {
			// read the result set
			System.out.println(rs.getRow() + ": id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", surname=" + rs.getString("surname"));
		}
	}*/

	
	
	public static void lato() throws SQLException{
		String str1 = modello.PrimaColazione.getText();
		//try{
		ResultSet rs = statement.executeQuery("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
		while(rs.next()){
			int lollo=rs.getInt("kcal_100g");
			String str2 = modello.Quantità1.getText();
			int x = Integer.parseInt(str2);
			int prodotto=x*lollo;
			g+=prodotto;
			modello.F1.setText(String.valueOf(g));
		}
		//}
		/*catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }*/
		
	}
	
	public static void palo() throws SQLException{
		String str1 = modello.Pranzo.getText();
		//try{
		System.out.println(str1);
		ResultSet rs = statement.executeQuery("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 + "'");
		while(rs.next()){
			int lollo=rs.getInt("kcal_100g");
			String str2 = modello.Quantità2.getText();
			int x = Integer.parseInt(str2);
			int prodotto=x*lollo;
			p+=prodotto;
			modello.F2.setText(String.valueOf(p));
		}
		//}
		/*catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }*/
		
	}
	
	public static void petto() throws SQLException{
		String str1 = modello.Cena.getText();
		//try{
		ResultSet rs = statement.executeQuery("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
		while(rs.next()){
			int lollo=rs.getInt("kcal_100g");
			String str2 = modello.Quantità3.getText();
			int x = Integer.parseInt(str2);
			int prodotto=x*lollo;
			t+=prodotto;
			modello.F3.setText(String.valueOf(t));
		}
		//}
		/*catch (SQLException ex)Due soluzioni:


        {
            System.out.print("exception is" + ex);
        }*/
		
	}
	
	
	
	
	
	public static void coscia() throws SQLException{
		String str1 = modello.Snack.getText();
		//try{
		//ResultSet rs = statement.executeQuery("SELECT kcal_100g FROM alimenti WHERE nome=str1");
		PreparedStatement pstmt = connection.prepareStatement("SELECT kcal_100g FROM alimenti WHERE nome='" + str1 +"'");
	    pstmt.setString(1, str1);
	    ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int lollo=rs.getInt("kcal_100g");
			String str2 = modello.Quantità4.getText();
			int x = Integer.parseInt(str2);
			int prodotto=x*lollo;
			h+=prodotto;
			modello.F4.setText(String.valueOf(h));
		}
		//}
		/*catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }*/
		
	}
	
	public static void inserisci() throws SQLException{
		String str1 = modello.AttivitàFisica.getText();
		//try{
		ResultSet rs = statement.executeQuery("SELECT kcal_ora FROM sport WHERE nome='"+str1+"'");
		while(rs.next()){
			int lollo=rs.getInt("kcal_ora");
			String str2 = modello.NumeroOre.getText();
			int x = Integer.parseInt(str2);
			int prodotto=x*lollo;
			m+=prodotto;
			modello.F5.setText(String.valueOf(m));
		}
		//}
		/*catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }*/
		
	}
	
	

	
	

	
	
	
	/*if(str=="500"){
		
	}*/
	/*public static void inserisci() throws SQLException{
		 String str1 = modello.AttivitàFisica.getText();
         try
         {
             ResultSet rs = statement.executeQuery("SELECT Nome FROM sport WHERE Nome=str1");
             while (rs.next())
             {
                 String val1 = rs.getString(1);
                 if ( val1==str1)
                 {
              	   ResultSet rs1 = statement.executeQuery("SELECT Kcal_ora FROM sport WHERE Nome=str1");
              	   String str3=rs1.getString(1);
              	   String str2 = modello.NumeroOre.getText();
              	   int y = Integer.parseInt(str3);
              	   int x = Integer.parseInt(str2);
              	   int prodotto=x*y;
              	   g=g+prodotto;
              	   modello.F5.setText(String.valueOf(g));
                
                
                 }
                
             }
         } catch (SQLException ex)
         {
             System.out.print("exception is" + ex);
         }
	}*/
	 /*modello.Calcola5.addActionListener(new ActionListener(){     
  	   public void actionPerformed(ActionEvent e){ 
	       //String str1 = modello.AttivitàFisica.getText();
	           try
	           {
	               ResultSet rs = statement.executeQuery("SELECT kcal_ora FROM sport WHERE nome='calcio'");
	               while (rs.next())
	               {
	                   int val1 = rs.getInt("kcal_ora");
	                	   modello.F5.setText(String.valueOf(val1));
	               }
	           }catch(SQLException insertException) {
					displaySQLErrors(insertException);
				}		
  	   }
	   });}
		
	private static void displaySQLErrors(SQLException e) {
	    errorText.append("SQLException: " + e.getMessage() + "\n");
	    errorText.append("SQLState:     " + e.getSQLState() + "\n");
	    errorText.append("VendorError:  " + e.getErrorCode() + "\n");
	  }*/
	
	public void closeConnection() {
		if (connection != null)
			try {
				// relevant after 
				// connection.setAutoCommit(false);
				// connection.commit();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		new modello();
		Diario s = null;

		try{
			s = new Diario("sqlite");
			s.testInsert();
			//s.coscia();
			//ActionEvent evt = null;
			//s.jButton2ActionPerformed(evt);
			//s.inserisci();
			/*s.getColumnNames();
			s.testSelect();
			s.testUpdate();
			s.testSelect();*/
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Errore nel caricamento del driver");
			e.printStackTrace();
		}
	}
}


