#```python
import subprocess
import unittest
import time
import codecs
import functools

unbuffered_print = functools.partial(print, flush=True)

def run_test(input_data=''):
    result_out_string = ''
    try:
	
        # Запустите другую программу с помощью subprocess.Popen()
        process = subprocess.Popen(['.\\get_max_value_from_input.exe'],
                                   stdin=subprocess.PIPE,
                                   stdout=subprocess.PIPE,
                                   stderr=subprocess.PIPE)

        # process = subprocess.Popen(['java.exe', 'MaxSumDigits'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        #time.sleep(0.75)
		
        # Отправьте данные на стандартный ввод запущенной программы
        #input_data = 'Введите данные для другой программы'
        # process.stdin.write(input_data.encode())
        # process.stdin.flush()
        # process.stdin.close()
        # assert process.wait() == 0
        #process.stdin.close()
        # Прочитайте ответ с стандартного вывода запущенной программы
        # output_data = process.stdout.read() #.decode()
        #print(output_data.decode())
        # Закройте запущенную программу

        send_input_data = True

        if (input_data is None) or (len(input_data) == 0):
            send_input_data = False

        if True:

            output_data = None
            error_data = None

            if send_input_data:
                process_input_data = input_data.encode('utf-8')
                send_input_data = False
            else:
                process_input_data = None

            output_data, error_data = process.communicate(input=process_input_data)

            if output_data is not None:
                # b = output_data.decode('utf-8')
                b = codecs.decode(output_data, 'cp1251')
                result_out_string += b
            else:
                None #  break

        return result_out_string
    except:
        # 	
        error = ""

    return result_out_string
    

input_data_all = """12345
-67890
987654321
-4123456789
0
12345678901234567890
-98765432109876543210
9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
-1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
123 45
- 67890
 9876 54321 
-4123 456789
0
123456 78901234567890
-98765432109876543210
9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
-1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"""

#define TRACE
# output_data_all = """Error:System.FormatException: ЌҐ г¤ «®бм ўлЇ®«­Ёвм бЁ­в ЄбЁзҐбЄЁ©  ­ «Ё§ §­ зҐ­Ёп.
#    ў System.Numerics.BigNumber.ParseBigInteger(String value, NumberStyles style, NumberFormatInfo info)
#    ў MaxSumDigits.Program.Main(String[] args) value:-
# Error:System.FormatException: ЌҐ г¤ «®бм ўлЇ®«­Ёвм бЁ­в ЄбЁзҐбЄЁ©  ­ «Ё§ §­ зҐ­Ёп.
#    ў System.Numerics.BigNumber.ParseBigInteger(String value, NumberStyles style, NumberFormatInfo info)
#    ў MaxSumDigits.Program.Main(String[] args) value:
# Error:System.FormatException: ЌҐ г¤ «®бм ўлЇ®«­Ёвм бЁ­в ЄбЁзҐбЄЁ©  ­ «Ё§ §­ зҐ­Ёп.
#    ў System.Numerics.BigNumber.ParseBigInteger(String value, NumberStyles style, NumberFormatInfo info)
#    ў MaxSumDigits.Program.Main(String[] args) value:
# 9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
# """


#undef TRACE
output_data_all = """9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
"""


class TestReadInt(unittest.TestCase):

    def test_all_data(self):
        # unbuffered_print('Input: '+input_data_all)
        input_test_data = input_data_all
        expected_test_data = output_data_all.replace('\n','\r\n')
        # unbuffered_print('Expected: '+expected_test_data)
        output_test_data = run_test(input_test_data)
        # unbuffered_print('Output: '+output_test_data)
       
        self.assertEqual(output_test_data, expected_test_data, "test_all_data")

    #  Вход	                 Ожидаемый результат
    #  5	                     5
    def test_positive_number(self):
        input_test_data = "5\r\n"
        expected_test_data = "5\r\n"
        # unbuffered_print('Input: ' + input_test_data)
        # unbuffered_print('Expected: ' + expected_test_data)
        output_test_data = run_test(input_test_data)
        # unbuffered_print('Output: ' + output_test_data)
        self.assertEqual(output_test_data, expected_test_data, "test_positive_number")

    def test_negative_number(self):
        self.assertEqual(run_test("0\n-10"), str(-10)+"\r\n", 'test_negative_number')

    def test_zero(self):
        self.assertEqual(run_test("0\n0"), str(0)+"\r\n", 'test_zero')

    def test_large_positive_number(self):
        self.assertEqual(run_test("0\n123456789"), str(123456789)+"\r\n", 'test_large_positive_number')

    def test_large_negative_number(self):
        self.assertEqual(run_test("0\n-2147483648"), str(-2147483648)+"\r\n", 'test_large_negative_number')

    def test_max_positive_number(self):
        self.assertEqual(run_test("0\n2147483647"), str(2147483647)+"\r\n", 'test_max_positive_number')

    def test_max_negative_number(self):
        self.assertEqual(run_test("0\n-2147483648"), str(-2147483648)+"\r\n", 'test_max_negative_number')

    def test_empty_string(self):
        self.assertEqual(run_test(""), str(0)+"\r\n", 'test_empty_string')

    def test_invalid_input(self):
        self.assertEqual(run_test("abc"), str(0)+"\r\n", 'test_invalid_input')

    def test_multiple_values(self):
        self.assertEqual(run_test("1 2 3"), str(3)+"\r\n", 'test_multiple_values')

    def test_values_separated_by_commas(self):
        self.assertEqual(run_test("1,2,3"), str(3)+"\r\n", 'test_values_separated_by_commas')

    def test_values_float_E(self):
        self.assertEqual(run_test("0\n12E+3"), str(0) + "\r\n", 'test_values_float_E')

    def test_values_float_point(self):
        self.assertEqual(run_test("0\n12.3"), str(0) + "\r\n", 'test_values_float_point')

# Тесткейсы:
#  -10	                     1
#  0	                     0
#  123456789	             (1+2+3+4+5+6+7+8+9)
#  9876543210	             (9+8+7+6+5+4+3+2+1+0)
#  2147483647	             (2+1+4+7+4+8+3+6+4+7)
#  -2147483648	             (2+1+4+7+4+8+3+6+4+8)
#  1000000000000000000	     1
#  -1000000000000000000	 1
#  18446744073709551615	 (1+8+4+4+6+7+4+4+0+7+3+7+0+9+5+5+1+6+1+5)
#  Пустая строка	         0
#  Невалидный ввод
#  (например, "abc")	     0

#def read_int(input_string):
#    try:
#        return int(input_string)
#    except ValueError:
#        return 0

if __name__ == "__main__":
    unittest.main()


#```