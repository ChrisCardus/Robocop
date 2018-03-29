package container;

public interface Container<A> {
	public A remove();
	public void add(A a);
	public boolean isEmpty();
}
