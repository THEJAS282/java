class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int maxCount = 0;
        int count = 0;

        // Helper function: check if char is vowel
        java.util.function.Predicate<Character> isVowel = 
            c -> "aeiou".indexOf(c) != -1;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel.test(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;

        // Slide the window
        for (int i = k; i < n; i++) {
            if (isVowel.test(s.charAt(i))) {
                count++;
            }
            if (isVowel.test(s.charAt(i - k))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);

            // Early exit if we reach maximum possible
            if (maxCount == k) return k;
        }

        return maxCount;
    }
}
