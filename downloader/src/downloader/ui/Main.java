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
		
		
		DownloadPanel DP = new DownloadPanel(this);
		StackLayout SL = new StackLayout();
		DP.setLayout(SL);
		DP.setBackground(Color.darkGray);
		setSize(600, 500);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//setUndecorated(true);
		
		
		for(String url : urls) {
			DP.add(url);
		}
		

		JTextField textP = new JTextField();
		JButton buttonAdd = new JButton("add");
		buttonAdd.addActionListener(new ButtonAddListener(textP, DP, this));
		JPanel userInteract = new JPanel();
		userInteract.setLayout(new BorderLayout());
		userInteract.add(textP);
		userInteract.add(buttonAdd, BorderLayout.EAST);
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
