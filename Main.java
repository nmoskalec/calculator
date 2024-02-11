import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение в формате:\n\"a + b\" или \"a - b\" или \"a * b\" или \"a / b\". ");
        System.out.println("Где \"a\" и \"b\" - символы от 0 до 10 ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.replaceAll(" ", "");
        if (line.length() <= 2){
            throw new IllegalArgumentException("Cтрока не является математической операцией");
        }
        String output = calc(line);
        System.out.println(output);
    }
    public static String calc(String input) {
        String answer;
        answer =  operands(input);
        return answer;
    }

    private static char operationCalc(String line) {
        char op = ' ';
        int k = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+') {
                op = '+';
                k += 1;
            }
            if (line.charAt(i) == '-') {
                op = '-';
                k += 1;
            }
            if (line.charAt(i) == '*') {
                op = '*';
                k += 1;
            }
            if (line.charAt(i) == '/') {
                op = '/';
                k += 1;
            }
        }
        if (op == ' '){
            throw new IllegalArgumentException("Неверный знак операции");
        }
        else if (k > 1){
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return op;
    }


    public static String calculation(String a, String b, char operation) {

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '.') {
                throw new IllegalArgumentException("Вы ввели вещественное число");
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '.') {
                throw new IllegalArgumentException("Вы ввели вещественное число");
            }
        }

        int num1 =  parseInt(a);
        int num2 =  parseInt(b);
        if ((num1 > 10 ) || (num2 > 10)){
            throw new IllegalArgumentException("Вы ввели число превыщающее 10 или 3 числа");
        }
        else {

            int result;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
            return Integer.toString(result);
        }
    }


    private static String operands(String line){
        int i = 0;
        int k = line.length() - 1;
        String a;
        String b;
        char operation;
        String result;
        operation = operationCalc(line);
        while (line.charAt(i) != operation) {
            i += 1;
        }
        a = line.substring(0, i);
        while (line.charAt(k) != operation) {
            k -= 1;
        }
        b = line.substring(k + 1);
        if ((i == 0) || (k == (line.length() - 1))){
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        result = calculation(a, b, operation);
        return result;
    }
}



