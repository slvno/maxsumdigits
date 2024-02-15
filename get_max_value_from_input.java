import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;
public class MaxSumDigits {

    public static void main(String[] args) {
        // Создаем объект класса Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Создаем список целых чисел для хранения введенных чисел
        List<BigInteger> numbers = new ArrayList<>();

        // Читаем числа с клавиатуры до тех пор, пока не будет введена пустая строка
        while (true) {
            // Читаем строку с клавиатуры
            String inputNumberStr = scanner.nextLine();

            // Проверяем, является ли строка пустой
            if (inputNumberStr.isEmpty()) {
                // Если строка пустая, выходим из цикла
                break;
            }
			
			// Разбить строку на массив чисел
            String[] numbers_split = inputNumberStr.split(" ");

            for (String numberStr : numbers_split) {
              try
			  {
                  // Преобразуем строку в целое число
                  BigInteger number = new BigInteger(numberStr);
				
                  // Добавляем число в список
                  numbers.add(number);
			  }
			  catch (java.lang.NumberFormatException e)
			  {
				    System.out.println("Error: "+e.toString()+" number:" +numberStr);
			  }     
			}			  
        }

        // Закрываем объект класса Scanner
        scanner.close();

        // Находим число с максимальной суммой цифр
        BigInteger maxNumber = findMaxSumNumber(numbers);

        // Выводим число с максимальной суммой цифр
        System.out.println(maxNumber);
    }

    private static BigInteger findMaxSumNumber(List<BigInteger> numbers) {
        // Инициализируем переменные для хранения максимальной суммы цифр и числа с максимальной суммой цифр
        long maxSum = 0;
        BigInteger maxNumber = BigInteger.ZERO;
       
        // Перебираем числа в списке
        for (BigInteger number : numbers) {
            // Рассчитываем сумму цифр в числе
            long sumOfDigits = sumOfDigits(number);

            // Проверяем, является ли сумма цифр в числе больше максимальной суммы цифр
            if (sumOfDigits > maxSum) {
                // Если сумма цифр в числе больше максимальной суммы цифр, обновляем максимальную сумму цифр и число с максимальной суммой цифр
                maxSum = sumOfDigits;
                maxNumber = number;
            }
        }

        // Возвращаем число с максимальной суммой цифр
        return maxNumber;
    }

    private static long sumOfDigits(BigInteger number) {
        // Преобразуем число в строку
        String numberStr = String.valueOf(/*Math.abs(*/number.abs());

        // Инициализируем переменную для хранения суммы цифр
        long sumOfDigits = 0;

        // Перебираем цифры в числе
        for (char digit : numberStr.toCharArray()) {
            // Преобразуем цифру в целое число
            long digitInt = Character.getNumericValue(digit);

            // Добавляем цифру к сумме цифр
            sumOfDigits += digitInt;
        }

        // Возвращаем сумму цифр
        return sumOfDigits;
    }
}

/*
Тестовый набор входных данных:

12345
-67890
987654321
-4123456789
0

Ожидаемый результат:

987654321

Пояснения:

    Число 12345 имеет сумму цифр 15.
    Число -67890 имеет сумму цифр 30.
    Число 987654321 имеет сумму цифр 45.
    Число -4123456789 имеет сумму цифр 39.
    Число 0 имеет сумму цифр 0.

Таким образом, число с максимальной суммой цифр в нем - 987654321.

Примечание:

В приведенном выше приложении мы используем метод Math.abs() для получения абсолютного значения отрицательного числа. Это необходимо для того, чтобы правильно рассчитать сумму цифр в отрицательном числе.
*/
