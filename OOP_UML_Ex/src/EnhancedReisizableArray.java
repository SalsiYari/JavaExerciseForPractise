import java.util.Arrays;

public class EnhancedReisizableArray {
    static final int DEFAULT_CAPACITY=4;
    int[] v;
    public EnhancedReisizableArray(){
        v = new int[DEFAULT_CAPACITY];
    }
    public int get(int i){
        return v[i];
    }
    public void set(int i,int val){
        if(i>=0 && i<=4){
            v[i]=val;
        }
        this.v = new int[i+1];
        v[i]=val;
        for(int k=DEFAULT_CAPACITY; k<i-1;k++ ) {
            v[k] = 0;
        }
    }
    public boolean contains(int val){
        for(int i=0; i<v.length;i++){
            if(v[i]==val)
                return true;
        }
        return false;
    }
    public int length(){
        return v.length;
    }
    public int[] toArray(){
        return Arrays.copyOf(v,v.length);
    }

    public void fill(int value) {
        Arrays.fill(v, value);
    }

}
