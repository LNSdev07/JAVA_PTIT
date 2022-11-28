
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;
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
public class J07004 {
    public static void sovle(String s){
        String[] arr = s.split("\\s+");
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<arr.length; i++){
            if(!arr[i].equals("")){
                int tmp = Integer.parseInt(arr[i]);
                if( map.containsKey(tmp)){
                    int tanSuat = map.get(tmp);
                    ++tanSuat;
                    map.put(tmp, tanSuat);
                }
                else{
                    int tanSuat = 1;
                    map.put(tmp, tanSuat);
                }
            }
        }
        Set<Integer> set = map.keySet();
        for(Integer key : set){
            System.out.println(key+" "+ map.get(key));
        }
    }
    public static void main(String[] args) {
        String url ="DATA.in";
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
            Logger.getLogger(J07004.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(J07004.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07004.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07004.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07004.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
