import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Junit
{

    public void main(String[] args)
    {
        Treap<Integer> testTree= new Treap<>();
        System.out.println(testTree);
    }
    @Test
    void test_add()
    {
        Treap<Integer> testTree=new Treap<>();
        testTree.add (4 ,19);
        testTree.add (2 ,31);
        testTree.add (6 ,70);
        testTree.add (1 ,84);
        testTree.add (3 ,12);
        testTree.add (5 ,83);
        testTree.add (7 ,26);
        assertEquals(testTree.find(2),true);
        assertEquals(testTree.find(1),true);
        assertEquals(testTree.find(4),true);
        System.out.println(testTree);
    }

    @Test
    void test_find()
    {
        Treap<Integer> testTree=new Treap<>();
        testTree.find(4);
        testTree.find (2);
        testTree.find (6);
        testTree.find (1);
        testTree.find (3);
        testTree.find (5);
        testTree.find (7);
    }

    @Test
    void test_delete()
    {
        Treap<Integer> testTree=new Treap<>();
        testTree.delete (4);
        testTree.delete (2);
        testTree.delete (6);
        testTree.delete (1);
        testTree.delete (3);
        testTree.delete (5);
        testTree.delete (7);
    }


}
