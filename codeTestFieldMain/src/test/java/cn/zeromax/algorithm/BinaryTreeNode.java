package cn.zeromax.algorithm;

/**
 * 二叉树结点类
 * @param <T> 二叉树结点内容类型
 */
public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T val;

    BinaryTreeNode(){
    }

    BinaryTreeNode(T val){
        this.val = val;
    }

    BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        this(val);
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
