package LeetCodeHot100.course_schedule53;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。\
 * <p>
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 思路：DFS
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            indegree[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {

            int pre = queue.poll();
            numCourses--;

            for (Integer cur : adj.get(pre)) {
                if (--indegree[cur] == 0) queue.add(cur);
            }

        }

        return numCourses == 0;

    }

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
