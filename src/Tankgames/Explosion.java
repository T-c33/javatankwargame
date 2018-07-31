package Tankgames;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Explosion {
	private int x;
	private int y;
	private int r;
	private int s;
	public static ArrayList<Explosion> ExplosionList = new ArrayList<Explosion>();
	public Explosion(int a,int b) {
		x = a;
		y = b;
		r = 5;
		s = 1;
	}
	public void draw(Graphics g,ImageObserver frame,String file)
	{
		g.drawImage(new ImageIcon("Picture/"+file).getImage(), x-r, y-r,frame);
	}
	private void Explosiondraw(Graphics g,ImageObserver frame) {
			r = 5*(s/5%3+1);
			draw(g,frame,(s/5%3+1)+".png");
			s++;
	}
	public static void ExplosionAction(Graphics g,ImageObserver frame) {
		Explosion explosion;
		for(int i = 0; i<ExplosionList.size();i++) {
			explosion = ExplosionList.get(i);
			if(explosion.s<=15) {
				explosion.Explosiondraw(g, frame);
			}
			else
				ExplosionList.remove(i--);
		}
	}
}