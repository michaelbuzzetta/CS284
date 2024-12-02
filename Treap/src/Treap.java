import java.util.Random;
import java.util.Stack;

//Received help from tutor

/*
This treap code is used to build, and traverse a binary tree and heap hybrid.
It utilizes Nodes and Stacks to store the treap
 */
public class Treap<E extends Comparable <E>>
{
    //These variables are used throughout the code
    private Random priorityGenerator;
    private Node <E> root;

    //This node class is the backbone and the basis upon which the rest of my code was built
    private static class Node<E extends Comparable <E>>
    {
        public E data;
        public int priority;
        public Node<E> left;
        public Node<E> right;

        public Node(E data, int priority) {
            if (data == null) {
                throw new NullPointerException("Sorry");
            } else {
                this.data = data;
                this.priority = priority;
                left = null;
                right = null;
            }

        }

        public Node<E> rotateRight() {
            Node<E> pivot = left;
            left = pivot.right;
            pivot.right = this;
            return pivot;
        }

        public Node<E> rotateLeft() {
            Node<E> pivot2 = right;
            right = pivot2.left;
            pivot2.left = this;
            return pivot2;
        }

        @Override
        public String toString()
        {
            return "(key="+data.toString()+", priority="+priority+")";
        }

    }
    //This function, as well as all other toString functions are from professor Akcam's slides
    public String toString(Node<E> current, int level)
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < level; i++)
        {
            s.append(" ");
        }
        if (current == null)
            s.append("null\n");
        else
        {
            s.append(current.data.toString()).append("\n");
            s.append(toString(current.left, level + 1));
            s.append(toString(current.right, level + 1));
        }
        return s.toString();
    }
    public Treap()
    {
        priorityGenerator=new Random();
        root=null;
    }

    //These two treap methods creates the treaps that the rest of the code edits
    public Treap(long seed)
    {
        priorityGenerator=new Random(seed);
        root=null;
    }

    boolean add(E key)
    {
        return add(key, priorityGenerator.nextInt());
    }

    boolean add(E key, int priority)
    {
        if (root==null)
        {
            root=new Node<>(key, priority);
            return true;
        }
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current=root;
        while(current!=null)
        {
            stack.push(current);
            if(current.data.compareTo(key)<0)
            {
                current=current.right;
            }
            else if(current.data.compareTo(key)>0)
            {
                current=current.right;
            }
            else
            {
                return false;
            }
        }
        Node<E> newNode=new Node<>(key, priority);
        if(stack.peek().data.compareTo(key)>0)
        {
            stack.peek().left=newNode;

        }
        else
        {
            stack.peek().right=newNode;
        }
        reheap(stack, newNode);
        return true;
    }

    //reheap is a helper function for add, add is a method that adds elements to the treap, hence the name
    private void reheap(Stack<Node<E>> stack, Node<E> newNode2)
    {
        while(!stack.isEmpty())
        {
            Node<E> parent=stack.pop();
            if(parent.priority> newNode2.priority)
            {
                return;
            }
            if(stack.isEmpty())
            {
              if(parent.right==newNode2)
              {
                  this.root=parent.rotateLeft();
              }
              else
              {
                  this.root=parent.rotateRight();
              }
            }
            else
            {
                Node<E> grandParent=stack.peek();
                if(grandParent.left==parent)
                {
                    if(parent.left==newNode2)
                    {
                        grandParent.left=parent.rotateRight();
                    }
                    else
                    {
                        grandParent.left=parent.rotateLeft();
                    }
                }
                else
                {
                    if(parent.right==newNode2)
                    {
                        grandParent.right=parent.rotateLeft();
                    }
                    else
                    {
                        grandParent.right=parent.rotateRight();
                    }
                }
            }
        }

    }

    boolean delete(E key)
    {
        if(!find(key))
        {
            return false;
        }
        else
        {
            this.root = delete_assist(key, root);
            return true;
        }
    }

    //delete assist is a helper function for delete. Delete is a method that removes a specific element from the treap
    private Node<E> delete_assist(E key, Node<E> curr)
    {
        if(!(curr!=null))
        {
            return null;
        }
        else
        {
            if(curr.data.compareTo(key)>0)
            {
                curr.left=delete_assist(key, curr.left);
            }
            else if(curr.data.compareTo(key)<0)
            {
                curr.right=delete_assist(key, curr.right);
            }
            else
            {
                if(curr.right==null||curr.right.priority<curr.left.priority)
                {
                    curr=curr.rotateRight();
                    if(curr!=null)
                    {
                        curr.right = delete_assist(key, curr.right);
                    }
                }
                else if(curr.left==null||curr.left.priority<curr.right.priority)
                {
                    curr=curr.rotateLeft();
                    if(curr!=null)
                    {
                        curr.left = delete_assist(key, curr.left);
                    }                }
            }
        }
        return curr;
    }

    private boolean find(Node<E> root, E key)
    {
        if (key == null)
            throw new IllegalArgumentException("Searched item is null!");
        Node<E>current=root;
        while (current!=null) {
            if (key.compareTo(current.data) == 0) {
                return true;
            } else if (key.compareTo(current.data) < 0)
            {
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }

        return false;
    }

    //Find is a method that is used to locate, look at, but not remove, a specific element in the treap
    public boolean find(E key)
    {
        find(root, key);
        return true;
    }

    //toString returns the treap in string format
    @Override
    public String toString()
    {
        return toString(root,0);
    }


}
