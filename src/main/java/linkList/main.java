package linkList;

import array.ArrayStack;
import array.Stack;

import java.util.Random;

public class main {
    public static void main(String[] args) {
//        LinkedListDummyHead<Integer> linkedListDummyHead = new LinkedListDummyHead<Integer>();
//        for (int i = 0; i < 5; i++) {
//            linkedListDummyHead.addFrist(i);
//            System.out.println(linkedListDummyHead);
//        }
//
//        linkedListDummyHead.add(2,666);
//        System.out.println("------------------");
//        System.out.println(linkedListDummyHead);
//
//        linkedListDummyHead.remove(2);
//        System.out.println("------------------");
//        System.out.println(linkedListDummyHead);
//
//        linkedListDummyHead.removeFirst();
//        System.out.println("------------------");
//        System.out.println(linkedListDummyHead);
//
//        linkedListDummyHead.removeLast();
//        System.out.println("------------------");
//        System.out.println(linkedListDummyHead);

        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("arrayStack,time " + time1+"s");

        LinkedStack<Integer> linkedListDummyHead = new LinkedStack<Integer>();
        double time2 = testStack(linkedListDummyHead,opCount);
        System.out.println("linedListStack, tile :" + time2);
    }

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0;i<opCount;i++){
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}