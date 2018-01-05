package InterviewQuestion;

public class quickSelect {
    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while(start < end) {
            int pivot = partion(nums, start, end);
            if(pivot < index) start = pivot + 1;
            else if(pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private static int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while(start <= end) {
            while(start <= end && nums[start] <= nums[pivot]) start++;
            while(start <= end && nums[end] > nums[pivot]) end--;
            if(start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(findKthLargest(nums, 1));
    }
}
