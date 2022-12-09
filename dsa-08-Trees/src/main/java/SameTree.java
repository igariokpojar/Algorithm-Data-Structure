public class SameTree {
/*
Given the roots of two binary trees 'p' and 'q' , write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value
 */
    public static boolean isSameTree(TNode p, TNode q){
        // p and q are both null
        if (p==null && q==null)return true;

        // one of p and q is null
        if (q==null || p==null)return false;

        if (p.value != q.value)return false;

        return isSameTree(p.rightChild,q.rightChild) && isSameTree(p.leftChild,q.leftChild);
    }
}

