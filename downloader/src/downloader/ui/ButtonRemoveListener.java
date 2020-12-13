package downloader.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class ButtonRemoveListener implements ActionListener {
	JPanel m_barP;
	JPanel m_dlpanel;
	JFrame m_f;
	
	Downloader m_dl;
	
	ButtonRemoveListener(JFrame f, JPanel dlpanel, JPanel barP, Downloader dl){
		m_barP = barP;
		m_dlpanel = dlpanel;
		m_f = f;
		m_dl = dl;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* lors du clic sur le bouton on arrête le download 
		 * et remove le panel m_barP 
		 * qui se trouve dans le downloadpanel
		 * qui se trouve dans la frame f						 */
		m_dl.cancel(true);
		m_dlpanel.remove(m_barP);
		m_f.setVisible(true);// nécessaire pour affecter une taille au component ajouté
	}
	
}
