package kz.jm.nazira;

public class Calculator {
    private boolean roman = false;
    private boolean arabic = false;
    private int x;
    private int y;

    public int calculate(String sign, String a, String b) {
        x = parse(a);
        y = parse(b);
        if(roman && arabic){
            throw new RuntimeException
                    ("Неправильный ввод, вы должны ввести числа от 1 до 10 ти включительно, " +
                            "одной системы исчисления");
        }
        int result;
        switch (sign) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                throw new RuntimeException("Неправильный ввод, можно использовать только операторы + - * /");
        }
        return result;
    }

    private int parse(String num) {
        int result;
        try {
            result = Integer.parseInt(num);
            arabic = true;
        } catch (NumberFormatException e) {
            result = Translator.romanToArabic(num);
            roman = true;
        }
        if (validate(result)) {
            return result;
        } else {
            throw new RuntimeException
                    ("Неправильный ввод, вы должны ввести числа от 1 до 10 ти включительно, " +
                            "одной системы исчисления");
        }
    }

    private boolean validate(int num) {
        return num >= 1 && num <= 10;
    }

    public boolean isRoman() {
        return roman;
    }
}