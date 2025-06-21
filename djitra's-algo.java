import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build graph: node → list of (neighbor, time)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Min-heap: [time, node]
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, k});

        // Distance map
        Map<Integer, Integer> dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int time = curr[0], node = curr[1];

            if (dist.containsKey(node)) continue; // Already visited
            dist.put(node, time);

            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], w = edge[1];
                    if (!dist.containsKey(nei)) {
                        heap.offer(new int[]{time + w, nei});
                    }
                }
            }
        }

        if (dist.size() < n) return -1;

        // Maximum distance to reach a node
        int maxTime = 0;
        for (int t : dist.values()) {
            maxTime = Math.max(maxTime, t);
        }

        return maxTime;
    }
}
