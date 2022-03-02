package com.company.customBinarySearchTree;

public class BinarySearchTreeImpl {

    public Node root;

    public void customAddNode(Object data){

        Node newNode = new Node(data);
        Node y = null;
        Node x = root;

        //traverses through the tree until you find the place where x is null
        while(x != null){
            y = x;
            // if the newNode is less than the x value, we traverse left down the tree
            if((int)newNode.data < (int)x.data){
                x = x.left;
            }else{
                //if the newNode is greater than the x value, we traverse right down the tree
                x = x.right;
            }
        }

        // if the value y is equal to null that means tree is empty and we set the newNode to the root
        if(y == null)
        {
            root = newNode;
        }
        //if the newNode data is less than the data from y we set it to the left child
        else if((int)newNode.data < (int)y.data)
        {
            y.left = newNode;
        }
        //if the newNode data is greater than the data from y we set it to the right child
        else
        {
            y.right = newNode;
        }

        //This algorithm was taken from the "Introduction to Algorithms: Third Edition" by Thomas Cormen et. all

    }

    public void addNode(Object data) {
        // Create a new Node and initialize it
        Node newNode = new Node(data);
        // If there is no root this becomes root
        if (root == null) {
            root = newNode;
        } else {
            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;
            // Future parent for our new Node
            Node parent;
            while (true) {
                // root is the top parent so we start
                // there
                parent = focusNode;
                // Check if the new node should go on
                // the left side of the parent node
                if ((int)data < (int)focusNode.data) {
                    // Switch focus to the left child
                    focusNode = focusNode.left;
                    // If the left child has no children
                    if (focusNode == null) {
                        // then place the new node on the left of it
                        parent.left = newNode;
                        return; // All Done
                    }
                } else { // If we get here put the node on the right
                    focusNode = focusNode.right;
                    // If the right child has no children
                    if (focusNode == null) {
                        // then place the new node on the right of it
                        parent.right = newNode;
                        return; // All Done
                    }
                }
            }
        }
    }
    // The add method was taken from this website
    //https://www.newthinktank.com/2013/03/binary-tree-in-java/

    public void deleteNode(int key) {
        root = deleteNode(key, root);
    }

    Node deleteNode(int key, Node node) {
        // No node at current position --> go up the recursion
        if (node == null) {
            return null;
        }

        // Traverse the tree to the left or right depending on the key
        if (key < (int)node.data) {
            node.left = deleteNode(key, node.left);
        } else if (key > (int)node.data) {
            node.right = deleteNode(key, node.right);
        }

        // At this point, "node" is the node to be deleted

        // Node has no children --> just delete it
        else if (node.left == null && node.right == null) {
            node = null;
        }

        // Node has only one child --> replace node by its single child
        else if (node.left == null) {
            node = node.right;
        } else if (node.right == null) {
            node = node.left;
        }

        // Node has two children
        else {
            deleteNodeWithTwoChildren(node);
        }

        return node;
    }

    private void deleteNodeWithTwoChildren(Node node) {
        // Find minimum node of right subtree ("inorder successor" of current node)
        Node inOrderSuccessor = findMinimum(node.right);

        // Copy inorder successor's data to current node
        node.data = inOrderSuccessor.data;

        // Delete inorder successor recursively
        node.right = deleteNode((int)inOrderSuccessor.data, node.right);
    }

    private Node findMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }
        Node temp = node.right;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    private static class Node{

        Object data;
        Node right;
        Node left;

        public Node(Object data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

}
