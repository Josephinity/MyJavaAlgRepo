/**
 * Created by xiaobaby on 2/7/16.
 */
import java.util.HashMap;
import java.lang.*;
public class RunnableThread implements Runnable{
    private Thread t;
    private String threadName;

    public RunnableThread(String name){
        threadName = name;
        System.out.println(name+" created");

    }
    public void run(){
        System.out.println("Running "+threadName);
        try{
            MySQLAccess connection = new MySQLAccess();
            for(int i=0;i<4;i++) {
                final int n=i;
                connection.insertRows(new HashMap<Integer, String>() {{
                    put(n, "maria");
                }});
            }
        }catch(Exception e){
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    public void start(){
        System.out.println("starting thread "+threadName);
        if(t==null){
            t= new Thread(this,threadName);
            t.start();
        }
    }
}
