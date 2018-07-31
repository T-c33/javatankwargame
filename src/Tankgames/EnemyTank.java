package Tankgames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EnemyTank extends SuperTank{
	private int HP;

	public static ArrayList<EnemyTank> EnemyTankList = new ArrayList<EnemyTank>();
	public EnemyTank(int a,int b) {
		HP = 20;
		x = a;
		y = b;
		r = 10;
		direction = Direction.UP;
		velocity = 1;
	}
	
	
	public void EnemyTankmove(Graphics g,ImageObserver frame){
		if(CanMove())
			move();
		String file = "EnemyTank"+direction+".png";
		draw(g,frame,file);
	}
	public void draw(Graphics g,ImageObserver frame,String file)
	{
		super.draw(g, frame, file);
		g.setColor(Color.YELLOW);
		g.drawRect(this.getX()-10, this.getY()+12, 20, 4);
		g.fillRect(this.getX()-10, this.getY()+12,this.HP , 4);
		
	}
	public static void EnemyTankAction(Graphics g,ImageObserver frame) {
		EnemyTank enemyTank;
		for(int i=0;i<EnemyTankList.size();i++) {
			enemyTank = EnemyTankList.get(i);
			if(enemyTank.HP<=0) {
				EnemyTankList.remove(i--);
				continue;
			}
			switch((int)(Math.random()*100)) {
			case 1:
				enemyTank.direction = Direction.UP;
				break;
			case 2:
				enemyTank.direction = Direction.DOWN;
				break;
			case 3:
				enemyTank.direction = Direction.LEFT;
				break;
			case 4:
				enemyTank.direction = Direction.RIGHT;
				break;
			}
			if((int)(Math.random()*100) == 1)
				enemyTank.Shoot();
			enemyTank.EnemyTankmove(g,frame);
		}
		makeEnemyTank();
	}
	public void substractHP() {
		HP-=5;
	}
	private static void makeEnemyTank() {
		if((int)(Math.random()*50) == 1 && EnemyTankList.size()<5) {
			EnemyTankList.add(new EnemyTank((int)(Math.random()*500)+50,(int)(Math.random()*500)+50));
		}
	}
	public static void Bomb(int i) {
		
	}
	
	
	
     

}
