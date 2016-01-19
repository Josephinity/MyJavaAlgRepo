/**
 * Created by xiaobaby on 1/13/16.
 */

import java.util.*;

public class Run {
    static Iterator func(ArrayList mylist)
    {
        Iterator it=mylist.iterator();
        while(it.hasNext())
        {
            Object element = it.next();
            if(element.equals("###"))//Hints: use instanceof operator
                break;
        }
        return it;

    }
    public static void main(String args[]){
        ArrayList mylist = new ArrayList();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            mylist.add(sc.nextInt());
        }
        mylist.add("###");
        for(int i=0;i<m;i++)
        {
            mylist.add(sc.next());
        }


        Iterator it=func(mylist);
        while(it.hasNext())
        {
            Object element = it.next();
            System.out.println((String)element);
        }

    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode lastOdd=head;
        if(lastOdd.val%2==1){
            while(lastOdd.next!=null&&lastOdd.next.val%2==1) lastOdd=lastOdd.next;
        }else lastOdd=null;
        ListNode n = lastOdd==null?head:lastOdd.next;
        if(n==null) return head;
        while(n.next!=null){
            if(n.next.val%2==0) n=n.next;
            else{
                ListNode odd=n.next;
                n.next=odd.next;
                if(lastOdd==null){
                    lastOdd=odd;
                    odd.next=head;
                    head=odd;
                }else{
                    odd.next=lastOdd.next;
                    lastOdd.next=odd;
                    lastOdd=odd;
                }

            }
        }
        return head;
    }



}
