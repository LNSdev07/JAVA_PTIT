package bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while( t-- >0){
            String s = sc.nextLine();
            String[] arr = s.split("");
            String[] arr2 = s.split("\\s+");

            if(arr.length >=100){
                String tmp ="";

                for(int i = 99 ;i>=0 ;i++){
                    if(!arr[i].equals(" ")){
                        tmp+=arr[i];
                    }
                    else{
                        break;
                    }
                }

                System.out.println(tmp);

                StringBuilder stringBuilder = new StringBuilder(tmp);
                stringBuilder.reverse();
                String v = stringBuilder.toString();


                boolean check = true;
                for(String x : arr2){
                    if(x.equals(v)){
                        check = false;
                    }
                }

                if(check){
                    for(int i=0 ;i<= 99 - v.length(); i++){
                        System.out.print(arr[i]);
                    }
                }
                else{
                    for(int i=0 ;i<= 99; i++){
                        System.out.print(arr[i]);
                    }
                }


            }
            else{
                for(String x : arr){
                    System.out.print(x);
                }
            }
        }
    }
}
