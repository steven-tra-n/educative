package TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum){
        List<List<Integer>> allPaths = new ArrayList<>();

        if(root == null){
            return allPaths;
        };

        List<Integer> currentPath = new ArrayList<>();

        // findPathsRecursion(root, sum, allPaths, currentPath);
        // findAllPathsRecursion(root, allPaths, currentPath);
        findMaxPathNodeSum(root);

        return allPaths;
    };

    public static void findPathsRecursion(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currentPath){
        if(root == null){
            return;
        };

        currentPath.add(root.val);

        // Check if root is a leaf node
        if(root.val == sum && root.left == null && root.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
            // return;
        } else{
            findPathsRecursion(root.left, sum - root.val, allPaths, currentPath);
            findPathsRecursion(root.right, sum - root.val, allPaths, currentPath);
        };

        // Must pass a new ArrayList so that we are not passing the same list
        currentPath.remove(currentPath.size() - 1);
    };

    public static void findAllPathsRecursion(TreeNode root, List<List<Integer>> allPaths, List<Integer> currentPath){
        if(root == null){
            return;
        };

        currentPath.add(root.val);

        if(root.left == null && root.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else{
            findAllPathsRecursion(root.left, allPaths, currentPath);
            findAllPathsRecursion(root.right, allPaths, currentPath);
        };

        currentPath.remove(currentPath.size() - 1);
    };

    public static int max = Integer.MIN_VALUE;

    public static int findMaxPathNodeSum(TreeNode root){
        postOrderMaxPathNodeSum(root);

        return max;
    };

    public static int postOrderMaxPathNodeSum(TreeNode root){
        if(root == null){
            return 0;
        };

        // Keep traversing until we hit leafs
        int left = Math.max(postOrderMaxPathNodeSum(root.left), 0);
        int right = Math.max(postOrderMaxPathNodeSum(root.right), 0);

        // Check if subtree will have highest sum path
        max = Integer.max(max, left + right + root.val);

        return Integer.max(left, right) + root.val;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(4);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     int sum = 23;
//     List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
//     System.out.println("Tree paths with sum " + sum + ": " + result);