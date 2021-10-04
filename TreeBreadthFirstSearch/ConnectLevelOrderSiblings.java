package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        if(root == null){
            return;
        };

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        int currentLevelSize;

        queue.offer(root);

        while(!queue.isEmpty()){
            currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++){
                currentNode = queue.poll();

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                };

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                };

                if(i + 1 == currentLevelSize){ // Reached end of level
                    currentNode.next = null; 
                } else{
                    currentNode.next = queue.peek(); // Attach to next level node
                };
            };
        };
    };
};

// // level order traversal using 'next' pointer
// void printLevelOrder() {
//     TreeNode nextLevelRoot = this;
//     while (nextLevelRoot != null) {
//       TreeNode current = nextLevelRoot;
//       nextLevelRoot = null;
//       while (current != null) {
//         System.out.print(current.val + " ");
//         if (nextLevelRoot == null) {
//           if (current.left != null)
//             nextLevelRoot = current.left;
//           else if (current.right != null)
//             nextLevelRoot = current.right;
//         }
//         current = current.next;
//       }
//       System.out.println();
//     }
//   }
// };

// TreeNode root = new TreeNode(12);
//     root.left = new TreeNode(7);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(9);
//     root.right.left = new TreeNode(10);
//     root.right.right = new TreeNode(5);
//     ConnectLevelOrderSiblings.connect(root);
//     System.out.println("Level order traversal using 'next' pointer: ");
//     root.printLevelOrder();