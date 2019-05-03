/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.awt.event.*;

import javax.swing.*;

public class Edit extends AbstractAction
{
	StudentList	studentList = new StudentList();
	Student 	student		= null;
	
	private JFrame  frame   = null;
	private JDialog dialog  = null;
	
	public Edit(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			if(studentList.getList().getFirst() != null)
			{
				editStudentProfile();
			}
			else
			{
				JOptionPane.showMessageDialog(
						frame,
						"Empty student record.",
						"Edit",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(
						frame,
						"Empty student record.",
						"Edit",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void editStudentProfile()
	{
		int i = studentList.getRecord();
		student = (Student)studentList.getList().get(i);

		studentList.setRecord(i);
	
		dialog = new JDialog(frame,"Edit Student Profile",true);
		dialog.setContentPane(new EditProfile(student,dialog,i).getPanel());
		dialog.pack();
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}
}