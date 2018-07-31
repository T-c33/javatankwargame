package Tankgames;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bullet extends Spirit{
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private byte radiu = 1;
	public Bullet(Direction d,int a,int b) {
		direction = d;
		x = a;
		y = b;
		velocity = 4;
		r = 2;
		if(d == Direction.UP)
			y -= 11;
		else if (d == Direction.DOWN)
			y += 11;
		else if (d == Direction.LEFT)
			x -= 11;
		else
			x += 11;
	}
	public void BulletMove(Graphics g,ImageObserver frame) {
			move();
			draw(g,frame,"bullet.png");
	}
	private static void Bomb(int i) {
		Explosion.ExplosionList.add(new Explosion(bullets.get(i).x,bullets.get(i).y));
		bullets.remove(i);
	}
	public boolean crash() {
		if(Math.abs(Tank.tank.x-x)<10 && Math.abs(Tank.tank.y-y)<10) {
			Tank.tank.substractHP();
			return false;
		}
		EnemyTank enemyTank;
		for(int j = 0;j<EnemyTank.EnemyTankList.size();j++) {
			enemyTank =  EnemyTank.EnemyTankList.get(j);
			if(Math.abs(enemyTank.x-x)<10 && Math.abs(enemyTank.y-y)<10) {
				enemyTank.substractHP();
				return false;
				}
		}
		return true;
	}
	public static void BulletAction(Graphics g,ImageObserver frame) {
		Bullet bullet;
		for(int i=0;i<Bullet.bullets.size();i++) {
			bullet = Bullet.bullets.get(i);
			if(bullet.CanMove() && bullet.crash())
				bullet.BulletMove(g,frame);
			else
				Bullet.Bomb(i--);
		}
	}
}