class Solution {
    private int solve(int[] nums, int start, int end, int player) {
        if(start>end) {
            return 0;
        }
        if(player ==1) {
            int choice1 = nums[start] + solve(nums, start+1,end,0);
            int choice2 = nums[end] + solve(nums, start, end-1, 0);
            return Math.max(choice1, choice2);
        }else {
             int choice1 = -nums[start] + solve(nums, start+1,end,1);
            int choice2 = -nums[end] + solve(nums, start, end-1, 1);
            return Math.min(choice1, choice2);
        }
    }
    public boolean predictTheWinner(int[] nums) {
         return solve(nums, 0, nums.length - 1, 1) >= 0?true:false;
    }
}