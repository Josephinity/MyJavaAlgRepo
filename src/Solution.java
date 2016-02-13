/**
 * Created by xiaobaby on 2/4/16.
 */
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution tester = new Solution();
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt(), k=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            tester.subrangesDeduct(arr,k);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }


    }

    //window size=k
    public void subrangesDeduct(int[] array,int k){
        int[] non_inc = new int[array.length];
        int[] non_dec = new int[array.length];
        for(int i=1;i<array.length;i++){
            if(array[i]>=array[i-1]) non_dec[i]+=2*array[i-1]+1;
            if(array[i]<=array[i-1]) non_inc[i]+=2*array[i-1]+1;
        }

    }
}
