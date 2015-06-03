import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Стек: LIFO = Last Input First Output
 */
public class MyStack<T> {

    //TODO - реализовать итераторы, такие же как в очереди
    //TODO - базовый класс для очереди и стека

    /**
     * head - вершина стека
     * size - размер стека
     */

    private  Element<T> head = null;
    private  int size = 0;

    /**
     * Добавить на вершину стека
     *
     * @param v значение
     */
    public void push(T v)
    {
        Element<T> cur = new Element<>( v );
        if( head == null ) {
            assert (  size == 0 ) : "Недопустимое состояние очереди";
            head = cur;
        }
        else {
            cur.next = head;
            head = cur;
        }
        size++;
    }

    /**
     * Получить значение с вершины
     *
     * @return значение
     */
    public T pop() throws EmptyStackException
    {
        if( head == null ) {
            assert ( size == 0 ) : "Недопустимое состояние стека";
            throw new EmptyStackException();
        }
        assert size > 0 : "Недопустимое состояние стека";

        T res = head.value;
        head = head.next;
        size--;
        return res;
    }

    /**
     * Получить размер стека
     *
     * @return размер стека
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Элемент стека
     */
    public  static class Element<T> {
        T value;
        Element next;

        Element( T v )
        {
            value = v;
        }
    }
}
