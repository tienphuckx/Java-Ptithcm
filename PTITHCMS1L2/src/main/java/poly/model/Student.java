package poly.model;

public class Student {
	private String name;
	private int mark;
	private String major;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student(String name, int mark, String major) {
		super();
		this.name = name;
		this.mark = mark;
		this.major = major;
	}
	public Student() {
		super();
	}
	
	
}
