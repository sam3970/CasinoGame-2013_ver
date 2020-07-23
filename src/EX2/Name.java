package EX2;

import java.io.Serializable;				//저장을 하기위해 io 선언.

public class Name implements Serializable
{
	private String name;					//이름.
	private double Fmoney;					//시작자본.
	private double Total;					//최종금액.
	
	Name(String name,double Fmoney)			//이름과 시작자본을 생성자로 통해 저장.
	{
		this.name=name;
		this.Fmoney=Fmoney;
	}

	public void setTotal(double Total)		//최종금액 set 메소드.
	{	
		this.Total = Total + this.Fmoney;
	}
	
	public String toString()				//출력 메소드.
	{
		return name +" 님    시작 자본 :"+(int)Fmoney+"원"+"  최종 금액 : "+(int)Total+"원";
	}
}
