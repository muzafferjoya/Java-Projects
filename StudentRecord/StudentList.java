/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.util.*;

public class StudentList
{
	static Student student = null;
	static LinkedList list = null;
	static int record;
	
	public StudentList()
	{}
		
	public StudentList(Student student,LinkedList list)
	{
		this.student = student;
		this.list    = list;
	}
	
	public Student getStudentList()
	{
		return student;
	}
	
	public void setRecord(int n)
	{
		record = n;
	}
	
	public int getRecord()
	{
		return record;
	}
	
	public LinkedList getList()
	{
		return list;
	}

	public static int getSize()
	{
		return list.size();
	}
}