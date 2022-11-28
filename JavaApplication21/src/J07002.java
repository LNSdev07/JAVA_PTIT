
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class J07002 {
    public static boolean checkSo(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
        
    public static int solve(String s){
        s = s.trim();
        String[] arr = s.split("\\s+");
        int sum =0;
        for(int i=0; i<arr.length; i++){
            if(!arr[i].equals("")){
                if(checkSo(arr[i])) sum+= Integer.parseInt(arr[i]);
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        String url ="DATA.in";
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fis = new FileInputStream(url);
            
            reader = new InputStreamReader(fis);
            
            bufferedReader = new BufferedReader(reader);
            String line = null;
            String s ="";
            while((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()) continue;
                s+=line +" ";
            }
             System.out.println(solve(s));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(J07002.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(J07002.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07002.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07002.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(J07002.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
