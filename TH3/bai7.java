import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
class WordSet
{
    private TreeSet<String> set = new TreeSet<String>();

    public WordSet(String S) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(S)); 
        while(sc.hasNextLine())
        {
            String s = sc.nextLine(),
                   arr[] = s.split("\\s+");
            for(String i: arr)
            {
                i = i.toLowerCase();
                set.add(i);
            }
        }
    }

    @Override
    public String toString()
    {
        String temp = "";
        for(String i : set)
        {
            temp += i + "\n";
        }
        return temp;
    }
}

public class bai7
{
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
    public static void main7622929(String[] args) throws IOException 
	{
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
