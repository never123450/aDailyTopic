package one.array;

public class main {
    public static void main(String[] args) {
//        Array<Integer> array = new Array();
//        for (int i=0;i<10;i++){
//            array.addLast(i);
//        }
//        System.out.println(array);
//
//        array.add(1,100);
//        System.out.println(array);
//
//        array.addFirst(-1);
//        System.out.println(array);
//
//        array.remove(2);
//        System.out.println(array);
//
//        array.removeElement203(4);
//        System.out.println(array);
//
//        array.removeFirst();
//        System.out.println(array);


        ArrayStack<Integer> stack  =new ArrayStack<Integer>();
        for (int i=0;i<10;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }
}