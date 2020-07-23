package EX2;

import java.io.IOException;
import java.util.*;

public class GameMain 
{
	public static void main(String[] args) throws IOException 
	{
		
		int sel , b;						//�޴� ���� ���� , ���� �ݾ� ���� ����.	
		double total = 0;					//ȹ��ݾ��� ������ ����  0 ���� �ʱ�ȭ.
		
		Option o = new Option(20);			//�ִ� �ο� 20������ ���� �� Name 20�� ������ ����.
		
		o.loadPlayer();						//�÷��̾� ��� �ε�.
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Let's Game!!");
		System.out.println("�÷��̾� ���� �Է�");
		o.setOption();						//Option�� �ִ� setOption �żҵ� ȣ��.
		
		while(true)							//0 �� ��µɶ� ���� ���� �ݺ�.
		{
			System.out.println("    1.Roulette");
			System.out.println("    2.High and Low");
			System.out.println("    3.���� ���߱�");
			System.out.println("    4.Option");
			System.out.println("    0.����");
			
			System.out.print("�޴� ���� : ");
			sel = in.nextInt();
			
			if(sel == 0)					//�ݺ��� ���� ��
			{
				System.out.println("�����մϴ�.");
				o.setTotal(total);			//NameTotal�� total ���� ����.
				
				o.savePlayer();				//savePlayer �÷��̾� ���� ����.
				
				break;
			}
			
			switch(sel)
			{
				case 1 :
					System.out.println("Rollet Game");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//���� �ݾ� ����.
					
					Roullet r = new Roullet(b);	//���ñݾ��� �޾ƿ� ���ο� Roullet.
					
					r.RoulletMain();			//RoulletMain �żҵ� ȣ��			
					
					total += r.getMoney();		//ȹ���� �ݾ� total�� ����.
					
					o.setTotal(total);			//Name��Total�� total ���� ����.
					
					break;
					
				case 2 :
					System.out.println("High and Low");
					System.out.println("���� * Batting = ȹ���� �ݾ�");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//���� �ݾ� ����.
					
					HighLow h = new HighLow(b);	//���ñݾ��� �޾ƿ� ���ο� HighLow.
					
					h.High();
					
					total += h.getMoney();		//ȹ���� �ݾ� total�� ����.
					
					o.setTotal(total);			//Name��Total�� total ���� ����.
					
					break;
					
				case 3 :
					System.out.println("Guess : (1~10������ �� �� �Ѱ��� ���߱�.)");
					System.out.println("���� Ƚ��  * Batting = ȹ���� �ݾ�");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//���� �ݾ� ����.
					
					Guess g = new Guess(b);		//���ñݾ��� �޾ƿ� ���ο� Guess.
					
					g.guess();					//GuessŬ������ guess �޼ҵ� ȣ��.
					
					total += g.getMoney();		//ȹ���� �ݾ�total�� ����.
					
					o.setTotal(total);			//Name��Total��total ���� ����.
					
					break;				
			}
		
			if(sel == 4)						//Option�� ������ ����.
			{
				System.out.print("1. �÷��̾� ���� 2. �÷��̾� ��� ��� : ");
				sel=in.nextInt();
				
				if(sel==1)						
				{		
					
					o.setTotal(total);			//Name��Total�� total ���� ����.
					
					o.savePlayer();				//savePlayer �÷��̾� ���� ����.
					
					System.out.println("������ ���ο� �÷��̾�� �����մϴ�.");
					
					total=0;					//���� �÷��̾ �������Ҷ� total���� �״�� ����������� �ȵ����� total�� �ʱ�ȭ.
					
					o.setOption();				//���ο� �÷��̾� ���� ����.
						
				}
				else if(sel==2)
				{
					o.setTotal(total);			//NameTotal�� total ���� ����.
					
					o.savePlayer();				//savePlayer �÷��̾� ���� ����.
					
					o.printPlayer();			//�÷��̾� ������ ���.
				}
			}
						
		}
	}

}
