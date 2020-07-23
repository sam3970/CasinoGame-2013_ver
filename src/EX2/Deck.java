package EX2;

public class Deck 
{

    private Card[] deck;   // ���� �����ϱ� ���� �迭�� ������ �ϳ� �����մϴ�.
    private int cardUse; // �󸶳� ���� ī�尡 ó�� �Ǿ����� ��Ÿ�������� ��������ϴ�.
    
    public Deck() 
    {
           // ������ ���� ī���� ���� ����ϴ�.
       deck = new Card[52]; //�迭���� 52�� ������ �� ī���� ������ 52���̱� �����Դϴ�.
       
       int cardCt = 0;//���� ���� ī�尹���� 0���� �ʱ�ȭ��ŵ�ϴ�.  
       
       for (int pack=0;pack<=3;pack++) 
       {
          for (int value=1;value<=13;value++) 
          {
             deck[cardCt]=new Card(value,pack);//CardŬ������ �޸𸮿� �Ҵ��ϰ� ������ ���� ī������ ���� �ݺ������� ó���� �� ���� �ް� ó���� ī�� Ƚ���� �ϳ� ������ŵ�ϴ�. 
             cardCt++;
          }
       }
       cardUse = 0;// ���ݱ��� ó���� ī�� Ƚ���� ��Ÿ���� �κ��Դϴ�. �ϴ� 0���� �ʱ�ȭ��ŵ�ϴ�.
    }
    
    public void shuffle() 
    {
          //������ ������ ���Ǿ��� ��� ī�带 �ٽ� ���� �ְ� �����ϴ�.
        for (int z=51;z>0;z--) 
        {
            int random = (int)(Math.random()*(z+1));
            Card temp=deck[z];
            deck[z] = deck[random];
            deck[random]=temp;
        }
        cardUse = 0;
    }
    
    public int cardLeaving() 
    {
         //ī�带 �ϳ��� ������ �����ִ� ī��� �ϳ��� ���Ұ� �ǰԵǴµ�
    	//�̰� �Լ��� ����� ���� ���� �����ִ� ī���� ���� ��ȯ�ϴ°��Դϴ�.
        return 52 - cardUse;
    }
    
    public Card dealCard() 
    {
          //������ ���� �ϳ��� ī�带 ������ ��ȯ�մϴ�.
        if (cardUse == 52)
           shuffle();
        
        cardUse++;
        return deck[cardUse - 1];
    }

} // �� Ŭ������ ���Դϴ�.