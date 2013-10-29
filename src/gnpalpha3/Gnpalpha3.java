/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpalpha3;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author test
 */

public class Gnpalpha3 {
    static final int attributeamount=50;
    static final int dataamount=1000;
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    static final Date date = new Date();
    static String testdate = dateFormat.format(date);
    
    public static void main(String[] args) throws IOException {
        (new File("log/"+testdate+"")).mkdirs();
        int[][] data = randominput.randomdb(attributeamount,dataamount,50);
        ArrayList<int[][]> dataplot = new ArrayList<>();
        int[][] dataplot1 = plot.datasplit(data,0);
        int[][] dataplot2 = plot.datasplit(data,1);
        dataplot.add(dataplot1);
        dataplot.add(dataplot2);
        String[] label = {"attr1","attr2"};
        plot.makeplot(dataplot,label,"data","value","data");
    }
}
