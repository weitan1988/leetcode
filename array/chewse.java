public class Chewse {
    public int[] stock(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int max_profit = 0;
        int buy_date = 0, sell_date = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < prices[buy_date]) buy_date = i;
            int tmp_profit = prices[i] - prices[buy_date];
            if(tmp_profit > max_profit) {
                max_profit = tmp_profit;
                sell_date = i;
            }
        }
        return new int[]{buy_date, sell_date};
    }

    public List<String[]> anagram(String text) {
        // ignore the words with 

    }


}