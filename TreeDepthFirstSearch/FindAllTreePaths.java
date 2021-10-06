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

        findPathsRecursion(root, sum, allPaths, currentPath);

        return allPaths;
    };

    public static void findPathsRecursion(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currentPath){
        if(root == null){
            return;
        };

        currentPath.add(root.val);

        // Check if root is a leaf node
        if(root.val == sum && root.left == null && root.right == null){
            allPaths.add(currentPath);
            return;
        };

        findPathsRecursion(root.left, sum - root.val, allPaths, new ArrayList<Integer>(currentPath));
        findPathsRecursion(root.right, sum - root.val, allPaths, new ArrayList<Integer>(currentPath));
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