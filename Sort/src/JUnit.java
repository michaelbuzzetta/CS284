import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
public class JUnit
{
    CountingSort c = new CountingSort();
    @Test
    void testSort()
    {
        int[] intArray={1,2,3,3,7,2};
        int[] sorted=CountingSort.countSort(intArray,intArray.length);
        int[] correct={1,2,2,3,3,7};
        for (int i=0; i<intArray.length; i++)
        {
            Assert.assertEquals(correct[i], sorted[i]);
        }
    }

    void testSort2()
    {
        int[] intArray={1,2,3,3,7,2,4,10,100,0};
        int[] sorted=CountingSort.countSort(intArray,intArray.length);
        int[] correct={0,1,2,2,3,3,4,710,100};
        for (int i=0; i<intArray.length; i++)
        {
            Assert.assertEquals(correct[i], sorted[i]);
        }

    }
    public static void main(String[] args)
    {

    }
}