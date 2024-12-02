package Lists;

public class SLL<E>
{
    private Node<E> head;
    private int size;
    public static class Node<E>
    {
        private E data;
        private Node<E> next;

        public Node(E dataItem)
        {
            data=dataItem;
            next=null;
        }

        public Node(E dataItem, Node<E> next)
        {
            data=dataItem;
            this.next=next;
        }

        public SLL()
        {
            head = null;
            size=0;
        }

        public void addFirst(E item)
        {
            head = new Node<E>(item, head);
            size++;
        }

        public void add(E item, int index)
        {
            if(index <0|| index> size)
            {
                
            }
        }

    }
}
