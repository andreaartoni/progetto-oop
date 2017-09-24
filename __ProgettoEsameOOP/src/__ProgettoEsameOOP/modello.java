package __ProgettoEsameOOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Object;


public class modello extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JTextField PrimaColazione;
	public static JTextField Pranzo;
	public static JTextField Cena;
	public static JTextField Snack;
	public static JTextField Attivit‡Fisica;
	public static JTextField Quantit‡1;
	public static JTextField Quantit‡2;
	public static JTextField Quantit‡3;
	public static JTextField Quantit‡4;
	public static JTextField NumeroOre;
	private JButton L1;
	private JButton L2;
	private JButton L3;
	private JButton L4;
	private JButton L5;
	public static JButton Calcola1;
	public static JButton Calcola2; 
	public static JButton Calcola3;
	public static JButton Calcola4;
	public static JButton Calcola5;
	public static JLabel F1;
	public static JLabel F2;
	public static JLabel F3;
	public static JLabel F4;
	public static JLabel F5;
	private JButton B;
	private JButton TotaleKcal;
	private JButton Dispendio;
	private JLabel Tot;
	private JLabel Disp;
	private JTextField Massa;
	private JLabel Dif;
	private JToolBar Bar;
	private Date dt;
	private SimpleDateFormat dateFormat;
	private JLabel lblday;
	private String day;
	private JButton Cibo;
	int t=0;
	Statement statement;
	Connection connection;
	String db;
	int w=0;
	public static Connection con;
	
	public modello() {
		super("Diario");
		PrimaColazione=new JTextField("");
		Pranzo=new JTextField("");
		Cena=new JTextField("");
		Snack=new JTextField("");
		Attivit‡Fisica=new JTextField("");
		Quantit‡1=new JTextField("");
		Quantit‡2=new JTextField("");
		Quantit‡3=new JTextField("");
		Quantit‡4=new JTextField("");
		NumeroOre=new JTextField("");
		F1=new JLabel();
		F1.setText("0");
		F2=new JLabel();
		F2.setText("0");
		F3=new JLabel();
		F3.setText("0");
		F4=new JLabel();
		F4.setText("0");
		F5=new JLabel();
		F5.setText("0");
		B=new JButton("Assunte troppe calorie o no?");
		L1=new JButton("Aggiungi alimento");
		L2=new JButton("Aggiungi alimento");
		L3=new JButton("Aggiungi alimento");
		L4=new JButton("Aggiungi alimento");
		L5=new JButton("Aggiungi sport");
		Calcola1=new JButton("Calcola kcal");
		Calcola2=new JButton("Calcola kcal");
		Calcola3=new JButton("Calcola kcal");
		Calcola4=new JButton("Calcola kcal");
		Calcola5=new JButton("Calcola kcal");
		TotaleKcal= new JButton("Calcola il totale delle calorie acquisite");
		Dispendio=new JButton("Calcola il dispendio energetico");
		Tot=new JLabel();
		Disp=new JLabel();
		Tot.setText("0");
		Disp.setText("0");
		Massa=new JTextField("");
		Dif=new JLabel();
		Bar=new JToolBar();
		lblday=new JLabel();
		Cibo=new JButton("Alimenti aggiunti");
		ArrayList<String> myList = new ArrayList<String>();
		ArrayList<String> meList = new ArrayList<String>();
		ArrayList<String> miList = new ArrayList<String>();
		ArrayList<String> moList = new ArrayList<String>();
		 
		        try {
		            URL urlImageOpen = new URL("http://www.simplesoft.it/img/articles/java/toolBar/open.png");
		            URL urlImageSave = new URL("http://www.simplesoft.it/img/articles/java/toolBar/save.png");
		            URL urlImageAbout = new URL("http://www.simplesoft.it/img/articles/java/toolBar/about.png");
		            URL urlImageExit = new URL("http://www.simplesoft.it/img/articles/java/toolBar/exit.png");
		            JButton buttonOpen = new JButton(new ImageIcon(urlImageOpen));
		            JButton buttonSave = new JButton(new ImageIcon(urlImageSave));
		            JButton buttonAbout = new JButton(new ImageIcon(urlImageAbout));
		            JButton buttonExit = new JButton(new ImageIcon(urlImageExit));
		            Bar.add(buttonOpen);
		            Bar.add(buttonSave);
		            Bar.add(buttonAbout);
		            Bar.add(buttonExit);
		            
		            buttonExit.addActionListener(new ActionListener(){
		    			public void actionPerformed(ActionEvent e){
		    				System.exit(0);
		    			}
		    		});
		            
		        } catch (Exception ex) {
		                ex.printStackTrace();
		        }
		
		dt=new Date();
		dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		day = dateFormat.format(dt);
        lblday.setText(day);
        
        
		JPanel p0 = new JPanel();
		p0.add(lblday);
		p0.add(Bar);
		p0.add(Cibo);
		setLayout(new BorderLayout());
		add(p0, BorderLayout.NORTH);
		
		
		
		Cibo.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	 JFrame frame = new JFrame("Alimenti mangiati");
		            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            try 
		            {
		               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		            } catch (Exception f) {
		               f.printStackTrace();
		            }
		            JPanel panel = new JPanel();
		            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		            panel.setOpaque(true);
		            
		            int h=0;
		            JPanel inputpanel = new JPanel();
		            inputpanel.setLayout(new FlowLayout());
		            JTextField input = new JTextField(30);
		            JButton button = new JButton("Numero Alimenti");
		            DefaultListModel<String> model = new DefaultListModel<String>();
		            for(String s:myList){
		                model.addElement(s+"  Prima colazione");
		                h++;
		            }
		            JList<String> contactList = new JList<String>(model);
		            
		            DefaultListModel<String> pippo = new DefaultListModel<String>();
		            for(String s:meList){
		                model.addElement(s+"  Pranzo");
		                h++;
		            }
		            JList<String> superList = new JList<String>(pippo);
		            
		            DefaultListModel<String> pluto = new DefaultListModel<String>();
		            for(String s:miList){
		                model.addElement(s+"  Cena");
		                h++;
		            }
		            JList<String> excerList = new JList<String>(pluto);
		            
		            DefaultListModel<String> papero = new DefaultListModel<String>();
		            for(String s:moList){
		                model.addElement(s+"  Snack");
		                h++;
		            }
		            JList<String> fenderList = new JList<String>(papero);
		            
		            /*JScrollPane scroller = new JScrollPane(contactList);
		            scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);*/
		            /*panel.setLayout(new GridLayout(3, 3));*/
		            panel.add(contactList);
		            panel.add(superList);
		            panel.add(excerList);
		            panel.add(fenderList);
		            /*panel.add(scroller);*/
		            inputpanel.add(input);
		            inputpanel.add(button);
		            panel.add(inputpanel);
		            /*setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    		setSize(400, 200);
		    		setVisible(true);*/
		            /*setLayout(new BorderLayout());
		            add(panel,BorderLayout.CENTER);*/
		            String str = Integer.toString(h);
		            button.addActionListener(new ActionListener(){
		    		    public void actionPerformed(ActionEvent e){
		    		    	input.setText(str);
		    		    }
		    		    });
		            frame.getContentPane().add(BorderLayout.CENTER, panel);
		            frame.pack();
		            frame.setLocationByPlatform(true);
		            frame.setVisible(true);
		            frame.setResizable(true);
		            input.requestFocus();
		    }
		});
		
		
		
		
			
		
			
		
               /* Calcola1.addActionListener(new ActionListener(){
				
			    public void actionPerformed(ActionEvent e){
		               F1.setText("250");
			    }
        		});
                Calcola2.addActionListener(new ActionListener(){
    				
    			    public void actionPerformed(ActionEvent e){
    		               F2.setText("350");
    			    }
            		});
                Calcola3.addActionListener(new ActionListener(){
    				
    			    public void actionPerformed(ActionEvent e){
    		               F3.setText("450");
    			    }
            		});
                Calcola4.addActionListener(new ActionListener(){
    				
    			    public void actionPerformed(ActionEvent e){
    		               F4.setText("150");
    			    }
            		});
                Calcola5.addActionListener(new ActionListener(){
    				
    			    public void actionPerformed(ActionEvent e){
    		               F5.setText("950");
    			    }
            		});*/
                
		

		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 8));
		p1.add(PrimaColazione);
		p1.add(new JLabel("PrimaColazione"));
		p1.add(Quantit‡1);
		p1.add(new JLabel("Quantit‡ per 100g"));
		p1.add(Calcola1);
	    p1.add(F1);
		p1.add(new JLabel("Kcal"));
		p1.add(L1);
		p1.add(Pranzo);
		p1.add(new JLabel("Pranzo"));
		p1.add(Quantit‡2);
		p1.add(new JLabel("Quantit‡ per 100g"));
		p1.add(Calcola2);
		p1.add(F2);
		p1.add(new JLabel("Kcal"));
		p1.add(L2);
		p1.add(Cena);
		p1.add(new JLabel("Cena"));
		p1.add(Quantit‡3);
		p1.add(new JLabel("Quantit‡ per 100g"));
		p1.add(Calcola3);
		p1.add(F3);
		p1.add(new JLabel("Kcal"));
		p1.add(L3);
		p1.add(Snack);
		p1.add(new JLabel("Snack"));
		p1.add(Quantit‡4);
		p1.add(new JLabel("Quantit‡ per 100g"));
		p1.add(Calcola4);
		p1.add(F4);
		p1.add(new JLabel("Kcal"));
		p1.add(L4);
		p1.add(Attivit‡Fisica);
		p1.add(new JLabel("Attivit‡Fisica"));
		p1.add(NumeroOre);
		p1.add(new JLabel("NumeroOre"));
		p1.add(Calcola5);
		p1.add(F5);
		p1.add(new JLabel("Kcal"));
		p1.add(L5);
		
		
		add(p1, BorderLayout.CENTER);
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(4, 2));
		p2.add(Tot);
		p2.add(TotaleKcal);
		p2.add(Disp);
		p2.add(Dispendio);
		p2.add(Massa);
		p2.add(new JLabel("Peso"));
		p2.add(B);
		p2.add(Dif);
		add(p2, BorderLayout.SOUTH);
		
		L1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=Quantit‡1.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	myList.add(PrimaColazione.getText()+" "+qie+"g");
		        PrimaColazione.setText("");
		        Quantit‡1.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		L2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=Quantit‡2.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	meList.add(Pranzo.getText()+" "+qie+"g");
		        Pranzo.setText("");
		        Quantit‡2.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		L3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=Quantit‡3.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	miList.add(Cena.getText()+" "+qie+"g");
		        Cena.setText("");
		        Quantit‡3.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		L4.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=Quantit‡4.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	moList.add(Snack.getText()+" "+qie+"g");
		        Snack.setText("");
		        Quantit‡4.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		L5.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        Attivit‡Fisica.setText("");
		        NumeroOre.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		TotaleKcal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String gr=F1.getText();
				String ga=F2.getText();
				String gb=F3.getText();
				String gc=F4.getText();

				int q=Integer.parseInt(gr);
			    int w=Integer.parseInt(ga);
			    int l=Integer.parseInt(gb);
			    int r=Integer.parseInt(gc); 
			    int h=q+w+l+r;
			    Tot.setText(String.valueOf(h));
			}
		});
		
		Dispendio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			String gr=F1.getText();
			String ga=F2.getText();
			String gb=F3.getText();
			String gc=F4.getText();
			String gd=F5.getText();
		    int q=Integer.parseInt(gr);
		    int w=Integer.parseInt(ga);
		    int l=Integer.parseInt(gb);
		    int r=Integer.parseInt(gc);
		    int t=Integer.parseInt(gd);
		    int h=q+w+l+r-t;
		    Disp.setText(String.valueOf(h));
			}
		});
		
		B.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			String ta=Disp.getText();
			String tb=Massa.getText();
			int k=Integer.parseInt(ta);
			int j=Integer.parseInt(tb);
			if((k/j)<20)
				Dif.setText("No");
			else
				Dif.setText("Si");
			}
		});
		
		/*private static void displaySQLErrors(SQLException e) {
			errorText.append("SQLException: " + e.getMessage() + "\n");
		    errorText.append("SQLState:     " + e.getSQLState() + "\n");
		    errorText.append("VendorError:  " + e.getErrorCode() + "\n");
		  }*/
		Calcola1.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.lato();
					} catch(Exception ex) {
					     ex.printStackTrace();
					}
			}
		});
		
		Calcola2.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.palo();
					} catch(Exception ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		Calcola3.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.petto();
					} catch(Exception ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		Calcola4.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						
						Diario.coscia();
					} catch(SQLException ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		
		
		
		Calcola5.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try{
						Diario.inserisci();
					}catch (Exception ex)
			        {
			            ex.printStackTrace();
			        } 
			}
		});
		
	

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1200, 650);
		setVisible(true);
	}
	
}





