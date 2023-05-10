package sdbms;

import java.util.Comparator;

public class SortStudentByMarks implements Comparator<Student>
{
	public int compare(Student o1,Student o2)
	{
		return o1.getMarks()-o2.getMarks(); ̣
	}

}
