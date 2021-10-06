package TreeDepthFirstSearch;

import TreeBreadthFirstSearch.TreeNode;

public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum){
        if(root == null){
            return false;
        };

        // Current node has subtracted values to equal sum
        if(root.val == sum && root.left == null && root.right == null){
            return true;
        };

        // Recursion
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
//     System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));