import java.util.Iterator;
import java.util.NoSuchElementException;

//Received tutoring from Joshua Ronai
//Michael Buzzetta
//I pledge my honor that I have abided by the Stevens Honor System

public class ListQueue<E>
{
    /*
    This Class and all its code is responsible for creating, storing and tracking the node and queue
    that is used during the user input section
     */


    private Node<E> front;
    private int size;

    public Node<E> getFront() {
        return front;
    }

    public void setFront(Node<E> front) {
        this.front = front;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static class Node<E>
    {
        private E data;
        private Node<E> next;
        private int priority;

        public Node(E dataItem)
        {
            priority=Integer.MAX_VALUE;
            data=dataItem;
            next=null;

        }

        public Node(E dataItem, int priority)
        {
            priority=priority;
            data=dataItem;
            next=null;
        }

        public Node(E dataItem, Node<E> next, int priority)
        {
            priority=priority;
            data=dataItem;
            next=next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }


    }
    public class Iter implements Iterator<E>
    {
        private Node<E> next=front;

        public boolean hasNext()
        {
            if(next==null||next.next==null)
            {
                return false;
            }
            return true;
        }

        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("Sorry, there is no next element");
            }
            E curr = next.data;
            next.next=next;
            return curr;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("It's unsupported");
        }

    }

    public ListQueue()
    {
        front=null;
        size=0;
    }

    public ListQueue(Node<E> front)
    {
        this.front=front;
        size=1;
    }

    public E peek()
    {
        if(front==null)
        {
            return null;
        }
        return front.data;
    }

    public boolean offer(E item, int priority)
    {
        if(item==null)
        {
            throw new NullPointerException("The intended item is null");
        }

        if(size==0)
        {
            front=new Node<>(item,priority);
            size=1;
            return true;
        }

        if(priority<front.priority)
        {
            Node<E> temp = new Node<>(item, front, priority);
            front=temp;
            size++;
            return true;
        }
        Node<E> curr= front;
        while(curr.next!=null && priority>=curr.next.priority)
        {
            curr=curr.next;
        }
        Node<E> prev = new Node<>(item, priority);
        if(curr.next!=null)
        {
            prev.next=curr.next;
        }
        curr.next=prev;
        size++;
        return true;
    }

    public boolean addRear(E item)
    {
        if(item==null)
        {
            throw new NullPointerException("The intended item is null");
        }
        Node<E> curr= front;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        Node<E> prev = new Node<>(item, curr.priority);
        curr.next=prev;
        size++;
        return true;
    }

    public E poll()
    {
        if(front==null)
        {
            throw new NullPointerException("The intended item is null");
        }

        E x = peek();
        front=front.next;
        size--;
        return x;
    }

    public boolean remove(Node<E> toBeRemoved)
    {
        if(front==null)
        {
            return false;
        }

        if(front.data.equals(toBeRemoved.data))
        {
            poll();
            size--;
            return true;
        }
        Node<E> curr= front;
        while(curr.next!=null && curr.next.data.equals(toBeRemoved.data))
        {
            curr=curr.next;
        }
        curr.next=curr.next.next;
        size--;
        return true;
    }

    public Iterator<E> iterator()
    {
        Iter it=new Iter();
        return it;
    }

}

