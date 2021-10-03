package TreeBreadthFirstSearch;

import java.util.*;

public class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        int minDepth = 0;

        if(root == null){
            return minDepth;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        int currentLevelSize;

        queue.add(root);

        while(!queue.isEmpty()){
            currentLevelSize = queue.size();
            minDepth++;

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.remove();

                if(currentNode.left!= null){
                    queue.add(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                };

                if(currentNode.left == null && currentNode.right == null){
                    return minDepth; // The first time both left and right nodes will be the minimum
                };
            };
        };

        return minDepth;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
//     root.left.left = new TreeNode(9);
//     root.right.left.left = new TreeNode(11);
//     System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));