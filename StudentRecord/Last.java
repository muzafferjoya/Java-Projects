/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.awt.event.*;

import javax.swing.*;

public class Last extends AbstractAction
{
	StudentList studentList = new StudentList();
	
	public Last(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			Student student = (Student)studentList.getList().getLast();
		
			studentList.setRecord(studentList.getList().size() - 1);
		
			new StudentRecordGUI(studentList.getSize());
			new StudentRecordGUI(student.getFirstName(),
						 	     student.getLastName(),
					 	    	 student.getIdNum(),
						 	     student.getCourse(),
					 			 student.getYearLevel());
		}
		catch(Exception e)
		{}
	}
}