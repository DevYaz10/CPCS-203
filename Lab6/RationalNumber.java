public class RationalNumber {
    private int numer;
    private int denom;

    public RationalNumber(int numer, int denom) {
        this.numer = numer;
        this.denom = denom;
    }

    public RationalNumber add(RationalNumber op2) {
        //TODO implement addetion: a/b + c/d = (ad + bc)/bd
        int newNumer = this.numer * op2.denom + this.denom * op2.numer;
        int newDenom = this.denom * op2.denom;
        return new RationalNumber(newNumer, newDenom);
    }

    public RationalNumber multiply(RationalNumber op2) {
        //TODO implement multiplication a/b × c/d = ac/bd
        int newNumer = this.numer * op2.numer;
        int newDenom = this.denom * op2.denom;
        return new RationalNumber(newNumer, newDenom);
    }

    @Override
    public String toString() {
        return numer + "/" + denom;
    }
}
