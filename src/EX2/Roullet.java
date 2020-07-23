package EX2;

public class Roullet extends Money
{
	private int face[]= new int[3];	//3개의 난수를 저장하기위한 배열 생성.
				
	Roullet(int b)					//배팅금액을 받아올 생성자.
	{
		super(b);
	}
	
	public void RoulletMain()
	{		
		double m = 0 ;				//RouletMain에서 쓸  m 을 0 으로 초기화.
		
		face[0]=(int)(Math.random()*6+1);	//첫 째 수 난수로 생성.
		System.out.print(" "+face[0]);
		
		face[1]=(int)(Math.random()*6+1);	//둘 째 수 난수로 생성.
		System.out.print(" " +face[1]);
		
		face[2]=(int)(Math.random()*6+1);	//셋 째 수 난수로 생성.
		System.out.println(" "+face[2]);

		if(face[0]==7 && face[0]==face[1] && face[0]==face[2])				//모든 수가 777일 ㄴ경우
		{
			System.out.println("<System> : Batting 금액의 5배를 입수했다.");
			m+=batting*5;
		}
		else if(face[0] == face[1])											//두 수 가 같을 경우.
		{
			if(face[0]==face[2])											//모든 수가 같을 경우.
			{
				System.out.println("<System> : Batting 금액의 5배를 입수했다.");
				m+=batting*3;
			}
			else															//그렇지 않을 경우 두 수 만 같다.
			{
				System.out.println("<System> : Batting 금액의 2배를 입수했다.");
				m+=batting*2;
			}
		}	
		else if(face[0]==face[2])											//두 수가 같을 경우 - 2
		{
			if(face[0]==face[1])											//모든 수가 같을경우.
			{
				System.out.println("<System> : Batting 금액의 3배를 입수했다.");
				m+=batting*3;
			}
			else
			{
				System.out.println("<System> : Batting 금액의 2배를 입수했다.");
				m+=batting*2;
			}
		}
		else if(face[1]==face[2])											//두 수가 같을 경우 - 3
		{
			if(face[0]==face[2])
			{
				System.out.println("<System> : Batting 금액의 3배를 입수했다.");
				m+=batting*3;
			}
			else
			{
				System.out.println("<System> : Batting 금액의 2배를 입수했다.");
				m+=batting*2;
			}
		}
		else
		{
			System.out.println("<System> : Batting 금액의 2배를 잃었다.");
			m+=batting*(-2);
		}
		
		money=m;		//Roullet의 m에 Main의 m 값을 저장.
		
		System.out.println("게임 최종 결과 금액 : " + (int)money);
	}
	
	public double getMoney()	//m값을 반환할 메소드.
	{
		return money;
	}
	
}
