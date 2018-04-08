import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args){

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply, divide fractions until you type \'Q\' to quit");
        System.out.println("Please enter you fractions in the form a/b, where a & b are integers.");

        while (true){
            System.out.println("------------------------------------------------------------------------------");
            String operand = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();
            Fraction result;

            if (operand.equals("+")){
                System.out.println(frac1 + " " + operand + " " + frac2 + " = ");
                result = frac1.add(frac2);
                System.out.println(result.toString());
            }

            else if (operand.equals("-")){
                System.out.println(frac1 + " " + operand + " " + frac2 + " = ");
                result = frac1.subtract(frac2);
                System.out.println(result.toString());
            }

            else if (operand.equals("*")){
                System.out.println(frac1 + " " + operand + " " + frac2 + " = ");
                result = frac1.multiply(frac2);
                System.out.println(result.toString());
            }

            else if (operand.equals("/")){
                System.out.println(frac1 + " " + operand + " " + frac2 + " = ");
                result = frac1.divide(frac2);
                System.out.println(result.toString());
            }

            else if (operand.equals("=")){
                System.out.println(frac1 + " " + operand + " " + frac2 + " = ");
                System.out.println(frac1.equals(frac2));
            }

        }


    }

    public static String getOperation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an operation (+,-,*,/,= or Q to quit)");
        String operation = sc.next();

        while ((!operation.equals("+")) && (!operation.equals("-")) && (!operation.equals("*")) && (!operation.equals("/")) && (!operation.equals("=")) && (!operation.equalsIgnoreCase("Q"))){
            System.out.println("Invalid operation (+,-,*,/,= or Q to quit) ");
            operation = sc.next();
        }
        if (operation.equalsIgnoreCase("Q")){
            System.exit(0);
        }

        return operation;
    }

    public static boolean validFraction(String input){
        if (input.contains("/")){
            String[] inputArray = input.split("/");
            String numerator = inputArray[0];
            String denominator = inputArray[1];

            if (!isNumber(numerator) && !isNumber(denominator) && Integer.parseInt(denominator) == 0 && numerator.isEmpty() && denominator.isEmpty()){
                return false;
            }
            else return true;
        }
        else
        return (isNumber(input));
    }

    public static boolean isNumber(String input){

        // -? --> matches '-' sign, \\d+ --> matches 1 or more digit characters
        if (input.matches("-?\\d+")){
            return true;
        }
        else
            return false;
    }

    public static Fraction getFraction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a fraction (a/b) or integer (a) ");
        String frac = sc.nextLine();

        while (!validFraction(frac)){
            System.out.println("Invalid input. Please enter a fraction (a/b) or integer (a), where a and b are integers and b is not zero  ");
            frac = sc.nextLine();
        }
        //If it is a fraction
        if (frac.contains("/")){
            String[] fracArray = frac.split("/");
            int numerator = Integer.parseInt(fracArray[0]);
            int denominator = Integer.parseInt(fracArray[1]);

            return new Fraction(numerator, denominator);
        }

        //If it is an integer
        else {
            return new Fraction(Integer.parseInt(frac));
        }
    }


}
