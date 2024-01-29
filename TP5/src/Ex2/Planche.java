package Ex2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Planche   extends Canvas implements WindowListener  {

    private JMenuBar menuBar;
    private JMenu menuFichier;
    private JMenuItem menuItemQuitter;
    private Canvas zoneDessin;
    private JComboBox<String> comboBoxForme;
    private JRadioButton radioButtonRemplissage;
    private JColorChooser couleur;
    String selectedForme;
    boolean remplissage;
    Point P1 ;
    Point P2;
    public Planche() {
        
     Frame F = new Frame();
      F.setSize(400, 400);
     // F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      F.setVisible(true);
        // Création de la barre de menus
        menuBar = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        menuItemQuitter = new JMenuItem("Quitter");
        menuFichier.add(menuItemQuitter);
        menuBar.add(menuFichier);
        //setJMenuBar(menuBar);
        F.add(menuBar);
        F.addWindowListener(this); 
  MouseAdapter MA = new MouseAdapter() {
	  @Override
	public void mousePressed(MouseEvent e) {
		  P1= e.getPoint();
		  System.out.println("hhhhhh");}
	  
	  @Override
	public void mouseDragged(MouseEvent e) {
		  P2= e.getPoint();
		  System.out.println("j,kj,kykyk");
		  repaint();
	}
	  
	  
  };

        // Création de la zone de dessin
        
      //  zoneDessin = new Canvas();
       // zoneDessin.setBackground(Color.cyan);
        F.add(this, BorderLayout.CENTER);
        addMouseListener(MA);
        addMouseMotionListener(MA);
        // Création de la zone des outils
        JPanel zoneOutils = new JPanel();
        zoneOutils.setLayout(new BoxLayout(zoneOutils, BoxLayout.Y_AXIS));

        // Création du menu déroulant des formes
        comboBoxForme = new JComboBox<>();
        comboBoxForme.addItem("Rectangle");
        comboBoxForme.addItem("Ellipse");
        zoneOutils.add(comboBoxForme);
   
        // Création du groupe d'options de couleur
        JPanel groupeCouleur = new JPanel();
        groupeCouleur.setLayout(new BoxLayout(groupeCouleur, BoxLayout.X_AXIS));

        JLabel labelCouleur = new JLabel("Couleur");
        groupeCouleur.add(labelCouleur);
        couleur = new JColorChooser();
        groupeCouleur.add(couleur);
        zoneOutils.add(groupeCouleur);

        // Création de l'option à cocher de remplissage
        radioButtonRemplissage = new JRadioButton("Remplissage");
        zoneOutils.add(radioButtonRemplissage);

        // Ajout de la zone des outils à la fenêtre
        F.add(zoneOutils, BorderLayout.SOUTH);

        // Écoute de l'événement "Quitter"
        menuItemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        comboBoxForme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedForme = (String) comboBoxForme.getSelectedItem();
            }
        });
        radioButtonRemplissage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remplissage = radioButtonRemplissage.isSelected();
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
    	
    	if(P1 !=null && P2 !=null) {
    		int larg = Math.abs(P2.x  - P1.x);
    		int lon = Math.abs(P2.y - P1.y);
    		int minX = Math.min(P1.x, P2.x);
    		int minY = Math.min(P1.y, P2.y);
    		g.setColor(couleur.getColor());
    	if (selectedForme.equals("Rectangle")){
    		if (remplissage == true) {
    			g.fillRect(minX,minY, larg,lon  );
    			
    		}
    		else {
    			g.drawRect(minX,minY, larg, lon);
    			
    		}
    	}
    	if (selectedForme.equals("Ellipse")){
    		if (remplissage == true) {
    			g.fillOval(minX, minY, larg, lon);
    			
    		}
    		else {
    			g.drawOval(minX, minY, larg, lon);
    			
    		}
    	}
    
    	
    	}}
    
    
    
    
    public static void main(String[] args) {
        Planche planche = new Planche();
       
    }

 

	@Override
	public void windowClosing(WindowEvent e) {
 		 System.exit(0);
		
	}







	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	 

	 

 
	 
}
