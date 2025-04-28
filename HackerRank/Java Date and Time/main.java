import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  
   public static String findDay(int month, int day, int year) {

        int QuantidadeDeDias = 0, resultado = 0;
        int[] DiasMes1 = {31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30 , 31};
        int[] DiasMes2 = {31, 29, 31, 30, 31,30, 31, 31, 30, 31, 30 , 31};
        
        if(VerificadorBissexto(year) == true){
            for(int i = 0; i < (month - 1); i++){
                QuantidadeDeDias = DiasMes2[i] + QuantidadeDeDias; 
            }
        }
        else{
            for(int i = 0; i < (month - 1); i++){
            QuantidadeDeDias = DiasMes1[i] + QuantidadeDeDias;  
            }
        }
        month = QuantidadeDeDias;
        
        QuantidadeDeDias = 0;
        
        for(int i = 0; i < year-2000; i++){
            if(VerificadorBissexto(2000 + i) == true){
                QuantidadeDeDias += 366; 
                
            }
            else{
                QuantidadeDeDias += 365;
                
            }
        }
        year = QuantidadeDeDias;
        QuantidadeDeDias = 0;
        
        int QuantidadeDeDiasTotal = day + month + year ; 
        
        
        for ( int i = 0; i< QuantidadeDeDiasTotal; i++){
            if((QuantidadeDeDiasTotal - i ) % 7 == 0){
                resultado  = i;
                
                break;
            }
        }
        
        switch(resultado){
            case 0:
                return "FRIDAY";
            case 1:
                return "SATURDAY";
            case 2:
                return "SUNDAY";
            case 3:
                return "MONDAY";
            case 4:
                return "TUESDAY";
            case 5:
                return "WEDNESDAY";
            case 6:
                return "THURSDAY";
    }
    return null;

        
    }
    public static Boolean VerificadorBissexto(int n){
        if(((n % 4 == 0) && (n %  100 != 0)) || (n % 400 == 0)){
            return true;
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
