import java.util.*;
import java.io.*;

class SlidingWindow{

    // 1. Max sum subarray of size K
    public int maxSumSubarrayOfSizeK(int[] a, int k) {
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < k; i++){
            sum += a[i];
        }
        ans = sum;

        for(int e = k; e < a.length; e++){
            sum += a[e];
            sum -= a[e - k];
            ans = Math.max(ans, sum);
        }

        return ans;
    }


    // 2. Longest subarray with sum ≤ K
    public int longestSubarrayWithSumAtMostK(int[] a, int k) {
        int st = 0, ans = 0, sum = 0;
        for(int e = 0; e < a.length; e++){
            sum += a[e];

            while(sum > k){
                sum -= a[st];
                st++;
            }

            ans = Math.max(ans, e - st + 1);
        }
        return ans;
    }


    // 3. Longest substring with K distinct characters
    public int longestSubstringWithKDistinct(String s, int k) {
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int st = 0;

        for(int e = 0; e < s.length(); e++){
            char ch1 = s.charAt(e);
            mp.put(ch1, mp.getOrDefault(ch1, 0) + 1);

            while(mp.size() > k){
                char ch2 = s.charAt(st);
                mp.put(ch2, mp.get(ch2) - 1);
                if(mp.get(ch2) == 0){
                    mp.remove(ch2);
                }
                st++;
            }

            ans = Math.max(ans, e - st + 1);
        }
        return ans;
    }


    // 4. Count subarrays with sum = K
    public int countSubarraysWithSumK(int[] a, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int sum = 0, ans = 0;

        for(int e = 0; e < a.length; e++){
            sum += a[e];

            if(mp.containsKey(sum - k)){
                ans += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }


    // 5. At most K / Exactly K subarrays with ≤ K distinct integers
    public int countAtMostKDistinct(int[] a, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int st = 0, ans = 0;

        for(int e = 0; e < a.length; e++){
            mp.put(a[e], mp.getOrDefault(a[e], 0) + 1);

            while(mp.size() > k){
                mp.put(a[st], mp.get(a[st]) - 1);
                if(mp.get(a[st]) == 0){
                    mp.remove(a[st]);
                }
                st++;
            }

            ans += e - st + 1;
        }
        return ans;
    }


    // exactly K = atMost(K) - atMost(K-1)
    public int countExactlyKDistinct(int[] a, int k) {
        return countAtMostKDistinct(a, k) - countAtMostKDistinct(a, k - 1);
    }
}
