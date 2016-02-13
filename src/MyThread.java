/**
 * Created by xiaobaby on 2/8/16.
 */
public class MyThread extends Thread{
    private Thread t;
    private String threadName;

    MyThread(String name){
        threadName=name;
        System.out.println("Created "+threadName);
    }

    public void run(){
        System.out.println("Running "+threadName);
        try{
            Thread.sleep(200);
            MySQLAccess connection = new MySQLAccess();
            connection.deleteFromTable("standard");
        }catch(InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    public void start(){
        System.out.println("Starting " +  threadName );
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
