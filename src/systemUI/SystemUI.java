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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import retrieval.*;
import users.*;

import java.awt.event.ActionEvent;
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
	private JComboBox stuRetrievalBox;
	private GroupSystem system;
	
	/**
	 * Construct UI and swing widgets.
	 */
	public SystemUI() {
		super("Group Generator System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 398);
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
		
		JLabel lblEnterRetrieval = new JLabel("Enter the desired student-retrieval:");
		lblEnterRetrieval.setBounds(12, 133, 250, 15);
		contentPane.add(lblEnterRetrieval);
		String[] retrievalTypes = { "From file", "Manually"};
		stuRetrievalBox = new JComboBox(retrievalTypes);
		stuRetrievalBox.setBounds(271, 129, 103, 27);
		contentPane.add(stuRetrievalBox);
		
		JLabel lblEnterDescription = new JLabel("Enter project description:");
		lblEnterDescription.setBounds(12, 178, 250, 15);
		contentPane.add(lblEnterDescription);
		txtDescription = new JTextArea();
		JScrollPane sp = new JScrollPane(txtDescription);
		sp.setBounds(12, 202, 362, 127);
		add(sp);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				int tmp = system.getGroupManager().getGroupSize(); //Set to default size
				try {
					tmp = Integer.parseInt(txtGroupSize.getText());
				} catch(NumberFormatException e){ e.printStackTrace(); }
				system.getGroupManager().setGroupSize(tmp);
				System.out.println("Group Size: "+system.getGroupManager().getGroupSize());
				system.setCourseName(txtCourseName.getText());
				System.out.println("Course Name: "+system.getCourseName());
				system.setDeadline(txtDeadline.getText());
				System.out.println("Deadline: "+system.getDeadline());
				if (stuRetrievalBox.getSelectedIndex() == 0) {
					system.setRetrievalMethod(new StudentsFromFile());
					try {
						system.students = system.getRetrievalMethod().getStudents();
					} catch (IOException e) { e.printStackTrace(); }
				}
				//else other method of getting students
				System.out.println("Added students: "+system.students.size());
				system.setDescription(txtDescription.getText());
				System.out.println("Description: "+system.getDescription());
			}
		});
		btnSubmitButton.setBounds(271, 335, 100, 20);
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
