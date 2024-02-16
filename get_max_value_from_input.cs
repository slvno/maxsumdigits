//**Приложение с учетом отрицательных чисел:**

//#define DEBUG
//#define TRACE

//```csharp
using System;
using System.Numerics;
using System.Diagnostics;

namespace MaxSumDigits
{
    class Program
    {
        static void Main(string[] args)
        {
            Trace.Listeners.Add(new TextWriterTraceListener(Console.Out));
            Trace.AutoFlush = true;
            Trace.Indent();
            Trace.WriteLine("Entering Main");

            // Инициализируем переменную для хранения максимальной суммы цифр
            BigInteger maxSum = 0;

            // Инициализируем переменную для хранения числа с максимальной суммой цифр
            BigInteger maxNumber = 0;

            // Вводим целые числа с клавиатуры, пока не будет введен ноль
            while (true)
            {
                // Читаем строку с клавиатуры
                string inputNumberStr = Console.ReadLine();

                Trace.WriteLine(inputNumberStr, "inputNumberStr");

                // Проверяем, является ли строка пустой
                if (string.IsNullOrEmpty(inputNumberStr))
                {
                    // Если строка пустая, выходим из цикла
                    break;
                }
				
				string[] numberStrings = inputNumberStr.Split(' ', ',');

                Trace.WriteLine(numberStrings.ToString(), "numberStrings");
                Trace.WriteLine(numberStrings.Length, "numberStrings_count");
                int counter = 0;

                foreach (string numberStr in numberStrings)
                {
                    Trace.WriteLine(numberStr, "numberStrings["+ counter.ToString()+"]");
                    counter++;
                }

                foreach (string numberStr in numberStrings) 
				{
					
                    // Преобразуем строку в целое число BigInteger
                   BigInteger number = 0;
				
				   try
				   {
                        
                        number = BigInteger.Parse(numberStr);

                        Trace.WriteLine(number, "number = BigInteger.Parse(numberStr)");

                        // Если число равно нулю, выходим из цикла
                        if (number == 0)
                       {
                            break;
                       }

                       // Рассчитываем сумму цифр в числе
                       BigInteger sumOfDigits = 0;
                       if (number < 0)
                       {
                           // Если число отрицательное, берем его абсолютное значение
                           number = /*Math.Abs(*/BigInteger.Abs(number)/*)*/;
                       }
                       while (number > 0)
                       {
                           // Извлекаем последнюю цифру из числа
                           BigInteger digit = number % 10;

                           // Добавляем последнюю цифру к сумме цифр
                           sumOfDigits += digit;

                           // Удаляем последнюю цифру из числа
                           number /= 10;
                       }

                        Trace.WriteLine(sumOfDigits, "sumOfDigits");

                        // Проверяем, является ли сумма цифр в числе больше максимальной суммы цифр
                        if (sumOfDigits > maxSum)
                       {
                           // Если сумма цифр в числе больше максимальной суммы цифр, обновляем максимальную сумму цифр и число с максимальной суммой цифр
                           maxSum = sumOfDigits;
                           maxNumber = BigInteger.Parse(numberStr);
                       }
       				}
				
		       		catch (System.FormatException e)
				    {
					     Trace.WriteLine("Error:"+e+" value:"+ numberStr);
				    } 
               }

               
            }
		    // Выводим число с максимальной суммой цифр в нем
            Console.WriteLine(maxNumber);

            Trace.WriteLine("Exiting Main");
            Trace.Unindent();
        }
    }
}
/*
```

**Тестовый набор входных данных:**

```
12345
-67890
987654321
-4123456789
0
```

**Ожидаемый результат:**

```
987654321 
```

**Пояснения:**

* Число 12345 имеет сумму цифр 15.
* Число -67890 имеет сумму цифр 30.
* Число 987654321 имеет сумму цифр 45.
* Число -4123456789 имеет сумму цифр 39.
* Число 0 имеет сумму цифр 0.

Таким образом, число с максимальной суммой цифр в нем - 987654321.

**Примечание:**

В приведенном выше приложении мы используем метод `Math.Abs()` для получения абсолютного значения отрицательного числа. Это необходимо для того, чтобы правильно рассчитать сумму цифр в отрицательном числе.
*/
