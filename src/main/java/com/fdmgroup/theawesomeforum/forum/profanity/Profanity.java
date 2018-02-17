package com.fdmgroup.theawesomeforum.forum.profanity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="PROFANITIES")
@NamedQueries({
	@NamedQuery(name="PROFANITIES.readByString",
    query="SELECT p FROM PROFANITIES p WHERE p.content LIKE :searchString")
})
@Cacheable
public class Profanity {
 
	@Id
	@GeneratedValue
	private long id; 
	@Column(name="CONTENT", length = 2000)
	@Size(min=1, max=100)
	@NotNull
	private String content;
	
	public Profanity() {	}

	public Profanity(@NotNull String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String description) {
		this.content = description;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", content=" + content + "]";
	}
	
}
