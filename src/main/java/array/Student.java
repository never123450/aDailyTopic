package array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("student(name : %s,score: %d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>();
        arr.addLast(new Student("a",100));
        arr.addLast(new Student("b",77));
        arr.addLast(new Student("v",88));
        System.out.println(arr);
    }
}