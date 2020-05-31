package guı_version_3;
import java.util.ArrayList;

public class Stack implements StackI {

	int front = 0;
	ArrayList<Object> stack;

	public Stack() {
		super();
		this.stack = new ArrayList<Object>();
	}

	@Override
	public Object pop() {
		Object o = stack.get(front);
		stack.remove(front);
		front--;
		return o;
	}

	@Override
	public boolean push(Object data) {
		stack.add(data);
		front++;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public Object getIndex(int index) {
		return stack.get(index);
	}

	@Override
	public boolean search(Object o) {
		if (stack.contains(o)) {
			return true;
		}
		return false;
	}

	@Override
	public Object peek() {
		return stack.get(front);
	}
	
	public void display() {
		for (Object object : stack) {
			System.out.println(object);
		}
	}

}
