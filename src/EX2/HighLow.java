package EX2;

import java.io.IOException;
import java.io.InputStreamReader;

//����¿� ���õ� Ŭ������ �������̽��� ���ִ� ��Ű���Դϴ�.

public class HighLow extends Money					//HighLow class
{
	
	HighLow(int b)									//batting�� �޾ƿ� ������.
	{
		super(b);
	}
	
	public void High()throws IOException			//���� �÷��� �޼ҵ�
	{

		int gamePlayCount= 0;     //�÷��̾ ������ �� Ƚ���� ��Ÿ���ϴ�.
		int totalScore = 0;   	  //�ÿ��̾��� ������ �ջ��� ���� ��Ÿ���ϴ�.
		double averageScore;   	  //��������� �� �տ��� ������ �� Ƚ���� ������ �˴ϴ�.
		char playag;
     
      
		do 
		{
			int gameScore;						//������ ���� �� �� ���ӿ��� �ش��ϴ� ������ �ǹ��մϴ�.
			gameScore = Play.ExcuteGame();  	//������ �÷����ϰ� �� ������ ����մϴ�.
			InputStreamReader ain;				//���ڸ� �Է¹ޱ� ���� 'java.io.*'��Ű�� ���� �����Դϴ�.
         
			totalScore += gameScore;			//������ �ٽ� ���� �� ������ ������ ���� ������ ������ 
			gamePlayCount++;
         
			while(true)
			{
				ain=new InputStreamReader(System.in);
				
				/*
				 * (������ ������...)���ۿ� ����Ű�� ���� ��� ��µǴ� ������ �߻��Ǿ in���� ��ü��
        	  	 *	while���� ���� �� ������ ���� ������Ű���� �Ͽ����ϴ�.
				*/
				
				System.out.print("<System> : �ٽ� �÷��� �Ͻðڽ��ϱ�? (y/n) : ");
				
				playag=(char)ain.read(); // ����ڰ� ������ �ٽ��ϰ� ������ ���� ���̰� '����'�ϳ��� �ޱ� ���� ��ȯ�۾��� �մϴ�.
				Character.toUpperCase(playag); //�빮�ڷ� �Է¹޾Ҵٸ� �ҹ��ڷ� ��ȯ�ϴ� ����� �մϴ�.
				
				if(playag != 'y' && playag != 'n')
				{
					System.out.println("y(yes)�Ǵ� n(no)�� �Է��ϼž���!\n");
				}
				else
				{ 
					break;
				} //n�̳� y���� �ԷµǾ��ٸ� �ݺ��� ������ while���� ���������ϴ�. 
			}
		}while(playag!='n');
      
		averageScore = ((double)totalScore)/gamePlayCount;
      
		System.out.println();
		System.out.println("<System> : ������ ���� �� Ƚ�� : " +gamePlayCount+" ��");
		System.out.println("<System> : ���ӿ��� ȹ���� ���� : " +totalScore+" ��");
		System.out.println("<System> : ���ӿ��� ȹ���� ��� ���� :" + averageScore+" ��");
      
		money+=averageScore*batting;		//���� 1 ���� ���ñݾ��� *(����+1)
      
		System.out.println("<System> : ���� ���� ��� �ݾ� : " + averageScore + " * " + (int)batting + " = " + (int)money);
       
   }
	
	public double getMoney()				//���ӿ��� ȹ���� �� ��ȯ.
    {
  	  return (int)money;
    }
}