/**
 * Created by xiaobaby on 1/18/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.security.Permission;
class Calculate{
    public static Calculate output = new Calculate();
    public int getINTVal() throws IOException{
        int val = new Scanner(System.in).nextInt();
        if(val<=0){
            throw new NumberFormatException("All the values must be positive");
        }
        return val;
    }
    public double getDoubleVal()throws IOException{
        double val = new Scanner(System.in).nextDouble();
        if(val<=0){
            throw new NumberFormatException("All the values must be positive");
        }
        return val;
    }
    public static Calculate get_Vol(){
        return output;
    }
    public Double main(int h){
        return (double)h*h*h;
    }
    public Double main(int l,int b, int h){
        return (double)l*b*h;
    }
    public Double main(double r){
        return Math.PI*Math.pow(r,3)*2/3;
    }
    public Double main(double r, double h){
        return Math.PI*r*r*h;

    }
    public void display(double val){
        System.out.printf( "%.3f",val);
    }
}

public class Whatever {

    public static void main(String[] args) {
        try{
            Calculate cal=new Calculate();
            int T=cal.getINTVal();
            while(T-->0){
                double volume = 0.0d;
                int ch=cal.getINTVal();
                if(ch==1){

                    int a=cal.getINTVal();
                    volume=Calculate.get_Vol().main(a);


                }
                else if(ch==2){

                    int l=cal.getINTVal();
                    int b=cal.getINTVal();
                    int h=cal.getINTVal();
                    volume=Calculate.get_Vol().main(l,b,h);

                }
                else if(ch==3){

                    double r=cal.getDoubleVal();
                    volume=Calculate.get_Vol().main(r);

                }
                else if(ch==4){

                    double r=cal.getDoubleVal();
                    double h=cal.getDoubleVal();
                    volume=Calculate.get_Vol().main(r,h);

                }
                cal.output.display(volume);
            }

        }
        catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
