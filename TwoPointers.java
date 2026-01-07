import java.util.*;

class TwoPointers {

    // 1. Squares of a Sorted Array
    public long[] squaresOfSortedArray(int a[], int n) {
        int i = 0, j = n - 1;
        int k = n - 1;
        long[] ansArr = new long[n];

        while(i <= j){
            long ls = (long)a[i] * a[i];
            long rs = (long)a[j] * a[j];

            if(ls < rs){
                ansArr[k--] = rs;
                j--;
            }
            else{
                ansArr[k--] = ls;
                i++;
            }
        }
        return ansArr;
    }


    // 2. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int i = 0, j = i + 1;
        int k = 1;

        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[k++] = nums[j];
                j++;
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return k;
    }


    // 3. Merge Two Sorted Arrays into A[]
    public void mergeBothInA(int a[], int an, int b[], int bn) {
        int i = an - 1, j = bn - 1, k = a.length - 1;

        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                a[k--] = a[i];
                i--;
            }
            else{
                a[k--] = b[j];
                j--;
            }
        }

        while(j >= 0){
            a[k--] = b[j];
            j--;
        }
    }


    // 4. Triplet Sum
    public boolean tripletSum(int A[], int x) {
        Arrays.sort(A);
        boolean ans = false;

        for(int i = 0; i < A.length - 1; i++){
            int left = i + 1;
            int right = A.length - 1;
            int remainingSum = x - A[i];

            while(left < right){
                int sum = A[left] + A[right];

                if(sum == remainingSum){
                    ans = true;
                    break;
                }
                else if(sum < remainingSum)
                    left++;
                else
                    right--;
            }
        }
        return ans;
    }


    // 5. Two Sum (Generated to Match Your Style)
    public boolean twoSum(int nums[], int target) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;

        while(i < j){
            int sum = nums[i] + nums[j];

            if(sum == target)
                return true;

            if(sum < target)
                i++;
            else
                j--;
        }
        return false;
    }
}
