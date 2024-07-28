package LeetCodeHot100.top_k_frequent_elements75;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 思路：堆
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {

            int num = entry.getKey();
            int count = entry.getValue();

            if (queue.size() == k) {

                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {

                queue.offer(new int[]{num, count});

            }

        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        for (int i : topKFrequent(nums, k)) {
            System.out.print(i + " ");
        }

    }
}
