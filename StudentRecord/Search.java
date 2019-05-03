/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/

import java.awt.event.*;

import javax.swing.*;

public class Search extends AbstractAction
{
	private StudentList studentList = new StudentList();
	
	private JFrame 		frame;
	private JOptionPane dialog;
	
	public Search(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object[] search = {"ID #","FirstName","LastName"};
		String s = (String)dialog.showInputDialog(
							  	  frame,
							  	  "Search By:",
							      "Search",
							      JOptionPane.PLAIN_MESSAGE,
							      null,
							      search,
							      "ID #");
		
		if(s == "ID #")
		{
			boolean foundID = false;
			String id = JOptionPane.showInputDialog(
									frame,
									"Search " + s +":",
									"Search",
									JOptionPane.PLAIN_MESSAGE);
			if(id != null && id.length() != 0){
				for(int i = 0; i < studentList.getSize(); i++){
					Student student = (Student)studentList.getList().get(i);										
					if(Integer.valueOf(id).equals(student.getIdNum())){
						studentList(student,i);
						foundID = true;
					    break;
					}
				}
				if(foundID == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + id +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(s == "FirstName")
		{
			boolean foundFirstName = false;
			String firstname = (String)JOptionPane.showInputDialog(
										   frame,
										   "Search " + s +":",
										   "Search",
										   JOptionPane.PLAIN_MESSAGE);
			if(firstname != null && firstname.length() != 0){
				for(int i = 0; i < studentList.getSize(); i++){
					Student student = (Student)studentList.getList().get(i);										
					if(firstname.equals(student.getFirstName())){
						studentList(student,i);
						foundFirstName = true;
					    break;
					}
				}
				if(foundFirstName == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + firstname +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(s == "LastName")
		{
			boolean foundLastName = false;
			String lastname = JOptionPane.showInputDialog(
										   frame,
										   "Search " + s +":",
										   "Search",
										   JOptionPane.PLAIN_MESSAGE);
			if(lastname != null && lastname.length() != 0){
				for(int i = 0; i < studentList.getSize(); i++){
					Student student = (Student)studentList.getList().get(i);										
					if(lastname.equals(student.getLastName())){
						studentList(student,i);
						foundLastName = true;
					    break;
					}
				}
				if(foundLastName  == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + lastname +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public void studentList(Student student,int index)
	{
		student = (Student)studentList.getList().get(index);
		
		studentList.setRecord(index);

		new StudentRecordGUI(studentList.getRecord() + 1);
		new StudentRecordGUI(student.getFirstName(),
			 		 		 student.getLastName(),
			 		 		 student.getIdNum(),
			 		 		 student.getCourse(),
			 		 		 student.getYearLevel());
	}
}