package xiaomage.stack;

/**
 * @Description  测试
 * @author xwy
 * @date 2021年7月18日14:57:57
 * @param
 * @return
 */
public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
