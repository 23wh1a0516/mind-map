import java.util.*;

class Stacks{
    //next greater element
    static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
//previous smaller elements
    static int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
//Valid parentheses
    static boolean validParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if ((c == ')' && t != '(') || (c == '}' && t != '{') || (c == ']' && t != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    //Largest rectangle in histogram
static int largestRectangleHistogram(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                int h = heights[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, h * w);
            }
        }
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            int w = st.isEmpty() ? i : i - st.peek() - 1;
            max = Math.max(max, h * w);
        }
        return max;
    }
	//Stock span
    static int[] stockSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
    		span[i] = i + 1;
} else {
    		span[i] = i - st.peek();
}
            st.push(i);
        }
        return span;
    }
}
