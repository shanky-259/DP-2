class Solution {
    /*
     * Time Complexity - O(n) where n is the number of houses to color
     * Space Complexity - O(n) where n is the number of houses to color
     */
    public int minCost(int[][] costs) {
        if (costs == null ||  costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        // Start from last row, set cost 
        for (int j=0; j<3; j++)
            dp[n-1][j] = costs[n-1][j];
        for (int i=n-2; i>=0; i--) {
            // red
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            // blue
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            // green
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}