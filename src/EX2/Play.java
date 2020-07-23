package EX2;

import java.io.IOException;
import java.io.InputStreamReader;

public class Play 
{
	public static int ExcuteGame() throws IOException 
	{
        // ����ڰ� ���̷ο� ������ �ѹ� �����ϰ� ���� ������� ���������� �޾ƿɴϴ�.
		Deck dk= new Deck();  //��Ŭ������ ���̷ο�Ŭ�����ȿ� �Լ� �Ҵ��� �մϴ�.
      
		Card presentCard; // ���� ����ڰ� ������ �ִ� ī�带 �ǹ��մϴ�.
      
		Card subsequentlyCard; //�����ִ� ����ī�带 �ǹ��ϰ� ����ڴ� ���� �����ϰ� �ִ� ī�尡 high���� low���� �����ϰԵ˴ϴ�.
	   
		int exactGuess ; //����ڰ� �ùٸ� ������ ������ ���Ǵ� �����Դϴ�.������ ���� �� ������ �̰��� ����˴ϴ�.
		char guess;   // ����ڰ� ������ ���� �޾Ƽ� �����ϴ� �����Դϴ�. 'H'�� �����ߴٸ� ������ ���� ī�尡 ������ �ִ� ������ High��� ������̰� low��� ������ ���Ѱ��̵˴ϴ�.
     
		dk.shuffle();
		exactGuess = 0;
		presentCard = dk.dealCard();
     
		System.out.println("<System> : ù��° ī�� : " +presentCard);
     
		while (true) 
		{  	// ����ڰ� ������ ������ �� �ݺ����� ����ǰԵ˴ϴ�.
			System.out.print("<System> : ���ٰ� �����ǽø� (H) �۴ٰ� �����ǽø� lower (L) : ");
			
			do 
			{
				InputStreamReader in=new InputStreamReader(System.in); //���ڸ� �Է¹ޱ� ���� 'java.io.*'��Ű�� ���� �����Դϴ�.
				guess = (char)in.read();
				guess = Character.toUpperCase(guess);//�Է¹��� ���ڸ� �ҹ��ڷ� ��ȯ�����ִ� ����� �մϴ�. ����ڰ� �빮�ڷ� �Է��� �� ���� �ֱ� ������ �̷� ������ �ְ� �Ǿ����ϴ�.
				if (guess != 'H' && guess != 'L') 
					System.out.println("<System> : Error �ٽ� �Է� �Ͻʽÿ�.:");
			} while (guess != 'H' && guess != 'L');
        
			//����ī�带 �޾ƿ��� �װ��� '�����'���� �����ݴϴ�.
        
			subsequentlyCard = dk.dealCard(); //�����ִ� ī��52���� �ϳ��� ������ ī���ѿ��� �ϳ��� �� ���� ������ �ֽ��ϴ�.
       
			//'�����'�� Ź���� ������ �ߴ��� �Ǻ��ϴ� ���Դϴ�. 
        
			if (subsequentlyCard.getPackValue() == presentCard.getPackValue()) 
			{ //ī�尪�� ���� ��.
       	 
				System.out.println("\n<System> : ���� ī�� : " + subsequentlyCard);
				System.out.println("<System> : �����Ͻ� ī�尡 ���� ī��� �����ϴ�. ��Ģ�� ���� �й��ϼ̽��ϴ�.");
				
				break; 
			}
			else if (subsequentlyCard.getPackValue() > presentCard.getPackValue()) 
			{ //���� High�� ������ ��.
				if (guess == 'H') 
				{
					System.out.println("<System> : �÷��̾ ������ ī�尡 �½��ϴ�.(High)");
					exactGuess++; 
				}
				else 
				{
					System.out.println("\n<System> : ���� ī�� : " + subsequentlyCard);
					System.out.println("<System> : �����Ͻ� ī��� �� �ݴ��� Low�� ���Խ��ϴ�.");
					System.out.println("<System> : �� ��.");
					break;  // ���� ��.
				}
			}
			else 
			{  // ���� Low�� ������ ��
				if (guess == 'L') 
				{
					System.out.println("<System> : �÷��̾ ������ ī�尡 �½��ϴ�.(Low)");
					exactGuess++;
				}
				else 
				{
					System.out.println("\n<System> : ���� ī�� : " + subsequentlyCard);
					System.out.println("<System> : �����Ͻ� ī�尡 ���� ī��� �����ϴ�. ��Ģ�� ���� �й��ϼ̽��ϴ�.");
					break;  // ���ӳ�.
				}
			}
        
        /*do~while ���� ������ ����ں��� ���ǹ��� ���߼̴ٸ� ���Ӱ� ����ī�带 �޾Ƽ�  
                        ����ںв� ����� �ϹǷ� �Ʒ��� ���� �ڵ带 ¥�� �Ǿ����ϴ�.*/
        
			presentCard = subsequentlyCard;
			System.out.println();
			System.out.println("<System> : ���� ī�� : " + presentCard);
        
		} // ������ �������ɴϴ�
     
		System.out.println();
		System.out.println("<System> : �÷��̾ ���� Ƚ �� : [" + exactGuess + "]��");
		System.out.println();
     
		return exactGuess;
     
	}  //�÷��� �Լ��� �����մϴ�
  

} // �÷��� Ŭ������ ���Դϴ�.