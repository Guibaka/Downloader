package downloader.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonAddListener implements ActionListener {
	JTextField m_textField;
	DownloadPanel m_downloadPanel;
	JFrame m_frame;
	
	ButtonAddListener(JTextField text, DownloadPanel dp, JFrame f){
		m_textField = text;
		m_downloadPanel = dp;
		m_frame = f;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* lorsqu'on va cliquer sur le bouton, on va récupérer le contenu du
		 * jtextfield:
		 * 		- si c'est null: il n'y a rien on ne fait rien
		 * 		- sinon on traite le string grâce à add
		 * */
		String url = m_textField.getText();
		if(url!=null) {
			m_downloadPanel.add(url);
			m_textField.setText(null);
			m_frame.setVisible(true);
		}
	}

}
