/**
 * Created by xiaobaby on 2/3/16.
 */
import java.util.*;
import java.lang.reflect.*;

public class Run {
    public static void main(String[] args) {
        RunnableThread thread0=new RunnableThread("thread-0");
        thread0.start();
//
//        RunnableThread thread1=new RunnableThread("thread-1");
//        thread1.start();
        MyThread thread1=new MyThread("thread-1");
        thread1.start();


    }




}
