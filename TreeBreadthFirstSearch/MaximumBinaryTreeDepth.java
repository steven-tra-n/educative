package TreeBreadthFirstSearch;

import java.util.*;

public class MaximumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if(root == null){
            return -1;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        int currentLevelSize;
        int maxDepth = 0;

        queue.add(root);

        while(!queue.isEmpty()){
            currentLevelSize = queue.size();
            maxDepth++;

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.remove();

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                };
            };
        };

        return maxDepth;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));
//     root.left.left = new TreeNode(9);
//     root.right.left.left = new TreeNode(11);
//     System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));