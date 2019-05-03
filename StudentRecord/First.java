/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/

import java.util.*;
import java.awt.event.*;

import javax.swing.*;

public class First extends AbstractAction
{	
	private StudentList studentList = new StudentList();
	
	public First(String command, ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			Student student = (Student)studentList.getList().getFirst();
		
			studentList.setRecord(0);
					
			new StudentRecordGUI(1);			
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