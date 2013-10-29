/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpalpha3;

import static gnpalpha3.Gnpalpha3.testdate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author test
 */
public class randominput {
    public static int[][] randomdb(int attributeamount,int dataamount,int datavariation) throws IOException{
        int[][] data = new int[dataamount][attributeamount];
        int[][] pattern = new int[datavariation][attributeamount];
        for(int i=0;i<datavariation;i++){
            pattern[i] = randomrow(attributeamount);
        }
        for(int i=0;i<dataamount;i++){
            data[i] = pattern[randomrange(0,(datavariation-1))];
        }
        arraycsv(pattern,"pattern.csv");
        arraycsv(data,"data.csv");
        return data;
    }
    public static int[] randomrow(int attributeamount){
        int[] data = new int[attributeamount];
        for(int i=0;i<attributeamount;i++){
            data[i] = randomrange(1,10);
        }
        return data;
    }
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static void arraycsv(int[][] data,String filename) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[0].length;j++){
                    out.write(data[i][j]+",");
                }
                out.newLine();
            }
        }
    }
}
