package EX2;

import java.util.*;
import java.io.*;

public class Option
{
	private Name[] n;			//Name �� �迭�� ����.
	private int cnt;			//�÷��̾�� ī��Ʈ �� ����.
	
	Option(int s)				//Name�� s��ŭ �޾ƿ������� �����ڷ� �޾ƿ�.
	{
		n = new Name[s]; 		//�Է¹�����ŭ ����
		cnt = 0;				//cnt 0 �ʱ�ȭ.
	}
	
	public void setOption()
	{
		String Name;			//�̸��� ������� ����.
		double Money;			//���� �ں��� �Է¹��� ����.
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("�÷��̾� �̸� : ");
		Name = in.next();
		
		System.out.print("���� �ں� : ");
		Money = in.nextInt();
		
		n[cnt++]=new Name(Name,Money);	//��ü����
			
	}
	
	public void setTotal(double total)	//���� �� �� ����.
	{
		n[cnt-1].setTotal(total);		//Total���� ����.
		System.out.println("����Ϸ�...");
	}
	
	public void printPlayer()			//�÷��̾� ��� ��� �żҵ�.
	{
		for(int i = 0 ; i < cnt ;i++)
		{
			System.out.print("("+(i+1)+")");
			System.out.println(n[i]);			
		}
	}
	
	public void savePlayer()			//�÷��̾� ��� ����.
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
	
	public void loadPlayer()			//�÷��̾� ��� �ε�.
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
		
		System.out.println("����� ��ü �б�  �Ϸ�. �÷��̾� �� : "+cnt);
		
	}

}
