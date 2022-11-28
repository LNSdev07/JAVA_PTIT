import java.util.Scanner;

public class bai1 
{  
    public static void main(String args[])    
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) 
        {
            String s = input.next();
            int n = s.length();
            String s1 = s.substring(0, n/2), s2 = s.substring(n/2);  // Divide
            int sum1 = 0, sum2 = 0;                              
            String r1 = "", r2 = "";
            for(int i = 0; i < n/2; i++)    // Rotate                                        
            {
                sum1 += s1.charAt(i);
                sum2 += s2.charAt(i);                                          
            }

            for(int i = 0; i < n/2; i++)                                         
            {
                r1 += (char)((s1.charAt(i)-65+sum1)%26+65);
                r2 += (char)((s2.charAt(i)-65+sum2)%26+65);
            }

            String res = "";
            for(int i = 0; i < n/2; i++)
            {
                res += (char)((r1.charAt(i)-65+r2.charAt(i)-65)%26+65);
            }
            System.out.println(res);
        }
    }
}