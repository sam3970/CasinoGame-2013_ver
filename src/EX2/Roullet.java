package EX2;

public class Roullet extends Money
{
	private int face[]= new int[3];	//3���� ������ �����ϱ����� �迭 ����.
				
	Roullet(int b)					//���ñݾ��� �޾ƿ� ������.
	{
		super(b);
	}
	
	public void RoulletMain()
	{		
		double m = 0 ;				//RouletMain���� ��  m �� 0 ���� �ʱ�ȭ.
		
		face[0]=(int)(Math.random()*6+1);	//ù ° �� ������ ����.
		System.out.print(" "+face[0]);
		
		face[1]=(int)(Math.random()*6+1);	//�� ° �� ������ ����.
		System.out.print(" " +face[1]);
		
		face[2]=(int)(Math.random()*6+1);	//�� ° �� ������ ����.
		System.out.println(" "+face[2]);

		if(face[0]==7 && face[0]==face[1] && face[0]==face[2])				//��� ���� 777�� �����
		{
			System.out.println("<System> : Batting �ݾ��� 5�踦 �Լ��ߴ�.");
			m+=batting*5;
		}
		else if(face[0] == face[1])											//�� �� �� ���� ���.
		{
			if(face[0]==face[2])											//��� ���� ���� ���.
			{
				System.out.println("<System> : Batting �ݾ��� 5�踦 �Լ��ߴ�.");
				m+=batting*3;
			}
			else															//�׷��� ���� ��� �� �� �� ����.
			{
				System.out.println("<System> : Batting �ݾ��� 2�踦 �Լ��ߴ�.");
				m+=batting*2;
			}
		}	
		else if(face[0]==face[2])											//�� ���� ���� ��� - 2
		{
			if(face[0]==face[1])											//��� ���� �������.
			{
				System.out.println("<System> : Batting �ݾ��� 3�踦 �Լ��ߴ�.");
				m+=batting*3;
			}
			else
			{
				System.out.println("<System> : Batting �ݾ��� 2�踦 �Լ��ߴ�.");
				m+=batting*2;
			}
		}
		else if(face[1]==face[2])											//�� ���� ���� ��� - 3
		{
			if(face[0]==face[2])
			{
				System.out.println("<System> : Batting �ݾ��� 3�踦 �Լ��ߴ�.");
				m+=batting*3;
			}
			else
			{
				System.out.println("<System> : Batting �ݾ��� 2�踦 �Լ��ߴ�.");
				m+=batting*2;
			}
		}
		else
		{
			System.out.println("<System> : Batting �ݾ��� 2�踦 �Ҿ���.");
			m+=batting*(-2);
		}
		
		money=m;		//Roullet�� m�� Main�� m ���� ����.
		
		System.out.println("���� ���� ��� �ݾ� : " + (int)money);
	}
	
	public double getMoney()	//m���� ��ȯ�� �޼ҵ�.
	{
		return money;
	}
	
}
