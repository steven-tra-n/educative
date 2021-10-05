package TreeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root){
        List<TreeNode> result = new ArrayList<>();

        if(root == null){
            return result;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = null;
        int currentLevelSize = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.poll();

                if(i + 1 == currentLevelSize){
                    result.add(currentNode);
                };

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                };
            };
        };

        return result;
    };
}

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     root.left.left.left = new TreeNode(3);
//     List<TreeNode> result = RightViewTree.traverse(root);
//     for (TreeNode node : result) {
//       System.out.print(node.val + " ");
//     }