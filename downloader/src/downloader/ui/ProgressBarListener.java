package downloader.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import downloader.fc.Downloader;

public class ProgressBarListener implements PropertyChangeListener{
	ProgressBar m_bar;
	
	ProgressBarListener (ProgressBar bar){
		m_bar = bar;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		Downloader d = m_bar.getDownloader();
		m_bar.updateProgress(d.getProgress());;
	}
	
}
