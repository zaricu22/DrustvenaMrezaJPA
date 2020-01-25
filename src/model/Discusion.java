package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discusion database table.
 * 
 */
@Entity
@Table(name="discusion")
@NamedQuery(name="Discusion.findAll", query="SELECT d FROM Discusion d")
public class Discusion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idDiscusion;

	@Column(length=45)
	private String title;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="Group_idGroup", nullable=false)
	private Group group;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="discusion")
	private List<Post> posts;

	public Discusion() {
	}

	public int getIdDiscusion() {
		return this.idDiscusion;
	}

	public void setIdDiscusion(int idDiscusion) {
		this.idDiscusion = idDiscusion;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setDiscusion(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setDiscusion(null);

		return post;
	}

}