package cn.zeromax.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树算法类
 */
public class BinaryTreeAlgorithm { // TODO: 先序中序后序还是有很多相似之处，能否尝试合并？
    /**
     * 先序遍历二叉树
     * TODO: 目前resultList的效率很低，日后优化。
     * TODO: 还有一个目标就是将执行的内容将来用lambda表达式做成函数式参数传递。
     *
     * @param root 根节点
     * @param <T>  二叉树存储的内容类型
     * @return 二叉树存储内容的先序遍历列表
     */
    public static <T> List<T> preOrderTraversal(BinaryTreeNode<T> root) {
        List<T> resultList = new LinkedList<>();
        if (root == null) return resultList;
        resultList.add(root.getVal());
        if (root.getLeft() != null) {
            resultList.addAll(preOrderTraversal(root.getLeft()));
        }
        if (root.getRight() != null) {
            resultList.addAll(preOrderTraversal(root.getRight()));
        }
        return resultList;
    }

    /**
     * 中序遍历二叉树
     * TODO: 目前resultList的效率很低，日后优化。
     * TODO: 还有一个目标就是将执行的内容将来用lambda表达式做成函数式参数传递。
     *
     * @param root 根节点
     * @param <T>  二叉树存储内容类型
     * @return 二叉树存储内容中序遍历列表
     */
    public static <T> List<T> inOrderTraversal(BinaryTreeNode<T> root) {
        List<T> resultList = new LinkedList<>();
        if (root == null) return resultList;
        if (root.getLeft() != null) {
            resultList.addAll(inOrderTraversal(root.getLeft()));
        }
        resultList.add(root.getVal());
        if (root.getRight() != null) {
            resultList.addAll(inOrderTraversal(root.getRight()));
        }
        return resultList;
    }

    /**
     * 后序遍历二叉树
     * TODO: 目前resultList的效率很低，日后优化。
     * TODO: 还有一个目标就是将执行的内容将来用lambda表达式做成函数式参数传递。
     *
     * @param root 根节点
     * @param <T>  二叉树存储内容类型
     * @return 二叉树存储内容后序遍历列表
     */
    public static <T> List<T> postOrderTraversal(BinaryTreeNode<T> root) {
        List<T> resultList = new LinkedList<>();
        if (root == null) return resultList;
        if (root.getLeft() != null) {
            resultList.addAll(postOrderTraversal(root.getLeft()));
        }
        if (root.getRight() != null) {
            resultList.addAll(postOrderTraversal(root.getRight()));
        }
        resultList.add(root.getVal());
        return resultList;
    }

    /**
     * 层次遍历二叉树
     *
     * @param root 根节点
     * @param <T>  二叉树存储内容类型
     * @return 二叉树存储内容层次遍历列表
     */
    public static <T> List<T> levelTraversal(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        List<T> resultList = new LinkedList<>();
        if (root == null) return resultList;
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i = queue.size();i>0;i--){
                BinaryTreeNode<T> node = queue.poll();
                assert node != null;
                // TODO: 这里能试试用java8的Optional吗？不加断言后面会报警告，node.getXXX()可能导致空指针异常（虽然实际上自己写是不会为空，但想练习一下Optional的使用）
                if(node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }
                if(node.getRight()!=null){
                    queue.offer(node.getRight());
                }
                resultList.add(node.getVal());
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        root.setLeft(left);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        root.setRight(right);
        BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<>(4);
        right.setLeft(rightLeft);
        BinaryTreeNode<Integer> rightRight = new BinaryTreeNode<>(5);
        right.setRight(rightRight);
        // BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(99);
        // left.setLeft(leftLeft);
        System.out.println(preOrderTraversal(root)); // [1, 2, 3, 4, 5]
        System.out.println(inOrderTraversal(root)); // [2, 1, 4, 3, 5]
        System.out.println(postOrderTraversal(root)); // [2, 4, 5, 3, 1]
        System.out.println(levelTraversal(root)); // [1, 2, 3, 4, 5]
    }
}
