package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(TreeNode root){
        if(root == null){
            return;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = null;
        TreeNode previousNode = null; // Initialize once to null outside of the while loop
        int currentLevelSize;

        queue.add(root);

        while(!queue.isEmpty()){
            currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.poll();

                if(previousNode != null){
                    previousNode.next = currentNode;
                };

                previousNode = currentNode; // Connect all nodes with each other. The last node will automatically point to null

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                };
            };
        };
    };
};

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     ConnectAllSiblings.connect(root);

//     // level order traversal using 'next' pointer
//     TreeNode current = root;
//     System.out.println("Traversal using 'next' pointer: ");
//     while (current != null) {
//       System.out.print(current.val + " ");
//       current = current.next;
//     };
// }