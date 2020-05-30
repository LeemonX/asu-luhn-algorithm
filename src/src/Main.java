import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();

        if (inputData.length() == 16 && inputData.matches("[0-9]+")){
            StringBuilder multipliedOdds = new StringBuilder();

            int even = 0;

            for (int i = 0; i < inputData.length()-1; i++) {
                if (i % 2 == 1) {
                    even += Character.getNumericValue(inputData.charAt(i));
                }

                else {
                    multipliedOdds.append(Character.getNumericValue(inputData.charAt(i)) * 2);
                }
            }

            int odd = 0;

            for (int i = 0; i < multipliedOdds.length(); i++) {
                odd += Character.getNumericValue(multipliedOdds.charAt(i));
            }

            int finalSum = odd + even;
            int lastDigit = Character.getNumericValue(inputData.charAt(15));

            if((finalSum+lastDigit)%10 == 0){
                System.out.println(inputData.substring(0,4) + " " +
                        inputData.substring(4,8) + " " +
                        inputData.substring(8,12) + " " +
                        inputData.substring(12,16) + " is valid");
                System.exit(1);
            }
            else{
                lastDigit = ((finalSum+10)/10)*10 - finalSum;
                System.out.println("Valid last digit: " + lastDigit);
            }

        }
        else {
            System.out.println("Please input 16-digit card number");
        }
        sc.close();

    }

}
