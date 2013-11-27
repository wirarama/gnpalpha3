/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpalpha3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author test
 */
public class filelog {
    public static void arraycsv(int[][] data,String filename,String testdate) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for (int[] data1 : data) {
                for (int j = 0; j<data[0].length; j++) {
                    out.write(data1[j] + ",");
                }
                out.newLine();
            }
            out.close();
        }
    }
    public static void arraycsvdouble(double[][] data,String filename,String testdate) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for (double[] data1 : data) {
                for (int j = 0; j<data[0].length; j++) {
                    out.write(data1[j] + ",");
                }
                out.newLine();
            }
            out.close();
        }
    }
    public static void patternlog(int[] data,String filename,String testdate,String label) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for (int i = 0; i<data.length; i++) {
                out.write(label+" "+i+" : "+data[i]+"");
                out.newLine();
            }
            out.close();
        }
    }
    public static void stringlog(String[] data,String filename,String testdate) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for (String data1 : data) {
                out.write(data1 + "");
                out.newLine();
            }
            out.close();
        }
    }
    public static void array3csv(int[][][] data,String filename,String testdate) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log/"+testdate+"/"+filename))) {
            for (int[][] data1 : data) {
                for (int[] data11 : data1) {
                    for (int k = 0; k<data11.length; k++) {
                        out.write(data11[k] + "-");
                    }
                    out.write(",");
                }
                out.newLine();
            }
            out.close();
        }
    }
}
