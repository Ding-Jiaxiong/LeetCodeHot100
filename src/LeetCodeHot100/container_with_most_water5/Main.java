package LeetCodeHot100.container_with_most_water5;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 思路: 双指针，设两指针 i , j ，指向的水槽板高度分别为 h[i] , h[j] ，此状态下水槽面积为 S(i,j) 。S(i,j)=min(h[i],h[j])×(j−i) 优雅
 *
 * @author Ding Jiaxiong
 */
public class Main {

    public static int maxArea(int[] height) {

        int left = 0; // 左指针从左端开始
        int right = height.length - 1; // 右指针从右端开始

        int maxres = 0; // 最大面积

        while (left < right) { // 两指针相遇结束循环

            maxres = height[left] < height[right] ?
                    Math.max(maxres, (right - left) * height[left++]) :  // 左指针指向小于右指针指向，宽度都是一样的，高度应该是
                    Math.max(maxres, (right - left) * height[right--]);


        }

        return maxres;

    }

    public static void main(String[] args) {

        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(heights));

    }

}
