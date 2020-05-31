package guı_version_3;
public interface StackI {

	public Object pop();

	public boolean push(Object data);

	public boolean isEmpty();

	public int size();

	public Object getIndex(int index);

	public boolean search(Object o);
	
	public Object peek() ;

}
