public class Person
{
    private String givenName;
    private String familyName;
    private String IDNumber;
    private int birthYear = 1900;
    public static final int voteAge=18;
    public static final int seniorAge=65;

    public String getGivenName()
    {
        return givenName;
    }

    public void setGivenName()
    {
        this.givenName=givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public Person(String givenName, String familyName)
    {
        this.givenName=givenName;
        this.familyName=familyName;
    }
    public Person()
    {
        this.givenName="";
        this.familyName="";
    }
    public boolean canVote(int year)
    {
        return (year-birthYear)>=voteAge;
    }
    public boolean isSenior(int year)
    {
        return (year-birthYear)>=seniorAge;
    }

    public String toString()
    {
        return "Given name: "+givenName+"\n"+"Family Name: "+familyName;
    }

    public boolean equals(Person p)
    {
        if (p==null)
            return false;
        else
            return this.familyName.equals(p.getFamilyName());
    }
}


