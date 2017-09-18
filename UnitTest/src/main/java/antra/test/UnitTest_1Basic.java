package main.java.antra.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnitTest_1Basic {

    @Test
    public void testTrue() {
        assertTrue(1 == 1);
    }

    @Test
    public void testFalse() {
        assertFalse(1 == 2);
    }

    @Test
    public void testEquals() {
        assertEquals("A", "A");
    }
}
