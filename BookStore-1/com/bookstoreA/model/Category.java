package com.bookstoreA.model;

public class Category {

	private Long id;
	private String categoryDescription;

	public Long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "Category Id=" + id + ", Category Description=" + categoryDescription;
	}

}
