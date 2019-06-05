package main.java.quadtree;

public class QuadTree {
    public Node construct(int[][] grid) {
        return construct(grid,new int[]{0,0},grid.length,grid.length);
    }

    private Node construct(int[][] grid, int[] topLeft, int y, int x) {
        Node node = new Node();
        int num = grid[topLeft[0]][topLeft[1]];
        boolean isSet = false;
        for (int i=topLeft[0];i<y;i++) {
            if (isSet) break;
            for (int j=topLeft[1];j<x;j++) {
                if (grid[i][j]!=num) {
                    node.topLeft = construct(grid, new int[]{topLeft[0], topLeft[1]},
                            (topLeft[0]+y) / 2, (topLeft[1] + x) / 2);
                    node.bottomLeft = construct(grid, new int[]{(topLeft[0]+y) / 2, topLeft[1]},
                            y, (topLeft[1] + x) / 2);
                    node.topRight = construct(grid, new int[]{topLeft[0], (topLeft[1] + x) / 2},
                            (topLeft[0]+y) / 2, x);
                    node.bottomRight = construct(grid, new int[]{(topLeft[0]+y) / 2, (topLeft[1] + x) / 2},
                            y, x);
                    isSet = true;
                    break;
                }
            }
        }

        if (!isSet) node.val = num==1;
        else node.val = true;

        node.isLeaf = !isSet;
        return node;
    }

    public static void main(String[] args) {
        QuadTree qt = new QuadTree();
        Node n = qt.construct(new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        });
        System.out.println(n.topRight.topLeft.val);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        public Node() {}
        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}