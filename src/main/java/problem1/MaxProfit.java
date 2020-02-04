package problem1;

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int[] pricies = {7,6,4,3,1};
        int res = mp.maxProfit(pricies);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
