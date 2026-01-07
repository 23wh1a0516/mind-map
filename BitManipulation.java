import java.util.*;

public class BitManipulation {

    
      // 1) Check if a number is a power of 2
     
    public boolean isPowerOfTwo(int n){
        boolean ans = true;
        if(countSetBit(n) == 1){
            ans = true;
        } else {
            ans = false;
        }
        return ans;
    }

    public int countSetBit(int num){
        int c = 0;
        while(num > 0){
            if((num & 1) != 0){
                c++;
            }
            num = num >> 1;
        }
        return c;
    }

    
      // 2) Maximum consecutive set bits
       
    public int maxConsecutiveSetBits(int n){
        int curr = 0;
        int maxc = 0;

        while(n != 0){
            if((n & 1) == 1){
                curr++;
            } else {
                maxc = Math.max(curr, maxc);
                curr = 0;
            }
            n = n >> 1;
        }
        return Math.max(curr, maxc);
    }

    
       // 3) Find missing and repeating number
    public void findMissingAndRepeating(int[] arr, int n) {

        int XOR_total = 0;

        for (int num : arr) {
            XOR_total ^= num;
        }
        for (int i = 1; i <= n; i++) {
            XOR_total ^= i;
        }

        int rightmostSetBit = XOR_total & -XOR_total;
        int zeroGroup = 0, oneGroup = 0;

        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                oneGroup ^= num;
            } else {
                zeroGroup ^= num;
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rightmostSetBit) != 0) {
                oneGroup ^= i;
            } else {
                zeroGroup ^= i;
            }
        }

        int repeating = 0, missing = 0;

        for (int num : arr) {
            if (num == zeroGroup) {
                repeating = zeroGroup;
                missing = oneGroup;
                break;
            }
        }

        if (repeating == 0) {
            repeating = oneGroup;
            missing = zeroGroup;
        }

        System.out.println("Repeating Number: " + repeating);
        System.out.println("Missing Number: " + missing);
    }

  // 4) Find unique / missing number using XOR
    public int missingNumber(int[] arr, int N) {
        int xor1 = 0, xor2 = 0;

        for (int i = 1; i <= N; i++)
            xor1 ^= i;

        for (int num : arr)
            xor2 ^= num;

        return xor1 ^ xor2;
    }

    
       // 5) Generate all subsets using bit masking
       
    public List<List<Integer>> subsets(int A[]) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = A.length;
        int k = 1 << n;

        for (int num = 1; num < k; num++) {
            List<Integer> lst = new ArrayList<>();
            for (int bp = 0; bp < n; bp++) {
                if ((num & (1 << bp)) != 0) {
                    lst.add(A[bp]);
                }
            }
            ans.add(lst);
        }
        return ans;
    }
}
