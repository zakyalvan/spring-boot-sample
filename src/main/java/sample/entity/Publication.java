package sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="publication")
public class Publication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotBlank
	private String title;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Professor author;
	
	public Integer getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public Professor getAuthor() {
		return author;
	}
	public void setAuthor(Professor author) {
		this.author = author;
	}
}
