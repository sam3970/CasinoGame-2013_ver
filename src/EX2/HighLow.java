package EX2;

import java.io.IOException;
import java.io.InputStreamReader;

//입출력에 관련된 클래스와 인터페이스가 들어가있는 패키지입니다.

public class HighLow extends Money					//HighLow class
{
	
	HighLow(int b)									//batting을 받아올 생성자.
	{
		super(b);
	}
	
	public void High()throws IOException			//게임 플레이 메소드
	{

		int gamePlayCount= 0;     //플레이어가 게임을 한 횟수를 나타냅니다.
		int totalScore = 0;   	  //플에이어의 점수를 합산한 것을 나타냅니다.
		double averageScore;   	  //평균점수는 총 합에서 게임을 한 횟수를 나누면 됩니다.
		char playag;
     
      
		do 
		{
			int gameScore;						//게임을 했을 때 그 게임에만 해당하는 점수를 의미합니다.
			gameScore = Play.ExcuteGame();  	//게임을 플레이하고 그 점수를 기록합니다.
			InputStreamReader ain;				//문자를 입력받기 위한 'java.io.*'패키지 안의 성분입니다.
         
			totalScore += gameScore;			//게임을 다시 했을 시 누적된 점수와 지금 게임의 점수를 
			gamePlayCount++;
         
			while(true)
			{
				ain=new InputStreamReader(System.in);
				
				/*
				 * (윗구문 설명중...)버퍼에 엔터키가 남아 계속 출력되는 현상이 발생되어서 in버퍼 객체를
        	  	 *	while문이 실행 될 때마다 새로 생성시키도록 하였습니다.
				*/
				
				System.out.print("<System> : 다시 플레이 하시겠습니까? (y/n) : ");
				
				playag=(char)ain.read(); // 사용자가 게임을 다시하고 싶은지 묻는 곳이고 '문자'하나를 받기 위해 변환작업을 합니다.
				Character.toUpperCase(playag); //대문자로 입력받았다면 소문자로 변환하는 기능을 합니다.
				
				if(playag != 'y' && playag != 'n')
				{
					System.out.println("y(yes)또는 n(no)만 입력하셔야져!\n");
				}
				else
				{ 
					break;
				} //n이나 y값이 입력되었다면 반복을 끝내고 while문을 빠져나갑니다. 
			}
		}while(playag!='n');
      
		averageScore = ((double)totalScore)/gamePlayCount;
      
		System.out.println();
		System.out.println("<System> : 게임을 실항 한 횟수 : " +gamePlayCount+" 번");
		System.out.println("<System> : 게임에서 획득한 점수 : " +totalScore+" 점");
		System.out.println("<System> : 게임에서 획득한 평균 점수 :" + averageScore+" 점");
      
		money+=averageScore*batting;		//점수 1 점당 배팅금액의 *(점수+1)
      
		System.out.println("<System> : 게임 최종 결과 금액 : " + averageScore + " * " + (int)batting + " = " + (int)money);
       
   }
	
	public double getMoney()				//게임에서 획득한 값 반환.
    {
  	  return (int)money;
    }
}