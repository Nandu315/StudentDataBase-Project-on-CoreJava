package sdbms;

import java.util.Scanner;

import Customexception.InvalidChoiceException;

public class Solution
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Student Management System");
		System.out.println("------------------------------------------");
		Scanner sc=new Scanner(System.in);
		StudentManagement st=new StudentManagementImp();
		while(true)
		{
			System.out.println("1:Add Student\n2:Display");
			System.out.println("3:Display All Students\n4:Remove Student");
			System.out.println("5:remove all Student\n6:Update Student");
			System.out.println("7:Count Student\n8:Sort Students\n9:get Student With HighestMarks\n10:get Student With Lowest Marks\n11:Exit");
			System.out.println("Enter Choice:");
			int choice =sc.nextInt();
			switch(choice)
			{
			case 1:
				st.addStudent();
				break;
			case 2:
				st.displayStudent();
				break;
			case 3:
				st.displayAllStudents();
				break;
			case 4:
				st.removeStudent();
				break;
			case 5:
				st.removeAllStudents();
				break;
			case 6:
				st.updateStudent();
				break;
			case 7:
				st.countStudent();
				break;
			case 8:
				st.sortStudents();
				break;
			case 9:
				st.getStudentWithHighestMarks();
				break;
			case 10:
				st.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);
			default:
				try
				{
					throw new InvalidChoiceException("Kindly Enter Valid Choice"+"");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
		}


	}

}
