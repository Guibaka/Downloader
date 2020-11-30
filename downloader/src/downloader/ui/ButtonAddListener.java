package downloader.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonAddListener implements ActionListener {
	JTextField m_textField;
	DownloadPanel m_downloadPanel;
	
	ButtonAddListener(JTextField text, DownloadPanel dp){
		m_textField = text;
		m_downloadPanel = dp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String url = m_textField.getText();
		if(url!=null) {
			m_downloadPanel.add(url);
			m_downloadPanel.repaint();
		}
	}

}
