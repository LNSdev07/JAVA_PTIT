
import java.util.Scanner;

public class bai3 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().toLowerCase().trim();
            if (line.isEmpty()) {
                break;
            }                  

            line = Character.toUpperCase(line.charAt(0)) + line.substring(1, line.length()); 
            line = line.replaceAll("\\s+", " ");
            char last = line.charAt(line.length() - 1);
            if (last != '!' && last != '?' && last != '.') {
                line += ".";
            }
            line = line.replaceAll("\\s*\\.\\s*", "\\. ");
            line = line.replaceAll("\\s*\\!\\s*", "\\! ");
            line = line.replaceAll("\\s*\\?\\s*", "\\? ");    
            for (int i = 0; i < line.length() - 2; i++) {
                if (line.charAt(i) == '.' || line.charAt(i) == '!' || line.charAt(i) == '?') {
                    line = line.substring(0, i + 2) + Character.toUpperCase(line.charAt(i + 2)) + line.substring(i + 3, line.length());
                }
            }            
            System.out.println(line);
        }

    }
}