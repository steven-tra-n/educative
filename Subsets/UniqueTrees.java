package Subsets;

import java.util.ArrayList;
import java.util.List;

public class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n){
        if(n <= 0){
            return new ArrayList<TreeNode>();
        };
        
        return findUniqueTreesRecursive(1, n);
    };

    public static List<TreeNode> findUniqueTreesRecursive(int start, int end){
        List<TreeNode> result = new ArrayList<>();

        // Base condition, return null for an empty sub-tree
        // Consider n = 1, in this case we will have start = end = 1, this means we should have only one tree
        // We will have two recursive calls, findUniqueTreesRecursive(1, 0) and (2,1)
        // Both of these should return null for the left and the right child
        if(start > end){
            result.add(null);
            return result;
        };

        for(int i = start; i <= end; i++){
            // Making i root of the tree
            List<TreeNode> leftSubTrees = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightSubTrees = findUniqueTreesRecursive(i + 1, end);

            for(TreeNode leftTree : leftSubTrees){
                for(TreeNode rightTree : rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;

                    result.add(root);
                };
            };
        };

        return result;
    };
};

// List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
//     System.out.print("Total trees: " + result.size());