/*
 * -----------------------------------------------------------------------
 *
 * QATARLYST LIMITED
 *
 * -----------------------------------------------------------------------
 *
 * (C) Copyright 2012 Qatarlyst Limited. All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant hereto is,
 *          and remains, the property of Qatarlyst Limited.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Qatarlyst Limited. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Qatarlyst Limited.
 *
 * -----------------------------------------------------------------------
 */

import java.util.ArrayList;

public class Problem15a {
    static int WIDTH = 16;
    static int NUM_NODES = WIDTH * WIDTH;
    private static long paths = 0;

    public static void main(String[] args) {
        numberOfShortestPaths();
        System.out.println(paths + " paths");
    }

    public static void numberOfShortestPaths() {
        ArrayList<ArrayList<Integer>> adjacencyList = buildGraph();
        DFS(0, NUM_NODES - 1, adjacencyList);
    }

    public static void DFS(int start, int end, ArrayList<ArrayList<Integer>> adjacencyList) {
        if (start == end) {
            paths++;
            return;
        }
        for (int child : adjacencyList.get(start)) {
            DFS(child, end, adjacencyList);
        }
    }

    private static ArrayList<ArrayList<Integer>> buildGraph() {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < NUM_NODES; i++) {
            int rowEnd = i + WIDTH - i % WIDTH - 1;

            ArrayList<Integer> l = new ArrayList<Integer>();
            if (i + WIDTH <= NUM_NODES - 1) l.add(i + WIDTH);
            if (i + 1 <= rowEnd) l.add(i + 1);

            adjacencyList.add(l);
        }
        int j = 0;
        for (ArrayList<Integer> list : adjacencyList) {
            System.out.print("neighbors of " + j++ + ": ");
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


        return adjacencyList;

    }
}
