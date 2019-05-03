/*
 *	Name	Ryan Nilo Ybañez
 *
 **/

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class StudentRecordGUI extends JPanel
{
	static private final int BUTTON_INDEX = 8;

	static private JFrame 		frame;
	static private JTextField 	firstName, lastName, idNum, course, yearLevel;
	static private JLabel		numRecord;
	static private JButton[] 	button = new JButton[BUTTON_INDEX];

	private JPanel 		mainPanel, iconPanel,txtLblPanel;
	private JPanel 		symPanel, comPanel;
	private JLabel 		label, lblIcon;
	private JDialog 	dialog;

	private JButton		btnCount;
	private Action 		add,delete,search,edit,first,last,prev,next,count;

	public StudentRecordGUI(JFrame frame)
	{
		add 	= new Add("Add",frame);
		delete	= new Delete("Delete",frame);
		search  = new Search("Search",frame);
		edit	= new Edit("Edit",frame);

		first	= new First(null,new ImageIcon("image/first.gif"));
		last	= new Last(null, new ImageIcon("image/last.gif"));
		prev	= new Prev(null, new ImageIcon("image/prev.gif"));
		next	= new Next(null, new ImageIcon("image/next.gif"));

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		JToolBar toolBar = new JToolBar("ToolBar");
		toolBar.setFloatable(false);
        toolBar.setRollover(true);

		txtLblPanel = new JPanel();
		iconPanel	= new JPanel();
		symPanel	= new JPanel();
		comPanel	= new JPanel();

		toolBar.add(button[0] = new JButton(first));
		toolBar.add(button[1] = new JButton(prev));
		toolBar.add(button[2] = new JButton(next));
		toolBar.add(button[3] = new JButton(last));
		toolBar.addSeparator();
		toolBar.add(numRecord = new JLabel("Record #: 0"));

		button[4] = new JButton(add);
		button[5] = new JButton(edit);
		button[6] = new JButton(search);
		button[7] = new JButton(delete);

		button[5].setEnabled(false);
		button[6].setEnabled(false);
		button[7].setEnabled(false);

		button[4].setPreferredSize(new Dimension(80,26));
		button[5].setPreferredSize(new Dimension(80,26));
		button[6].setPreferredSize(new Dimension(80,26));
		button[7].setPreferredSize(new Dimension(80,26));

		button[0].setToolTipText("First");
		button[1].setToolTipText("Previous");
		button[2].setToolTipText("Next");
		button[3].setToolTipText("Last");

		addLayout();

		mainPanel 	= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createTitledBorder("Student Information"),
							BorderFactory.createEmptyBorder(5,5,5,5)));

		mainPanel.add(txtLblPanel);

		JPanel layout = new JPanel();
			layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(iconPanel);
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(mainPanel);
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(comPanel);

		add(toolBar, BorderLayout.PAGE_START);
		add(layout,	 BorderLayout.PAGE_END);

	}

	public StudentRecordGUI(boolean tF)
	{
		button[5].setEnabled(tF);
		button[6].setEnabled(tF);
		button[7].setEnabled(tF);
	}

	public StudentRecordGUI(int n)
	{
		numRecord.setText("Record #: " + String.valueOf(n));
	}

	public StudentRecordGUI(String firstname, String lastname, Integer num, String c, String yearlevel)
	{
		idNum.setText(String.valueOf(num));
		firstName.setText(firstname);
		lastName.setText(lastname);
		course.setText(c);
		yearLevel.setText(yearlevel);
	}

	public void addLayout()
	{
		JPanel lblPanel = new JPanel();
		lblPanel.setLayout(new GridLayout(5,1,25,5));
			lblPanel.add(label = new JLabel("Student Id :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("First Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Last Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Course :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Year Level :",JLabel.RIGHT));

		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(5,1,25,0));
			txtPanel.add(idNum 		= new JTextField(25));
			txtPanel.add(firstName	= new JTextField(25));
			txtPanel.add(lastName   = new JTextField(25));
			txtPanel.add(course 	= new JTextField(25));
			txtPanel.add(yearLevel 	= new JTextField(25));

			idNum.setHorizontalAlignment(JTextField.CENTER);
			firstName.setHorizontalAlignment(JTextField.CENTER);
			lastName.setHorizontalAlignment(JTextField.CENTER);
			course.setHorizontalAlignment(JTextField.CENTER);
			yearLevel.setHorizontalAlignment(JTextField.CENTER);

			idNum.setFocusable(false);
			firstName.setFocusable(false);
			lastName.setFocusable(false);
			course.setFocusable(false);
			yearLevel.setFocusable(false);

		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			txtLblPanel.setPreferredSize(new Dimension(350,130));

		comPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
			for(int i = 4; i < button.length; i++){
				comPanel.add(button[i]);
				button[i].setFont(new Font("sans-serif",Font.PLAIN,10));
			}

		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0054-32.gif")));
			iconPanel.setBorder(BorderFactory.createEtchedBorder());
	}

	public static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Student Record");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(new StudentRecordGUI(frame));

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public static void main(String[] args)
	{
		Runnable doRun = new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		};

        javax.swing.SwingUtilities.invokeLater(doRun);
	}
}