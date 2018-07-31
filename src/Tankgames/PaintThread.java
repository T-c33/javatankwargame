package Tankgames;

import Tankgames.TankGameFrame;

public class PaintThread implements Runnable{
	TankGameFrame frame;
	public void setFrame(TankGameFrame af)
	{
		frame = af;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			frame.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}