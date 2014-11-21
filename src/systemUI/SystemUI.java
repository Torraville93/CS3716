package systemUI;

import generator.*;
import groupSystem.*;
import groups.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Auto-generated UI class for group generating system.
 */
public class SystemUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseName;
	private JTextField txtGroupSize;
	private JTextField txtDeadline;
	private JTextArea txtDescription;
	private GroupSystem system;
	
	/**
	 * Construct UI and swing widgets.
	 */
	public SystemUI() {
		super("Group Generator System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		system = new GroupSystem();
		
		JLabel lblEnterCourse = new JLabel("Enter the desired course name:");
		lblEnterCourse.setBounds(12, 16, 250, 15);
		contentPane.add(lblEnterCourse);
		txtCourseName = new JTextField();
		txtCourseName.setBounds(271, 12, 103, 27);
		contentPane.add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblEnterGrpSize = new JLabel("Enter the desired group size:");
		lblEnterGrpSize.setBounds(12, 55, 250, 15);
		contentPane.add(lblEnterGrpSize);
		txtGroupSize = new JTextField();
		txtGroupSize.setColumns(10);
		txtGroupSize.setBounds(271, 51, 103, 27);
		contentPane.add(txtGroupSize);
		
		JLabel lblEnterDeadline = new JLabel("Enter the desired deadline:");
		lblEnterDeadline.setBounds(12, 94, 250, 15);
		contentPane.add(lblEnterDeadline);
		txtDeadline = new JTextField();
		txtDeadline.setColumns(10);
		txtDeadline.setBounds(271, 90, 103, 27);
		contentPane.add(txtDeadline);
		
		JLabel lblEnterDescription = new JLabel("Enter project description:");
		lblEnterDescription.setBounds(12, 133, 250, 15);
		contentPane.add(lblEnterDescription);
		txtDescription = new JTextArea();
		JScrollPane sp = new JScrollPane(txtDescription);
		sp.setBounds(12, 152, 362, 127);
		add(sp);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				int tmp = 0;
				try {
					tmp = Integer.parseInt(txtGroupSize.getText());
				}
				catch(NumberFormatException e){
					e.printStackTrace();
				}
				system.getGroupManager().setGroupSize(tmp);
				system.setCourseName(txtCourseName.getText());
				system.setDeadline(txtDeadline.getText());
				system.setDescription(txtDescription.getText());
				
				ArrayList<Group> tmpList = 
						system.getGroupManager().generateGroups(new SimpleStrat());
				for(Group grp: tmpList) {
					for (Student stu: grp.getStudents()) {
						String str = stu.getName() +" "+ stu.getID() +" ";
						System.out.println(str);
					}
				}
				//Output to file for now
				/*ArrayList<Group> tmpList = 
						system.getGroupManager().generateGroups(new SimpleStrat());
				FileWriter writer;
				try {
					writer = new FileWriter("output.txt");
					for(Group grp: tmpList) {
						for (Student stu: grp.getStudents()) {
							String str = stu.getName() +" "+ stu.getID() +" ";
							System.out.println(str);
							writer.write(str); 
						}
					}
					
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				} */
				
			}
		});
		btnSubmitButton.setBounds(271, 300, 100, 20);
		contentPane.add(btnSubmitButton);
	}
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemUI frame = new SystemUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}





/*
public class GroupPreferenceManager_UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseNumber;
	private JTextField txtGroupSize;
	public String courseNum;
	public int groupSize;

	 // Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupPreferenceManager_UI frame = new GroupPreferenceManager_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 // Create the frame.
	public GroupPreferenceManager_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				groupSize = Integer.parseInt(txtGroupSize.getText());
				courseNum = txtCourseNumber.getText();
				GroupSystem sys = new GroupSystem();
				sys.setGroupSize(groupSize);
			}
		});
		btnSubmitButton.setBounds(271, 88, 106, 40);
		contentPane.add(btnSubmitButton);
		
		JLabel lblEnterCourse = new JLabel("Enter the desired course number:");
		lblEnterCourse.setBounds(12, 16, 250, 15);
		contentPane.add(lblEnterCourse);
		
		txtCourseNumber = new JTextField();
		txtCourseNumber.setBounds(271, 10, 103, 27);
		contentPane.add(txtCourseNumber);
		txtCourseNumber.setColumns(10);
		
		txtGroupSize = new JTextField();
		txtGroupSize.setColumns(10);
		txtGroupSize.setBounds(271, 49, 103, 27);
		contentPane.add(txtGroupSize);
		
		JLabel lblEnterTheDesired = new JLabel("Enter the desired group size:");
		lblEnterTheDesired.setBounds(12, 55, 250, 15);
		contentPane.add(lblEnterTheDesired);
	}
	
	public int getSizeOfGroup() {
		return groupSize;
	}
}*/
