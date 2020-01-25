package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@Table(name="answer")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idAnswer;

	@Column(nullable=false, length=45)
	private String text;

	//bi-directional many-to-one association to Poll
	@ManyToOne
	@JoinColumn(name="Poll_idPoll", nullable=false)
	private Poll poll;

	public Answer() {
	}

	public int getIdAnswer() {
		return this.idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Poll getPoll() {
		return this.poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

}