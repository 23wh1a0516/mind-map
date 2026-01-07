import java.util.*;
class PriorityQueues {
//K largest
    static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

//K Smallest    
static int[] kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
//Running Median
    static double[] runningMedian(int[] arr) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    double[] res = new double[arr.length];

    for (int i = 0; i < arr.length; i++) {
        if (maxHeap.isEmpty() || arr[i] <= maxHeap.peek()) {
            maxHeap.add(arr[i]);
        } else {
            minHeap.add(arr[i]);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() == minHeap.size()) {
            res[i] = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            res[i] = maxHeap.peek();
        }
    }
    return res;
}
//Fractional knapsack
static double fractionalKnapsack(int[] value, int[] weight, int capacity) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> Double.compare(
            (double) value[b] / weight[b],
            (double) value[a] / weight[a]
        )
    );
    for (int i = 0; i < value.length; i++) {
        pq.add(i);
    }
    double profit = 0;
    while (capacity > 0 && !pq.isEmpty()) {
        int i = pq.poll();
        if (weight[i] <= capacity) {
            profit += value[i];
            capacity -= weight[i];
        } else {
            profit += ((double) value[i] / weight[i]) * capacity;
            break;
        }
    }
    return profit;
}
//Minimum cost to connect ropes
static int minCostToConnectRopes(int[] ropes) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int r : ropes) {
        pq.add(r);
    }
    int cost = 0;
    while (pq.size() > 1) {
        int a = pq.poll();
        int b = pq.poll();
        int sum = a + b;
        cost += sum;
        pq.add(sum);
    }
    return cost;
}
