/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/
 
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewStudent extends JFrame
{	
	static private LinkedList list = new LinkedList();
	static private Student newStudent;
		   
	private JPanel 		panel,mainPanel,txtLblPanel,btnPanel,iconPanel;
	
	private JLabel 		label,lblIcon;
	private JTextField 	firstName, lastName, idNum;
	private JButton		btnAdd,btnExt;
	
	private JComboBox 	course,yearLevel;
	private JDialog		dialog;
	
	private String[] 	listOfCourse = { 
										 "[ SELECT COURSE ]",
										 "ACCOUNTANCY",
										 "BANKING IN FINANACE",
										 "COMPUTER SCIENCE",
										 "CRIMINOLOGY",
										 "COM - E",
										 "ELECTRONIC COMM - E",
										 "INFORMATION TECHNOLOGY",
										 "MANAGEMENT",
										 "MARINE ENGINEERING",
										 "NURCING",
										 "NAUTICAL"
										};
										
	private String[]	levelYear 	 = {
										 "[ SELECT LEVEL ]",
										 "1TH YEAR",
										 "2TH YEAR",
										 "3TH YEAR",
										 "4TH YEAR",
										 "5TH YEAR"
										};
	
	public NewStudent(JDialog dialog)
	{
		this();
		this.dialog = dialog;
	}
	
	public NewStudent()
	{
		panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		txtLblPanel = new JPanel();
		iconPanel	= new JPanel();
		btnPanel	= new JPanel();
		
		addLayout();
						
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		mainPanel.add(txtLblPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(5,5)));
		mainPanel.add(btnPanel);
		
		panel.add(iconPanel);
		panel.add(mainPanel);		
	}
		
	public void addLayout()
	{
		JPanel lblPanel = new JPanel();
		lblPanel.setLayout(new GridLayout(5,1,5,1));
			lblPanel.add(label = new JLabel("Student Id :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("First Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Last Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Course :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Year Level :",JLabel.RIGHT));
		
		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(5,1));	
			txtPanel.add(idNum 		= new JTextField(15));
			txtPanel.add(firstName	= new JTextField(15));
			txtPanel.add(lastName	= new JTextField(15));
			txtPanel.add(course 	= new JComboBox(listOfCourse));
			txtPanel.add(yearLevel 	= new JComboBox(levelYear));
			
			idNum.setHorizontalAlignment(JTextField.CENTER);
			firstName.setHorizontalAlignment(JTextField.CENTER);
			lastName.setHorizontalAlignment(JTextField.CENTER);
			
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
			btnPanel.add(btnAdd = new JButton("Add"));
			btnPanel.add(btnExt = new JButton("Close"));
			
		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));			
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			
		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0062-32.gif"),JLabel.LEFT));					
			iconPanel.setBorder(BorderFactory.createEtchedBorder());

		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!isEmptyTextBox()){
					if(!existIdNum(idNum.getText())){
						addNewStudent();
						message();
						dispose();	
					}else{
						JOptionPane.showMessageDialog(dialog,"ID number has already exist.","Message",JOptionPane.ERROR_MESSAGE);
					}
				}	
				else{
					JOptionPane.showMessageDialog(dialog,"Please fill up the textbox complete.","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnExt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	
	public JPanel getPanel()
	{
		return panel;
	}

	public boolean isEmptyTextBox()
	{
		return(firstName.getText().length() == 0 ||
			   lastName.getText().length()  == 0 ||
			   idNum.getText().length() 	== 0 ||
			   course.getSelectedIndex()    == 0 ||
			   yearLevel.getSelectedIndex() == 0);
	}
	
	public void message()
	{
		JOptionPane.showMessageDialog(dialog,"Successfull","Message",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void addNewStudent()
	{
		newStudent = new Student(firstName.getText().trim(),
							     lastName.getText().trim(),
							     Integer.valueOf(idNum.getText().trim()),
							     String.valueOf(course.getSelectedItem()),
							     String.valueOf(yearLevel.getSelectedItem()));
		
		list.addLast(newStudent);
		
		StudentList sl = new StudentList(newStudent,list);
		System.out.println(list.size() - 1);
		sl.setRecord(list.size() - 1);
		
		Student student = (Student)list.getLast();
		
		new StudentRecordGUI(true);
		new StudentRecordGUI(list.size());
		new StudentRecordGUI(student.getFirstName(),
							 student.getLastName(),
							 student.getIdNum(),
							 student.getCourse(),
							 student.getYearLevel());
	}
	
	public boolean existIdNum(String idNumber)
	{
		boolean found = false;
		
		StudentList s = new StudentList();
		
		for(int i = 0; i < list.size(); i++)
		{
			Student id = (Student)s.getList().get(i);
			if(Integer.valueOf(idNumber).equals(id.getIdNum()))
			{
				found = true;
				break;
			}
		}
		return found;	
	}
		
	public void dispose()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}