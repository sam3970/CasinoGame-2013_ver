package EX2;

import java.util.*;
import java.io.*;

public class Option
{
	private Name[] n;			//Name 을 배열로 선언.
	private int cnt;			//플레이어수 카운트 할 변수.
	
	Option(int s)				//Name을 s만큼 받아오기위해 생성자로 받아옴.
	{
		n = new Name[s]; 		//입력받은만큼 생성
		cnt = 0;				//cnt 0 초기화.
	}
	
	public void setOption()
	{
		String Name;			//이름을 저장받을 변수.
		double Money;			//시작 자본을 입력받을 변수.
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("플레이어 이름 : ");
		Name = in.next();
		
		System.out.print("시작 자본 : ");
		Money = in.nextInt();
		
		n[cnt++]=new Name(Name,Money);	//객체생성
			
	}
	
	public void setTotal(double total)	//저장 겸 값 저장.
	{
		n[cnt-1].setTotal(total);		//Total값에 저장.
		System.out.println("저장완료...");
	}
	
	public void printPlayer()			//플레이어 기록 출력 매소드.
	{
		for(int i = 0 ; i < cnt ;i++)
		{
			System.out.print("("+(i+1)+")");
			System.out.println(n[i]);			
		}
	}
	
	public void savePlayer()			//플레이어 기록 저장.
	{
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try
		{
			fs = new FileOutputStream("Option.dat");
			os = new ObjectOutputStream(fs);
			os.writeInt(cnt);			
			for(int i = 0 ; i < cnt ; i++)
				os.writeObject(n[i]);
			os.close();
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
	}
	
	public void loadPlayer()			//플레이어 기록 로드.
	{
		FileInputStream fs = null;
		ObjectInputStream os = null;
		try
		{
			fs = new FileInputStream("Option.dat");
			os = new ObjectInputStream(fs);
			cnt = os.readInt();
			for(int i = 0 ; i < cnt ; i++)
				n[i]=(Name)os.readObject();
			os.close();
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
		System.out.println("저장된 객체 읽기  완료. 플레이어 수 : "+cnt);
		
	}

}
