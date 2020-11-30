package downloader.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.JPanel;

import downloader.fc.Downloader;

public class DownloadPanel extends JPanel {
	//Vector<Downloader> m_downloaders = new Vector<Downloader>();
	int H;
	int W;
	

	DownloadPanel() {
		W = 600;
		H = 500;

	}

	public void add(String url) {
		try {
			Downloader downloader = new Downloader(url);
			//m_downloaders.add(downloader);
			ProgressBar pb = new ProgressBar(downloader);
			downloader.addPropertyChangeListener(new ProgressBarListener(pb));
			add(pb);
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

	public int getWidth() {
		return W;
	}

	public int getHeight() {
		return H;
	}

	/*
	public Vector<Downloader> getDownloaders(){
		return m_downloaders;
	}
	*/
	
}
