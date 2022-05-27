package com.company;

import java.util.*;

public class NodeBinarySearchTree {

    public double value;
    public NodeBinarySearchTree Left;
    public NodeBinarySearchTree Right;

    public NodeBinarySearchTree(double value) {
        this.value = value;
    }

    public void insert(double newValue) {

        if (newValue == value) return;

        if (newValue < value) {
            if (Left == null)
                Left = new NodeBinarySearchTree(newValue);

            else Left.insert(newValue);
        } else if (newValue > value) {
            if (Right == null)
                Right = new NodeBinarySearchTree(newValue);

            else Right.insert(newValue);
        }
    }

    public NodeBinarySearchTree get(double value) {
        if (this.value == value)
            return this;

        if (value < this.value) {
            if (Left != null)
                return Left.get(value);
        } else if (value > this.value) {
            if (Right != null)
                return Right.get(value);
        }
        return null;
    }

    public List<Double> getSortedList() {
        List<Double> list = new ArrayList<>();
        InnerGetSortedList(list);
        return list;
    }


    public List<Double> getSortedListForSecondTask() {
        List<Double> list = new ArrayList<>();
        InnerGetSortedList(list);
        Collections.reverse(list);
        return list;
    }

    private void InnerGetSortedList(List<Double> list) {

        //get to the leftest node
        if (Left != null)
            Left.InnerGetSortedList(list);

        list.add(value);

        if (Right != null)
            Right.InnerGetSortedList(list);
    }

    public double min() {
        if (Left != null)
            return Left.min();
        return value;
    }

    public double max() {
        if (Right != null)
            return Right.max();
        return value;
    }

    //поиск в глубину
    public double recursiveSum() {
        double sum = value;
        if (Left != null)
            sum += Left.recursiveSum();
        if (Right != null)
            sum += Right.recursiveSum();

        return sum;
    }

    //поиск в глубину
    public double sumDeep() {
        Stack<NodeBinarySearchTree> stack = new Stack<>();
        stack.push(this);

        double sum = 0;

        while (!stack.isEmpty()) {
            NodeBinarySearchTree nodeBinarySearchTree = stack.pop();
            sum = sum + nodeBinarySearchTree.value;

            if (nodeBinarySearchTree.Right != null)
                stack.push(nodeBinarySearchTree.Right);

            if (nodeBinarySearchTree.Left != null)
                stack.push(nodeBinarySearchTree.Left);
        }

        return sum;

    }

    //поиск в ширину
    public double sumWidth() {
        Queue<NodeBinarySearchTree> queue = new LinkedList<>();
        queue.add(this);

        double sum = 0;

        while (!queue.isEmpty()) {
            NodeBinarySearchTree nodeBinarySearchTree = queue.remove();
            sum = sum + nodeBinarySearchTree.value;

            if (nodeBinarySearchTree.Right != null)
                queue.add(nodeBinarySearchTree.Right);

            if (nodeBinarySearchTree.Left != null)
                queue.add(nodeBinarySearchTree.Left);
        }

        return sum;

    }

}
