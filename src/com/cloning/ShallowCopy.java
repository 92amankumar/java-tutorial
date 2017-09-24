package com.cloning;

public class ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student student = new Student();
		student.setId(1);
		student.setName("ABC");
		Course course = new Course();
		course.setSubject("TEST");
		student.setCourse(course);
		System.out.println(student.hashCode());
		System.out.println(student.getCourse().hashCode());

		Student studentShallowCopy = (Student) student.clone();
		System.out.println(studentShallowCopy.hashCode());
		System.out.println(studentShallowCopy.getCourse().hashCode());

	}
}

class Course {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

class Student implements Cloneable {
	private int id;
	private String name;
	private Course course;

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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
