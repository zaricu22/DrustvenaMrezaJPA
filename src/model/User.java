package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable=false, length=45)
	private String password;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;
	
	@Column(nullable=false, length=1)
	private String gender;
	
	@Column(length=45)
	private String school;

	@Column(length=45)
	private String city;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	//bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="User_username", referencedColumnName="username", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Role_idRole", referencedColumnName="idRole", nullable=false)
			}
		)
	private List<Role> roles;

	//bi-directional many-to-many association to Event
	@ManyToMany
	@JoinTable(
		name="user_event"
		, joinColumns={
			@JoinColumn(name="User_username", referencedColumnName="username", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Event_idEvent", referencedColumnName="idEvent", nullable=false)
			}
		)
	private List<Event> events;

	//bi-directional many-to-many association to Group
	@ManyToMany
	@JoinTable(
		name="user_group"
		, joinColumns={
			@JoinColumn(name="User_username", referencedColumnName="username", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Group_idGroup", referencedColumnName="idGroup", nullable=false)
			}
		)
	private List<Group> groups;

	//bi-directional many-to-many association to Page
	@ManyToMany
	@JoinTable(
		name="user_page"
		, joinColumns={
			@JoinColumn(name="User_username", referencedColumnName="username", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Page_idPage", referencedColumnName="idPage", nullable=false)
			}
		)
	private List<Page> pages;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="friends"
		, joinColumns={
			@JoinColumn(name="User_username", referencedColumnName="username", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="User_username1", referencedColumnName="username", nullable=false)
			}
		)
	private List<User> users1;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="users1")
	private List<User> users2;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	public User() {
		posts = new ArrayList<Post>();
		events = new ArrayList<Event>();
		groups = new ArrayList<Group>();
		pages = new ArrayList<Page>();
		users1 = new ArrayList<User>();
		users2 = new ArrayList<User>();
		messages1 = new ArrayList<Message>();
		messages2 = new ArrayList<Message>();
	}

	public void addRole(Role r) {
		roles.add(r);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setUser(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setUser(null);

		return post;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Page> getPages() {
		return this.pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUser2(null);

		return messages2;
	}

}