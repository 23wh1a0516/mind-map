class Arrays{

// 1. Count vowels and consonants
    static void countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // 2. Reverse string
    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 3. Anagram check
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // 4. Longest substring without repeating characters
    static int longestUniqueSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
