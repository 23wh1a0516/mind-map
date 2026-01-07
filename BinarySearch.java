import java.util.*;
class BinarySearch {

    public int MinimumInRotatedArray(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int floorSqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int p : piles) {
                hours += (int) Math.ceil((double) p / mid);
            }

            if (hours <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int allocateBooks(int[] pagesArr, int numStudents) {
        if (numStudents > pagesArr.length) return -1;

        int left = 0, right = 0;
        for (int pages : pagesArr) {
            left = Math.max(left, pages);
            right += pages;
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int studentsRequired = 1;
            int pagesSum = 0;

            for (int pages : pagesArr) {
                if (pagesSum + pages > mid) {
                    studentsRequired++;
                    pagesSum = pages;
                } else {
                    pagesSum += pages;
                }
            }

            if (studentsRequired <= numStudents) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
