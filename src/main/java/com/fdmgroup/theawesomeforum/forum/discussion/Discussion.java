package com.fdmgroup.theawesomeforum.forum.discussion;

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

import com.fdmgroup.theawesomeforum.forum.entry.Entry;

@Entity(name="DISCUSSIONS")
@NamedQueries({
	@NamedQuery(
			name="DISCUSSIONS.readByString",
			query="SELECT d FROM DISCUSSIONS d WHERE lower(d.title) LIKE :searchString"
			),
	@NamedQuery(
			name="DISCUSSIONS.readByEntry",
			query="SELECT d FROM DISCUSSIONS d WHERE lower(d.title) LIKE :searchString"
			)
})
@Cacheable
public class Discussion {  

	@Id 
	@GeneratedValue 
	private long id;
	@Column(name="TITLE")
	@Size(min=1, max=100)
	@NotNull
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ENTRY_ID") 
	List<Entry> entries;
	
	public Discussion() {	}

	public Discussion(@NotNull String title, List<Entry> entries) {
		this.title = title;
		this.entries = entries;
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

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", title=" + title + ", entries=" + entries + "]";
	}
	
}
