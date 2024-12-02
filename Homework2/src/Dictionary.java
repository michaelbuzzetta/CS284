import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary
{

    private ArrayList<String> wordList;
    private ArrayList<DictionaryItem> dictArrayList;

    public Dictionary()
    {
        wordList = new ArrayList<>(1300);
        dictArrayList = new ArrayList<>(1300);
        readFile("ionDictionary.txt");
    }

    public Dictionary(String filename)
    {
        wordList = new ArrayList<>(1300);
        dictArrayList = new ArrayList<>(1300);
        readFile(filename);
    }

    public void printMenu()
    {
        Scanner scan = new Scanner(System.in);
        int menuItem = 0;

        while (menuItem != 3)
        {
            System.out.println("\n1: Print the word list from the dictionary.");
            System.out.println("2: Search a word in the dictionary and display its count.");
            System.out.println("3: Quit the program.");
            System.out.print("Enter your choice (1-3): ");
            menuItem = scan.nextInt();

            if (menuItem < 1 || menuItem > 3) {
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            } else {
                processMenuItem(menuItem, scan);
            }
        } 
        

        scan.close();
    }

    private boolean processMenuItem(int menuItem, Scanner scan)
    {
        if (menuItem == 1) {
            printDictionary();
        }
        else
        {
            if (menuItem == 2)
            {
                System.out.print("Enter a word to search: ");
                String searchWord = scan.next();
                int count = searchDictionary(searchWord);
                System.out.println("The word \"" + searchWord + "\" appears " + count + " times in the book.");
            }
            else
            {
                if (menuItem == 3)
                {
                    System.out.println("Exiting the program...");
                    return false;
                }
            }
        }
        return true;
    }

    public void readFile(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                splitStoreLine(scanner);
            }

            scanner.close();

        }
        catch (FileNotFoundException e)
        {

            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    private void splitStoreLine(Scanner scan)
    {
        try {

            for (int i = 0; i<=4; i++)
            {
                scan.nextLine();
            }
            while (scan.hasNext())
            {
                String line = scan.nextLine();
                String[] wordCount = line.split("\\|");
                String word = wordCount[0].strip();
                int count = Integer.parseInt(wordCount[1].strip());

                DictionaryItem item = new DictionaryItem(word, count);
                dictArrayList.add(item);
                wordList.add(word);
            }
        }
        catch(NumberFormatException n)
        {
            System.out.println("You done goofed!");
            n.printStackTrace();
        }
    }

    public void printDictionary()
    {
        for (String word : wordList)
        {
            System.out.println("The word " + word + " exists in the Ion dictionary");
        }

    }

    public int searchDictionary(String word)
    {
        int index = binarySearch(word, 0, wordList.size() - 1);

        if (index == -1)
        {
            return 0;
        }
        else
        {
            return dictArrayList.get(index).getCount();
        }
    }

    private int binarySearch(String word, int low, int high)
    {
        if (high < low)
        {
            return -1;
        }
        else
        {
            int mid = (low + high) / 2;
            String midWord = wordList.get(mid);

            if (midWord.compareTo(word) == 0)
            {
                return mid;
            }
            else
            {
                if (midWord.compareTo(word) > 0)
                {
                    return binarySearch(word, low, mid - 1);
                }
                else
                {
                    return binarySearch(word, mid + 1, high);
                }
            }
        }
    }
}


