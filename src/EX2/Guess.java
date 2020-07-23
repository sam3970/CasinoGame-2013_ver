package EX2;

import java.util.Scanner;

public class Guess extends Money	//Money 상속.
{

	Guess(double b)					//batting금액 저장.
	{
		super(b);
	}
	
	public void guess()
	{
		int i=0 , you , sel , G;		//i는 횟수 , you는 플레이어가 입력한 수 , sel은 선택 변수 , G는 컴퓨터가 생성한 난수 저장 변수. 
		
		Scanner in = new Scanner(System.in);	
		
		while(true)
		{
			System.out.print("숫자 한개 입력 : ");
			
			you = in.nextInt();
			
			G = (int)(Math.random()*10+1);		//난수 생성.
			
			System.out.println("나온 숫자 : "+G);
			
			if(you == G)						//플레이어가 수를 맞췄을경우.
			{
				if(i==4)//게임 횟수 최대 5회로 제한
				{
					money = batting * (i+1);				
					break;
				}
				
				System.out.println("<System> 성공하셨습니다.");
				
				System.out.print("<System> 계속 하시겠습니까? (1.계속한다. 2.그만한다.)");
				
				sel=in.nextInt();
				
				if(sel==1)						//만약 계속할 경우 횟수 증가.
				{	
					i++;
				}
				
				else if(sel==2)					//게임 종료 할 경우 점수를 계산하고 게임 종료.
				{
					money = batting * (i+1);
					break;
				}
				else
				{
					System.out.println("<System> 잘못입력하셨습니다.");
				}
			}
			else
			{
				System.out.println("<System> 입력하신 값과 같지 않습니다.");
				money=batting*(-2);
				break;
			}
		}
		System.out.println("게임 최종 결과 금액 : " + (int)money);
	}
	
	public double getMoney()						//Guess에서 얻은 금액을 반활해주는 메소드.
	{
		return money;
	}
	

}