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
    public static int[][][] ruleset(int ruleamount,int attributeamount){
        int[][][] ruleset = new int[ruleamount][attributeamount][3];
        for(int i=0;i<ruleamount;i++){
            ruleset[i] = randomrule(attributeamount);
        }
        return ruleset;
    }
    public static int[][] randomrule(int attributeamount){
        int[][] rule = new int[attributeamount][3];
        for(int i=0;i<attributeamount;i++){
            rule[i][0] = 0; //min
            rule[i][1] = 0; //max
            rule[i][2] = 0; //index
        }
        return rule;
    }
}
