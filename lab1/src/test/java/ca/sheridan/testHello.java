package ca.sheridan;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class testHello {
    
    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        assertEquals("Hello", hello.sayHello());
    }
}
