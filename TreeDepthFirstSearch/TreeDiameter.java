package TreeDepthFirstSearch;

public class TreeDiameter {
    private static int maxDiameter = 0;

    public static int findDiameter(TreeNode root){
        dfs(root);

        return maxDiameter;
    };

    public static int dfs(TreeNode node){
        if(node == null){
            return 0;
        };

        int leftTreeHeight = dfs(node.left);
        int rightTreeHeight = dfs(node.right);

        // Check if not leaf nodes
        if(leftTreeHeight != 0 && rightTreeHeight != 0){
            // Diameter will be height plus current node (1)
            int currentDiameter = leftTreeHeight + rightTreeHeight + 1;

            maxDiameter = Integer.max(maxDiameter, currentDiameter);
        };

        // Return the higher tree branch
        return Integer.max(leftTreeHeight, rightTreeHeight) + 1;
    };
};

// TreeNode root = new TreeNode(1);
//     root.left = new TreeNode(2);
//     root.right = new TreeNode(3);
//     root.left.left = new TreeNode(4);
//     root.right.left = new TreeNode(5);
//     root.right.right = new TreeNode(6);
//     System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
//     root.left.left = null;
//     root.right.left.left = new TreeNode(7);
//     root.right.left.right = new TreeNode(8);
//     root.right.right.left = new TreeNode(9);
//     root.right.left.right.left = new TreeNode(10);
//     root.right.right.left.left = new TreeNode(11);
//     System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));