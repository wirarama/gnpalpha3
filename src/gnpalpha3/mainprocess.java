/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpalpha3;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author test
 */
public class mainprocess {
    public static void mainprocess(
            int attributeamount,
            int dataamount,
            int cross,
            int mutation,
            int range,
            int variation,
            boolean isplot
    ) throws IOException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String testdate = dateFormat.format(date);
        (new File("log/"+testdate+"")).mkdirs();
        int[][] data = randominput.randomdb(attributeamount,dataamount,variation,testdate,range,cross,mutation);
        double[][] stat = statistics.getstatistics(data,testdate);
        int ruleamount = 1000000;
        int[][][] ruleset = rule.ruleset(ruleamount,attributeamount,stat,data,testdate);
        if(isplot==true){
            plot.datasplitbatch(data,2,testdate);
        }
        Runtime.getRuntime().exec("caja /home/wirarama/NetBeansProjects/gnpalpha3/log/"+testdate+"");
        knapsack.gnpknapsack(ruleset.length,testdate);
        System.exit(1);
    }
}
