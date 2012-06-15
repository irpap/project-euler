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

public class BFS {
    static int WIDTH = 3;
    static int NUM_NODES = WIDTH * WIDTH;
    static int UNDISCOVERED = 0;
    static int DISCOVERED = 1;
    static int PROCESSED = 2;

    private static void BFS(int start, int end, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] p = new int[NUM_NODES];
        for (int i = 0; i < p.length; i++) p[i] = -1;
        int[] state = new int[NUM_NODES];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        state[start] = DISCOVERED;

        while (!queue.isEmpty()) {

            int node = queue.pollFirst();
            System.out.println("processing " + node);


            for (int child : adjacencyList.get(node)) {
                if (state[child] == UNDISCOVERED) {
                    state[child] = DISCOVERED;
                    p[child] = node;
                    queue.add(child);
                }
            }
            state[node] = PROCESSED;
        }


        System.out.println("parents path: ");
        System.out.println(NUM_NODES - 1);
        int i = p[NUM_NODES - 1];
        System.out.println(i);
        while (p[i] != -1) {
            System.out.println(p[i]);
            i = p[i];
        }

    }


    private static void enqueueChildren(int node, ArrayList<ArrayList<Integer>> adjacencyList, LinkedList<Integer> queue) {
        for (int i : adjacencyList.get(node)) {
            queue.add(i);
        }
    }
}
