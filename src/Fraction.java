import java.security.cert.TrustAnchor;

public class Fraction {

    //variables definition
    private int numerator;
    private int denominator;

    //Constructors
    public Fraction(int numerator, int denominator){

        if (denominator == 0){
            throw new IllegalArgumentException();
        }
        else if (denominator < 0){
            this.denominator = Math.abs(denominator);
            this.numerator = - numerator;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    //getters
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    //type conversion methods
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    public double toDouble(){
        return (double) this.numerator/ this.denominator;
    }

    //calculator method
    //Add two fractions
    public Fraction add(Fraction other){
        int num = this.numerator*other.denominator + other.numerator*this.denominator;
        int deno = this.denominator*other.denominator;
        Fraction result = new Fraction(num,deno);
        result.toLowestTerms();
        return result;
    }

    //Subtract two fractions
    public Fraction subtract(Fraction other){
        int num = this.numerator*other.denominator - other.numerator*this.denominator;
        int deno = this.denominator*other.denominator;
        Fraction result = new Fraction(num,deno);
        result.toLowestTerms();
        return result;
    }

    //Multiply two fractions
    public Fraction multiply(Fraction other){
        int num = this.numerator*other.numerator;
        int deno = this.denominator*other.denominator;
        Fraction result = new Fraction(num,deno);
        result.toLowestTerms();
        return result;
    }
    //Divide two fractions
    public Fraction divide(Fraction other){
        int num = this.numerator*other.denominator;
        int deno = this.denominator*other.numerator;
        Fraction result = new Fraction(num,deno);
        result.toLowestTerms();
        return result;
    }

    //Check whether two fractions are equal
    public boolean equals(Object object){
        if (object instanceof Fraction){
            Fraction other = (Fraction) object;
            this.toLowestTerms();
            other.toLowestTerms();
            if ((this.numerator == other.numerator) && (this.denominator == other.denominator)){
                return true;
            }
            else return false;
        }
        else {
            try {
                throw new IllegalAccessException("Not a Fraction");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //Convert the fraction to lowest terms
    public void toLowestTerms(){
        int hcf = gcd(this.numerator, this.denominator);
        this.numerator /= hcf;
        this.denominator /= hcf;
    }

    //Find the gcd
    public int gcd(int a, int b){

        if (a == 0 || b == 0){
            return a + b;
        }
        return gcd(b,a%b);
    }

}
