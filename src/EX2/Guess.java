package EX2;

import java.util.Scanner;

public class Guess extends Money	//Money ���.
{

	Guess(double b)					//batting�ݾ� ����.
	{
		super(b);
	}
	
	public void guess()
	{
		int i=0 , you , sel , G;		//i�� Ƚ�� , you�� �÷��̾ �Է��� �� , sel�� ���� ���� , G�� ��ǻ�Ͱ� ������ ���� ���� ����. 
		
		Scanner in = new Scanner(System.in);	
		
		while(true)
		{
			System.out.print("���� �Ѱ� �Է� : ");
			
			you = in.nextInt();
			
			G = (int)(Math.random()*10+1);		//���� ����.
			
			System.out.println("���� ���� : "+G);
			
			if(you == G)						//�÷��̾ ���� ���������.
			{
				if(i==4)//���� Ƚ�� �ִ� 5ȸ�� ����
				{
					money = batting * (i+1);				
					break;
				}
				
				System.out.println("<System> �����ϼ̽��ϴ�.");
				
				System.out.print("<System> ��� �Ͻðڽ��ϱ�? (1.����Ѵ�. 2.�׸��Ѵ�.)");
				
				sel=in.nextInt();
				
				if(sel==1)						//���� ����� ��� Ƚ�� ����.
				{	
					i++;
				}
				
				else if(sel==2)					//���� ���� �� ��� ������ ����ϰ� ���� ����.
				{
					money = batting * (i+1);
					break;
				}
				else
				{
					System.out.println("<System> �߸��Է��ϼ̽��ϴ�.");
				}
			}
			else
			{
				System.out.println("<System> �Է��Ͻ� ���� ���� �ʽ��ϴ�.");
				money=batting*(-2);
				break;
			}
		}
		System.out.println("���� ���� ��� �ݾ� : " + (int)money);
	}
	
	public double getMoney()						//Guess���� ���� �ݾ��� ��Ȱ���ִ� �޼ҵ�.
	{
		return money;
	}
	

}