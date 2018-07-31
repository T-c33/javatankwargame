package Tankgames;

public class SuperTank extends Spirit{
	protected int HP;
	public boolean CanMove(){
		switch(direction) {
		case UP:
			if(Math.abs(x-Tank.tank.x)<10+r&&y>Tank.tank.y&&y<=Tank.tank.y+r+10)
					return false;
			for(int i = 0;i<EnemyTank.EnemyTankList.size();i++)
				if(Math.abs(x-EnemyTank.EnemyTankList.get(i).x)<10+r&&y>EnemyTank.EnemyTankList.get(i).y&&y<=EnemyTank.EnemyTankList.get(i).y+r+10)
						return false;
			break;
		case DOWN:
			if(Math.abs(x-Tank.tank.x)<10+r&&y<Tank.tank.y&&y>=Tank.tank.y-r-10)
					return false;
			for(int i = 0;i<EnemyTank.EnemyTankList.size();i++)
				if(Math.abs(x-EnemyTank.EnemyTankList.get(i).x)<10+r&&y<EnemyTank.EnemyTankList.get(i).y&&y>=EnemyTank.EnemyTankList.get(i).y-r-10)
						return false;
			break;
		case LEFT:
			if(Math.abs(y-Tank.tank.y)<10+r&&x>Tank.tank.x&&x<=Tank.tank.x+r+10)
					return false;
			for(int i = 0;i<EnemyTank.EnemyTankList.size();i++)
				if(Math.abs(y-EnemyTank.EnemyTankList.get(i).y)<10+r&&x>EnemyTank.EnemyTankList.get(i).x&&x<=EnemyTank.EnemyTankList.get(i).x+r+10)
						return false;
			break;
		default:
			if(Math.abs(y-Tank.tank.y)<10+r&&x<Tank.tank.x&&x>=Tank.tank.x-r-10)
					return false;
			for(int i = 0;i<EnemyTank.EnemyTankList.size();i++)
				if(Math.abs(y-EnemyTank.EnemyTankList.get(i).y)<10+r&&x<EnemyTank.EnemyTankList.get(i).x&&x>=EnemyTank.EnemyTankList.get(i).x-r-10)
						return false;
			break;
		}
		if(super.CanMove())
			return true;
		else
			return false;
	}

	protected void Shoot() {
		Bullet.bullets.add(new Bullet(direction,x,y));
	}
	public void substractHP() {
		HP-=5;
	}
}
