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
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author test
 */
public class gui  extends JFrame{
    JLabel lbattribute = new JLabel();
    JLabel lbdata = new JLabel();
    JLabel lbplot = new JLabel();
    JTextField txtattribute = new JTextField();
    JTextField txtdata = new JTextField();
    JCheckBox chkplot = new JCheckBox("Export Plot as PNG");
    JButton btn = new JButton("Process");
    
    public gui(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("GNP Knapsack");
        
        lbattribute.setText("Attribute : ");
        lbattribute.setBounds(new Rectangle(35,20,120,20));
        
        lbdata.setText("Data : ");
        lbdata.setBounds(new Rectangle(35,50,120,20));
        
        lbplot.setText("Plot : ");
        lbplot.setBounds(new Rectangle(35,80,120,20));
        
        txtattribute.setRequestFocusEnabled(true);
        txtattribute.setBounds(new Rectangle(155,20,60,20));
        txtattribute.setText("50");
        
        txtdata.setBounds(new Rectangle(155,50,60,20));
        txtdata.setText("1000");
        
        chkplot.setBounds(new Rectangle(155,80,180,20));
        
        btn.setBounds(new Rectangle(155,110,120,20));
        
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try {
                    inputprocess();
                    JOptionPane.showMessageDialog(null,"finished");
                } catch (IOException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.getContentPane().add(lbattribute,null);
        this.getContentPane().add(lbdata,null);
        this.getContentPane().add(lbplot,null);
        this.getContentPane().add(txtattribute,null);
        this.getContentPane().add(txtdata,null);
        this.getContentPane().add(chkplot,null);
        this.getContentPane().add(btn,null);
        
        this.setSize(400,200);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (layar.width-this.getSize().width)/2;
        int y = (layar.height-this.getSize().height)/2;
        this.setLocation(x,y);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void inputprocess() throws IOException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String testdate = dateFormat.format(date);
        (new File("log/"+testdate+"")).mkdirs();
        int attributeamount = Integer.parseInt(txtattribute.getText());
        int dataamount = Integer.parseInt(txtdata.getText());
        int[][] data = randominput.randomdb(attributeamount,dataamount,50,testdate,1000,8,10);
        double[][] stat = statistics.getstatistics(data,testdate);
        if(chkplot.isSelected()==true){
            plot.datasplitbatch(data,5,testdate);
        }
    }
}
