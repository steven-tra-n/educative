package TreeDepthFirstSearch;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return dfs(root, 0);
    };

    public static int dfs(TreeNode node, int sum){
        if(node == null){
            return 0;
        };

        sum = sum * 10 + node.val;

        // Found leaf
        if(node.left == null && node.right == null){
            return sum;
        };

        // Continue adding and traversing until leaf
        return dfs(node.left, sum) + dfs(node.right, sum);
    };
};

// TreeNode root = new TreeNode(1);
//     root.left = new TreeNode(0);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(1);
//     root.right.left = new TreeNode(6);
//     root.right.right = new TreeNode(5);
//     System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));