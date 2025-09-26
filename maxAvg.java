class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException("Window size is larger than array.");
        }

        double windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum; // ✅ initialize correctly

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }

    // ✅ Main method to run the program
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Max Average: " + sol.findMaxAverage(nums1, k1)); 
        // Expected: 12.75

        // Example 2
        int[] nums2 = {-5, -2, -3, -4};
        int k2 = 2;
        System.out.println("Max Average: " + sol.findMaxAverage(nums2, k2)); 
        // Expected: -2.5
    }
}
