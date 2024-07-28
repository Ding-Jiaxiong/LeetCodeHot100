package LeetCodeHot100.median_of_two_sorted_arrays68;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 思路：hard 二分【大厂不准】
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m + n];

        //  特判
        if (m == 0) {

            if (n % 2 == 0) { // 第二个数组是偶数个元素

                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }

        if (n == 0) {

            if (m % 2 == 0) { // 第一个数组是偶数个元素

                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {

                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while (count != (m + n)) {

            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
