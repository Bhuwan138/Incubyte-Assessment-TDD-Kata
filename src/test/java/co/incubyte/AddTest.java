package co.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    Add add = new Add();

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, add.add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber(){
        assertEquals(1, add.add("1"));
    }

    @Test
    public void shouldReturnSumOnTwoNumbersDelimitedByComma(){
        assertEquals(3, add.add("1,2"));
    }

    @Test
    public void shouldReturnSumOnMultipleNumbersDelimitedByComma(){
        assertEquals(55, add.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimeter(){
        assertEquals(6, add.add("1\n2,3"));
    }

    @Test
    public void shouldAcceptCustomDelimeterSyntax(){
        assertEquals(3, add.add("//;\n1;2"));
    }

    @Test
    public void customDelimeterCouldBeRegExpSpecialChar(){
        assertEquals(3, add.add("//.\n1.2"));
    }

    @Test
    public void shouldThrowExceptionOnNegativeNumber(){
        try{
            add.add("-1,-2,3");
        }catch (IllegalArgumentException e){
            assertEquals("negatives not allowed: -1,-2", e.getMessage());
        }
    }

    @Test
    public void showMultipleNegativeNumbersInExceptionMessage(){
        try{
            add.add("-1,-2,-3");
        }catch (IllegalArgumentException e){
            assertEquals("negatives not allowed: -1,-2,-3", e.getMessage());
        }
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000(){
        assertEquals(2, add.add("2,1001"));
    }

    @Test
    public void shouldAcceptCustomDelimeterOfAnyLength(){
        assertEquals(6, add.add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldAcceptMultipleCustomDelimeter(){
        assertEquals(6, add.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void shouldAcceptMultipleCustomDelimeterOfAnyLength(){
        assertEquals(6, add.add("//[**][%%]\n1**2%%3"));
    }


}
