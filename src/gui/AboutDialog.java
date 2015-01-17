package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class AboutDialog extends JDialog implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
	
	public AboutDialog() {
		
		ClassLoader cl = this.getClass().getClassLoader();
		setModal(true);
		setTitle("About");
		ImageIcon abico = new ImageIcon(cl.getResource("about.png"));
		setIconImage(abico.getImage());
		setSize(500, 225);
		setLocationRelativeTo(Frame.getInstance());
		setResizable(false);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Created by:");
		
		
		JLabel ip = new JLabel("Ivan Šop");
		JLabel em = new JLabel("ivan.sop93@gmail.com");
		JLabel ind = new JLabel("RA121/2012");
		JLabel imgLabel = new JLabel(new ImageIcon(cl.getResource("aboutimage.jpg")));
		
		JButton close = new JButton("Close");
		close.addActionListener(this);
		
		// glavni panel, obuhvata sve
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		panel.setBackground(Color.WHITE);
		
		// sve desno od slike				
		JPanel desnaStrana = new JPanel();
		desnaStrana.setLayout(new BorderLayout());
		
		// deljenje desne strane
		JPanel gore = new JPanel();
		gore.setBackground(Color.WHITE);
		gore.setPreferredSize(new Dimension(30, 20));
		
		JPanel dole = new JPanel();
		dole.setBackground(Color.WHITE);
		dole.setPreferredSize(new Dimension(30, 50));
				
		JPanel levo = new JPanel();
		levo.setBackground(Color.WHITE);
		levo.setPreferredSize(new Dimension(40, 45));
		
		JPanel desno = new JPanel();
		desno.setBackground(Color.WHITE);

		JPanel sredina = new JPanel();
		sredina.setLayout(new GridLayout(4,1));
		sredina.setBackground(Color.WHITE);
		sredina.setBorder(title);
		
		
		//close je na juznom panelu
		dole.add(close);
		
		// podaci na centralnom panelu
		sredina.add(ip);
		sredina.add(ind);
		sredina.add(em);
		
		
		add(panel);
		
		// slika je na glavnom panelu
		panel.add(imgLabel);
		
		desnaStrana.add(gore,BorderLayout.NORTH);
		desnaStrana.add(dole,BorderLayout.SOUTH);
		desnaStrana.add(levo,BorderLayout.WEST);
		desnaStrana.add(desno,BorderLayout.EAST);
		desnaStrana.add(sredina,BorderLayout.CENTER);
		panel.add(desnaStrana);
	}


	
	
}
