package main.java.antra.test.mocktest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class simpleTest {
    @Test
    public void simpleTest() {

        List<String> list = mock(List.class);

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("hello world");

        String result = list.get(0);

        //验证方法调用
        verify(list).get(0);

        Assert.assertEquals("hello world", result);
    }
}
