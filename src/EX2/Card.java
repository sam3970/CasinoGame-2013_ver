package EX2;

public class Card 
{

    public final static int SPADE=0; // 카드의 종류엔 스페이드,하트,다이아몬드,클로버가 존재합니다. 
    public final static int HEART=1;
    public final static int DIAMOND=2;                       
    public final static int CLOVER=3;                       
                            
    public final static int ACE = 1; // 숫자의 의미는 카드의 크기를 얘기하는데 ace즉 a카드는 기본적으로 1을 나타냅니다. 
    public final static int JACK = 11;       
    public final static int QUEEN = 12;      
    public final static int KING = 13;
                            
    private final int pack; //카드 한 팩을 의미합니다.
                              
    private final int packvalue; 
                             
    public Card(int packvalue, int pack) 
    {
            // 지정된 값과 suit카드를 토대로 카드를 만듭니다.
            //값은 1~13사이여야합니다.
            //위의 선언된 스페이드 하트 다이아 클로버 값을 0~3사이로 제시했으므로 그 사이 값이 나와야합니다.
    		//만약 이 변수값이 범위에서 벗어난다면 생성된 카드는 무효가됩니다.
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
           case SPADE:   return "스페이드(♠)";
           case HEART:   return "하트(♥)";
           case DIAMOND: return "다이아몬드(◆)";
           case CLOVER:    return "클로버(♣)";
           default:       return "으아.. 뭔가 잘못되었어요ㅠㅠ..";
        }
    }
    
    public String getValueString() 
    {
            // 카드 한 팩을 나타내는 문자열을 반환합니다.
            // 만약 카드의 값이 유효범위에서 벗어났다면 Incorrect Value를 출력합니다.(이런걸 버그라고하죠 버그..)  
        switch (packvalue) 
        {
           case 1:   return "에이스(Ace)"; //Ace는 기본적으로 1을 나타내며 카드의 조합에 따라 10이 되기도 합니다.
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "잭(Jack)";
           case 12:  return "퀸(Queen)";
           case 13:  return "킹(King)";
           default:  return "Error";
        }
    }
    
    public String toString() 
    {
    	//스페이드의 10"같이 이러한 형식으로 출력이 되게 됩니다.
        return getPackString() + " " + getValueString();
    }


} //카드 클래스의 끝입니다.