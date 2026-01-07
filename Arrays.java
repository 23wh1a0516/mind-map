import java.util.*;
import java.io.*;

class Arrays{

    // 1. Max / Min in array
    public int[] getMaxMin(int[] a) {
        int mx = a[0];
        int mn = a[0];

        for(int i = 1; i < a.length; i++){
            if(a[i] > mx)
                mx = a[i];
            if(a[i] < mn)
                mn = a[i];
        }

        return new int[]{mx, mn};
    }


    // 2. Second largest element
    public int secondLargest(int[] a) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++){
            if(a[i] > largest){
                second = largest;
                largest = a[i];
            }
            else if(a[i] > second && a[i] != largest){
                second = a[i];
            }
        }

        return second;
    }


    // 3. Reverse array
    public int[] reverseArray(int[] a) {
        int i = 0, j = a.length - 1;

        while(i < j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }

        return a;
    }


    // 4. Prefix sum for range queries
    public long[] staticRangeSumQueries(int[] a, int[][] queries) {
        int q = queries.length;
        long ans[] = new long[q];

        long pre[] = new long[a.length];
        pre[0] = a[0];
        for(int i = 1; i < a.length; i++){
            pre[i] += pre[i - 1] + a[i];
        }

        for(int i = 0; i < q; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            if(x == 0){
                ans[i] = pre[y];
            }
            else{
                ans[i] = pre[y] - pre[x - 1];
            }
        }

        return ans;
    }


    // 5. Count zeros (CN0Z)
    public int countZeros(int[] a) {
        int c = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] == 0)
                c++;
        }

        return c;
    }
}
