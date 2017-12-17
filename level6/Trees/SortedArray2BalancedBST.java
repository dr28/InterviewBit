package com.dr.level6.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : [1, 2, 3]
 A height balanced BST  :

 2
 /   \
 1     3
 */
public class SortedArray2BalancedBST {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return null;
        return toBST(a, 0, a.size() -1);
    }

    private TreeNode toBST(List<Integer> nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high)/2;
        TreeNode n = new TreeNode(nums.get(mid));
        n.left = toBST(nums, low, mid - 1);
        n.right = toBST(nums, mid + 1, high);
        return n;
    }
    public static void main(String[] args) {

        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);

        TreeNode result = new SortedArray2BalancedBST().sortedArrayToBST(a);

        Queue q = new LinkedList();
        q.add(result);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();

            System.out.println("node " + node.val);
            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);

        }
    }
}
