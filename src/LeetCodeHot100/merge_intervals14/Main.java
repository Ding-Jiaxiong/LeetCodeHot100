package LeetCodeHot100.merge_intervals14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 思路: 排序
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int[][] merge(int[][] intervals) {

        // 特判
        if (intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, new Comparator<int[]>() {  // 按照每个区间的起始值排序

            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> mergedres = new ArrayList<>();  // 结果列表

        for (int i = 0; i < intervals.length; i++) {

            int L = intervals[i][0];  // 当前区间的起始值
            int R = intervals[i][1];  // 当前区间的结束值

            if (mergedres.size() == 0 || mergedres.get(mergedres.size() - 1)[1] < L) {  // 直接添加（mergedres为空，或者当前区间的起始值L大于mergedres中最后一个区间的结束值）
                mergedres.add(new int[]{L, R});
            } else {
                mergedres.get(mergedres.size() - 1)[1] = Math.max(mergedres.get(mergedres.size() - 1)[1], R); // 更新mergedres中最后一个区间的结束值为当前区间结束值和mergedres中最后一个区间结束值的最大值，这样就合并了重叠的区间。
            }

        }

        return mergedres.toArray(new int[mergedres.size()][]);  // 列表转换为二维数组返回

    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        for (int[] ints : merge(intervals)) {

            for (int anInt : ints) {

                System.out.print(anInt + " ");
            }

            System.out.println();

        }
    }

}
