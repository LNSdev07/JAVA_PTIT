import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String[] words = sc.nextLine().trim().toLowerCase().split("\\s+");
            int len = words.length;
            if(!isEndWord(words[len-1])) words[len-1] += ".";
            String line = "";
            for(int i = 0; i < len; i++)
            {
                String temp = words[i];
                if(!isEndWord(temp)) line += temp + " ";
                else
                {
                    line = Character.toUpperCase(line.charAt(0)) + line.substring(1, line.length()-1);
                    if(temp.length() > 1) line += " " + temp;
                    else line += temp;
                    lines.add(line);
                    line = "";
                }
            }
        }

        for(String line : lines) System.out.println(line);
    }

    private static boolean isEndWord(String line) 
    {
        if(line.endsWith(".") || line.endsWith("!") || line.endsWith("?")) return true;
        return false;
    }
}