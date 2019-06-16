package main.java.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {

    class QueueNode {
        int x;
        int y;
        int dist;

        public QueueNode(int x,int y,int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private boolean isValid(int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<QueueNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new QueueNode(0,0,1));

        int[] colVector = new int[]{1,0,-1,0,1,1,-1,-1};
        int[] rowVector = new int[]{0,1,0,-1,-1,1,-1,1};

        while (!bfsQueue.isEmpty()) {
            QueueNode top = bfsQueue.peek();
            if (top.x==n-1 && top.y==n-1) return top.dist;

            bfsQueue.poll();

            for (int i=0;i<8;++i) {
                for (int j=0;j<8;++j) {
                    int x = top.x + colVector[i];
                    int y = top.y + rowVector[j];
                    if (isValid(x,y,n) && grid[x][y]==0 && !visited[x][y]) {
                        visited[x][y] = true;
                        bfsQueue.offer(new QueueNode(x,y,top.dist+1));
                    }
                }
            }
        }

        return -1;
    }
}
