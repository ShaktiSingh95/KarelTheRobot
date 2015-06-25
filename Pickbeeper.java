//this program allows karel to collect all the beepers present in his world.
import stanford.karel.*;
public class Pickbeeper extends Karel 
{
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			goToEnd();
			decideTurn(i);
		}
	}
	public void goToEnd()
	{
		while(frontIsClear())
		{
			checkAndPickBeeper();
			move();
		}
	}
	public void decideTurn(int p)
	{
		if(p%2==0)
		{	
			changeRow(true,p);
		}
		else
		{
			changeRow(false,p);
		}
	}
	public void changeRow(boolean state,int p)
	{
		if(p!=9)
		{
			if(state==true)
			{
				turnLeft();
				checkAndPickBeeper();
				move();
				turnLeft();
			}
			else
			{
				turnRight();
				checkAndPickBeeper();
				move();
				turnRight();
			}
		}
		else
		{
			checkAndPickBeeper();
		}
	}
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}
	public void checkAndPickBeeper()
	{
		while(beepersPresent())
		{
			pickBeeper();
		}
	}
}
