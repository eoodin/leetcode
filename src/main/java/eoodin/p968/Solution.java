package eoodin.p968;

class Solution {
    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(1, findMin(true, false, root));
    }

    private int findMin(boolean coveredByParent, boolean tobeCovered, TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null){
            return coveredByParent ? 0 : 1;
        }

        if (coveredByParent) {
            int minHasCam, minHasNoCam;
            minHasNoCam = findMin(false, false, node.left) + findMin(false, false, node.right);
            if (tobeCovered) return minHasNoCam;
            minHasCam = 1 + findMin( true, false, node.left) + findMin(true, false, node.right);
            return Math.min(minHasCam, minHasNoCam);
        } else {
            if (tobeCovered) {
                return  findMin(true, false, node.left) + findMin( true, false, node.right) + 1;
            }
            return Math.min(
                    findMin(true, false, node.left) + findMin( true, false, node.right) + 1,
                    findMin(false, true, node.left) + findMin( false, true, node.right)
            );
        }
    }
}