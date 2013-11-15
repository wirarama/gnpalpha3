/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpalpha3;

import java.io.IOException;

/**
 *
 * @author test
 */
public class randominput {
    public static int[][] randomdb(int attributeamount,int dataamount,int datavariation,String testdate) throws IOException{
        int[][] data = new int[dataamount][attributeamount];
        int[][] pattern = new int[datavariation][attributeamount];
        int[][] range = attrrange(attributeamount);
        for(int i=0;i<datavariation;i++){
            pattern[i] = randomrow(attributeamount,range);
        }
        for(int i=0;i<dataamount;i++){
            data[i] = pattern[randomrange(0,(datavariation-1))];
        }
        int[] patternresult = patternseeker(pattern,data,pattern[0].length);
        filelog.arraycsv(range,"range.csv",testdate);
        filelog.arraycsv(pattern,"pattern.csv",testdate);
        filelog.arraycsv(data,"data.csv",testdate);
        filelog.patternlog(patternresult,"patternresult.log",testdate);
        return data;
    }
    public static int[] randomrow(int attributeamount,int[][] range){
        int[] data = new int[attributeamount];
        for(int i=0;i<attributeamount;i++){
            data[i] = randomrange(range[i][0],range[i][1]);
        }
        return data;
    }
    public static int[][] attrrange(int attributeamount){
        int[][] range = new int[attributeamount][2];
        for(int i=0;i<attributeamount;i++){
            range[i][0] = randomrange(1,1000);
            range[i][1] = range[i][0]+randomrange(1,50);
        }
        return range;
    }
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    
    public static int[] patternseeker(int[][] pattern,int[][] data,int limit){
        int[] out = new int[pattern.length];
        int[][] check = new int[pattern.length][data.length];
        for(int i = 0;i<pattern.length;i++){
            out[i] = 0;
            for(int j=0;j<data.length;j++){
                check[i][j] = 0;
                for(int k=0;k<pattern[0].length;k++){
                    if(pattern[i][k]==data[j][k]){
                        check[i][j] += 1;
                    }
                }
                if(check[i][j]==pattern[0].length){
                    out[i] += 1;
                }
            }
        }
        return out;
    }
}