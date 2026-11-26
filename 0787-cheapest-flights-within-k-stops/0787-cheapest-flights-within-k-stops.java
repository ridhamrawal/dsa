import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize prices array with a large value representing infinity
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Relax edges k + 1 times (at most k stops means at most k + 1 flights)
        for (int i = 0; i <= k; i++) {
            // Use a temporary array to ensure we only use prices from the previous step
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // If 'from' is reachable, check if this flight offers a cheaper price to 'to'
                if (prices[from] != Integer.MAX_VALUE && prices[from] + cost < temp[to]) {
                    temp[to] = prices[from] + cost;
                }
            }
            // Update the main prices array for the next iteration
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}