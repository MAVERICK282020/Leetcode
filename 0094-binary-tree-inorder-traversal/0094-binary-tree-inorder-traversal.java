
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Visit the node
            curr = stack.pop();
            result.add(curr.val);

            // Process the right subtree
            curr = curr.right;
        }

        return result;
    }
}
