package EX2;

public class Card 
{

    public final static int SPADE=0; // ī���� ������ �����̵�,��Ʈ,���̾Ƹ��,Ŭ�ι��� �����մϴ�. 
    public final static int HEART=1;
    public final static int DIAMOND=2;                       
    public final static int CLOVER=3;                       
                            
    public final static int ACE = 1; // ������ �ǹ̴� ī���� ũ�⸦ ����ϴµ� ace�� aī��� �⺻������ 1�� ��Ÿ���ϴ�. 
    public final static int JACK = 11;       
    public final static int QUEEN = 12;      
    public final static int KING = 13;
                            
    private final int pack; //ī�� �� ���� �ǹ��մϴ�.
                              
    private final int packvalue; 
                             
    public Card(int packvalue, int pack) 
    {
            // ������ ���� suitī�带 ���� ī�带 ����ϴ�.
            //���� 1~13���̿����մϴ�.
            //���� ����� �����̵� ��Ʈ ���̾� Ŭ�ι� ���� 0~3���̷� ���������Ƿ� �� ���� ���� ���;��մϴ�.
    		//���� �� �������� �������� ����ٸ� ������ ī��� ��ȿ���˴ϴ�.
        this.packvalue=packvalue;
        this.pack=pack;
    }
        
    public int getPack() 
    {
        return pack;
    }
    
    public int getPackValue() 
    {
        return packvalue;
    }
    
    public String getPackString() 
    {
            
        switch (pack) 
        {
           case SPADE:   return "�����̵�(��)";
           case HEART:   return "��Ʈ(��)";
           case DIAMOND: return "���̾Ƹ��(��)";
           case CLOVER:    return "Ŭ�ι�(��)";
           default:       return "����.. ���� �߸��Ǿ����Ф�..";
        }
    }
    
    public String getValueString() 
    {
            // ī�� �� ���� ��Ÿ���� ���ڿ��� ��ȯ�մϴ�.
            // ���� ī���� ���� ��ȿ�������� ����ٸ� Incorrect Value�� ����մϴ�.(�̷��� ���׶������ ����..)  
        switch (packvalue) 
        {
           case 1:   return "���̽�(Ace)"; //Ace�� �⺻������ 1�� ��Ÿ���� ī���� ���տ� ���� 10�� �Ǳ⵵ �մϴ�.
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "��(Jack)";
           case 12:  return "��(Queen)";
           case 13:  return "ŷ(King)";
           default:  return "Error";
        }
    }
    
    public String toString() 
    {
    	//�����̵��� 10"���� �̷��� �������� ����� �ǰ� �˴ϴ�.
        return getPackString() + " " + getValueString();
    }


} //ī�� Ŭ������ ���Դϴ�.