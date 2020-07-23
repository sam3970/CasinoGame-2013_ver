package EX2;

import java.io.IOException;
import java.util.*;

public class GameMain 
{
	public static void main(String[] args) throws IOException 
	{
		
		int sel , b;						//메뉴 선택 변수 , 배팅 금액 저장 변수.	
		double total = 0;					//획득금액을 저장할 변수  0 으로 초기화.
		
		Option o = new Option(20);			//최대 인원 20명으로 설정 즉 Name 20개 포인터 생성.
		
		o.loadPlayer();						//플레이어 기록 로드.
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Let's Game!!");
		System.out.println("플레이어 정보 입력");
		o.setOption();						//Option에 있는 setOption 매소드 호출.
		
		while(true)							//0 이 출력될때 까지 무한 반복.
		{
			System.out.println("    1.Roulette");
			System.out.println("    2.High and Low");
			System.out.println("    3.숫자 맞추기");
			System.out.println("    4.Option");
			System.out.println("    0.종료");
			
			System.out.print("메뉴 선택 : ");
			sel = in.nextInt();
			
			if(sel == 0)					//반복문 종료 문
			{
				System.out.println("감사합니다.");
				o.setTotal(total);			//NameTotal에 total 값을 더함.
				
				o.savePlayer();				//savePlayer 플레이어 정보 저장.
				
				break;
			}
			
			switch(sel)
			{
				case 1 :
					System.out.println("Rollet Game");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//배팅 금액 저장.
					
					Roullet r = new Roullet(b);	//배팅금액을 받아와 새로운 Roullet.
					
					r.RoulletMain();			//RoulletMain 매소드 호출			
					
					total += r.getMoney();		//획득한 금액 total에 저장.
					
					o.setTotal(total);			//Name의Total에 total 값을 더함.
					
					break;
					
				case 2 :
					System.out.println("High and Low");
					System.out.println("점수 * Batting = 획득한 금액");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//배팅 금액 저장.
					
					HighLow h = new HighLow(b);	//배팅금액을 받아와 새로운 HighLow.
					
					h.High();
					
					total += h.getMoney();		//획득한 금액 total에 저장.
					
					o.setTotal(total);			//Name의Total에 total 값을 더함.
					
					break;
					
				case 3 :
					System.out.println("Guess : (1~10까지의 수 중 한가지 맞추기.)");
					System.out.println("맞춘 횟수  * Batting = 획득한 금액");
					System.out.print("Set Batting : ");
					b=in.nextInt();				//베팅 금액 저장.
					
					Guess g = new Guess(b);		//배팅금액을 받아와 새로운 Guess.
					
					g.guess();					//Guess클레스의 guess 메소드 호출.
					
					total += g.getMoney();		//획득한 금액total에 저장.
					
					o.setTotal(total);			//Name의Total에total 값을 더함.
					
					break;				
			}
		
			if(sel == 4)						//Option을 선택했 을시.
			{
				System.out.print("1. 플레이어 변경 2. 플레이어 기록 출력 : ");
				sel=in.nextInt();
				
				if(sel==1)						
				{		
					
					o.setTotal(total);			//Name의Total에 total 값을 더함.
					
					o.savePlayer();				//savePlayer 플레이어 정보 저장.
					
					System.out.println("저장후 새로운 플레이어로 시작합니다.");
					
					total=0;					//다음 플레이어가 게임을할때 total값이 그대로 저장되있으면 안됨으로 total을 초기화.
					
					o.setOption();				//새로운 플레이어 정보 저장.
						
				}
				else if(sel==2)
				{
					o.setTotal(total);			//NameTotal에 total 값을 더함.
					
					o.savePlayer();				//savePlayer 플레이어 정보 저장.
					
					o.printPlayer();			//플레이어 정보를 출력.
				}
			}
						
		}
	}

}
