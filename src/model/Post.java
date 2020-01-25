package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="post")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idPost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date time;

	@Column(nullable=false, length=45)
	private String text;

	@Column
	private int likes;
	
	@ManyToOne
	@JoinColumn(name="User_username", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="Discusion_idDiscusion", nullable=false)
	private Discusion discusion;
	
	@ManyToOne
	@JoinColumn(name="Page_idPage", nullable=false)
	private Page page;
	
	@ManyToOne
	@JoinColumn(name="Group_idGroup", nullable=false)
	private Group group;
	

	public Post() {
	}


	public int getIdPost() {
		return idPost;
	}


	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Discusion getDiscusion() {
		return discusion;
	}


	public void setDiscusion(Discusion discusion) {
		this.discusion = discusion;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	
	

}