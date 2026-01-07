import java.util.*;
class Queues {
// Level order traversal
    static List<List<Integer>> levelOrderTraversal(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        q.add(arr[i++]);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int val = q.poll();
                level.add(val);
                if (i < arr.length) q.add(arr[i++]);
                if (i < arr.length) q.add(arr[i++]);
            }
            res.add(level);
        }
        return res;
    }
//Sliding window maximum
    static int[] slidingWindowMaximum(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                res[idx++] = arr[dq.peekFirst()];
            }
        }
        return res;
    }
//First negative number in window
    static int[] firstNegativeInWindow(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
            if (i >= k - 1) {
                while (!q.isEmpty() && q.peek() < i - k + 1) {
                    q.poll();
                }
                res[idx++] = q.isEmpty() ? 0 : arr[q.peek()];
            }
        }
        return res;
    }
}

}
