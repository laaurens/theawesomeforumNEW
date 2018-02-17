package com.fdmgroup.theawesomeforum.forum.entry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fdmgroup.theawesomeforum.user.User;

@Entity(name = "ENTRIES")
@NamedQueries({

		@NamedQuery(
				name="ENTRIES.readByString",
				query="SELECT e FROM ENTRIES e WHERE lower(e.content) LIKE :searchString"
        ),
		@NamedQuery(
				name="ENTRIES.searchByDate",
				query="SELECT e FROM ENTRIES e WHERE e.dateOfEntry = :searchDate"
		)
})
@Cacheable
public class Entry {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "CONTENT", length = 2000)
	@Size(min = 1, max = 2000)
	@NotNull
	private String content;
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "DATE_OF_ENTRY")
	private LocalDateTime dateOfEntry;
	@Transient
	User user;

	public Entry() {
	}

	public Entry(@NotNull String content, User user) {
		this.content = content;
		this.user = user;
		this.userId = user.getId();
		this.dateOfEntry = LocalDateTime.now().withNano(0);

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

	public User getUser() {
		return user;
	}

	public LocalDateTime getDateOfEntry() {
		return dateOfEntry;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", content=" + content + "]";
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return this.getUser().getUserName();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDateOfEntry(LocalDateTime dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

}
