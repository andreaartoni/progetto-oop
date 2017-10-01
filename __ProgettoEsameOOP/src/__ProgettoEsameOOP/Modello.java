package __ProgettoEsameOOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modello extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JTextField primaColazione;
	public static JTextField pranzo;
	public static JTextField cena;
	public static JTextField snack;
	public static JTextField attivit‡Fisica;
	public static JTextField quantit‡1;
	public static JTextField quantit‡2;
	public static JTextField quantit‡3;
	public static JTextField quantit‡4;
	public static JTextField numeroOre;
	private JButton l1;
	private JButton l2;
	private JButton l3;
	private JButton l4;
	private JButton l5;
	public static JButton calcola1;
	public static JButton calcola2; 
	public static JButton calcola3;
	public static JButton calcola4;
	public static JButton calcola5;
	public static JLabel f1;
	public static JLabel f2;
	public static JLabel f3;
	public static JLabel f4;
	public static JLabel f5;
	public static JLabel totColazione;
	public static JLabel totPranzo;
	public static JLabel totCena;
	public static JLabel totSnack;
	public static JLabel totSport;
	private JButton bilancio;
	private JLabel fabbisogno;
	private JLabel totaleKcal; //
	public static JLabel tot;
	public static JLabel fab;
	private JLabel dif;
	private JToolBar bar;
	private Date dt;
	private SimpleDateFormat dateFormat;
	private JLabel lblday;
	private String day;
	private JButton cibo;
	int t=0;
	
	public Modello(int n, String username) {
		super("Diario");
		
		primaColazione=new JTextField("");
		pranzo=new JTextField("");
		cena=new JTextField("");
		snack=new JTextField("");
		attivit‡Fisica=new JTextField("");
		quantit‡1=new JTextField("");
		quantit‡2=new JTextField("");
		quantit‡3=new JTextField("");
		quantit‡4=new JTextField("");
		numeroOre=new JTextField("");
		
		f1=new JLabel("0");
		f2=new JLabel("0");
		f3=new JLabel("0");
		f4=new JLabel("0");
		f5=new JLabel("0");
	
		totColazione=new JLabel("0");
		totPranzo=new JLabel("0");
		totCena=new JLabel("0");
		totSnack=new JLabel("0");
		totSport=new JLabel("0");
		
		
		dt=new Date();
		dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		day = dateFormat.format(dt);
		Diario.calorieAssunte(day, username);

		bilancio=new JButton("Assunte troppe calorie o no?");

		l1=new JButton("Aggiungi alimento");
		l2=new JButton("Aggiungi alimento");
		l3=new JButton("Aggiungi alimento");
		l4=new JButton("Aggiungi alimento");
		l5=new JButton("Aggiungi sport");
		
		calcola1=new JButton("Calcola kcal");
		calcola2=new JButton("Calcola kcal");
		calcola3=new JButton("Calcola kcal");
		calcola4=new JButton("Calcola kcal");
		calcola5=new JButton("Calcola kcal");
		
		totaleKcal= new JLabel("Totale delle calorie acquisite");
		fabbisogno=new JLabel("Fabbisogno energetico");
		int totale = Integer.parseInt(totColazione.getText())+Integer.parseInt(totPranzo.getText())+Integer.parseInt(totCena.getText())+Integer.parseInt(totSnack.getText());
		tot=new JLabel(String.valueOf(totale));
		fab=new JLabel(String.valueOf(n+Integer.parseInt(totSport.getText())));
		
		dif=new JLabel();
		bar=new JToolBar();
		lblday=new JLabel();
	
		cibo=new JButton("Alimenti aggiunti");
		ArrayList<String> listaColazione = new ArrayList<String>();
		ArrayList<String> listaPranzo = new ArrayList<String>();
		ArrayList<String> listaCena = new ArrayList<String>();
		ArrayList<String> listaSnack = new ArrayList<String>();
		 
		        try {
		            URL urlImageOpen = new URL("http://www.simplesoft.it/img/articles/java/toolBar/open.png");
		            URL urlImageSave = new URL("http://www.simplesoft.it/img/articles/java/toolBar/save.png");
		            URL urlImageAbout = new URL("http://www.simplesoft.it/img/articles/java/toolBar/about.png");
		            URL urlImageExit = new URL("http://www.simplesoft.it/img/articles/java/toolBar/exit.png");
		            JButton buttonOpen = new JButton(new ImageIcon(urlImageOpen));
		            JButton buttonSave = new JButton(new ImageIcon(urlImageSave));
		            JButton buttonAbout = new JButton(new ImageIcon(urlImageAbout));
		            JButton buttonExit = new JButton(new ImageIcon(urlImageExit));
		            bar.add(buttonOpen);
		            bar.add(buttonSave);
		            bar.add(buttonAbout);
		            bar.add(buttonExit);
		            
		            buttonExit.addActionListener(new ActionListener(){
		    			public void actionPerformed(ActionEvent e){
		    				System.exit(0);
		    			}
		    		});
		            
		            buttonSave.addActionListener(new ActionListener(){
		    			public void actionPerformed(ActionEvent e){
		    				Diario.aggiorna(day, username);
		    			}
		    		});
		            
		            
		        } catch (Exception ex) {
		                ex.printStackTrace();
		        }
		
	
        lblday.setText(day);
        
		JPanel p0 = new JPanel();
		p0.add(lblday);
		p0.add(bar);
		p0.add(cibo);
		setLayout(new BorderLayout());
		add(p0, BorderLayout.NORTH);
		
		
		cibo.addActionListener(new ActionListener(){
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
		            for(String s:listaColazione){
		                model.addElement(s+"  Prima colazione");
		                h++;
		            }
		            JList<String> contactList = new JList<String>(model);
		            
		            DefaultListModel<String> pippo = new DefaultListModel<String>();
		            for(String s:listaPranzo){
		                model.addElement(s+"  Pranzo");
		                h++;
		            }
		            JList<String> superList = new JList<String>(pippo);
		            
		            DefaultListModel<String> pluto = new DefaultListModel<String>();
		            for(String s:listaCena){
		                model.addElement(s+"  Cena");
		                h++;
		            }
		            JList<String> excerList = new JList<String>(pluto);
		            
		            DefaultListModel<String> papero = new DefaultListModel<String>();
		            for(String s:listaSnack){
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
			
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 9));
		p1.add(primaColazione);
		p1.add(new JLabel("Prima Colazione"));
		p1.add(quantit‡1);
		p1.add(new JLabel("quantit‡ per 100g"));
		p1.add(calcola1);
	    p1.add(f1);
	    p1.add(totColazione);
		p1.add(new JLabel("Kcal"));
		p1.add(l1);
		p1.add(pranzo);
		p1.add(new JLabel("Pranzo"));
		p1.add(quantit‡2);
		p1.add(new JLabel("quantit‡ per 100g"));
		p1.add(calcola2);
		p1.add(f2);
		p1.add(totPranzo);
		p1.add(new JLabel("Kcal"));
		p1.add(l2);
		p1.add(cena);
		p1.add(new JLabel("Cena"));
		p1.add(quantit‡3);
		p1.add(new JLabel("quantit‡ per 100g"));
		p1.add(calcola3);
		p1.add(f3);
		p1.add(totCena);
		p1.add(new JLabel("Kcal"));
		p1.add(l3);
		p1.add(snack);
		p1.add(new JLabel("Snack"));
		p1.add(quantit‡4);
		p1.add(new JLabel("quantit‡ per 100g"));
		p1.add(calcola4);
		p1.add(f4);
		p1.add(totSnack);
		p1.add(new JLabel("Kcal"));
		p1.add(l4);
		p1.add(attivit‡Fisica);
		p1.add(new JLabel("attivit‡ fisica"));
		p1.add(numeroOre);
		p1.add(new JLabel("numero ore"));
		p1.add(calcola5);
		p1.add(f5);
		p1.add(totSport);
		p1.add(new JLabel("Kcal"));
		p1.add(l5);
		
		
		add(p1, BorderLayout.CENTER);
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(4, 2));
		p2.add(tot);
		p2.add(totaleKcal);
		p2.add(fab);
		p2.add(fabbisogno);
		p2.add(bilancio);
		p2.add(dif);
		add(p2, BorderLayout.SOUTH);
		
		l1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=quantit‡1.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	listaColazione.add(primaColazione.getText()+" "+qie+"g");
		        primaColazione.setText("");
		        quantit‡1.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		l2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=quantit‡2.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	listaPranzo.add(pranzo.getText()+" "+qie+"g");
		        pranzo.setText("");
		        quantit‡2.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		l3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=quantit‡3.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	listaCena.add(cena.getText()+" "+qie+"g");
		        cena.setText("");
		        quantit‡3.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		l4.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	String te=quantit‡4.getText();
		    	int qi=Integer.parseInt(te);
		    	int qie=qi*100;
		    	listaSnack.add(snack.getText()+" "+qie+"g");
		        snack.setText("");
		        quantit‡4.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
		l5.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        attivit‡Fisica.setText("");
		        numeroOre.setText("");
		        //textfield.setText(null); //or use this
		    }
		});
		
	
		bilancio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			int totaleAssunto=Integer.parseInt(tot.getText());
			int totaleFabbisogno=Integer.parseInt(fab.getText());
			if(totaleAssunto<=totaleFabbisogno)
				dif.setText("No");
			else
				dif.setText("Si");
			}
		});
		
		calcola1.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.colazione();
						int k=Integer.parseInt(f1.getText());
						totColazione.setText(String.valueOf(Integer.parseInt(totColazione.getText())+k));
						tot.setText(String.valueOf(Integer.parseInt(tot.getText())+k));
					} catch(Exception ex) {
					     ex.printStackTrace();
					}
			}
		});
		
		calcola2.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.pranzo();
						int k=Integer.parseInt(f2.getText());
						totPranzo.setText(String.valueOf(Integer.parseInt(totPranzo.getText())+k));
						tot.setText(String.valueOf(Integer.parseInt(tot.getText())+k));
					} catch(Exception ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		calcola3.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.cena();
						int k=Integer.parseInt(f3.getText());
						totCena.setText(String.valueOf(Integer.parseInt(totCena.getText())+k));
						tot.setText(String.valueOf(Integer.parseInt(tot.getText())+k));
					} catch(Exception ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		calcola4.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try {
						Diario.snack();
						int k=Integer.parseInt(f4.getText());
						totSnack.setText(String.valueOf(Integer.parseInt(totSnack.getText())+k));
						tot.setText(String.valueOf(Integer.parseInt(tot.getText())+k));
					} catch(SQLException ex) {
					     ex.printStackTrace();
					}	
			}
		});
		
		calcola5.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
					try{
						Diario.sport();
						int k=Integer.parseInt(f5.getText());
						totSport.setText(String.valueOf(Integer.parseInt(totSport.getText())+k));
						fab.setText(String.valueOf(Integer.parseInt(tot.getText())+k));
					}catch (Exception ex)
			        {
			            ex.printStackTrace();
			        } 
			}
		});

		setSize(1200, 650);
		setVisible(true);
	}
	
}





