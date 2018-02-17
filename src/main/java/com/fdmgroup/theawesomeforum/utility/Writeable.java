package com.fdmgroup.theawesomeforum.utility;

public interface Writeable<E> {

	public E create(E e);

	public boolean update(E e);

	public void delete(long id);

}
