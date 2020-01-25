package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCategory;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="category")
	private List<Event> events;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="category")
	private List<Group> groups;

	//bi-directional many-to-one association to Page
	@OneToMany(mappedBy="category")
	private List<Page> pages;

	public Category() {
		events = new ArrayList<Event>();
		groups = new ArrayList<Group>();
		pages = new ArrayList<Page>();
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setCategory(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setCategory(null);

		return event;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Group addGroup(Group group) {
		getGroups().add(group);
		group.setCategory(this);

		return group;
	}

	public Group removeGroup(Group group) {
		getGroups().remove(group);
		group.setCategory(null);

		return group;
	}

	public List<Page> getPages() {
		return this.pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public Page addPage(Page page) {
		getPages().add(page);
		page.setCategory(this);

		return page;
	}

	public Page removePage(Page page) {
		getPages().remove(page);
		page.setCategory(null);

		return page;
	}

}