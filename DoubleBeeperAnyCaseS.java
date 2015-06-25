//this program allows karel to double number beepers already present at a perticular node.
//please do not put more two beeper in a line.
//neither use two consequent beeper on two very first blocks.

import stanford.karel.Karel;
public class DoubleBeeperAnyCase extends Karel 
{
		int d=0,i=0;
		public void run() 
		{
				for(i=0;i<10;i++)
				{
						goToEnd();
						decideTurn(i);
				}
		}
		public void goToEnd()
		{
				while(frontIsClear())
				{
						if(beepersPresent())
						{
								d=checkShiftPos();
								decideWay(d);
						}
						move();
				}
				if(!frontIsClear()&&i==9)
				{
						alterDoubleBeeper();
				}	
		
		}
		public int checkShiftPos()
		{
				move();
				if(beepersPresent())
				{
						turnAround();
						move();
						turnAround();
						return 1;
				}
				else
				{
						turnAround();
						move();
						turnAround();
						return 0;
				}
		}
		public void decideWay(int a)
		{
				if(a==0)
				{
						doubleBeeper();
				}
				else if(a==1)
				{
						alterDoubleBeeper();
				}
				else if(a==-1)
				{
						if(i%2==0)
						{
								turnLeft();
								shiftBeeperAhead();
								bringTwice();
								turnAround();
								move();
								turnLeft();
								move();
						}
						else
						{
								turnRight();
								shiftBeeperAhead();
								bringTwice();
								turnAround();
								move();
								turnRight();
								move();
						}
				}
		}
		public void doubleBeeper()
		{	
				shiftBeeperAhead();
				bringTwice();
		}
		public void alterDoubleBeeper()
		{
				shiftBeeperBack();
				fetchTwice();
		}
		public void shiftBeeperAhead()
		{
				pickBeeper();
				move();
				putBeeper();
				turnAround();
				move();
				turnAround();
				if(beepersPresent())
				{	
						shiftBeeperAhead();
				}
		}
		public void bringTwice()
		{
				move();
				if(beepersPresent())
				{
						pickBeeper();
						turnAround();
						move();
						putBeeper();
						putBeeper();
						turnAround();
						bringTwice();			
				}
		}
		public void shiftBeeperBack()
		{
				turnAround();
				pickBeeper();
				move();
				putBeeper();
				turnAround();
				move();
				if(beepersPresent())
				{
						shiftBeeperBack();
				}
				else
				{
						turnAround();
						move();
				}
		}
		public void fetchTwice()
		{
				turnAround();
				pickBeeper();
				move();
				putBeeper();
				putBeeper();
				turnAround();
				move();
				if(beepersPresent())
				{
						fetchTwice();
				}
				else
				{
						turnAround();
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
				int q=1;
				if(p!=9)
				{
						if(state==true)
						{
								turnLeft();
								if(beepersPresent())
								{
										d=checkShiftPos();
										if(d==1)
										{
												decideWay(-1);
										}
										else
										{
												decideWay(0);
										}
								}
								else
								{
										move();
								}
								turnLeft();
						}
						else
						{
								turnRight();
								if(beepersPresent())
								{
										d=checkShiftPos();
										if(d==1)
										{
												decideWay(-1);
										}
										else
										{
												decideWay(0);
										}
								}
								else
								{
										move();
								}
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
		public void turnAround()
		{
				turnLeft();
				turnLeft();
		}
}
