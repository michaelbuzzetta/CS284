
public class BinaryNumber
{
    private int[] binary;
    private int length;

    public BinaryNumber(int length)
    {
        if(length<=0)
        {
            throw new IllegalArgumentException("Length cant be less than 1");
        }

        this.length = length;
        binary = new int[length];
        for(int i=0; i<length; i++)
        {
            binary[i]=0;
        }


    }

    public BinaryNumber(String str)
    {


        binary = new int[str.length()];

        for (int x = 0; x< str.length(); x++)
        {
            int a = Integer.parseInt(Character.toString(str.charAt(x)));
            if (a==0 || a==1)
            {
                binary[x]=a;
            }
            else
            {
                throw new IllegalArgumentException("Please only enter 0 or 1");
            }
        }
        length=str.length();
    }

    public int getLength()
    {
        return binary.length;
    }

    public int[] getInnerArray()
    {
        return binary;
    }

    public int getDigit(int index)
    {
       return binary[index];
    }

    public int toDecimal()
    {
        int d = 0;
        int index = 0;
        for(int x = length-1; x >= 0; x--)
        {
            d += (binary[index] * Math.pow(2, x));
            index++;
        }
        return d;
    }

    public void bitShift(int direction, int amount)
    {
        if(direction==1)
        {
            int newLength=binary.length-amount;
            int[] array = new int[newLength];
            for (int x = 0; x<newLength; x++)
            {
                array[x]=binary[x];
            }

            binary=array;
        }
        else if (direction == -1)
        {
            int NewLength = binary.length + amount;
            int[] array = new int [NewLength];
            for(int x = 0; x < binary.length; x++) {
                array[x] = binary[x];
            }
            binary = array;
        }
    }

    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2)
    {
        int[] array = new int[bn1.getLength()];

        for (int i = 0; i < bn1.getLength(); i++) {
            if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1) {
                array[i] = 1;
            }
        }
        return array;
    }

    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2)
    {
        int[] array = new int[bn1.getLength()];

        for (int x = 0; x < bn1.getLength(); x++) {
            if (bn1.getDigit(x) == 1 && bn2.getDigit(x) == 1) {
                array[x] = 1;
            }
        }
        return array;
    }

    public static int[] prepend(int[] array, int amount) {
        int[] arr = new int[array.length + amount];
        int j = 0;
        for (int i = amount; i < array.length+amount; i++) {
            arr[i] = array[j];
            j++;
        }
        return arr;
    }
    public void add(BinaryNumber aBinaryNumber) {
        int[] num1 = this.getInnerArray();
        int[] num2 = aBinaryNumber.getInnerArray();
        int length = Math.max(num1.length, num2.length);
        int[] result = new int[length + 1];

        int carry = 0;
        int i;

        // padding shorter array with zeros
        if (num1.length != length) {
            int[] paddedFirst = new int[length];
            for (i = 0; i < num1.length; i++) {
                paddedFirst[i + length - num1.length] = num1[i];
            }
            num1 = paddedFirst;
        }
        if (num2.length != length) {
            int[] paddedSecond = new int[length];
            for (i = 0; i < num2.length; i++) {
                paddedSecond[i + length - num2.length] = num2[i];
            }
            num2 = paddedSecond;
        }

        // addition
        for (i = length - 1; i >= 0; i--) {
            result[i + 1] = (num1[i] + num2[i] + carry) % 2;
            carry = (num1[i] + num2[i] + carry) / 2;
        }
        result[0] = carry;

        binary = result;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            sb.append(binary[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        BinaryNumber a = new BinaryNumber(7);
        BinaryNumber b = new BinaryNumber(10);
        BinaryNumber c = new BinaryNumber("1001");
        BinaryNumber d = new BinaryNumber("11001");

        int a1 = a.getDigit(2);
        int b1 = b.getDigit(2);
        int b2 = c.getDigit(0);
        int c1 = c.toDecimal();
        int d1 = d.toDecimal();


        System.out.println(a);
        System.out.println(b);
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(c1);
        System.out.println(d1);
        System.out.println(d+"0");
        d.add(c);
        System.out.println(d+"0");





    }
}