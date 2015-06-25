//A simple program which commands karel to cover each and every block of his word.
import stanford.karel.*;

//turnLeft()
//move()
//pickBeeper()
//putBeeper()

//hasBeepers()
//frontIsClear()
//rightIsClear()
//leftIsClear()

public class YoungKarel extends Karel 
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
				move();
				turnLeft();
			}
			else
			{
				turnRight();
				move();
				turnRight();
			}
		}
	}
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}
}
