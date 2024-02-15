import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;
public class MaxSumDigits {

    public static void main(String[] args) {
        // ������� ������ ������ Scanner ��� ������ ������ � ����������
        Scanner scanner = new Scanner(System.in);

        // ������� ������ ����� ����� ��� �������� ��������� �����
        List<BigInteger> numbers = new ArrayList<>();

        // ������ ����� � ���������� �� ��� ���, ���� �� ����� ������� ������ ������
        while (true) {
            // ������ ������ � ����������
            String inputNumberStr = scanner.nextLine();

            // ���������, �������� �� ������ ������
            if (inputNumberStr.isEmpty()) {
                // ���� ������ ������, ������� �� �����
                break;
            }
			
			// ������� ������ �� ������ �����
            String[] numbers_split = inputNumberStr.split(" ");

            for (String numberStr : numbers_split) {
              try
			  {
                  // ����������� ������ � ����� �����
                  BigInteger number = new BigInteger(numberStr);
				
                  // ��������� ����� � ������
                  numbers.add(number);
			  }
			  catch (java.lang.NumberFormatException e)
			  {
				    System.out.println("Error: "+e.toString()+" number:" +numberStr);
			  }     
			}			  
        }

        // ��������� ������ ������ Scanner
        scanner.close();

        // ������� ����� � ������������ ������ ����
        BigInteger maxNumber = findMaxSumNumber(numbers);

        // ������� ����� � ������������ ������ ����
        System.out.println(maxNumber);
    }

    private static BigInteger findMaxSumNumber(List<BigInteger> numbers) {
        // �������������� ���������� ��� �������� ������������ ����� ���� � ����� � ������������ ������ ����
        long maxSum = 0;
        BigInteger maxNumber = BigInteger.ZERO;
       
        // ���������� ����� � ������
        for (BigInteger number : numbers) {
            // ������������ ����� ���� � �����
            long sumOfDigits = sumOfDigits(number);

            // ���������, �������� �� ����� ���� � ����� ������ ������������ ����� ����
            if (sumOfDigits > maxSum) {
                // ���� ����� ���� � ����� ������ ������������ ����� ����, ��������� ������������ ����� ���� � ����� � ������������ ������ ����
                maxSum = sumOfDigits;
                maxNumber = number;
            }
        }

        // ���������� ����� � ������������ ������ ����
        return maxNumber;
    }

    private static long sumOfDigits(BigInteger number) {
        // ����������� ����� � ������
        String numberStr = String.valueOf(/*Math.abs(*/number.abs());

        // �������������� ���������� ��� �������� ����� ����
        long sumOfDigits = 0;

        // ���������� ����� � �����
        for (char digit : numberStr.toCharArray()) {
            // ����������� ����� � ����� �����
            long digitInt = Character.getNumericValue(digit);

            // ��������� ����� � ����� ����
            sumOfDigits += digitInt;
        }

        // ���������� ����� ����
        return sumOfDigits;
    }
}

/*
�������� ����� ������� ������:

12345
-67890
987654321
-4123456789
0

��������� ���������:

987654321

���������:

    ����� 12345 ����� ����� ���� 15.
    ����� -67890 ����� ����� ���� 30.
    ����� 987654321 ����� ����� ���� 45.
    ����� -4123456789 ����� ����� ���� 39.
    ����� 0 ����� ����� ���� 0.

����� �������, ����� � ������������ ������ ���� � ��� - 987654321.

����������:

� ����������� ���� ���������� �� ���������� ����� Math.abs() ��� ��������� ����������� �������� �������������� �����. ��� ���������� ��� ����, ����� ��������� ���������� ����� ���� � ������������� �����.
*/
