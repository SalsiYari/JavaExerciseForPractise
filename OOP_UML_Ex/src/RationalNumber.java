import java.util.Objects;

public class RationalNumber {


    private int numerator;
    private int denominator;

    public RationalNumber(int num, int denominator){
        numerator=num;
        this.denominator=denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public RationalNumber add(RationalNumber num){
        RationalNumber tmp=new RationalNumber(num.numerator + this.numerator, leastCommonMultiple(this.denominator, num.denominator))   ;
        return tmp;
    }

    public RationalNumber multiply(RationalNumber num){
        RationalNumber tmp=new RationalNumber(num.numerator * this.numerator,num.denominator *this.denominator);
        return tmp;
    }




    static int greatestCommonDivisor(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int rest = max % min;
        if (max % min == 0) {
            return min;
        } else {
            return greatestCommonDivisor(min, rest);
        }
    }

    static int leastCommonMultiple(int a, int b) {
        return Math.abs(a * b) / greatestCommonDivisor(a, b);
    }

    public String toString(){
        return (" "+String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator) );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
