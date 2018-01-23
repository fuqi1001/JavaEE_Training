package main.java.antra.test.mocktest.cookbook;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class simpleTest {

    @Test
    public void test1() {
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(false);

        boolean added = listMock.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test
    public void test2() {
        MyList listMock = mock(MyList.class);
        doReturn(false).when(listMock).add(anyString());

        boolean added = listMock.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    //configure mock to throw an exception on a method call
    @Test(expected = IllegalStateException.class)
    public void test3ThrowException() {
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);

        listMock.add(randomAlphabetic(6));
    }

    //configure the behavior of a method with void return type – to throw an exception
    @Test
    public void test4() {
        MyList listMock = mock(MyList.class);
        doThrow(NullPointerException.class).when(listMock).clear();
        listMock.clear();
    }

    //configure the behavior of multiple calls
    @Test
    public void test5() {
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);

        listMock.add(randomAlphabetic(6));
        listMock.add(randomAlphabetic(6)); //will throw a exception
    }

    //configure the behavior of a spy
    @Test
    public void test6() {
        MyList instance = new MyList();
        MyList spy = spy(instance);
        doThrow(NullPointerException.class).when(spy).size();
        spy.size();  //// will throw the exception
    }


    //configure method to call the real, underlying method on a mock
    @Test
    public void test7() {
        MyList listMock = mock(MyList.class);
        when(listMock.size()).thenCallRealMethod();
        assertThat(listMock.size(), equalTo(1));
    }

    //configure mock method call with custom Answer
    @Test
    public void test8() {
        MyList listMock = mock(MyList.class);
        doAnswer(invocation -> "Always the same").when(listMock).get(anyInt());

        String element = listMock.get(1);
        assertThat(element, is(equalTo("Always the same")));
    }

    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some method:
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        //print "one" - the first element of the list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }
}
