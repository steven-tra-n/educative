package TreeBreadthFirstSearch;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        int levelSize;
        TreeNode currentNode;

        queue.add(root); // Add initial node

        while(!queue.isEmpty()){
            levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(); // New list for each while loop

            for(int i = 0; i < levelSize; i++){
                currentNode = queue.remove(); // Pop and add to current level
                currentLevel.add(currentNode.val);

                if(currentNode != null){
                    if(currentNode.left != null){
                        queue.add(currentNode.left);
                    };

                    if(currentNode.right != null){
                        queue.add(currentNode.right);
                    };
                };
            };

            result.add(currentLevel); // After all level nodes are added, we can add to result
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
//     List<List<Integer>> result = LevelOrderTraversal.traverse(root);
//     System.out.println("Level order traversal: " + result);