package EX2;

import java.io.Serializable;				//������ �ϱ����� io ����.

public class Name implements Serializable
{
	private String name;					//�̸�.
	private double Fmoney;					//�����ں�.
	private double Total;					//�����ݾ�.
	
	Name(String name,double Fmoney)			//�̸��� �����ں��� �����ڷ� ���� ����.
	{
		this.name=name;
		this.Fmoney=Fmoney;
	}

	public void setTotal(double Total)		//�����ݾ� set �޼ҵ�.
	{	
		this.Total = Total + this.Fmoney;
	}
	
	public String toString()				//��� �޼ҵ�.
	{
		return name +" ��    ���� �ں� :"+(int)Fmoney+"��"+"  ���� �ݾ� : "+(int)Total+"��";
	}
}
