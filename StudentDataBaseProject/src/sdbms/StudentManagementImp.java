package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Customexception.InvalidChoiceException;
import Customexception.StudentNotFoundException;

public class StudentManagementImp implements StudentManagement
{
	Scanner sc=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent()
	{
		System.out.println("Enter Student Age");
		int age=sc.nextInt();
		System.out.println("Enter Student name");
		String name=sc.next();
		System.out.println("Enter Student marks");
		int marks=sc.nextInt();
		Student s=new Student(age,name,marks);
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student id is "+s.getId());
	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student id to be displayed:");
		String id=sc.next();//String id=sc.next().toUpperCase();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student s=db.get(id);
			System.out.println("id: "+s.getId());
			System.out.println("Age: "+s.getAge());
			System.out.println("Name: "+s.getName());
			System.out.println("Marks: "+s.getMarks());
		}
		else
		{
			try {
				throw new StudentNotFoundException("Student with "+id+" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents()
	{
		System.out.println("Student details are as follows");
		System.out.println("---------------------------");
		Set<String> keys=db.keySet();
		for(String key:keys)
		{
			Student obj=db.get(key);
			System.out.println(obj);//	System.out.println(db.get(key));
		}
		
	}
	
	public void removeStudent()
	{
		System.out.println("Enter Student id:");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found");
			System.out.println(db.get(id));//getting student object and printing it.
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else
		{
			try {
				throw new StudentNotFoundException("Student with Id "+id+" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents()
	{
		if(db.size()!=0)
		{
			System.out.println("Avaialable Student Records: "+db.size());
			db.clear();
			System.out.println("All the Student records deleted Successfully");
		}
		else
		{
			try {
				throw new StudentNotFoundException("No Student Records to delete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void updateStudent()
	{
		System.out.println("Enter Student Id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Age:");
				int age=sc.nextInt();
				std.setAge(age);//std.setAge(scan.nextInt());
				System.out.println("Age updated successfully");
				break;
			case 2:
				System.out.println("Enter Name");
				String name=sc.next();
				std.setName(name);
				System.out.println("Name updated successfully");
			case 3:
				System.out.println("Enter marks:");
				int marks=sc.nextInt();
				std.setMarks(marks);
				System.out.println("MArks Update successfully");
				break;
			default:
				try
				{
					throw new InvalidChoiceException("Kindly Enter Valid Choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}

		}
		else
		{
			try {
				throw new StudentNotFoundException("Student with "+id+ " is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void countStudent()
	{
		System.out.println(" No. of Student Records: "+db.size());

	}
	@Override
	public void sortStudents()
	{
		Set<String> keys=db.keySet();
		List<Student> l=new ArrayList<Student>();
		for(String key:keys)
		{
			Student s=db.get(key);
			l.add(s);//list.add(db.get(key));
		}
		System.out.println("1:Sort By Id\n2:Sort By Age\n3:Sort By Name\n4:Sort By marks\n Enter Choice:");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			Collections.sort(l,new SortStudentById());
			display(l);
			break;
		case 2:
			Collections.sort(l,new SortStudentByAge());
			display(l);
		    break;
		case 3:
			Collections.sort(l,new SortStudentByName());
			display(l);
			break;
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			display(l);
			break;
			default:
				try {
					throw new InvalidChoiceException("Kindly Enter a Valid Choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

		}

	}
	@Override
	public void getStudentWithHighestMarks()
	{
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys)
		{
			Student s=db.get(key);
			list.add(s);
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student details with Highest marks");
		System.out.println(list.get(list.size()-1));
		
	}
	@Override
	public void getStudentWithLowestMarks()
	{
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys)
		{
			Student s=db.get(key);
			list.add(s);
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student details with Lowest marks");
		System.out.println(list.get(0));
		
	}
	private static void display(List<Student>l)
	{
		for(Student s:l)
		{
			System.out.println(s);
		}
	}

}
