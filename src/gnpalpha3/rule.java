/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpalpha3;

/**
 *
 * @author test
 */
public class rule {
    public static int[][][] ruleset(int ruleamount,int attributeamount,double[][] stat){
        int[][][] ruleset = new int[ruleamount][attributeamount][3];
        int[][][] rangeset = rangeset(attributeamount,stat);
        for(int i=0;i<ruleamount;i++){
            ruleset[i] = randomrule(attributeamount,rangeset[i]);
        }
        return ruleset;
    }
    public static int[][] randomrule(int attributeamount,int[][] range){
        int[][] rule = new int[attributeamount][3];
        for(int i=0;i<attributeamount;i++){
            int rand = randominput.randomrange(0,3);
            rule[i][0] = range[rand][0];
            rule[i][1] = range[rand][1];
            rule[i][2] = rand;
        }
        return rule;
    }
    public static int[][][] rangeset(int attributeamount,double[][] stat){
        int[][][] range = new int[attributeamount][4][2];
        for(int i=0;i<attributeamount;i++){
            range[i] = rangegeneratorsub(stat[i][0],stat[i][1]);
        }
        return range;
    }
    public static int[][] rangegeneratorsub(double max,double min){
        int[][] subrange = new int[4][2];
        double deviation = (max-min)/4;
        int j = 0;
        for(double i=min;i<=max;i=i+deviation){
            subrange[j][0] = (int) i;
            subrange[j][1] = (int) (i+deviation);
            j++;
        }
        return subrange;
    }
}
