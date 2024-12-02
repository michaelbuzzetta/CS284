public class DictionaryItem
{
    private String word;
    private int count;

    public DictionaryItem(String word, int count)
    {
        if (count<0)
        {
            throw new IllegalArgumentException("The value should be a non-negative integer");
        }
        this.word=word;
        this.count=count;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        if (count<0)
        {
            throw new IllegalArgumentException("The value should be a non-negative integer");
        }
        this.count = count;
    }



}
