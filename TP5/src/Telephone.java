import java.awt.*;
import java.awt.event.*;

public class Telephone extends Frame implements ActionListener,WindowListener {
    public String Contenu = "";
    public String prev = "";
    public TextField input;
    public Button B1, B2, B3, B4, B5, B6, B7, B8, B9, Bis, Reset, B0;

    public Telephone() {
        super("Untitled");
        input = new TextField();
        input.setEditable(false);
        Panel panel = new Panel();
        this.setLayout(new BorderLayout());
        this.add(input, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(4, 3));
        B0 = new Button("0");
        B1 = new Button("1");
        B2 = new Button("2");
        B3 = new Button("3");
        B4 = new Button("4");
        B5 = new Button("5");
        B6 = new Button("6");
        B7 = new Button("7");
        B8 = new Button("8");
        B9 = new Button("9");
        panel.add(B1);
        panel.add(B2);
        panel.add(B3);
        panel.add(B4);
        panel.add(B5);
        panel.add(B6);
        panel.add(B7);
        panel.add(B8);
        panel.add(B9);
        B0.addActionListener(this);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        Bis = new Button("Bis");
        Bis.addActionListener(this);
        panel.add(Bis);
        panel.add(B0);
        Reset = new Button("Reset");
        panel.add(Reset);
        Reset.addActionListener(this);
        this.add(panel);
        this.pack();
        this.setSize(300, 200);
        this.setLocation(500, 300);
        this.setVisible(true);
        addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B0) {
            this.Contenu+="0";
        }
        if (e.getSource() == B1) {
            this.Contenu+="1";
        }
        if (e.getSource() == B2) {
            this.Contenu+="2";
        }
        if (e.getSource() == B3) {
            this.Contenu+="3";
        }
        if (e.getSource() == B4) {
            this.Contenu+="4";
        }
        if (e.getSource() == B5) {
            this.Contenu+="5";
        }
        if (e.getSource() == B6) {
            this.Contenu+="6";
        }
        if (e.getSource() == B7) {
            this.Contenu+="7";
        }
        if (e.getSource() == B8) {
            this.Contenu+="8";
        }
        if (e.getSource() == B9) {
            this.Contenu+="9";
        }
        if (e.getSource() == Bis) {
        	this.Contenu=this.prev;

        }
        if (e.getSource() == Reset) {
        	this.prev=this.Contenu;
        	this.Contenu="";
            input.setText(Contenu);
        }
        input.setText(this.Contenu);
        
    }

    public static void main(String[] args) {
        new Telephone();
    }
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(ABORT);	
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(ABORT);	
	}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
