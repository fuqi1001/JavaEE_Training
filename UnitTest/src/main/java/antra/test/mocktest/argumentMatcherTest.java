package main.java.antra.test.mocktest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class argumentMatcherTest {
    @Test
    public void argumentMatcherTest() {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("hello", "world");
        String result = list.get(0) + list.get(1);
        verify(list, times(2)).get(anyInt());
        Assert.assertEquals("helloworld", result);
    }

    @Test
    public void argumentMatcherTest2() {
        Map<Integer, String> map = mock(Map.class);
        when(map.put(anyInt(), anyString())).thenReturn("hello");

        map.put(1,"world");
        verify(map).put(eq(1), eq("world"));
    }
}
