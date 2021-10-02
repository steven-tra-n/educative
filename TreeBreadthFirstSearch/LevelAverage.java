package TreeBreadthFirstSearch;

import java.util.*;

public class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        int currentLevelCounter;
        double currentLevelSum = 0;

        queue.add(root);

        while(!queue.isEmpty()){
            currentLevelCounter = queue.size();

            for(int i = 0; i < currentLevelCounter; i++){
                currentNode = queue.remove();
                currentLevelSum += currentNode.val;

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                };
            };

            result.add(currentLevelSum / currentLevelCounter);
            currentLevelSum = 0; // Reset total for next loop
        };

        return result;
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.left.right = new TreeNode(2);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     List<Double> result = LevelAverage.findLevelAverages(root);
//     System.out.print("Level averages are: " + result);