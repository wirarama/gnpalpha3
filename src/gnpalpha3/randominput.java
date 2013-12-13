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
    public static int[][] randomdb(
            int attributeamount,
            int dataamount,
            int datavariation,
            String testdate,
            int rangeamount,
            int crossoverrate,
            int mutationrate
    ) throws IOException{
        int datavariation1 = (int)((dataamount*datavariation)/100);
        int[][] data = new int[dataamount][attributeamount];
        int[][] pattern = new int[datavariation1][attributeamount];
        int[][] range = attrrange(attributeamount,rangeamount);
        for(int i=0;i<datavariation1;i++){
            pattern[i] = randomrow(attributeamount,range,pattern,crossoverrate,mutationrate,(i-1));
        }
        for(int i=0;i<dataamount;i++){
            data[i] = pattern[randomrange(0,(datavariation1-1))];
        }
        int[] patternresult = patternseeker(pattern,data,pattern[0].length);
        filelog.arraycsv(range,"0.1.range.csv",testdate);
        filelog.arraycsv(pattern,"0.2.pattern.csv",testdate);
        filelog.arraycsv(data,"0.3.data.csv",testdate);
        filelog.patternlog(patternresult,"0.4.patternresult.log",testdate,"pattern");
        return data;
    }
    public static int[] randomrow(
            int attributeamount,
            int[][] range, 
            int[][] pattern,
            int crossoverrate,
            int mutationrate,
            int currentrow
    ){
        int[] data = new int[attributeamount];
        for(int i=0;i<attributeamount;i++){
            data[i] = randomrange(range[i][0],range[i][1]);
        }
        
        //mutation
        int rand = randomrange(0,mutationrate);
        if(rand==0) data = patternmutation(data);
        //crossover
        rand = randomrange(0,crossoverrate);
        if(rand==0) data = patterncrossover(data,pattern[randomrange(0,currentrow)]);
        
        return data;
    }
    public static int[][] attrrange(int attributeamount,int rangeamount){
        int[][] range = new int[attributeamount][2];
        for(int i=0;i<attributeamount;i++){
            range[i][0] = randomrange(1,1000);
            range[i][1] = range[i][0]+randomrange(1,rangeamount);
        }
        return range;
    }
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static int[] patterncrossover(int[] pattern1,int[] pattern2){
        int[] crosspattern = new int[pattern1.length];
        int rand = randomrange(0,pattern1.length);
        for(int i=0;i<pattern1.length;i++){
            if(i<rand){
                crosspattern[i] = pattern1[i];
            }else{
                crosspattern[i] = pattern2[i];
            }
        }
        return crosspattern;
    }
    public static int[] patternmutation(int[] pattern){
        int[] mutationpattern = new int[pattern.length];
        for(int i=0;i<pattern.length;i++){
                int rand = randomrange(0,8);
                if(rand!=0){
                    mutationpattern[i] = pattern[i];
                }else{
                    mutationpattern[i] = randomrange((pattern[i]-100),(pattern[i]+100));
                }
        }
        return mutationpattern;
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