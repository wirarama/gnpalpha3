/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpalpha3;

import java.io.IOException;

/**
 *
 * @author test
 */
public class rule {
    public static int[][][] ruleset(
            int ruleamount,
            int attributeamount,
            double[][] stat,
            int[][] data,
            String testdate
    ) throws IOException{
        int[][][] ruleset = new int[ruleamount][attributeamount][3];
        int[][][] rangeset = rangeset(attributeamount,stat,data);
        int[] rulecoverage = new int[ruleamount];
        for(int i=0;i<ruleamount;i++){
            ruleset[i] = randomrule(attributeamount,rangeset);
            rulecoverage[i] = rulecoverage(ruleset[i],data);
        }
        int[][] rangelogset = rangelogset(rangeset,data);
        filelog.array3csv(ruleset,"ruleset.csv",testdate);
        filelog.array3csv(rangeset,"rangeset.csv",testdate);
        filelog.patternlog(rulecoverage,"rulecoverage.log",testdate,"rule");
        filelog.arraycsv(rangelogset,"rangecoverage.csv",testdate);
        return ruleset;
    }
    public static int[][] randomrule(int attributeamount,int[][][] range){
        int[][] rule = new int[attributeamount][3];
        for(int i=0;i<attributeamount;i++){
            int rand = randominput.randomrange(0,3);
            rule[i][0] = range[i][rand][0];
            rule[i][1] = range[i][rand][1];
            rule[i][2] = rand;
        }
        return rule;
    }
    public static int[][][] rangeset(int attributeamount,double[][] stat,int[][] data){
        int[][][] range = new int[attributeamount][4][2];
        for(int i=0;i<attributeamount;i++){
            range[i] = rangegeneratorsub(stat[i][0],stat[i][1],data,i);
        }
        return range;
    }
    public static int[][] rangegeneratorsub(double max,double min,int[][] data,int index){
        int[][] subrange = new int[4][2];
        double deviation = (max-min)/4;
        int j = 0;
        for(double i=min;i<max;i=i+deviation){
            subrange[j][0] = (int) i;
            subrange[j][1] = (int) (i+deviation);
            j++;
        }
        return subrange;
    }
    public static int[][] rangelogset(int[][][] rangeset,int[][] data){
        int[][] rangelogset = new int[rangeset.length][4];
        for(int i=0;i<rangeset.length;i++){
            for(int j=0;j<4;j++){
                rangelogset[i][j] = rangelog(rangeset[i][j][0],rangeset[i][j][1],data,i);
            }
        }
        return rangelogset;
    }
    public static int rangelog(int min,int max,int[][] data,int index){
        int count = 0;
        for (int[] data1 : data) {
            if (data1[index] > min && data1[index] < max) {
                count=count+1;
            }
        }
        return count;
    }
    public static int rulecoverage(int[][] rule,int[][] data){
        int count=0;
        for (int[] data1 : data) {
            int support=0;
            for (int j = 0; j<data1.length; j++) {
                if (data1[j] >= rule[j][0] && data1[j] <= rule[j][1]) {
                    support=support+1;
                }
            }
            if(support==data1.length){
                count=count+1;
            }
        }
        return count;
    }
}
