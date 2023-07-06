class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0; int j=0;
        int sum =0; int ans = Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                ans =Math.min(ans,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}

/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/
