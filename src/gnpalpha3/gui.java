/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpalpha3;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author test
 */
public class gui extends JFrame{
    JLabel lbattribute = new JLabel();
    JLabel lbdata = new JLabel();
    JLabel lbcross = new JLabel();
    JLabel lbmutation = new JLabel();
    JLabel lbrange = new JLabel();
    JLabel lbvariation = new JLabel();
    JLabel lbplot = new JLabel();
    JTextField txtattribute = new JTextField();
    JTextField txtdata = new JTextField();
    JTextField txtcross = new JTextField();
    JTextField txtmutation = new JTextField();
    JTextField txtrange = new JTextField();
    JTextField txtvariation = new JTextField();
    JCheckBox chkplot = new JCheckBox("Export Plot as PNG");
    static JButton btn = new JButton("Process");
    static int leftmargin = 35;
    static int rowheight = 20;
    static int rowmargin = 10;
    static int labelwidth = 150;
    MyTask process = new MyTask();
    
    class MyTask extends SwingWorker {
        @Override
        protected Object doInBackground() throws Exception {
            btn.setEnabled(false);
            Integer result = new Integer(0);
            mainprocess.mainprocess(
                    Integer.parseInt(txtattribute.getText()),
                    Integer.parseInt(txtdata.getText()),
                    Integer.parseInt(txtcross.getText()),
                    Integer.parseInt(txtmutation.getText()),
                    Integer.parseInt(txtrange.getText()),
                    Integer.parseInt(txtvariation.getText()),
                    chkplot.isSelected()
            );
            btn.setEnabled(true);
            btn.setText("Process");
            return result;
        }
    }
    
    public gui(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("GNP Knapsack");
        
        lbattribute.setText("Attribute : ");
        lbattribute.setBounds(rowlabel(1));
        
        txtattribute.setRequestFocusEnabled(true);
        txtattribute.setBounds(rowfield(1,60));
        txtattribute.setText("8");
        
        lbdata.setText("Data : ");
        lbdata.setBounds(rowlabel(2));
        
        txtdata.setBounds(rowfield(2,60));
        txtdata.setText("1000");
        
        lbcross.setText("Crossover Rate : ");
        lbcross.setBounds(rowlabel(3));
        
        txtcross.setBounds(rowfield(3,30));
        txtcross.setText("8");
        
        lbmutation.setText("Mutation Rate : ");
        lbmutation.setBounds(rowlabel(4));
        
        txtmutation.setBounds(rowfield(4,30));
        txtmutation.setText("10");
        
        lbrange.setText("Data Range : ");
        lbrange.setBounds(rowlabel(5));
        
        txtrange.setBounds(rowfield(5,40));
        txtrange.setText("500");
        
        lbvariation.setText("Data Variation(%) : ");
        lbvariation.setBounds(rowlabel(6));
        
        txtvariation.setBounds(rowfield(6,40));
        txtvariation.setText("30");
        
        lbplot.setText("Plot : ");
        lbplot.setBounds(rowlabel(7));
        
        chkplot.setBounds(rowfield(7,180));
        
        btn.setBounds(rowfield(8,180));
        
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                process.execute();
                /*try {
                    mainprocess.mainprocess(
                            Integer.parseInt(txtattribute.getText()),
                            Integer.parseInt(txtdata.getText()),
                            Integer.parseInt(txtcross.getText()),
                            Integer.parseInt(txtmutation.getText()),
                            Integer.parseInt(txtrange.getText()),
                            Integer.parseInt(txtvariation.getText()),
                            chkplot.isSelected()
                    );  } catch (IOException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
        this.getContentPane().add(lbattribute,null);
        this.getContentPane().add(lbdata,null);
        this.getContentPane().add(lbcross,null);
        this.getContentPane().add(lbmutation,null);
        this.getContentPane().add(lbrange,null);
        this.getContentPane().add(lbvariation,null);
        this.getContentPane().add(lbplot,null);
        this.getContentPane().add(txtattribute,null);
        this.getContentPane().add(txtdata,null);
        this.getContentPane().add(txtcross,null);
        this.getContentPane().add(txtmutation,null);
        this.getContentPane().add(txtrange,null);
        this.getContentPane().add(txtvariation,null);
        this.getContentPane().add(chkplot,null);
        this.getContentPane().add(btn,null);
        
        this.setSize(400,280);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (layar.width-this.getSize().width)/2;
        int y = (layar.height-this.getSize().height)/2;
        this.setLocation(x,y);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static Rectangle rowlabel(int y){
        Rectangle out = formrow(y,true,0);
        return out;
    }
    public static Rectangle rowfield(int y,int width){
        Rectangle out = formrow(y,false,width);
        return out;
    }
    public static Rectangle formrow(int y,boolean label,int width){
        int top;
        if(y==1){
            top = rowmargin;
        }else{
            top = rowmargin+((y-1)*(rowmargin+rowheight));
        }
        Rectangle out;
        if(label==true){
            out = new Rectangle(leftmargin,top,labelwidth,rowheight);
        }else{
            out = new Rectangle((leftmargin+labelwidth),top,width,rowheight);
        }
        return out;
    }
}
