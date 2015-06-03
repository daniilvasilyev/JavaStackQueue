import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование стека
 */
public class MyStackTest {

    /**
     * Стек с целыми числами
     */
    @Test
    public void testIntStack() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop().intValue());
        assertEquals(2, myStack.pop().intValue());
        assertEquals(1, myStack.pop().intValue());
    }

    /**
     * Стек со строками
     */
    @Test
    public void testStringStack() {
        MyStack<String> myStack = new MyStack<>();
        assertEquals( 0, myStack.getSize() );
        myStack.push("Hello");
        assertEquals( 1, myStack.getSize() );
        myStack.push("world");
        assertEquals( 2, myStack.getSize() );
        assertEquals("world", myStack.pop());
        assertEquals( 1, myStack.getSize() );
        assertEquals("Hello", myStack.pop());
        assertEquals( 0, myStack.getSize() );
    }

    /**
     * Стек пуст и мы пытаемся из него вытащить значение
     */
    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        class MyClass {
        }
        MyStack<MyClass> myStack = new MyStack<>();
        myStack.pop();
    }
}
