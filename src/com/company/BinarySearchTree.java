package com.company;

import java.util.List;

public class BinarySearchTree {

    private NodeBinarySearchTree nodeBinarySearchTree;

    public NodeBinarySearchTree get(double value) throws Exception {
        if (nodeBinarySearchTree == null)
            throw new Exception("Дерево пусте!");
        else return nodeBinarySearchTree.get(value);

    }

    public double min() throws Exception {
        if (nodeBinarySearchTree == null)
            throw new Exception("Дерево пусте!");
        else return nodeBinarySearchTree.min();
    }

    public double max() throws Exception {
        if (nodeBinarySearchTree == null)
            throw new Exception("Дерево пусте!");
        else return nodeBinarySearchTree.max();
    }

    public void insert(double value) {
        if (nodeBinarySearchTree == null)
            nodeBinarySearchTree = new NodeBinarySearchTree(value);
        else
            nodeBinarySearchTree.insert(value);
    }

    public List<Double> getSortedList() {
        if (nodeBinarySearchTree != null)
            return nodeBinarySearchTree.getSortedList();
        else return null;

    }

    public List<Double> getSortedListForSecondTask() {
        if (nodeBinarySearchTree != null)
            return nodeBinarySearchTree.getSortedListForSecondTask();
        else return null;

    }


    public double recursiveSum() {
        return nodeBinarySearchTree.recursiveSum();
    }

    public double sumDeep() {
        return nodeBinarySearchTree.sumDeep();
    }

    public double sumWidth() {
        return nodeBinarySearchTree.sumWidth();
    }

     public void remove(double val) {
        nodeBinarySearchTree = remove(nodeBinarySearchTree, val);
    }

    public NodeBinarySearchTree remove(NodeBinarySearchTree nodeBinarySearchTree, double val) {
        if (nodeBinarySearchTree == null)
            return null;
        if (nodeBinarySearchTree.value > val)
            nodeBinarySearchTree.Left = remove(nodeBinarySearchTree.Left, val);
        else if (nodeBinarySearchTree.value < val)
            nodeBinarySearchTree.Right = remove(nodeBinarySearchTree.Right, val);

        else {
            if (nodeBinarySearchTree.Left == null)
                return nodeBinarySearchTree.Right;
            if (nodeBinarySearchTree.Right == null)
                return nodeBinarySearchTree.Left;

            nodeBinarySearchTree.value = nodeBinarySearchTree.Right.min();
            nodeBinarySearchTree.Right = remove(nodeBinarySearchTree.Right, nodeBinarySearchTree.value);
        }
        return nodeBinarySearchTree;
    }

}
