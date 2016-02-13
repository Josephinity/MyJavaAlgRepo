/**
 * Difficult
 *
 * test case
 20
 114 48 86 180 176 66 126 194 50 198 140 192 186 4 136 138 130 178 36 14
 43 110
 */
import java.util.*;
public class LinearSearchGreedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextLong();
        }
        long p=sc.nextLong(),q=sc.nextLong();
        if(n<=0) System.out.println(p);
        else System.out.println(getM(array,p,q));
    }
    static long getM(long[] array,long p, long q){
        Arrays.sort(array);
        for(long x:array)
            System.out.print(x+" ");
        long m=p;
        if(array[array.length-1]<=p) return q;
        if(array[0]>=q) return p;
        long maxDist=p<array[0]?array[0]-p:0;
        int index = 0;
        while(index<array.length-1&&array[index]<q){
            System.out.println("index: "+index +"  "+p+" "+q);
            if(p<array[index+1]){
                long mid = (array[index]+array[index+1])/2;
                if(mid>q&&q-array[index]>maxDist) return q;
                if(mid<p&&array[index+1]-p>maxDist) {
                    maxDist = array[index+1]-p;     //important
                }
                if(mid<=q&&mid>=p&&mid-array[index]>maxDist) {
                    maxDist = mid-array[index]; m = mid;
                }
                System.out.println(m + "  "+maxDist+"  "+mid);
            }
            index++;
        }
        if(q>array[index]&&q-array[index]>maxDist) return q;
        return m;
    }
}
