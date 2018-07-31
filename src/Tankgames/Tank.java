package Tankgames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Tank extends SuperTank{
	private int count;
	private int num;
	public static Tank tank;
	public Tank() {
		x = 400;
		y = 300;
		r = 10;
		HP = 20;
		direction = Direction.UP;
		velocity = 1;
		count = 0;
		num = 10;
	}
	public void tankAction(Graphics g,ImageObserver frame) {
		if(tank.HP>0)
		{
			
		
			tankmove(g,frame);
			if(num<10) {
				count++;
				if(count==50)
				{
					num++;
					count=0;
				}
			}
		}
	}
	
	//ÑªÌõ
	
	
	public void tankmove(Graphics g,ImageObserver frame)
	{
		g.setColor(Color.RED);
		g.drawRect(tank.getX()-10, tank.getY()+12, 20, 4);
		g.fillRect(tank.getX()-10, tank.getY()+12,tank.HP , 4);
		
		g.setColor(Color.BLUE);
		g.drawRect(tank.getX()-11, tank.getY()+17, 20, 4);
		g.fillRect(tank.getX()-11, tank.getY()+17,tank.num*2 , 4);
		
		if(CanMove())
			move();
		String file = "mainTank"+direction+".png";
		draw(g,frame,file);
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			direction = Direction.UP;
			break;
		case KeyEvent.VK_DOWN:
			direction = Direction.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			direction = Direction.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			direction = Direction.RIGHT;
			break;
		case KeyEvent.VK_ENTER:
			if(velocity == 1)
				velocity = 0;
			else if(velocity == 0)
				velocity = 1;
			break;
		case KeyEvent.VK_SPACE:
			Shoot();
			break;
		}
	}
	public void substractHP() {
		HP-=5;
	}
	public void Shoot() {
		if(num>0) {
			super.Shoot();
			num--;
	}
	}
	public void getEvent(KeyEvent e) {
		keyPressed(e);
		}
	
	public static boolean ifover() {
		if(tank.HP>0)
			return false;
		else
			return true;
	}

	}


