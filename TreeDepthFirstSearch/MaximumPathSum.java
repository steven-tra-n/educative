package TreeDepthFirstSearch;

public class MaximumPathSum {
    private static int maxSum;

    public static int findMaximumPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        dfs(root);

        return maxSum;
    };

    public static int dfs(TreeNode node){
        if(node == null){
            return 0;
        };

        int maxLeftSum = dfs(node.left);
        int maxRightSum = dfs(node.right);

        // Ignore negatives, since we need to find the maxmimum sum we should
        // ignore any path which has an overall negative sum

        maxLeftSum = Math.max(maxLeftSum, 0);
        maxRightSum = Math.max(maxRightSum, 0);

        int currentSum = maxLeftSum + maxRightSum + node.val;

        maxSum = Math.max(maxSum, currentSum);

        return Math.max(maxLeftSum, maxRightSum) + node.val;
    };
};

// TreeNode root = new TreeNode(1);
// root.left = new TreeNode(2);
// root.right = new TreeNode(3);
// System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

// root.left.left = new TreeNode(1);
// root.left.right = new TreeNode(3);
// root.right.left = new TreeNode(5);
// root.right.right = new TreeNode(6);
// root.right.left.left = new TreeNode(7);
// root.right.left.right = new TreeNode(8);
// root.right.right.left = new TreeNode(9);
// System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

// root = new TreeNode(-1);
// root.left = new TreeNode(-3);
// System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));