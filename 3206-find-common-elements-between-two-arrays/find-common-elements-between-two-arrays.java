class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Populate sets with unique elements
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        int answer1 = 0;
        int answer2 = 0;

        // Calculate answer1
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                answer1++;
            }
        }

        // Calculate answer2
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                answer2++;
            }
        }

        return new int[]{answer1, answer2};
    }
}