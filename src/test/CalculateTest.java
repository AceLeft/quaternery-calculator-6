package test;

import Calculator.Calculate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculateTest {
    @Test
    public void base4ToBase10(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.base4ToBase10("11");
        Assertions.assertEquals(5, returnedValue);
    }

    @Test
    public void base10ToBase4(){
        Calculate calculateTest = new Calculate();
        String returnedValue = calculateTest.base10ToBase4(11);
        Assertions.assertEquals("23", returnedValue);
    }

    @Test
    public void addition(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.addition(1,5);
        Assertions.assertEquals(6, returnedValue);
    }

    @Test
    public void subtraction(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.subtraction(5,1);
        Assertions.assertEquals(4, returnedValue);
    }

    @Test
    public void multiplication(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.multiplication(2,5);
        Assertions.assertEquals(10, returnedValue);
    }

    @Test
    public void division(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.division(10,5);
        Assertions.assertEquals(2, returnedValue);
    }

    @Test
    public void squareRoot(){
        Calculate calculateTest = new Calculate();
        int returnedValue = calculateTest.squareRoot(25);
        Assertions.assertEquals(5, returnedValue);
    }
}
