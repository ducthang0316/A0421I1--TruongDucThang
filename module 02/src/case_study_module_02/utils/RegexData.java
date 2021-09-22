package case_study_module_02.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);
    public static String regexStr(String temp, String regex, String error){
      boolean check = true;
      do {
          if (temp.matches(regex)){
              check = false;
          } else {
              System.out.println(error);
              temp = scanner.nextLine();
          }
      } while (check);

        return temp;
    }

    public static String regexAge (String temp, String regex){
        boolean check = true;
        while (check){
            try {
                if (Pattern.matches(regex, temp)){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int age = Period.between(date, now).getYears();
                    if (age > 18 && age < 100){
                        check = false;
                    } else {
                        throw new InvalidDateException("Age must greater than 18 and less than 100");
                    }
                } else {
                    throw new InvalidDateException("Wrong format. please follow this format dd/MM/yyyy");
                }
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
               temp = scanner.nextLine();
            }
        }
        return temp;
    }

    public static String regexDate (String temp, String regex){
        boolean check = true;
        Date date1 = null;
        while (check){
            try {
                if (Pattern.matches(regex, temp)){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(temp, formatter);

                } else {
                    throw new InvalidDateException("Wrong format. please follow this format dd/MM/yyyy");
                }
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }


}
