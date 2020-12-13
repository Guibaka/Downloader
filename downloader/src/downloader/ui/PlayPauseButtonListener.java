package downloader.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import downloader.fc.Downloader;

public class PlayPauseButtonListener implements ActionListener {
	Downloader m_d;
	JButton m_b;

	PlayPauseButtonListener(JButton b, Downloader d) {
		m_d = d;
		m_b =b;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (m_d.isPaused()) { // cas où le download est en pause
			System.out.println("Continue");
			m_d.resume();
			m_b.setText("pause");
		} else { // cas où le download est en cours
			System.out.println("Suspend");
			m_d.pause();
			m_b.setText("resume");
		}
	}

}
