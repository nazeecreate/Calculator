package kz.jm.nazira;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение для вычисления:");
        String lineToCalculate = in.nextLine();
        String[] splitedArray = split(lineToCalculate);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(splitedArray[1], splitedArray[0], splitedArray[2]);
        System.out.println("Результат:");
        System.out.println(calculator.isRoman() ? Translator.arabicToRoman(result) : result);
    }

    private static String [] split(String s){
        String[] result = s.replace(" ","").split("\\b");
        if (result.length == 3){
            return result;
        }
        else{
            throw new RuntimeException
                    ("Некорректный ввод. Введите выражение в виде a + b");
        }
    }
}
