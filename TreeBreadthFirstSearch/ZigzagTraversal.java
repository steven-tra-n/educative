package TreeBreadthFirstSearch;

import java.util.*;

public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        int currentLevelSize;
        boolean zigZag = false; 

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.remove();

                if(zigZag){ // Alternate reversal
                    currentLevel.add(0, currentNode.val);
                } else{
                    currentLevel.add(currentNode.val);
                };

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                };
            };

            zigZag = !zigZag;
            result.add(currentLevel);
        };

        return result;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     root.right.left.left = new TreeNode(20);
//     root.right.left.right = new TreeNode(17);
//     List<List<Integer>> result = ZigzagTraversal.traverse(root);
//     System.out.println("Zigzag traversal: " + result);