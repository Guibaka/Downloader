package downloader.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class ButtonRemoveListener implements ActionListener {
	Component m_c;
	JPanel m_dlpanel;
	JFrame m_f;
	
	/* Rajout d'un downloader pour fix le problème en dessous */
	Downloader dl;
	
	ButtonRemoveListener(JFrame f, JPanel dlpanel, Component c, Downloader dl){
		m_c = c;
		m_dlpanel = dlpanel;
		m_f = f;
		this.dl = dl;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* lors du clic sur le bouton on remove le component c 
		 * qui se trouve dans le downloadpanel
		 * qui se trouve dans la frame f						 */
		dl.cancel(true);
		m_dlpanel.remove(m_c);
		m_f.setVisible(true);
	}
	
	/* @GUI: est ce que un m_dlpanel.remove va aussi remove le download et son thread associé???
	 * 		 
	 * 		 il me semble que ça va juste remove sur la frame la downloadbar/boutons/label 
	 * 		 mais pas le download en lui même 
	 * 
	 * EDIT: 
	 * 		 après un test: j'ai lancé un download que j'ai ensuite remove
	 * 		 => dans la console ça a continué de print DONC ça ne "kill" pas le dl 
	 * */
	
}
