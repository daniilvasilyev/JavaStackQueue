import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

/**
 * Тестирование очереди
 */
public class MyQueueTest {

    /**
     * Очередь со строками
     */
    @Test
    public void testStringQueue() {
        MyQueue<String> myQueue = new MyQueue<>();
        assertEquals( 0, myQueue.getSize() );
        myQueue.put("Hello");
        assertEquals( 1, myQueue.getSize() );
        myQueue.put("world");
        assertEquals( 2, myQueue.getSize() );
        assertEquals("Hello", myQueue.get());
        assertEquals( 1, myQueue.getSize() );
        assertEquals("world", myQueue.get());
        assertEquals( 0, myQueue.getSize() );
    }

    /**
     * Очередь пуста и мы пытаемся из неё вытащить значение
     */
    @Test(expected = NoSuchElementException.class)
    public void testEmptyQueue() {
        class MyClass {
        }
        MyQueue<MyClass> myQueue = new MyQueue<>();
        myQueue.get();
    }

    @Test
    public void testIterator() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.put( 1 );
        myQueue.put( 2 );
        myQueue.put( 3 );
        myQueue.put( 4 );
        myQueue.put( 5 );

        Iterator<Integer> iterator = myQueue.iterator();
        int i = 1;
        while ( iterator.hasNext() ) {
            assertEquals( i++, (int)iterator.next() );
        }

        assertEquals( 5, myQueue.getSize() );
        assertEquals( 1, (int)myQueue.get() );

    }
}
