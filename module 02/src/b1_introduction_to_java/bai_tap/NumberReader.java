package b1_introduction_to_java.bai_tap;
import java.util.Scanner;

public class NumberReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number: ");
        int num = scanner.nextInt();
        int ones, tens, hundreds, specialCase ;
        hundreds = num / 100;
        tens = (num % 100) / 10;
        ones = (num % 100) % 10;
        specialCase = num % 100;

        if (num > 19 && num < 1000){
            switch (hundreds){
                case 0:
                    System.out.printf("");
                    break;
                case 1:
                    System.out.printf("one hundred ");
                    break;
                case 2:
                    System.out.printf("two hundred ");
                    break;
                case 3:
                    System.out.printf("three hundred ");
                    break;
                case 4:
                    System.out.printf("four hundred ");
                    break;
                case 5:
                    System.out.printf("five hundred ");
                    break;
                case 6:
                    System.out.printf("six hundred ");
                    break;
                case 7:
                    System.out.printf("seven hundred ");
                    break;
                case 8:
                    System.out.printf("eight hundred ");
                    break;
                case 9:
                    System.out.printf("nine hundred ");
                    break;
            }
            switch (tens) {
                case 2:
                    System.out.printf("twenty ");
                    break;
                case 3:
                    System.out.printf("thirty ");
                    break;
                case 4:
                    System.out.printf("forty ");
                    break;
                case 5:
                    System.out.printf("fifty ");
                    break;
                case 6:
                    System.out.printf("sixty ");
                    break;
                case 7:
                    System.out.printf("seventy ");
                    break;
                case 8:
                    System.out.printf("eighty ");
                    break;
                case 9:
                    System.out.printf("ninety ");
                    break;
            }
            if (tens == 1){
                switch (specialCase){
                    case 10: System.out.printf("and ten "); break;
                    case 11: System.out.printf("and eleven "); break;
                    case 12: System.out.printf("and twelve "); break;
                    case 13: System.out.printf("and thirteen "); break;
                    case 14: System.out.printf("and fourteen "); break;
                    case 15: System.out.printf("and fifteen "); break;
                    case 16: System.out.printf("and sixteen "); break;
                    case 17: System.out.printf("and seventeen "); break;
                    case 18: System.out.printf("and eighteen "); break;
                    case 19: System.out.printf("and nineteen ");break;
                }
                System.exit(ones);
            }
            switch (ones){
                case 1:
                    System.out.printf("one");
                    break;
                case 2:
                    System.out.printf("two");
                    break;
                case 3:
                    System.out.printf("three");
                    break;
                case 4:
                    System.out.printf("four");
                    break;
                case 5:
                    System.out.printf("five");
                    break;
                case 6:
                    System.out.printf("six");
                    break;
                case 7:
                    System.out.printf("seven");
                    break;
                case 8:
                    System.out.printf("eight");
                    break;
                case 9:
                    System.out.printf("nine");
                    break;
            }
        }  else if ( num >10 && num < 20 ){
            switch (tens){
                case 0: System.out.printf(""); break;
                case 1:
                    switch (ones){
                        case 0: System.out.printf("ten"); break;
                        case 1:  System.out.printf("eleven"); break;
                        case 2: System.out.printf("twelve"); break;
                        case 3: System.out.printf("thirteen"); break;
                        case 4: System.out.printf("fourteen"); break;
                        case 5: System.out.printf("fifteen"); break;
                        case 6: System.out.printf("sixteen"); break;
                        case 7: System.out.printf("seventeen"); break;
                        case 8: System.out.printf("eighteen"); break;
                        case 9: System.out.printf("nineteen"); break;
                    }
                    break;
            }
        } else if (num >= 0 && num < 10){
            switch (ones) {
                case 1: System.out.printf("one"); break;
                case 2: System.out.printf("two"); break;
                case 3: System.out.printf("three"); break;
                case 4: System.out.printf("four"); break;
                case 5: System.out.printf("five"); break;
                case 6: System.out.printf("six"); break;
                case 7: System.out.printf("seven"); break;
                case 8: System.out.printf("eight"); break;
                case 9: System.out.printf("nine"); break;
                case 0: System.out.printf("zero"); break;
            }
        } else {
            System.out.printf("out of ability");
        }
    }
}
