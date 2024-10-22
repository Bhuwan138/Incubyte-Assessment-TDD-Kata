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
}
