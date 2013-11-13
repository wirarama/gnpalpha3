/*
 * To change this template, choose Tools | Templates
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

public class Gnpalpha3 {
    static final int attributeamount=56;
    static final int dataamount=12000;
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    static final Date date = new Date();
    static String testdate = dateFormat.format(date);
    
    public static void main(String[] args) throws IOException {
        (new File("log/"+testdate+"")).mkdirs();
        int[][] data = randominput.randomdb(attributeamount,dataamount,50);
        //plot.datasplitbatch(data,3);
    }
}
