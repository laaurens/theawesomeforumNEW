package com.fdmgroup.theawesomeforum.forum.category;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
 
@Entity(name="CATEGORIES") 
@NamedQueries({
	@NamedQuery(name="CATEGORIES.readByString",
    query="SELECT c FROM CATEGORIES c WHERE lower(c.title) LIKE :searchString")
})
@Cacheable
public class Category {

	@Id
	@GeneratedValue
	private long id; 
	@Column(name="TITLE")
	@Size(min=1, max=100)
	@NotNull
	private String title;
	 
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name="SUBCATEGORY_ID")
	List<Subcategory> subcategories;
	
	public Category() {	}
	
	public Category(@NotNull String title, List<Subcategory> subcategories) {
		this.title = title;

		this.subcategories = subcategories;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", subcategories=" + subcategories + "]";
	}
	
}
