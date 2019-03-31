package BinarySearchTree;


import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 7, 4, 2,8};
        for (int num : nums) {
            bst.add(num);
        }
//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();
        //看完结果之后发现中序遍历是按顺序输出的
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        System.out.println(bst);
//        bst.levelOrder();
//        System.out.println(bst.maximum());
//        System.out.println(bst.minimum());

//        BST<Integer> bst = new BST<>();
//        int n = 1000;
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(10000));
//        }

//        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty()){
//            nums.add(bst.removeMin());
//        }
        bst.removeMin();
        bst.inOrder();
    }
}