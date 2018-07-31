package Tankgames;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import Tankgames.PaintThread;
import Tankgames.Tank;

public class TankGameFrame extends Container{
	public TankGameFrame() {
		Bullet.bullets.clear();
		Explosion.ExplosionList.clear();
		EnemyTank.EnemyTankList.clear();
		Tank.tank = new Tank();
		this.setLocation(0,0);
		this.setSize(700,600);
		PaintThread myThread;
		myThread = new PaintThread();
		myThread.setFrame(this);
		Thread thread;
		thread = new Thread(myThread);
		this.setVisible(true);
		thread.start();
	}
	public void paint(Graphics g)
	{
		if(!Tank.ifover()) {
			Image offScreenImage = null;
			if(offScreenImage == null){
				offScreenImage = this.createImage(700,600);
			}
			Graphics goffScreen = offScreenImage.getGraphics();
			goffScreen.fillRect(0, 0, 700, 600);
			Tank.tank.tankAction(goffScreen,this);
			Bullet.BulletAction(goffScreen, this);
			EnemyTank.EnemyTankAction(goffScreen, this);
			Explosion.ExplosionAction(goffScreen, this);
			g.drawImage(offScreenImage,0,0,null);
		}
		else {
			Tank.tank = null;
			Bullet.bullets.clear();
			Explosion.ExplosionList.clear();
			EnemyTank.EnemyTankList.clear();
		}
	}
}
