import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the adjacency list: u -> list of [v, weight]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>())
                 .add(new int[]{edge[1], edge[2]});
        }

        // 2. Min-Heap storing [currentTime, node], ordered by currentTime
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k});

        // 3. Track shortest time to reach each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0];
            int u = current[1];

            // Skip if we already found a faster path to u
            if (time > dist[u]) continue;

            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        minHeap.offer(new int[]{dist[v], v});
                    }
                }
            }
        }

        // 4. Find the maximum time among all nodes (1 to n)
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node i is unreachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
