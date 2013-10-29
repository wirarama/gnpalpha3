/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpalpha3;

import static gnpalpha3.Gnpalpha3.testdate;
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
    public static void makeplot(ArrayList<int[][]> data,String[] label,String pngname,String xlabel,String ylabel){
        JavaPlot p = new JavaPlot();
        p.setTitle(pngname);
        p.setKey(JavaPlot.Key.BELOW);
        p.getAxis("x").setLabel(xlabel);
        p.getAxis("y").setLabel(ylabel);
        int dataamount = 7;
        int k=0;
        boolean fileexport=true;
        for(int i=0;i<data.size();i++){
            int[][] data1 = data.get(i);
            p.addPlot(data1);
            ((AbstractPlot) p.getPlots().get(k)).setTitle(label[k]);
            PlotStyle stl = ((AbstractPlot) p.getPlots().get(k)).getPlotStyle();
            stl.setStyle(Style.LINES);
            ImageTerminal png = new ImageTerminal();
            File file = new File("plot/"+pngname+testdate+".png");
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
}
