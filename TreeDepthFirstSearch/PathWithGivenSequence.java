package TreeDepthFirstSearch;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence){
        return dfs(root, sequence, 0);
    };

    public static boolean dfs(TreeNode node, int[] sequence, int index){
        if(node == null){
            return false;
        };
        
        // Found matching path
        if(node.left == null && node.right == null && index == sequence.length - 1 && node.val == sequence[index]){
            return true;
        };

        // Out of bounds or doesn't match
        if(index >= sequence.length - 1 || node.val != sequence[index]){
            return false;
        };
        
        return dfs(node.left, sequence, index + 1) || dfs(node.right, sequence, index + 1);            
    };
};

// TreeNode root = new TreeNode(1);
//     root.left = new TreeNode(0);
//     root.right = new TreeNode(1);
//     root.left.left = new TreeNode(1);
//     root.right.left = new TreeNode(6);
//     root.right.right = new TreeNode(5);

//     System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
//     System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));