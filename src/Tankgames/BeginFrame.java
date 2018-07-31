package Tankgames;



import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class BeginFrame extends JFrame{
	private Container container = null;
	private myJPanel beginpic = null;
	private KeyMonitor keymonitor = new KeyMonitor();
	
	private class myJPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(new ImageIcon("Picture/start.png").getImage(),0,0,700,600,this);
		}
	}
	private class ItemListener3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	
	private class ItemListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			remove(beginpic);
			if (container != null)
				remove(container);
			container = new TankGameFrame();
			add(container);
			addKeyListener(keymonitor);
		}
	}
	private class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			Tank.tank.getEvent(e);
		}
	}
	private class ItemListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (container != null) {
				remove(container);
				container = null;
				removeKeyListener(keymonitor);
				add(beginpic);
			}
			beginpic.repaint();
		}
	}
}
