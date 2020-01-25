package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name="`group`")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGroup;

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

	//bi-directional many-to-one association to Discusion
	@OneToMany(mappedBy="group")
	private List<Discusion> discusions;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="group")
	private List<Post> posts;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="groups")
	private List<User> users;

	public Group() {
		discusions = new ArrayList<Discusion>();
		posts = new ArrayList<Post>();
		users = new ArrayList<User>();
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
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

	public List<Discusion> getDiscusions() {
		return this.discusions;
	}

	public void setDiscusions(List<Discusion> discusions) {
		this.discusions = discusions;
	}

	public Discusion addDiscusion(Discusion discusion) {
		getDiscusions().add(discusion);
		discusion.setGroup(this);

		return discusion;
	}

	public Discusion removeDiscusion(Discusion discusion) {
		getDiscusions().remove(discusion);
		discusion.setGroup(null);

		return discusion;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setGroup(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setGroup(null);

		return post;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}