package main.java.antra.test.mocktest.cookbook;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

public class verifyTest {

    @Test
    public void test1() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList).size();
    }

    @Test
    public void test2() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList, times(1)).size();
    }

    //verify no interaction with the whole mock occurred
    @Test
    public void test3() {
        List<String> mockedList = mock(MyList.class);
        verifyZeroInteractions(mockedList);
    }

    //verify no interaction with a specific method occurred
    @Test
    public void test4() {
        List<String> mockedList = mock(MyList.class);
        verify(mockedList, times(0)).size();
    }

    //verify there are no unexpected interactions – this should fail:
    @Test
    public void test5() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    //verify order of interaction
    @Test
    public void test6() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();
    }

    //verify an interaction has not occurred
    @Test
    public void test7() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList, never()).clear();
    }

    //verify an interaction has occurred at least certain number of times
    @Test
    public void test8() {
        List<String> mockedList = mock(MyList.class);
        mockedList.clear();
        mockedList.clear();
        mockedList.clear();

        verify(mockedList, atLeast(1)).clear();
        verify(mockedList, atMost(10)).clear();
    }

    //verify interaction with exact argument
    @Test
    public void test9() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    //verify interaction with flexible/any argument
    @Test
    public void test10() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

}
