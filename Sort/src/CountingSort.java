import java.util.Arrays;
//Michael Buzzetta
//I pledge my honor that I have abided by the Stevens honor system

//Recieved assistance from tutors
class CountingSort
{
    public static int[] countSort(int array[], int size)
    {
        int[] output = new int[size + 1];
        // Find the largest element of the array
        int maxValue = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > maxValue)
                maxValue = array[i];
        }
        int[] track = new int[maxValue + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < maxValue; ++i)
        {
            track[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            track[array[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= maxValue; i++) {
            track[i] += track[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--)
        {
            output[track[array[i]] - 1] = array[i];
            track[array[i]]--;
        }
        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {

            array[i] = output[i];
        }
        return array;
    }

    public static void main(String args[])
    {
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        int size = data.length;
        CountingSort cs = new CountingSort();
        cs.countSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}