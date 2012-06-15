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
import java.util.LinkedList;

public class Problem15 {
    static int WIDTH = 3;
    static int NUM_NODES = WIDTH * WIDTH;
    private static int paths = 0;
    static int UNDISCOVERED = 0;
    static int DISCOVERED = 1;
    static int PROCESSED = 2;

    public static void main(String[] args) {
        numberOfShortestPaths();
        System.out.println(paths + " paths");
    }

    public static void numberOfShortestPaths() {
        ArrayList<ArrayList<Integer>> adjacencyList = buildGraph();
        boolean[] processed = new boolean[NUM_NODES];
        DFS(0, 3, adjacencyList, processed);
    }

    public static void DFS(int start, int end, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] processed) {
        if (start == end) {
            paths++;
            return;
        }
        for (int child : adjacencyList.get(start)) {
            processed[child] = true;
            DFS(child, end, adjacencyList, processed);
        }

    }

    private static ArrayList<ArrayList<Integer>> buildGraph() {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < NUM_NODES; i++) {
            int rowStart = i - i % WIDTH;
            int rowEnd = i + WIDTH - i % WIDTH - 1;

            ArrayList<Integer> l = new ArrayList<Integer>();
            if (i + 1 <= rowEnd) l.add(i + 1);
            if (i - 1 >= rowStart) l.add(i - 1);
            if (i + WIDTH <= NUM_NODES - 1) l.add(i + WIDTH);
            if (i - WIDTH >= 0) l.add(i - WIDTH);

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
