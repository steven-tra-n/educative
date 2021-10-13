package TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class CountAllPathSum {

    public static int countPaths(TreeNode root, int S){
        List<Integer> currentpath = new ArrayList<>();

        return dfs(root, S, currentpath);
    };

    public static int dfs(TreeNode node, int S, List<Integer> currentPath){
        if(node == null){
            return 0;
        };

        int sum = 0;
        int pathCount = 0;

        currentPath.add(node.val);

        pathCount += dfs(node.left, S, currentPath);
        pathCount += dfs(node.right, S, currentPath);

        // Iterate through currentPath to see if any sums add up to S
        for(int i = currentPath.size() - 1; i >= 0; i--){
            sum += currentPath.get(i);

            if(sum == S){
                pathCount++;
            };
        };

        // Remove current node for backtracking
        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(4);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));