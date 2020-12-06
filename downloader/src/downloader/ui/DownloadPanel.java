package downloader.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class DownloadPanel extends JPanel {
	//Vector<Downloader> m_downloaders ;
	JFrame m_frame;

	DownloadPanel(JFrame f) {
		//m_downloaders = new Vector<Downloader>();
		m_frame = f;
	}


	public void add(String url) {
		try {
			Downloader downloader = new Downloader(url);
			//m_downloaders.add(downloader);
			ProgressBar pb = new ProgressBar(downloader);
			downloader.addPropertyChangeListener(new ProgressBarListener(pb));
			
			JLabel label = new JLabel(url);
			JPanel d = new JPanel();
			d.setLayout(new BorderLayout());
			JPanel buttons = new JPanel();
			buttons.setLayout(new BorderLayout());
			
			JButton removeB = new JButton("remove");
			removeB.addActionListener(new ButtonRemoveListener(m_frame, this, d));
			buttons.add(removeB, BorderLayout.EAST);
			
			JButton pause_playB = new JButton("pause");
			pause_playB.addActionListener(new PlayPauseButtonListener(downloader));
			buttons.add(pause_playB, BorderLayout.WEST);
			
			d.add(pb);
			d.add(buttons, BorderLayout.EAST);
			d.add(label, BorderLayout.NORTH);
			add(d);
			
			downloader.execute();
		} catch (RuntimeException e) {
			System.err.format("skipping %s %s\n", url, e);
		}

		/*
		Thread t = new Thread() {
			public void run() {
				try {
					String filename = m_downloaders.lastElement().download();
				} catch (InterruptedException e) {
					System.err.println("failed!");
				}
			}
		};	
		t.start();
		*/

	}

	

	/*
	public Vector<Downloader> getDownloaders(){
		return m_downloaders;
	}
	*/
	
}
