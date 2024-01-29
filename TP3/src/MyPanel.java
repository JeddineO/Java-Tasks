import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyPanel implements WindowListener,ActionListener {
    Agence G = new Agence();
    JFrame frame;
    JButton B1,B2,B3,B4,B5,B6,B7,B8,save,save2,rechercher,Louer;
    JPanel panel1,panel2,panel3,panel4,panel5;
    JTextField nom,prenom,civilite,cin,marque,model,annee,prix,cannee,cmarque,cprix,mat;

    public MyPanel() {
        // Set the look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("loaction"))) {
            G = (Agence) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

       frame = new JFrame("Location de voiture");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel1.setLayout(new GridLayout(2, 4));

         B1 = new JButton("Ajouter une voiture");
         B2 = new JButton("Ajouter un client");
         B3 = new JButton("Louer une voiture");
         B4 = new JButton("Rendre voiture");
         B5 = new JButton("Liste des voitures");
         B6 = new JButton("Liste des clients");
         B7 = new JButton("Liste des loeurs");
         B8 = new JButton("Quitter");
         
         
         JMenuBar jmb = new JMenuBar();
         JMenu file = new JMenu ("Fichier");

         JMenuItem item;
         file.add (item = new JMenuItem ("Enregister"));
         file.addSeparator();
         file.add (item = new JMenuItem ("Fermer"));
         jmb.add (file);
         
         JMenu client = new JMenu ("Clients");
         
         client.add (item = new JMenuItem ("Ajouter"));
         client.addSeparator();
         client.add (item = new JMenuItem ("Supprimer"));
         client.addSeparator();
         client.add (item = new JMenuItem ("Afficher"));
         jmb.add (client);
         
         JMenu voiture = new JMenu ("Voitures");
         voiture.add (item = new JMenuItem ("Ajouter"));
         voiture.addSeparator();
         voiture.add (item = new JMenuItem ("Supprimer"));
         voiture.addSeparator();
         voiture.add (item = new JMenuItem ("Afficher"));
         jmb.add (voiture);
         
         
         JMenu locations = new JMenu ("locations");
         locations.add (item = new JMenuItem ("Louer voiture"));
         locations.addSeparator();
         locations.add (item = new JMenuItem ("Rendre voiture"));
         locations.addSeparator();
         locations.add (item = new JMenuItem ("Afficher loueurs"));
         jmb.add (locations);


         frame.setJMenuBar(jmb);

         

        panel1.add(B1);
        panel1.add(B2);
        panel1.add(B3);
        panel1.add(B4);
        panel1.add(B5);
        panel1.add(B6);
        panel1.add(B7);
        panel1.add(B8);
        
        
        

        JLabel nameLabel = new JLabel("Nom:");
        nom = new JTextField();
        nom.setColumns(10);

        JLabel surnameLabel = new JLabel("Prénom:");
         prenom = new JTextField();

        JLabel cinLabel = new JLabel("CIN:");
         cin = new JTextField();
        cin.setColumns(10);

        JLabel civiliteLabel = new JLabel("Civilité:");
        JComboBox<String> civiliteChoice = new JComboBox<>(new String[]{"Mme", "M"});

         save = new JButton("Enregistrer");
        JButton reset = new JButton("Annuler");
        
      


        panel3.setLayout(new GridLayout(9, 1));
        panel3.add(civiliteLabel);
        panel3.add(civiliteChoice);
        panel3.add(nameLabel);
        panel3.add(nom);
        panel3.add(surnameLabel);
        panel3.add(prenom);
        panel3.add(cinLabel);
        panel3.add(cin);
        panel3.add(reset);
        panel3.add(save);
        
        
        cmarque = new JTextField();
        cmarque.setColumns(10);
        cannee = new JTextField();
        cannee.setColumns(10);
        cprix = new JTextField();
        cprix.setColumns(10);
        rechercher=new JButton("Rechercher");
        
        panel4.setLayout(new FlowLayout());

        panel4.add(new JLabel("Marque :"));
        panel4.add(cmarque);
        panel4.add(new JLabel("Année :"));
        panel4.add(cannee);
        panel4.add(new JLabel("Prix :"));
        panel4.add(cprix);
        panel4.add(rechercher);
        
        
        
        marque = new JTextField();
        marque.setColumns(10);
        
        model = new JTextField();
        model.setColumns(10);
        
        annee = new JTextField();
        annee.setColumns(10);
        
        prix = new JTextField();
        prix.setColumns(10);
        
        save2 = new JButton("Enregistrer");
        JButton retour = new JButton("Annuler");
        
        
        
        panel5.setLayout(new FlowLayout());

        
        
        panel5.add(new JLabel("Enter le matricule :"));
        Louer=new JButton("Louer");
        mat = new JTextField();
        mat.setColumns(10);
        panel5.add(mat); 
        panel5.add(Louer);


        B1.addActionListener(this);
        B2.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B3.addActionListener(this);
        save.addActionListener(this);
        save2.addActionListener(this);
        rechercher.addActionListener(this);
        B8.addActionListener(this);

        
       
       panel2.setLayout(new GridLayout(9, 1));
       panel2.add(new JLabel("Marque :"));
       panel2.add(marque);
       panel2.add(new JLabel("Modèle :"));
       panel2.add(model);
       panel2.add(new JLabel("Année :"));
       panel2.add(annee);
       panel2.add(new JLabel("Prix :"));
       panel2.add(prix);
       panel2.add(save2);
       panel2.add(retour);
       
       
       
       
       


        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.addWindowListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400); 
        frame.setLocation(350, 200);

    }

    public static void main(String[] args) {
        new MyPanel();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == B1) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel1, BorderLayout.NORTH);
            frame.getContentPane().add(panel2, BorderLayout.CENTER);
            frame.revalidate(); 
            frame.repaint();    
        }
if (e.getSource() == save2) {
	int a=-1,b=-1;
	a=Integer.parseInt(annee.getText());
	b=Integer.parseInt(prix.getText());

    		
    		try {
    			G.voitures.add(new Voiture(marque.getText(), model.getText(), a, b));
    		    JOptionPane.showMessageDialog(null, "Voiture ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
    		    frame.getContentPane().removeAll();
                frame.getContentPane().add(panel1, BorderLayout.NORTH);
                frame.revalidate(); 
                frame.repaint();
    		} catch (Exception ex) {
    		    ex.printStackTrace();
    		}
    	}
    	if (e.getSource() == B2) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel1, BorderLayout.NORTH);
            frame.getContentPane().add(panel3, BorderLayout.CENTER);
            frame.revalidate(); 
            frame.repaint();    
        }
    	if (e.getSource() == save) {
    		
    		try {
    		    G.clients.add(new Client(nom.getText(), prenom.getText(), cin.getText(), "M"));
    		    JOptionPane.showMessageDialog(null, "Client ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
    		    frame.getContentPane().removeAll();
                frame.getContentPane().add(panel1, BorderLayout.NORTH);
                frame.revalidate(); 
                frame.repaint();
    		} catch (Exception ex) {
    		    ex.printStackTrace();
    		}
    	}
    	if (e.getSource() == B3) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel1, BorderLayout.NORTH);
            frame.getContentPane().add(panel4, BorderLayout.WEST);
            frame.revalidate(); 
            frame.repaint();    
        }
    	if (e.getSource() == rechercher) {
    	    InterCritere IC = new InterCritere();   

    	    if (!cannee.getText().equals("")) {
    	        CritereAnnee Cannee = new CritereAnnee(Integer.parseInt(cannee.getText()));
    	        IC.addCritere(Cannee);
    	    }

    	    if (!cprix.getText().equals("")) {
    	        CriterePrix Cprix = new CriterePrix(Integer.parseInt(cprix.getText()));
    	        IC.addCritere(Cprix);
    	    }
    	    
    	    if (!cmarque.getText().equals("")) {
    	    	CritereMarque Cmarque = new CritereMarque(cmarque.getText());
        	    IC.addCritere(Cmarque);
    	    }    	    

    	   JTextArea resultTextArea = new JTextArea(G.afficheSelection(IC));
    	    

    	    frame.getContentPane().removeAll();
    	    frame.setLayout(new FlowLayout());

    	    frame.getContentPane().add(panel1, BorderLayout.NORTH);
    	    frame.getContentPane().add(panel4, BorderLayout.NORTH);
    	    frame.getContentPane().add(resultTextArea);
    	    frame.getContentPane().add(panel5);
    	    frame.revalidate();
    	    frame.repaint();
    	}


    	if (e.getSource() == B5) {
            StringBuilder clientsInfo = new StringBuilder("Liste des voiture: \n");

            for (Voiture voiture : G.voitures) {
                clientsInfo.append(voiture).append("\n");
            }
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel1, BorderLayout.NORTH);
            JTextArea resultTextArea = new JTextArea(clientsInfo.toString());
            frame.getContentPane().add(resultTextArea, BorderLayout.CENTER);
            frame.revalidate(); 
            frame.repaint(); 
        }
    	
    	if (e.getSource() == B6) {
            StringBuilder clientsInfo = new StringBuilder("Liste des clients: \n");

            for (Client client : G.clients) {
                clientsInfo.append(client).append("\n");
            }
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel1, BorderLayout.NORTH);
            JTextArea resultTextArea = new JTextArea(clientsInfo.toString());
            frame.getContentPane().add(resultTextArea, BorderLayout.CENTER);
            frame.revalidate(); 
            frame.repaint(); 
        }
    	
    	if (e.getSource() == B8) {
           
            frame.getContentPane().removeAll();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loaction"))) {
    			oos.writeObject(G);
    			System.out.println("Object est bien serialisé.");
    		} catch (IOException ex) {
    			ex.printStackTrace();
    		}
            System.exit(0);
        }
    	
    	if (e.getSource() == Louer) {
            
			Voiture v = G.findVoiture(Integer.parseInt(mat.getText()));

        }
	}

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
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
