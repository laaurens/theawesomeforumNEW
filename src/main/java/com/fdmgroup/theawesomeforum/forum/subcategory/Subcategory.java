package com.fdmgroup.theawesomeforum.forum.subcategory;

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

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;

@Entity(name="SUBCATEGORIES") 
@NamedQueries({
	@NamedQuery(name="SUBCATEGORIES.readByString",
    query="SELECT s FROM SUBCATEGORIES s WHERE s.title LIKE :searchString")
})
@Cacheable
public class Subcategory {

	@Id
	@GeneratedValue
	private long id; 
	@Column(name="TITLE")
	@Size(min=1, max=100)
	@NotNull
	private String title;
	@Column(name="DESCRIPTION")
	@Size(min=1, max=100)
	private String description;
	 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="DISCUSSION_ID")
	List<Discussion> discussions;
	
	public Subcategory() {	} 

	public Subcategory(@NotNull String title, String description, List<Discussion> discussions) {
		this.title = title;
		this.description = description;
		this.discussions = discussions;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	@Override
	public String toString() {
		return "Subcategory [id=" + id + ", title=" + title + ", description=" + description + ", discussions=" + discussions + "]";
	}
	
}
