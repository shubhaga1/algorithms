// https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

/*
Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation: 
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

*/

class ZeroFilledSubarray {
    public int zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int count = 0; // count of consecutive zeros
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2; // add count to answer
                count = 0; // reset count
            }
        }
        if(count!=0){
            ans += (count * (count + 1)) / 2; // add the remaining count to answer
        }
        return ans;
    }
}
