/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EditProfile extends JPanel
{	
	private StudentList studentList = new StudentList();
	private Student 	student;
	
	private JPanel 		panel,mainPanel,txtLblPanel,btnPanel,iconPanel;
	
	private JLabel 		label,lblIcon;
	private JTextField 	firstName, lastName, idNum;
	private JButton		btnSave,btnExt;
	
	private JComboBox 	course,yearLevel;
	private JDialog		dialog;
	
	private String[] 	listOfCourse = { 
										 "SELECT COURSE","",
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
										 "1TH YEAR",
										 "2TH YEAR",
										 "3TH YEAR",
										 "4TH YEAR",
										 "5TH YEAR"
										};	
	private int index;
	
	public EditProfile(Student student,JDialog dialog,int index)
	{
		this();
		this.dialog  = dialog;
		this.index   = index;
		
		firstName.setText(student.getFirstName());
		lastName.setText(student.getLastName());
		idNum.setText(String.valueOf(student.getIdNum()));
		course.setSelectedItem(student.getCourse());
		yearLevel.setSelectedItem(student.getYearLevel());
	}
	
	public EditProfile()
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
	
	public JPanel getPanel()
	{
		return panel;
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
			btnPanel.add(btnSave = new JButton("Save"));
			btnPanel.add(btnExt  = new JButton("Close"));
			
		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));			
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			
		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0062-32.gif"),JLabel.LEFT));					
			iconPanel.setBorder(BorderFactory.createEtchedBorder());

		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int n = JOptionPane.showConfirmDialog(
									dialog,
									"Continue save?",
									"Confirm save",
									JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION)
				{
					save();
					message();
					dispose();
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
	
	public void save()
	{
		student = new Student(firstName.getText().trim(),
							  lastName.getText().trim(),
							  Integer.valueOf(idNum.getText().trim()),
							  String.valueOf(course.getSelectedItem()),
							  String.valueOf(yearLevel.getSelectedItem()));
		
		studentList.getList().set(index,student);
		
		Student update = (Student)studentList.getList().get(index);
		new StudentRecordGUI(update.getFirstName(),
							 update.getLastName(),
							 update.getIdNum(),
							 update.getCourse(),
							 update.getYearLevel());
	}
	
	public void message()
	{
		JOptionPane.showMessageDialog(
					dialog,
					"Successfull.",
					"Message",
					JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void dispose()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}