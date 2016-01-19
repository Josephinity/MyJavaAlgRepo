/**
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

public class WiggleSortSolution {
    FindMedianUnsortedArray ob=new FindMedianUnsortedArray();

    public void wiggleSort(int[] nums){
        ob.partialSort(nums);
        System.out.println("partial sorted");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        if(nums.length>1&&nums[nums.length/2-1]==nums[nums.length/2]){
            int median=nums[nums.length/2-1],mid=nums.length/2-1,left=0,right=nums.length-1;

        }
        System.out.println("reversed");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        int largeindex=nums.length%2==0?nums.length-2:nums.length-1,smallindex=1;
        while(largeindex>smallindex){
            swap(nums,largeindex,smallindex);
            largeindex-=2;smallindex+=2;
        }
    }

    void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
