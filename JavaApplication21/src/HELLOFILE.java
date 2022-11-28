
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
public class HELLOFILE {
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
            while((line = bufferedReader.readLine()) != null){
//                if( line.isEmpty()){
//                    continue;
//                }
                System.out.println(line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HELLOFILE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HELLOFILE.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(HELLOFILE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(HELLOFILE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(HELLOFILE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
