package com.example.imagelistview;

public class Student {
	//define encapsulation
	private int image;
	private String name,course;
	//create constructors
	public Student(int image, String name, String course) {
		super();
		this.image = image;
		this.name = name;
		this.course = course;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
	
}
