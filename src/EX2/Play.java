package EX2;

import java.io.IOException;
import java.io.InputStreamReader;

public class Play 
{
	public static int ExcuteGame() throws IOException 
	{
        // 사용자가 하이로우 게임을 한번 실행하고 나서 사용자의 게임점수를 받아옵니다.
		Deck dk= new Deck();  //덱클래스를 하이로우클래스안에 함수 할당을 합니다.
      
		Card presentCard; // 현재 사용자가 가지고 있는 카드를 의미합니다.
      
		Card subsequentlyCard; //덱에있는 다음카드를 의미하고 사용자는 현재 보유하고 있는 카드가 high인지 low인지 예측하게됩니다.
	   
		int exactGuess ; //사용자가 올바른 예측을 했을때 사용되는 변수입니다.게임이 끝난 후 총합이 이곳에 저장됩니다.
		char guess;   // 사용자가 추축한 값을 받아서 저장하는 변수입니다. 'H'를 선택했다면 다음에 나올 카드가 가지고 있는 덱보다 High라면 맞춘것이고 low라면 맞추지 못한것이됩니다.
     
		dk.shuffle();
		exactGuess = 0;
		presentCard = dk.dealCard();
     
		System.out.println("<System> : 첫번째 카드 : " +presentCard);
     
		while (true) 
		{  	// 사용자가 오답을 냈을때 이 반복문이 종료되게됩니다.
			System.out.print("<System> : 높다고 생각되시면 (H) 작다고 생각되시면 lower (L) : ");
			
			do 
			{
				InputStreamReader in=new InputStreamReader(System.in); //문자를 입력받기 위한 'java.io.*'패키지 안의 성분입니다.
				guess = (char)in.read();
				guess = Character.toUpperCase(guess);//입력받은 문자를 소문자로 변환시켜주는 기능을 합니다. 사용자가 대문자로 입력을 할 수도 있기 때문에 이런 구문을 넣게 되었습니다.
				if (guess != 'H' && guess != 'L') 
					System.out.println("<System> : Error 다시 입력 하십시오.:");
			} while (guess != 'H' && guess != 'L');
        
			//다음카드를 받아오며 그것을 '사용자'에게 보여줍니다.
        
			subsequentlyCard = dk.dealCard(); //덱에있는 카드52개중 하나를 가져와 카드팩에서 하나를 빼 왼쪽 변수에 넣습니다.
       
			//'사용자'가 탁월한 선택을 했는지 판별하는 곳입니다. 
        
			if (subsequentlyCard.getPackValue() == presentCard.getPackValue()) 
			{ //카드값이 같을 때.
       	 
				System.out.println("\n<System> : 다음 카드 : " + subsequentlyCard);
				System.out.println("<System> : 선택하신 카드가 나온 카드와 같습니다. 규칙에 의해 패배하셨습니다.");
				
				break; 
			}
			else if (subsequentlyCard.getPackValue() > presentCard.getPackValue()) 
			{ //조건 High를 맞췄을 때.
				if (guess == 'H') 
				{
					System.out.println("<System> : 플레이어가 선택한 카드가 맞습니다.(High)");
					exactGuess++; 
				}
				else 
				{
					System.out.println("\n<System> : 다음 카드 : " + subsequentlyCard);
					System.out.println("<System> : 선택하신 카드는 정 반대인 Low가 나왔습니다.");
					System.out.println("<System> : 패 배.");
					break;  // 게임 끝.
				}
			}
			else 
			{  // 조건 Low를 맞췄을 때
				if (guess == 'L') 
				{
					System.out.println("<System> : 플레이어가 선택한 카드가 맞습니다.(Low)");
					exactGuess++;
				}
				else 
				{
					System.out.println("\n<System> : 다음 카드 : " + subsequentlyCard);
					System.out.println("<System> : 선택하신 카드가 나온 카드와 같습니다. 규칙에 의해 패배하셨습니다.");
					break;  // 게임끝.
				}
			}
        
        /*do~while 문을 돌고나서 사용자분이 조건문을 맞추셨다면 새롭게 다음카드를 받아서  
                        사용자분께 드려야 하므로 아래와 같이 코드를 짜게 되었습니다.*/
        
			presentCard = subsequentlyCard;
			System.out.println();
			System.out.println("<System> : 다음 카드 : " + presentCard);
        
		} // 루프문 빠져나옵니다
     
		System.out.println();
		System.out.println("<System> : 플레이어가 맞춘 횟 수 : [" + exactGuess + "]번");
		System.out.println();
     
		return exactGuess;
     
	}  //플레이 함수를 종료합니다
  

} // 플레이 클래스의 끝입니다.