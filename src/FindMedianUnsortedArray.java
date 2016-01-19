/**
 Find median without sorting the array
 Because of WiggleSort, all numbers equal to median are in the middle as an additional requirement
 */
import java.util.Random;
public class FindMedianUnsortedArray {


    //median = nums[mid];
    public void partialSort(int[] nums){
        int mid=nums.length/2,left=0,right=nums.length-1;
        int pivot=partition(nums,left,right);
        while(nums[pivot]!=nums[mid]) {
            if (pivot < mid) left = pivot;
            else right = pivot;
            pivot = partition(nums, left, right);
        }
    }

    int partition(int[] nums, int start, int end){
        //int rnd = new Random().nextInt(end-start);  //can randomize pivot
        int pivot = nums[(end+start)/2];
        int placeholder1=start,placeholder2=end;
        while(start<end){
            while(start<end&&nums[start]<=pivot){
                if(nums[start]<pivot) {
                    nums[placeholder1]=nums[start];
                    placeholder1++;
                }
                start++;
            }
            while(end>start&&nums[end]>=pivot){
                if(nums[end]>pivot){
                    nums[placeholder2]=nums[end];
                    placeholder2--;
                }
                end--;
            }
            if(start<end){
                int tmp = nums[start];
                nums[placeholder1]=nums[end];
                placeholder1++; end--;
                nums[placeholder2]=tmp;
                placeholder2--; start++;
            }
        }
        if(end==start) {
            if (nums[end] < pivot) {
                nums[placeholder1] = nums[end];
                placeholder1++;
            }
            if (nums[start] > pivot) {
                nums[placeholder2] = nums[start];
                placeholder2--;
            }
        }
        while(placeholder1<=placeholder2){
            nums[placeholder1]=pivot;
            placeholder1++;
        }
        return start;
    }

}
