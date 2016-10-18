package ThreadedBinaryTree;
   
class Node {
    int data;
    Node left;
    Node right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class ThreadedBinaryTree {
    Node root;
    
    void MorrisTraversal(Node root) {
        Node current;
        Node pre;

        if (root == null) {
            return;
        }

        current = root;
        
        while (current != null) {
            
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

    }

    public static void main(String args[]) {
        
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.root = new Node(45);
        tree.root.left = new Node(32);
        tree.root.right = new Node(78);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(39);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(89);
        tree.root.left.left.left = new Node(12);
        tree.root.left.right.left = new Node(34);
        tree.root.right.left.right = new Node(65);
        tree.root.right.right.right = new Node(91);
        tree.MorrisTraversal(tree.root);
    }
}