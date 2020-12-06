package downloader.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class ButtonRemoveListener implements ActionListener {
	Component m_c;
	JPanel m_d;
	JFrame m_f;
	
	ButtonRemoveListener(JFrame f, JPanel d, Component c){
		m_c = c;
		m_d = d;
		m_f = f;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		m_d.remove(m_c);
		m_f.setVisible(true);
	}
	
	
}
