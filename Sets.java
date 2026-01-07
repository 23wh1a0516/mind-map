import java.util.*;
public class Sets {
    
    // Remove duplicates
    public List<Integer> removeDuplicates(List<Integer> nums){
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(!set.contains(num)){
                ans.add(num);
            }
            set.add(num);
        }

        return ans;
    }

    // Check Existence
    public boolean checkExistance(List<Integer> nums, int num){
        Set<Integer> set = new HashSet<>(nums);
        if(!set.contains(num)) return false;
        return true;
    }

    // Longest Consecutive Sequence length
    public int longestConsecSeq(List<Integer> nums){
        Set<Integer> set = new HashSet<>(nums);
        int maxLen = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int curr = num;
                int count = 0;
                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }

                maxLen = Math.max(maxLen,count);
            }
        }

        return maxLen;
    }

    // Union of arrays
    public List<Integer> unionOfArrays(List<Integer> nums1, List<Integer> nums2){
        Set<Integer> set = new HashSet<>(nums1);
        for(int num : nums2) set.add(num);

        return new ArrayList<>(set);
    }

    // Intersection of arrays
    public List<Integer> intersectOfArrays(List<Integer> nums1, List<Integer> nums2){
        Set<Integer> set = new HashSet<>(nums1);
        List<Integer> res = new ArrayList<>();
        for(int num : nums2){
           if(set.contains(num) && !res.contains(num)) res.add(num);
        }

        return res;
    }

    // Distinct count
    public int countDistinct(List<Integer> nums){
        Set<Integer> set = new HashSet<>(nums);
        return set.size();
    }


    
}
