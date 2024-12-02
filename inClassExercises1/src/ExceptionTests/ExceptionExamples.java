package ExceptionTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExamples
{
    public void readFile(String filename)
    {
        File f = new File(filename);
        Scanner c;
        try
        {
            c = new Scanner(f);
            while(c.hasNextLine())
            {
                System.out.println(c.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error! File not found!!!");
            //e.printStackTrace();
        }


    }

    public int get(int a[], int index)
    {
        if (index<0)
        {
            throw new ArrayIndexOutOfBoundsException("Array index out of range");
        }
        return a[index];
    }

    public static void main(String[] args)
    {
        ExceptionExamples ee = new ExceptionExamples();
        ee.readFile("myFile.txt");
        int[] a = new int[3];
        /*try
        {

        }
         */
    }
}
