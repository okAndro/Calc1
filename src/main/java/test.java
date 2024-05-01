import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, '1 + 2'):");

        String input = scanner.nextLine();

        try {
            checkAndCalculate(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    // Метод для проверки и вычисления арифметического выражения
    public static void checkAndCalculate(String input) throws Exception { // добавляем throws Exception
        // Создаем шаблон поиска для нахождения двух чисел, разделенных оператором
        Pattern pattern = Pattern.compile("^(\\d+)\\s*([+\\-*/])\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(input);

        // Проверяем соответствие строки шаблону
        if (matcher.matches()) {
            // Извлекаем числа и оператор
            int number1 = Integer.parseInt(matcher.group(1));
            int number2 = Integer.parseInt(matcher.group(3));
            String operator = matcher.group(2);

            // Проверяем, что числа в заданном диапазоне
            if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
                throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно."); // теперь выбрасываем Exception
            }

            // Выполняем операцию
            int result = calculate(number1, number2, operator);
            // Выводим результат
            System.out.println("Результат выражения: " + result);

        } else {
            // Если шаблон не совпал, выбрасываем Exception
            throw new Exception("Строка не является математической операцией."); // теперь выбрасываем Exception
        }
    }

    // Метод для вычисления результата
    public static int calculate(int num1, int num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + op);
        }
    }
}