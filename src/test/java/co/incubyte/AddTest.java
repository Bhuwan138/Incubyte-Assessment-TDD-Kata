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


}
