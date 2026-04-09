
package TreePackage;

/**
 * An implementation of the ADT Binary Node.
 * 
 */
class BinaryNode<T> {

    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;
    private BinaryNode<T> parent; // ADD PRIVATE VARIABLEs TO HOLD A PRARENT REFERENCE
    private BinaryNode<T> thread; // AND A THREAD REFERENCE HERE

    public BinaryNode() {
        this(null); // Call next constructor
    } // end default constructor

    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null); // Call next constructor
    } // end constructor

    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
            BinaryNode<T> newRightChild), BinaryNode<T> parent, BinaryNode<T> thread) {
        // MODIFY THIS CONSTRUCTOR
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
        this.parent = parent;
        this.thread = thread;
    } // end constructor

    // ADD TWO MORE CONSTRUCTORS
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
                      BinaryNode<T> newRightChild) {
        this(dataPortion, newLeftChild, newRightChild, null);
    }

    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
                      BinaryNode<T> newRightChild, BinaryNode<T> parent) {
        this(dataPortion, newLeftChild, newRightChild, parent, null);
    }




    /**
     * Retrieves the data portion of this node.
     *
     * @return The object in the data portion of the node.
     */
    public T getData() {
        return data;
    } // end getData

    /**
     * Sets the data portion of this node.
     *
     * @param newData The data object.
     */
    public void setData(T newData) {
        data = newData;
    } // end setData

    /**
     * Retrieves the left child of this node.
     *
     * @return The node that is this node's left child.
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    } // end getLeftChild

    /**
     * Sets this node's left child to a given node.
     *
     * @param newLeftChild A node that will be the left child.
     */
    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    } // end setLeftChild

    /**
     * Detects whether this node has a left child.
     *
     * @return True if the node has a left child.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    } // end hasLeftChild

    /**
     * Retrieves the right child of this node.
     *
     * @return The node that is this node's right child.
     */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    } // end getRightChild

    /**
     * Sets this nodes's right child to a given node.
     *
     * @param newRightChild A node that will be the right child.
     */
    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    } // end setRightChild

    /**
     * Detects whether this node has a right child.
     *
     * @return True if the node has a right child.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    } // end hasRightChild

    /**
     * Detects whether this node is a leaf.
     *
     * @return True if the node is a leaf.
     */
    // ADD IN ANOTHER COPY THAT TAKES A PARENT REFERENCE
    public BinaryNode<T> getParent() {
        return parent;
    }

    // ADD IN ACCESSORS FOR THE PARENT REFERENCE
    public void setParent(BinaryNode<T> p) {
        parent = p;
    }
    public boolean hasParent() {
        return parent != null;
    }

    // AND THREAD REFERENCE
    public BinaryNode<T> getThread() {
        return thread;
    }
    public void setThread(BinaryNode<T> target) {
        thread = target;
    }
    public boolean hasThread() {
        return thread != null;
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    } // end isLeaf

    /**
     * Computes the height of the subtree rooted at this node.
     *
     * @return The height of the subtree rooted at this node.
     */
    public int getHeight() {
        return getHeight(this); // Call private getHeight
    } // end getHeight

    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.getLeftChild()),
                    getHeight(node.getRightChild()));
        }
        return height;
    } // end getHeight

    /**
     * Counts the nodes in the subtree rooted at this node.
     *
     * @return The number of nodes in the subtree rooted at this node.
     */
    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;

        if (leftChild != null) {
            leftNumber = leftChild.getNumberOfNodes();
        }

        if (rightChild != null) {
            rightNumber = rightChild.getNumberOfNodes();
        }

        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes

    /**
     * Copies the subtree rooted at this node.
     *
     * @return The root of a copy of the subtree rooted at this node.
     */
    public BinaryNode<T> copy() {
        return copy(null);
    }

    public BinaryNode<T> copy(BinaryNode<T> p) {
        BinaryNode<T> newRoot = new BinaryNode<T>(data);
        newRoot.setParent(p);
        if (leftChild != null) {
            newRoot.setLeftChild(leftChild.copy(newRoot));
            newRoot.getLeftChild().linkSubtreeThreadOut(newRoot);
        }
        if (rightChild != null) {
            newRoot.setRightChild(rightChild.copy(newRoot));
            newRoot.setThread(newRoot.getRightChild().getLeftmostInSubtree());
        }
        

        return newRoot;
    } // end copy

    // link subtree thread
    public void linkSubtreeThreadOut(BinaryNode<T> linkTo) {
        BinaryNode<T> rightmost = this;
        while (rightmost.hasRightChild()) {
            rightmost = rightmost.getRightChild();
        }
        rightmost.setThread(linkTo);

        //get left most
        public BinaryNode<T> getLeftmostInSubtree() {
            BinaryNode<T> leftmost = this;
            while (leftmost.hasLeftChild()) {
                leftmost = leftmost.getLeftChild();
            }
            return leftmost;
        }






} // end BinaryNode
