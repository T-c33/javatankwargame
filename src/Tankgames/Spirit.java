package Tankgames;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Spirit {
	protected int x;
	protected int y;
	protected int r;
	protected int velocity;
	protected Direction direction;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Direction getDirection() {
		return direction;
	}
	public void move() {
		switch(direction) {
		case UP:
			y -= velocity;
			break;
		case DOWN:
			y += velocity;
			break;
		case LEFT:
			x -= velocity;
			break;
		default:
			x += velocity;
			break;
		}
	}
	public boolean CanMove() {
		switch(direction) {
		case UP:
			if(y>r)
				return true;
			break;
		case DOWN:
			if(y<600-r)
				return true;
			break;
		case LEFT:
			if(x>r)
				return true;
			break;
		default:
			if(x<700-r)
				return true;
			break;
		}
		return false;
	}
	public void draw(Graphics g,ImageObserver frame,String file)
	{
		g.drawImage(new ImageIcon("Picture/"+file).getImage(), x-r, y-r,2*r,2*r,frame);
		
	}
}

