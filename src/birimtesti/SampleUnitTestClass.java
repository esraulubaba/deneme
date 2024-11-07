package birimtesti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SampleUnitTestClass {


    @Test
    public void test(){
        System.out.println(" inside test ");
    }
    

    Calculator calculatorTest = new Calculator();

    @Test
    public void test_add(){
        // given
       int firstNumber = 10;
       int secondNumber = 20;
       int expected = 30;

       // when
       int actual = calculatorTest.add(firstNumber, secondNumber);

       // then
       Assertions.assertEquals(expected, actual);
    }
    
  
   class Calculator{
       int add(int a, int b){
           return a + b;
       }
       
       @ParameterizedTest
       @ValueSource(ints = {-10, 1, 0, 20})
       public void should_returnZero_when_multiplyNumberWithZero(int givenSource){
           // given
           int firstNumber = givenSource;
           int secondNumber = 0;

           // when
           int actual = calculatorTest.multiply(firstNumber, secondNumber);

           // then
           Assertions.assertTrue(actual == 0);
       }

	private int multiply(int firstNumber, int secondNumber) {
		return 0;
	}
	
	@ParameterizedTest(name = "1st={0}, 2nd={1}")
    @CsvSource(value = {"-10, -1", "-10, -20", "-3, -45"})
    public void should_returnTrue_when_multiplyTwoNegativeNumbers(int givenFirstNumber, int givenSecondNumber){
        // given
        int firstNumber = givenFirstNumber;
        int secondNumber = givenSecondNumber;

        // when
        int actual = calculatorTest.multiply(firstNumber, secondNumber);

        // then
        Assertions.assertTrue(actual > 0);
    }
	

    @Test
    public void should_throwException_when_divideNumberWithZero(){
        // given
        int firstNumber = 10;
        int secondNumber = 0;

        // when
        Executable executable = () -> calculatorTest.multiply(firstNumber, secondNumber);

        // then
        Assertions.assertThrows(ArithmeticException.class, executable);
    }
   }
  
}