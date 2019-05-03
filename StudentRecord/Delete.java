/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Delete extends AbstractAction
{
	private StudentList studentList = new StudentList();
	private JFrame 		frame =	null;
	
	public Delete(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(studentList.getList().size() != 0)
		{
			int n = JOptionPane.showConfirmDialog(
								frame,
								"Are you sure? you want to  delete this record 'student'",
            	                "Confirm delete",
                	            JOptionPane.YES_NO_OPTION);
        
        	if(n == JOptionPane.YES_OPTION)
        	{
        		deleteStudentRecord();
        	}
    	}
	}

	public void deleteStudentRecord()
	{		
		studentList.getList().remove(studentList.getRecord());
		
		if(studentList.getList().size() != 0)
		{
			Student student = (Student)studentList.getList().getLast();
	
			studentList.setRecord(studentList.getList().size() - 1);
			
			new StudentRecordGUI(studentList.getRecord() + 1);
			new StudentRecordGUI(student.getFirstName(),
							 	 student.getLastName(),
							 	 student.getIdNum(),
							 	 student.getCourse(),
							 	 student.getYearLevel());
		}
		else
		{
			new StudentRecordGUI(false);
			new StudentRecordGUI(0);
			new StudentRecordGUI("","",0,"","");
		}
	
	}
}