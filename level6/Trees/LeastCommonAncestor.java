package com.dr.level6.Trees;
/*Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest
 (i.e. deepest) node that has both v and w as descendants.
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.*/
public class LeastCommonAncestor {
    static int n11,n22;

    public int lca(TreeNode a, int val1, int val2) {
        n11=n22=0;

        TreeNode result=calLca(a,val1,val2);
        int a1;

        if(n11==0||n22==0)
            return -1;
        if(result==null)
            a1=-1;
        else
            a1=result.val;

        return a1;
    }

    TreeNode calLca(TreeNode root,int n1,int n2){
        if(root==null)
            return null;

        TreeNode left=calLca(root.left,n1,n2);
        TreeNode right=calLca(root.right,n1,n2);

        if(n1==root.val)
            n11=1;
        if(n2==root.val)
            n22=1;
        if(n1==root.val || n2==root.val)
            return root;
        if(left!=null && right!=null)
            return root;
        if(left==null && right==null)
            return null;
        if(left==null)
            return right;
        else
            return left;
    }

    public static void main(String[] args){

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(2);
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(4);

        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(8);

        System.out.println(new LeastCommonAncestor().lca(tree, 7,4));
    }
}
