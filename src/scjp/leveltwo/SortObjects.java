package scjp.leveltwo;

import java.util.*;

/*
 * 
 * 
 * You are given a list of student information: ID, FirstName, and CGPA. 
 * Your task is to rearrange them according to their CGPA in decreasing order. 
 * If two student have the same CGPA, then arrange them according to their first name in alphabetical order. 
 * If those two students also have the same first name, then order them according to their ID. 
 * No two students have the same ID. 
 * 
 * Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.
 * 
 * Sample Input

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

	Sample Output

Ashis
Fahim
Samara
Samiha
Rumpa

 */

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {

		double cgpa1 = s1.getCgpa();
		double cgpa2 = s2.getCgpa();
		
		if(Math.abs(cgpa1 - cgpa2)<.00000001){
			int fnameCom = s1.getFname().compareTo(s2.getFname());
			if(fnameCom==0){
				return s1.getId()-s2.getId(); 
			}
			return fnameCom;
		}

		return (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
	}

}

public class SortObjects
{
	public static void main(String[] args){
	
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(33, "Rumpa", 3.68));
		studentList.add(new Student(85, "Ashis", 3.85));
		studentList.add(new Student(56, "Samiha", 3.75));
		studentList.add(new Student(19, "Samara", 3.75));
		studentList.add(new Student(22, "Fahim", 3.76));
		
		Collections.sort(studentList, new StudentComparator());

		for(Student st: studentList){
			System.out.println(st.getFname() + (" - " + st.getId() + ", " + st.getCgpa()));
		}
		
		//Compare only based on name
		Collections.sort(studentList, new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getFname().compareTo(o2.getFname());
			}
			
		});

		for(Student st: studentList){
			System.out.println(st.getFname() + (" - " + st.getId() + ", " + st.getCgpa()));
		}
	}
}
