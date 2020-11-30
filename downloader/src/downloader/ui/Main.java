package downloader.ui;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import downloader.fc.Downloader;


public class Main extends JFrame{
	
	Main(String title,  String[] urls){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		DownloadPanel DP = new DownloadPanel();
		StackLayout SL = new StackLayout();
		DP.setLayout(SL);
		setSize(DP.getWidth(), DP.getHeight());
		
		
		for(String url : urls) {
			DP.add(url);
		}
		
		add(DP);
		
	}
	

	public static void main(String[] argv) {
		String[] urls = argv;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				new Main("Dowloader", urls).setVisible(true); 
			}
		});
	}
}
