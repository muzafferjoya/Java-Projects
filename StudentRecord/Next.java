/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.awt.event.*;

import javax.swing.*;

public class Next extends AbstractAction
{
	StudentList studentList = new StudentList();
	private int size;
	

	public Next(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try{
			if(studentList.getRecord() < studentList.getSize())
				{
					int i = studentList.getRecord();
					Student student = (Student)studentList.getList().get(i + 1);
			
					studentList.setRecord(++i);
			
					new StudentRecordGUI(1 + i);			
					new StudentRecordGUI(student.getFirstName(),
									 	 student.getLastName(),
									 	 student.getIdNum(),
										 student.getCourse(),
				 						 student.getYearLevel());
			}
		}
		catch(Exception e)
		{}
	}
}