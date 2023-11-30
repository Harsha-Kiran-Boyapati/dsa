package dsa.leetcode150.arrays;

public class LargestLoss {
    public int solve(int[] prices){
        int n = prices.length;
        //edge cases
        if(n<=1) return 0;
        if(prices[0] > prices[n-1]) return n-1;

        //
        int[] maxLeft = new int[n], minRight = new int[n];

        maxLeft[0] = prices[0];
        for(int i=1; i<n; i++) maxLeft[i] = Math.max(prices[i], maxLeft[i-1]);

        minRight[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--) minRight[i] = Math.min(prices[i], minRight[i+1]);


        int ans = 0;

        int sellIdx, buyIdx=n-1;
        for(sellIdx=n-1; sellIdx>0; sellIdx--){
            while(maxLeft[buyIdx] <= minRight[sellIdx] && buyIdx>=1){
                buyIdx--;
            }
            if(maxLeft[buyIdx] > minRight[sellIdx]) ans = Math.max(ans, sellIdx-buyIdx);
        }
         return ans;
    }

}
