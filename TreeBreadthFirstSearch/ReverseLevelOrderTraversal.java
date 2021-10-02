package TreeBreadthFirstSearch;

import java.util.*;

public class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode currentNode;
    int levelSize;

    queue.add(root);

    while(!queue.isEmpty()){
        List<Integer> currentLevel = new ArrayList<>();
        levelSize = queue.size();

        for(int i = 0; i < levelSize; i++){
            currentNode = queue.remove();
            currentLevel.add(currentNode.val);

            if(currentNode != null){
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                };
            };
        };

        result.add(0, currentLevel); // Add level to beginning of array
    };

    return result;
  };
};
