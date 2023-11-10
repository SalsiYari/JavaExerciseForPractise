public class ClickCounter {
    int value;
    public ClickCounter(){}

    public int getValue() {
        return value;
    }
    public void click(){
        value +=1;
    }
    public void undo(){
        value -=1;
    }
    public void reset(){
        value=0;
    }

}
