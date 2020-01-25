package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the poll database table.
 * 
 */
@Entity
@Table(name="poll")
@NamedQuery(name="Poll.findAll", query="SELECT p FROM Poll p")
public class Poll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idPoll;

	@Column(nullable=false, length=100)
	private String question;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date time;
	
	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="Page_idPage", nullable=false)
	private Page page;


	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="poll")
	private List<Answer> answers;

	public Poll() {
	}

	public int getIdPoll() {
		return this.idPoll;
	}

	public void setIdPoll(int idPoll) {
		this.idPoll = idPoll;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setPoll(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setPoll(null);

		return answer;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}