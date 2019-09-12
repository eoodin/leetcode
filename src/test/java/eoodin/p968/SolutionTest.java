package eoodin.p968;

import org.junit.Test;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {

    @Test
    public void mytest1() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        Assert.assertEquals(1, solution.minCameraCover(root));
    }

    @Test
    public void mytest2() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0, new TreeNode(0), null);
        Assert.assertEquals(1, solution.minCameraCover(root));
    }

    @Test
    public void exampleTest1() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(0)),
                null);


        int num = solution.minCameraCover(root);
        Assert.assertEquals(1, num);
    }

    @Test
    public void exampleTest2() {
        Solution solution = new Solution();
        TreeNode root =
                new TreeNode(0,
                    new TreeNode(0,
                        new TreeNode(0,
                            new TreeNode(0,
                            null,
                                 new TreeNode(0)),null),
                        null),
                null);

        int num = solution.minCameraCover(root);
        Assert.assertEquals(2, num);
    }

    @Test
    public void exampleTest3() {
        Solution solution = new Solution();
        TreeNode root = stringToTreeNode("[0,0,null,null,0,0,null,null,0,0]");
        int num = solution.minCameraCover(root);
        Assert.assertEquals(2, num);
    }
    @Test
    public void exampleTest4() {
        Solution solution = new Solution();
        TreeNode root = stringToTreeNode("[0,null,0,null,0,null,0]");
        int num = solution.minCameraCover(root);
        Assert.assertEquals(2, num);
    }

    static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


}
