package com.fdmgroup.theawesomeforum.utility;

import java.util.List;

public interface Readable <E>{

	public E readOneById(long id);

	public List<E> readAll();
	
	public long count();
	
	public List<E> findByString(String searchString);
	
}
