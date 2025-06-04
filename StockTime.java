class Solution {
    public int maxProfit(int[] prices) {
        int minp = Integer.MAX_VALUE;  
        int maxp = 0;

        for (int price : prices) {
            if (price < minp) {
                minp = price;  
            } else if (price - minp > maxp) {
                maxp = price - minp;  
            }
        }

        return maxp; 
    }
}
