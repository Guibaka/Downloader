package downloader.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import downloader.fc.Downloader;

public class PlayPauseButtonListener implements ActionListener {
	Downloader m_d;

	PlayPauseButtonListener(Downloader d) {
		m_d = d;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (m_d.isPaused()) {
			System.out.println("Continue");
			m_d.resume();
		} else {
			System.out.println("Suspend");
			m_d.pause();
		}
	}

}
