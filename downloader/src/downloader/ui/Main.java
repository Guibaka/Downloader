package downloader.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;

import downloader.fc.Downloader;


public class Main extends JFrame{
	
	Main(String title,  String[] urls){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* création du downloadpanel: là où on traite nos downloads (downloader) */
		DownloadPanel DP = new DownloadPanel(this);
		
		/* stacklayout = modèle de layout qu'on donne à notre component
		 * pour empiler nos barres comme il faut */
		StackLayout SL = new StackLayout();
		DP.setLayout(SL);
		/*
		 * LES PARAMETRES CI DESSOUS PEUVENT ETRE PLACES DANS LA CLASSE DOWNLOADPANEL
		 */
		DP.setBackground(Color.darkGray);
		setSize(600, 500);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setUndecorated(true);
		
		/* ajout des téléchargements en argument */
		for(String url : urls) 
			DP.add(url);
		
		/* jtextfield pour ajouter les urls à télécharger */
		JTextField textP = new JTextField();
		
		/* bouton "add" */
		JButton buttonAdd = new JButton("add");
		
		/* ajout du listener à notre bouton */
		buttonAdd.addActionListener(new ButtonAddListener(textP, DP, this));
		
		/* panel pour placer le textfield et le bouton à droite */
		JPanel userInteract = new JPanel();
		userInteract.setLayout(new BorderLayout());
		userInteract.add(textP);
		userInteract.add(buttonAdd, BorderLayout.EAST);
		
		/* ajout de nos components: les downloads en haut et l'ajout d'urls en bas */
		add(userInteract, BorderLayout.SOUTH);
		add(DP, BorderLayout.NORTH);
	}
	

	public static void main(String[] argv) {
		String[] urls = argv;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				new Main("Dowloader", urls).setVisible(true);; 
			}
		});
	}
}
