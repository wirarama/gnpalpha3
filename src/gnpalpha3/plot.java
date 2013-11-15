/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpalpha3;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.terminal.ImageTerminal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

/**
 *
 * @author test
 */
public class plot {
    public static void makeplot(ArrayList<int[][]> data,String[] label,String pngname,String xlabel,String ylabel,String testdate){
        JavaPlot p = new JavaPlot();
        p.setTitle(pngname);
        p.setKey(JavaPlot.Key.BELOW);
        p.getAxis("x").setLabel(xlabel);
        p.getAxis("y").setLabel(ylabel);
        int k=0;
        boolean fileexport=true;
        for(int i=0;i<data.size();i++){
            int[][] data1 = data.get(i);
            p.addPlot(data1);
            ((AbstractPlot) p.getPlots().get(k)).setTitle(label[k]);
            PlotStyle stl = ((AbstractPlot) p.getPlots().get(k)).getPlotStyle();
            stl.setStyle(Style.LINES);
            ImageTerminal png = new ImageTerminal();
            File file = new File("log/"+testdate+"/"+pngname+testdate+".png");
            try {
                file.createNewFile();
                png.processOutput(new FileInputStream(file));
            } catch (FileNotFoundException ex) {
                System.err.print(ex);
            } catch (IOException ex) {
                System.err.print(ex);
            }
            if(fileexport==true){ p.setTerminal(png); }
            p.plot();
            if(fileexport==true){
                try {
                    ImageIO.write(png.getImage(), "png", file);
                } catch (IOException ex) {
                    System.err.print(ex);
                }
            }
            k++;
        }
    }
    public static int[][] datasplit(int[][] data,int index){
        int[][] out = new int[data.length][2];
        for(int i=0;i<data.length;i++){
            out[i][0]=i+1;
            out[i][1]=data[i][index];
        }
        return out;
    }
    public static void datasplitbatch(int[][] data,int limit,String testdate){
        ArrayList<int[][]> dataplot;
        String[] label;
        int l = 1;
        for(int i=0;i<data[0].length;i=i+limit){
            int k = i;
            dataplot = new ArrayList<>();
            label = new String[5];
            LOOP:for(int j=0;j<limit;j++){
                label[j] = "attr"+(k+1);
                int[][] dataplot1 = datasplit(data,k);
                dataplot.add(dataplot1);
                k++;
                if(k>=data[0].length) break LOOP;
            }
            makeplot(dataplot,label,"data("+l+")","data","value",testdate);
            l++;
        }
    }
}
