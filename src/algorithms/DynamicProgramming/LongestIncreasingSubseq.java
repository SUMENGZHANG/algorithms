package DynamicProgramming;

public class LongestIncreasingSubseq {

    /**
     * 方案一， 复杂度 n**2
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int []dp = new int[len];
        for(int i = 0;i<len;i++){
            dp[i] = 1;
        }
        int max = 1;
        for(int i =1;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;

    }

    /**
     *
     * @param nums
     * @return
     */
    public int lengthOfLISWithBinarySearch(int[] nums) {

     return 0;
    }
}
