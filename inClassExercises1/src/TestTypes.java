public class TestTypes
{
    public static void main(String[] args)
    {
        int item = 42;
        double realItem = item;

        double y=3.14;
        int x=(int) y;

        String number = "23";
        int re = Integer.parseInt(number);

        String greeting = "Welcome";
        String welcome = greeting;
        System.out.println(welcome);
        greeting = "hello";
        System.out.println(welcome);

        int[] data1 = {1,2,3,4,5};
        int[] data2=data1;
        System.out.println(data1[0]);
        data2[0]=8;
        System.out.println(data1[0]);

        int[] data3 = {5,6,7,8,9};
        int data4[]=data3.clone();
        System.out.println(data3[0]);
        data4[0]=4;
        System.out.println(data3[0]);
        int percentage=5;
        double income = 100.0;
        TestTypes tt= new TestTypes();
        System.out.println("Prior to raise:" +income);
        tt.incomeRaise(percentage, income);
        System.out.println("After Raise: "+income);
        tt.stringExercise();


    }

    public double incomeRaise(int percentage, double income)
    {

        income+=income*(percentage/100.0);
        return income;
    }

    public void stringExercise()
    {
        System.out.println();
        String test="Palindrome reader";
        System.out.println("charAt(0): "+test.charAt(0));
        System.out.println("length:"+test.length());
        System.out.println("Index of ('r'): "+test.indexOf('r'));
        int index=test.indexOf('r')+(test.substring(test.indexOf('r')+1)).indexOf('r')+1;
        System.out.println("Second index of ('r'): "+index);
        System.out.println("toUpperCase: "+test.toUpperCase());
    }
}
