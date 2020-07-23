package EX2;

public class Deck 
{

    private Card[] deck;   // 덱을 생성하기 위해 배열로 변수를 하나 선언합니다.
    private int cardUse; // 얼마나 많은 카드가 처리 되었는지 나타내기위해 만들었습니다.
    
    public Deck() 
    {
           // 섞이지 않은 카드의 덱을 만듭니다.
       deck = new Card[52]; //배열값이 52인 이유는 총 카드의 개수가 52개이기 때문입니다.
       
       int cardCt = 0;//현재 보유 카드갯수를 0으로 초기화시킵니다.  
       
       for (int pack=0;pack<=3;pack++) 
       {
          for (int value=1;value<=13;value++) 
          {
             deck[cardCt]=new Card(value,pack);//Card클래스를 메모리에 할당하고 무늬의 값과 카드팩의 값을 반복문으로 처리후 그 값을 받고 처리된 카드 횟수를 하나 증가시킵니다. 
             cardCt++;
          }
       }
       cardUse = 0;// 지금까지 처리된 카드 횟수를 나타내는 부분입니다. 일단 0으로 초기화시킵니다.
    }
    
    public void shuffle() 
    {
          //임의의 순서로 사용되어진 모든 카드를 다시 덱에 넣고 섞습니다.
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
         //카드를 하나씩 보내면 덱에있는 카드는 하나씩 감소가 되게되는데
    	//이곳 함수의 기능은 현재 덱에 남아있는 카드의 수를 반환하는것입니다.
        return 52 - cardUse;
    }
    
    public Card dealCard() 
    {
          //덱으로 부터 하나의 카드를 돌리고 반환합니다.
        if (cardUse == 52)
           shuffle();
        
        cardUse++;
        return deck[cardUse - 1];
    }

} // 덱 클래스의 끝입니다.