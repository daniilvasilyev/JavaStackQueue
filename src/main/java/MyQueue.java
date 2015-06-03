import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import javax.lang.model.element.Element;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Очередь: FIFO = First Input First Output
 */
public class MyQueue<T> implements Iterable<T> {

    /**
     * head - начало очереди
     * tail - конец очереди
     * size - размер очереди
     */
    private  Element<T> head = null, tale = null;
    private  int size = 0;

    /**
     * Добавить в конец очереди
     *
     * @param v значение
     */
    public void put(T v)
    {
        Element<T> cur = new Element<>( v );
        if( head == null ) {
            assert ( tale == null && size == 0 ) : "Недопустимое состояние очереди";
            head = cur;
            tale = head;
        }
        else {
            tale.next = cur;
            tale = cur;
        }
        size++;
    }

    /**
     * Взять из начала очереди
     *
     * @return значение
     */
    public T get() throws NoSuchElementException {
        if( head == null ) {
            assert ( tale == null && size == 0 ) : "Недопустимое состояние очереди";
            throw new NoSuchElementException( "Очередь пуста" );
        }
        assert size > 0 : "Недопустимое состояние очереди";
        T res = head.value;
        head = head.next;
        size--;
        return res;
    }

    /**
     * Получить размер очереди
     *
     * @return размер очереди
     */
    public int getSize()
    {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    /**
     * Элемент очереди
     */
    public static class Element<T> {

        T value;
        Element<T> next = null;

        Element( T v )
        {
            value = v;
        }
    }

    public class MyStackIterator implements Iterator<T> {
        Element<T> cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            //имеет ли смысл так обходить очередь или стек??
            T res = cur.value;
            cur = cur.next;
            return res;
        }
    }
}
