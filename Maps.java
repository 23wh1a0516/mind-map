import java.util.*;

public class Maps {

    // Count Frequencies
    public void countFrequices(String word){
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch : word.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
        }

        for(char ch : freq.keySet()){
            System.out.println(ch + " : " + freq.get(ch));
        }
    }

    // First non-repeating element
    public void firstNonRepeating(String word){
        LinkedHashMap<Character,Integer> freq = new LinkedHashMap<>();
        for(char ch : word.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
        }

        int flag = 0;
        for(char ch : freq.keySet()){
            if(freq.get(ch) == 1){
                System.out.println(ch);
                flag = 1;
                break;
            }
        }

        if(flag == 0) System.out.println("No such element");
    }

    // Majority element
    public int majorityElement(List<Integer> nums){
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        int len = nums.size();
        for(int num : freq.keySet()){
            if(freq.get(num) > len/2){
                return num;
            }
        }

        return -1;
    }

    // count distinct elements

    public int countDistinctElements(List<Integer> nums){
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        return freq.size();
    }

    
}
