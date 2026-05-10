public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int denominator, int numerator) {
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public RationalNumber add(RationalNumber op2) {
        int newNumer = this.numerator*op2.denominator + this.denominator*op2.denominator;
        int newDenom = this.denominator*op2.denominator;
        return new RationalNumber(newDenom, newNumer);
    }

    public RationalNumber multiply(RationalNumber op2) {
        int newNumer = this.numerator*op2.numerator / this.denominator*op2.denominator;
        int newDenom = this.denominator*op2.denominator;
        return new RationalNumber(newDenom, newNumer);
    }

    @Override
    public String toString() {
       return numerator + "/" + denominator;
    }

    


}
