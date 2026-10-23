class Solution {
    public int numSquares(int n) {
        if (n < 0) return 0;
        else if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (isPerfectNum(i)) {
                dp[i] = 1;
                continue;
            }

            dp[i] = i; 
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(
                    dp[i],
                    dp[i - j * j] + 1
                );
            }
        }

        return dp[n];
    }

    private boolean isPerfectNum(int num) {
        // assert num >= 0
        int temp = (int)(Math.sqrt(num));
        return temp * temp == num;
    }
}