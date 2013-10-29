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
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/data.csv"))) {
            for(int i=0;i<dataamount;i++){
                for(int j=0;j<attributeamount;j++){
                    out.write(data[i][j]+",");
                }
                out.newLine();
            }
        }
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
}
