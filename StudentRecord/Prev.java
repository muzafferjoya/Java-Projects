/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.awt.event.*;
import javax.swing.*;

public class Prev extends AbstractAction
{
	StudentList studentList = new StudentList();
	
	public Prev(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			prevStudentRecord();
		}
		catch(Exception e)
		{}
	}
	
	public void prevStudentRecord()
	{
		if(studentList.getRecord() != 0)
		{
			int i = studentList.getRecord();
			
				Student student = (Student)studentList.getList().get(i - 1);
				studentList.setRecord(--i);
			
				new StudentRecordGUI(i + 1);			
				new StudentRecordGUI(student.getFirstName(),
							 		 student.getLastName(),
							 		 student.getIdNum(),
							 		 student.getCourse(),
					 				 student.getYearLevel());
		}
	}
}