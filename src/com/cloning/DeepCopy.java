package com.cloning;

public class DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		StudentDeep student = new StudentDeep();
		student.setId(1);
		student.setName("ABC");
		CourseDeep course = new CourseDeep();
		course.setSubject("TEST");
		student.setCourse(course);
		System.out.println(student.hashCode());
		System.out.println(student.getCourse().hashCode());

		StudentDeep studentShallowCopy = (StudentDeep) student.clone();
		System.out.println(studentShallowCopy.hashCode());
		System.out.println(studentShallowCopy.getCourse().hashCode());

	}
}

class CourseDeep implements Cloneable {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class StudentDeep implements Cloneable {
	private int id;
	private String name;
	private CourseDeep course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CourseDeep getCourse() {
		return course;
	}

	public void setCourse(CourseDeep course) {
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		StudentDeep student = (StudentDeep) super.clone();
		student.course = (CourseDeep) course.clone();
		return student;
	}
}
