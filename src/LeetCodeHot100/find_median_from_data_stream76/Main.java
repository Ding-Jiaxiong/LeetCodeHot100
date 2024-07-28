package LeetCodeHot100.find_median_from_data_stream76;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 实现 MedianFinder 类
 * <p>
 * 思路：根据需要对堆进行操作
 *
 * @author Ding Jiaxiong
 */

public class Main {

    class MedianFinder {

        Queue<Integer> A, B;

        public MedianFinder() {

            A = new PriorityQueue<>();  // 小顶堆
            B = new PriorityQueue<>((x, y) -> (y - x));  // 大顶堆
        }

        public void addNum(int num) {

            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }

        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {


    }
}
