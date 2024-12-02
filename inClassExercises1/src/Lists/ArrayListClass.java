package Lists;
import java.util.ArrayList;
import java.util.List;
public class ArrayListClass
{
    public static void main(String args[])
    {
        List<String> myList = new ArrayList<String>();
        myList.add("Bashful");
        myList.add("Awful");
        myList.add("Jumpy");
        myList.add("Happy");
        System.out.println(myList);

        for(String element:myList)
        {
            System.out.println(element);
        }
    }
}
