package xiaomage.tree;

import xiaomage.printer.BinaryTrees;

import java.util.Random;

public class TestMorrisTree {

    private static class MorrisTree extends BinarySearchTree<Integer> {
        /**
         * 利用 Morris 进行中序遍历
         */
        public void inOrder() {
            // inOrder(root); // 正常的中序遍历
            Node<Integer> node = root;
            while (node != null) {
                if (node.left != null) {
                    // 找到前驱节点(前驱 precursor)(succeed 后继)
                    Node<Integer> pred = node.left;
                    while (pred.right != null && pred.right != node) {
                        pred = pred.right;
                    }
                    if (pred.right == null) {
                        pred.right = node;
                        node = node.left;
                    } else { // pred.right = node;
                        System.out.println(node.element + " ");
                        pred.right = null;
                        node = node.right;
                    }
                } else {
                    System.out.println(node.element + " ");
                    node = node.right;
                }
            }
        }

        private void inOrder(BinarySearchTree.Node<Integer> root) {
            if (root == null) return;
            inOrder(root.left);
            System.out.println(root.element);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        MorrisTree tree = new MorrisTree();
        for (int i = 0; i < 10; i++) {
            tree.add(new Random().nextInt(100));
        }
        BinaryTrees.println(tree);
        System.out.println("-------------");
        tree.inOrder();
        BinaryTrees.println(tree);
    }

}