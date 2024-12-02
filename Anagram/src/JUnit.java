import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//Michael Buzzetta
//I pledge my honor that I have abided by the stevens honor system

//Recieved help from tutor
public class JUnit {
    public void test1() {
        Anagrams a = new Anagrams();
        a.addWord("fat");
        a.addWord("taf");
        a.addWord("aft");
        a.addWord("hi");
        a.addWord("ih");
        Long x = (long) 1846;
        Long y = (long) 437;
        Assert.assertEquals("Test 1", a.myHashCode("fat"), x);
        Assert.assertEquals("Test 2", a.myHashCode("hi"), y);
    }
    @Test
    public void test2() {
        Anagrams b = new Anagrams();
        try {
            b.processFile("words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long,ArrayList<String>>> maxE = b.getMaxEntries();
        ArrayList<String> list = new ArrayList<String>();
        list.add("alerts");
        list.add("alters");
        list.add("artels");
        list.add("estral");
        list.add("laster");
        list.add("lastre");
        list.add("rastle");
        list.add("ratels");
        list.add("relast");
        list.add("resalt");
        list.add("salter");
        list.add("slater");
        list.add("staler");
        list.add("stelar");
        list.add("talers");
        Long x = (long) 236204078;
        Assert.assertEquals(maxE.get(0).getKey(), x);
        Assert.assertEquals(maxE.get(0).getValue(), list);
    }



}