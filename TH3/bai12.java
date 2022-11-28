import java.util.*;
import java.io.*;

public class bai12 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc;
        HashMap<String, String> mapSubject = new HashMap<>(), mapTeacher = new HashMap<>();
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        
        
        sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] arr = sc.nextLine().split(" ", 2);
            mapSubject.put(arr[0], arr[1]);
        }


        sc = new Scanner(new File("GIANGVIEN.in"));
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++)
        {
            String[] arr = sc.nextLine().split(" ", 2);
            mapTeacher.put(arr[0], arr[1]);
        }


        sc = new Scanner(new File("GIOCHUAN.in"));
        int k = sc.nextInt();
        for(int i = 0; i < k; i++)
        {
            String teacherId = sc.next(), subjectId = sc.next();
            double time = sc.nextDouble();
            if(map.containsKey(teacherId)) map.put(teacherId, time+map.get(teacherId));
            else map.put(teacherId, time);
        }

        for(Map.Entry<String, Double> entry : map.entrySet())
        {
            System.out.println(mapTeacher.get(entry.getKey()) + " " + String.format("%.2f", entry.getValue()));
        }
    }
}