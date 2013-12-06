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
public class arraysearch {
    public static boolean inarray(int[] data,int key){
        boolean exist = false;
        for(int i=0;i<data.length;i++){
            if(data[i]==key){
                exist = true;
                break;
            }
        }
        return exist;
    }
    public static int sumarray(int[] data){
        int sum = 0;
        for(int i=0;i<data.length;i++){
            sum = sum+data[i];
        }
        return sum+1;
    }
    public static int[][] cleanarray(int[][] data,int length){
        int[][] newdata = new int[length][data[0].length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
    public static int[][][] cleanarray3(int[][][] data,int length){
        int[][][] newdata = new int[length][data[0].length][data[0][0].length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
    public static int[] cleanarray1(int[] data,int length){
        int[] newdata = new int[length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
}
