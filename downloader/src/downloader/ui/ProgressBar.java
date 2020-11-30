package downloader.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import downloader.fc.Downloader;

public class ProgressBar extends JProgressBar {
	Downloader m_downloader;
	int m_progress;
	
	ProgressBar(Downloader download){
		m_downloader = download;
		m_progress = download.getProgress();
		setMinimum(0);
		setMaximum(100);
		setValue(0);
		setStringPainted(true);
	}

	public Downloader getDownloader() {
		return m_downloader;
	}
	
	public void updateProgress(int prog) {
		m_progress = prog;
		this.setValue(prog);
	}
}
