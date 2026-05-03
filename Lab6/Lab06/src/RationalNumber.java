public class RationalNumber {
    
    private int numerator;
    private int denominator;
    
    public RationalNumber(int numer, int denom)
    {
        numerator = numer;
        denominator = denom;
    }
    
    
    public RationalNumber add(RationalNumber op2)
    {
        int newNumerator = (this.numerator * op2.denominator) + (op2.numerator * this.denominator);
        int newDenominator = this.denominator * op2.denominator;
        
        return new RationalNumber(newNumerator, newDenominator);
    }
     
    public RationalNumber multiply(RationalNumber op2)
    {
        int newNumerator = this.numerator * op2.numerator;
        int newDenominator = this.denominator * op2.denominator;
        
        return new RationalNumber(newNumerator, newDenominator);
    }
    
    public String toString()
    {
        return numerator + "/" + denominator;
    }
}