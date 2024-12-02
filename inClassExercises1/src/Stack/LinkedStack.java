package Stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> impliments StackInt<E>
{
    public static class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node(E dataItem)
        {
            data=dataItem;
            next=null;
        }

        private Node(E dataItem, Node<E> nodeRef)
        {
            data=dataItem;
            next=nodeRef;
        }
    }

    private Node<E> topofStackRef;

    public LinkedStack()
    {
        topofStackRef=null;
    }

    public LinkedStack(E[] data)
    {
        topofStackRef=null;
        for(E item:data)
        {
            push(item);
        }
    }

    @Override
    public E push(E obj)
    {
        topofStackRef=new Node<E>(obj, topofStackRef);
    }

    @Override
    public E peek()
    {
        if(isEmpty())
            throw new NoSuchElementException();
        return topofStackRef.data;
    }

    @Override
    public boolean isEmpty()
    {
        return topofStackRef==null;
    }

    @Override
    public E pop()
    {
        if(isEmpty())
            throw new NoSuchElementException();
        E oldData=topofStackRef.data;
        topofStackRef=topofStackRef.next();
        return oldData;
    }

    public String toString()
    {
        StringBuilder r = new StringBuilder();
        Node<E> current = topofStackRef;
        r.append("[top] <- ");
        while (current != null)
        {
            r.append(current.data.toString()+"<-");
            current=current.next;
        }
        r.append("[bottom]");
        return r.toString();
    }
}
