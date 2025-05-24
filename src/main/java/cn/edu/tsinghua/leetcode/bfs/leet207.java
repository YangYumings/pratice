package cn.edu.tsinghua.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet207 {
    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */


    /**
     * 方法一：BFS
     */
    static List<List<Integer>> edges;
    static int[] indeg;

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        // init edges
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        // cal indeg
        indeg = new int[numCourses];
        for (int[] target : prerequisites) {
            edges.get(target[1]).add(target[0]);
            ++indeg[target[0]];
        }

        // init queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int index = queue.poll();
            for (int v : edges.get(index)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    /**
     * 方法二：DFS
     * visited 三种状态
     * 0：未访问
     * 1：正在访问
     * 2：已经访问
     */
    static int[] visited;
    // 用于表示是否存在环
    static boolean valid = true;

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // init edges
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        // init vis
        visited = new int[numCourses];
        for (int[] pair : prerequisites) {
            edges.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < numCourses & valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public static void dfs(int index) {
        visited[index] = 1;
        for (int v : edges.get(index)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
                // 再次访问正在访问的一个点说明存在环
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[index] = 2;
    }
}
