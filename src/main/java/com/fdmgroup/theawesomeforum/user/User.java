package com.fdmgroup.theawesomeforum.user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
import com.fdmgroup.theawesomeforum.forum.entry.Entry;

@Entity(name = "USERS")
@NamedQueries({
	@NamedQuery(name="USERS.readByString",
    query="SELECT u FROM USERS u WHERE lower(u.userName) LIKE :searchString"),
	@NamedQuery(name="USERS.readByEmail",
    query="SELECT u FROM USERS u WHERE lower(u.email) LIKE :searchString"),
	@NamedQuery(name="USERS.readByBirthday",
    query="SELECT u FROM USERS u WHERE u.birthday LIKE :searchString")
	
//	from User u 
//	where day(u.birthday) = day(CURRENT_DATE) 
//	and month(u.birthday) = month(CURRENT_DATE) 
})
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "USERNAME", unique = true)
	@NotNull
	private String userName;
	@Column(name = "PASSWORD")
	@Size(min = 7, max = 14)
	@NotNull
	private String password;
	@Column(name = "IS_ADMIN")
	@NotNull
	private boolean isAdmin;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "BIRTHDAY")
	private LocalDate birthday;
	@Column(name = "BIO")
	private String bio;
	@Column(name = "HOMEPAGE")
	private String homepage;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "EMAIL", unique = true)
	@NotNull
	private String email;

	@OneToMany(cascade = CascadeType.MERGE)
	List<Entry> entries;
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "USER_ID")
	List<Discussion> discussions;

	public User() {
	}

	public User(@NotNull String userName, @NotNull boolean isAdmin, @NotNull String password, String firstName,
			String lastName, String location, String bio, String homepage, LocalDate birthday, @NotNull String email) {
		this.password = password;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.bio = bio;
		this.homepage = homepage;
		this.birthday = birthday;
		this.email = email;
	}

	public User(@NotNull String userName, @NotNull boolean isAdmin, @NotNull String password) {
		this.password = password;
		this.userName = userName;
		this.isAdmin = isAdmin;
	}

	public User(String userName, boolean isAdmin, String password, List<Discussion> discussions, List<Entry> entries) {
		this.password = password;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.discussions = discussions;
		this.entries = entries;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String passWord) {
		this.password = passWord;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getBio() {
		return bio;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", isAdmin=" + isAdmin + "]";
	}

}
