
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J07007 {
    public static void sovle(String s){
        s = s.trim();
        String[] arr = s.split("\\s+");
        Set<String> set = new TreeSet<>();
        for(int i=0; i<arr.length; i++){
            if(!arr[i].equals("")){
                set.add(arr[i].toLowerCase());
            }
        }
        for(String x : set){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        String url ="VANBAN.in";
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fis = new FileInputStream(url);
            
            reader = new  InputStreamReader(fis);
            
            bufferedReader = new BufferedReader(reader);
            
            String line = null;
            String res ="";
            while((line = bufferedReader.readLine()) != null){
                if( line.isEmpty()){
                    continue;
                }
                res+=line+" ";
            }
            sovle(res);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
