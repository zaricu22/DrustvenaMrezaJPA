package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the page database table.
 * 
 */
@Entity
@Table(name="page")
@NamedQuery(name="Page.findAll", query="SELECT p FROM Page p")
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idPage;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateFounded;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	@Column(length=255)
	private String picture;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="Category_idCategory", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Poll
	@OneToMany(mappedBy="page")
	private List<Poll> polls;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="page")
	private List<Post> posts;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="pages")
	private List<User> users;

	public Page() {
		users = new ArrayList<User>();
		posts = new ArrayList<Post>();
		polls = new ArrayList<Poll>();
		
	}

	public int getIdPage() {
		return this.idPage;
	}

	public void setIdPage(int idPage) {
		this.idPage = idPage;
	}

	public Date getDateFounded() {
		return this.dateFounded;
	}

	public void setDateFounded(Date dateFounded) {
		this.dateFounded = dateFounded;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Poll> getPolls() {
		return this.polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	public Poll addPoll(Poll poll) {
		getPolls().add(poll);
		poll.setPage(this);

		return poll;
	}

	public Poll removePoll(Poll poll) {
		getPolls().remove(poll);
		poll.setPage(null);

		return poll;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setPage(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setPage(null);

		return post;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}