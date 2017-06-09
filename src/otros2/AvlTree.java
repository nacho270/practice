package otros2;

import java.util.LinkedList;
import java.util.Queue;

public class AvlTree<T extends Comparable<? super T>> {

    private static class AvlNode<T> {

        protected T element;
        protected AvlNode<T> left;
        protected AvlNode<T> right;
        protected int height;

        public AvlNode(final T theElement) {
            this(theElement, null, null);
        }

        public AvlNode(final T theElement, final AvlNode<T> lt, final AvlNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public AvlNode<T> root;

    public AvlTree() {
        root = null;
    }

    public int height(final AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    public int max(final int a, final int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public boolean insert(final T x) {
        try {
            root = insert(x, root);
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    protected AvlNode<T> insert(final T x, AvlNode<T> t) throws Exception {
        if (t == null) {
            t = new AvlNode<>(x);
        } else if (x.compareTo(t.element) < 0) {
            // inserto a izquierda
            t.left = insert(x, t.left);

            // si factor de balance es 2 -> rotar
            if (height(t.left) - height(t.right) == 2) {
                // si el elemento insertado es menor al izquiero del nodo actual -> rotar izquierda
                if (x.compareTo(t.left.element) < 0) {
                    t = rotateLeft(t);
                } else {
                    // si el elemento insertado es mayor o igual al izquiero del nodo actual -> doble rotar izquierda
                    t = doubleRotateLeft(t);
                }
            }
        } else if (x.compareTo(t.element) > 0) {
            // inserto a derecha
            t.right = insert(x, t.right);

            // si factor de balance es 2 -> rotar
            if (height(t.right) - height(t.left) == 2) {
                // si el elemento insertado es mayor al dereche del nodo actual -> rotar derecha
                if (x.compareTo(t.right.element) > 0) {
                    t = rotateRight(t);
                } else {
                    // si el elemento insertado es menor o igual al derecho del nodo actual -> doble rotar derecha
                    t = doubleRorateRight(t);
                }
            }
        } else {
            throw new Exception("Duplicate value");
        }

        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    protected AvlNode<T> rotateLeft(final AvlNode<T> nodoDesbalanceado) {
        // rotacion
        final AvlNode<T> nuevaRaiz = nodoDesbalanceado.left;
        nodoDesbalanceado.left = nuevaRaiz.right;
        nuevaRaiz.right = nodoDesbalanceado;

        // actualizacion de alturas
        nodoDesbalanceado.height = max(height(nodoDesbalanceado.left), height(nodoDesbalanceado.right)) + 1;
        nuevaRaiz.height = max(height(nuevaRaiz.left), nodoDesbalanceado.height) + 1;

        return nuevaRaiz;
    }

    protected AvlNode<T> rotateRight(final AvlNode<T> nodoDesbalanceado) {
        // rotacion
        final AvlNode<T> nuevaRaiz = nodoDesbalanceado.right;
        nodoDesbalanceado.right = nuevaRaiz.left;
        nuevaRaiz.left = nodoDesbalanceado;

        // actualizacion de alturas
        nodoDesbalanceado.height = max(height(nodoDesbalanceado.left), height(nodoDesbalanceado.right)) + 1;
        nuevaRaiz.height = max(height(nuevaRaiz.right), nodoDesbalanceado.height) + 1;

        return nuevaRaiz;
    }

    protected AvlNode<T> doubleRotateLeft(final AvlNode<T> nodoDesbalanceado) {
        // primero roto a derecha (desbalanceo subarbol)
        nodoDesbalanceado.left = rotateRight(nodoDesbalanceado.left);
        // roto a izquierda
        return rotateLeft(nodoDesbalanceado);
    }

    protected AvlNode<T> doubleRorateRight(final AvlNode<T> nodoDesbalanceado) {
        // primero roto a izquieda (desbalanceo subarbol)
        nodoDesbalanceado.right = rotateLeft(nodoDesbalanceado.right);
        // roto a derecha
        return rotateRight(nodoDesbalanceado);
    }

    public String inDepthTraversal() {
        final StringBuilder str = new StringBuilder();
        inDepthTraversal(root, str, " ");
        return str.toString();
    }

    private void inDepthTraversal(final AvlNode<T> t, final StringBuilder str, final String sep) {
        if (t == null) {
            return;
        }
        str.append(t.element.toString());
        str.append(sep);
        inDepthTraversal(t.left, str, sep);
        inDepthTraversal(t.right, str, sep);
    }

    public String inBreathTraversalQueue() {
        final Queue<AvlNode<T>> queue = new LinkedList<>();
        final StringBuilder str = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            final AvlNode<T> tempNode = queue.poll();
            str.append(tempNode.element.toString());
            str.append(" ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return str.toString();
    }

    public String inBreathTraversal() {
        final StringBuilder str = new StringBuilder();
        final int h = height(root);
        for (int i = 1; i <= h; i++) {
            inBreathTraversal(root, i, str, " ");
        }
        return str.toString();
    }

    private void inBreathTraversal(final AvlNode<T> t, final int level, final StringBuilder str, final String sep) {
        if (t == null) {
            return;
        } else if (level == 1) {
            str.append(t.element.toString());
            str.append(sep);
        } else {
            inBreathTraversal(t.left, level - 1, str, sep);
            inBreathTraversal(t.right, level - 1, str, sep);
        }
    }

    private int recursiveHeight(final AvlNode<T> node) {
        if (node == null) {
            return 0;
        }
        final int heightLeft = recursiveHeight(node.left);
        final int heightRight = recursiveHeight(node.right);
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        }
        return heightRight + 1;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public T findMin() {
        if (isEmpty()) {
            return null;
        }

        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).element;
    }

    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null) {
            return t;
        }

        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t == null) {
            return t;
        }

        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    public void remove(final T x) {
        root = remove(x, root);
    }

    public AvlNode<T> remove(final T x, AvlNode<T> t) {
        if (t == null) {
            System.out.println("Sorry but you're mistaken, " + t + " doesn't exist in this tree :)\n");
            return null;
        }
        System.out.println("Remove starts... " + t.element + " and " + x);

        if (x.compareTo(t.element) < 0) {
            t.left = remove(x, t.left);
            final int l = t.left != null ? t.left.height : 0;

            if ((t.right != null) && (t.right.height - l >= 2)) {
                final int rightHeight = t.right.right != null ? t.right.right.height : 0;
                final int leftHeight = t.right.left != null ? t.right.left.height : 0;

                if (rightHeight >= leftHeight) {
                    t = rotateLeft(t);
                } else {
                    t = doubleRorateRight(t);
                }
            }
        } else if (x.compareTo(t.element) > 0) {
            t.right = remove(x, t.right);
            final int r = t.right != null ? t.right.height : 0;
            if ((t.left != null) && (t.left.height - r >= 2)) {
                final int leftHeight = t.left.left != null ? t.left.left.height : 0;
                final int rightHeight = t.left.right != null ? t.left.right.height : 0;
                if (leftHeight >= rightHeight) {
                    t = rotateRight(t);
                } else {
                    t = doubleRotateLeft(t);
                }
            }
        }
        /*
         * Here, we have ended up when we are node which shall be removed. Check if there is a left-hand node, if so pick
         * out the largest element out, and move down to the root.
         */
        else if (t.left != null) {
            t.element = findMax(t.left).element;
            remove(t.element, t.left);

            if ((t.right != null) && (t.right.height - t.left.height >= 2)) {
                final int rightHeight = t.right.right != null ? t.right.right.height : 0;
                final int leftHeight = t.right.left != null ? t.right.left.height : 0;

                if (rightHeight >= leftHeight) {
                    t = rotateLeft(t);
                } else {
                    t = doubleRorateRight(t);
                }
            }
        } else {
            t = (t.left != null) ? t.left : t.right;
        }

        if (t != null) {
            final int leftHeight = t.left != null ? t.left.height : 0;
            final int rightHeight = t.right != null ? t.right.height : 0;
            t.height = Math.max(leftHeight, rightHeight) + 1;
        }
        return t;
    } // End of remove...

    public boolean contains(final T x) {
        return contains(x, root);
    }

    protected boolean contains(final T x, final AvlNode<T> t) {
        if (t == null) {
            return false; // The node was not found

        } else if (x.compareTo(t.element) < 0) {
            return contains(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            return contains(x, t.right);
        }

        return true; // Can only reach here if node was found
    }

    /***********************************************************************/
    // Diagnostic functions for the tree
    public boolean checkBalanceOfTree(final AvlTree.AvlNode<Integer> current) {

        boolean balancedRight = true, balancedLeft = true;
        int leftHeight = 0, rightHeight = 0;

        if (current.right != null) {
            balancedRight = checkBalanceOfTree(current.right);
            rightHeight = getDepth(current.right);
        }

        if (current.left != null) {
            balancedLeft = checkBalanceOfTree(current.left);
            leftHeight = getDepth(current.left);
        }

        return balancedLeft && balancedRight && Math.abs(leftHeight - rightHeight) < 2;
    }

    public int getDepth(final AvlTree.AvlNode<Integer> n) {
        int leftHeight = 0, rightHeight = 0;
        if (n.right != null) {
            rightHeight = getDepth(n.right);
        }
        if (n.left != null) {
            leftHeight = getDepth(n.left);
        }
        return Math.max(rightHeight, leftHeight) + 1;
    }

    public boolean checkOrderingOfTree(final AvlTree.AvlNode<Integer> current) {
        if (current.left != null) {
            if (current.left.element.compareTo(current.element) > 0) {
                return false;
            } else {
                return checkOrderingOfTree(current.left);
            }
        } else if (current.right != null) {
            if (current.right.element.compareTo(current.element) < 0) {
                return false;
            } else {
                return checkOrderingOfTree(current.right);
            }
        } else if (current.left == null && current.right == null) {
            return true;
        }

        return true;
    }

    public static void main(final String[] args) {
        final AvlTree<Integer> t = new AvlTree<>();

        t.insert(new Integer(100));
        t.insert(new Integer(29));
        t.insert(new Integer(71));
        t.insert(new Integer(82));
        t.insert(new Integer(48));
        t.insert(new Integer(39));
        t.insert(new Integer(101));
        t.insert(new Integer(22));
        t.insert(new Integer(46));
        t.insert(new Integer(17));
        t.insert(new Integer(3));
        t.insert(new Integer(20));
        t.insert(new Integer(25));
        t.insert(new Integer(10));

        System.out.println("In depth Traversal:");
        System.out.println(t.inDepthTraversal());

        System.out.println("In breath Traversal:");
        System.out.println(t.inBreathTraversal());
    }
}