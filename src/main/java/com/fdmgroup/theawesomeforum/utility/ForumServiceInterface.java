package com.fdmgroup.theawesomeforum.utility;

import java.util.List;

public interface ForumServiceInterface<E> {

	public void create(E e);

	public List<E> readAll();

	public void update(E e);

	public void delete(long id);

	public E readById(long id);

	public long count();

}
