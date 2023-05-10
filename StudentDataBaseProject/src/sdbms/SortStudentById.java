package sdbms;

import java.util.Comparator;

public class SortStudentById implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		return s1.getId().compareTo(s2.getId()); ̣
	}

}
