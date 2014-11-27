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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import parameters.*;
import retrieval.*;
import users.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;


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
	private JComboBox genStrategyBox;
	private JButton btnSubmitButton;
	private JButton btnGenerateButton;
	private GroupSystem system;
	private QuestionsUI qUI;
	
	/**
	 * Construct UI and swing widgets.
	 */
	public SystemUI() {
		super("Group Generator System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		system = new GroupSystem();
		
		JLabel lblEnterCourse = new JLabel("Enter the desired course name:");
		lblEnterCourse.setBounds(12, 16, 250, 15);
		contentPane.add(lblEnterCourse);
		txtCourseName = new JTextField();
		txtCourseName.setBounds(287, 12, 103, 27);
		contentPane.add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblEnterGrpSize = new JLabel("Enter the desired group size:");
		lblEnterGrpSize.setBounds(12, 55, 250, 15);
		contentPane.add(lblEnterGrpSize);
		txtGroupSize = new JTextField();
		txtGroupSize.setColumns(10);
		txtGroupSize.setBounds(287, 51, 103, 27);
		contentPane.add(txtGroupSize);
		
		JLabel lblEnterDeadline = new JLabel("Enter the desired deadline:");
		lblEnterDeadline.setBounds(12, 94, 250, 15);
		contentPane.add(lblEnterDeadline);
		txtDeadline = new JTextField();
		txtDeadline.setColumns(10);
		txtDeadline.setBounds(287, 90, 103, 27);
		contentPane.add(txtDeadline);
		
		JLabel lblEnterRetrieval = new JLabel("Select the desired student-retrieval:");
		lblEnterRetrieval.setBounds(12, 136, 250, 15);
		contentPane.add(lblEnterRetrieval);
		String[] retrievalTypes = { "From File", "Manually"};
		stuRetrievalBox = new JComboBox(retrievalTypes);
		stuRetrievalBox.setBounds(287, 129, 103, 27);
		contentPane.add(stuRetrievalBox);
		
		JLabel lblEnterStrategy = new JLabel("Select the desired generating strategy:");
		lblEnterStrategy.setBounds(12, 175, 250, 15);
		contentPane.add(lblEnterStrategy);
		String[] genStrategies = { "Simple", "Parameter"};
		genStrategyBox = new JComboBox(genStrategies);
		genStrategyBox.setBounds(287, 168, 103, 27);
		contentPane.add(genStrategyBox);
		
		JLabel lblEnterDescription = new JLabel("Enter project description:");
		lblEnterDescription.setBounds(12, 214, 250, 15);
		contentPane.add(lblEnterDescription);
		txtDescription = new JTextArea();
		JScrollPane sp = new JScrollPane(txtDescription);
		sp.setBounds(15, 232, 372, 127);
		add(sp);
		
		btnSubmitButton = new JButton("Submit");
		btnGenerateButton = new JButton("Generate Groups");
		btnGenerateButton.setEnabled(false);
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int tmp = system.getGroupManager().getGroupSize(); //Set to default size
				try {
					tmp = Integer.parseInt(txtGroupSize.getText());
				} catch(NumberFormatException e){ e.printStackTrace(); }
				system.setCourseName(txtCourseName.getText());
				System.out.println("Course Name: "+system.getCourseName());
				system.getGroupManager().setGroupSize(tmp);
				System.out.println("Group Size: "+system.getGroupManager().getGroupSize());
				system.setDeadline(txtDeadline.getText());
				System.out.println("Deadline: "+system.getDeadline());
				if (stuRetrievalBox.getSelectedIndex() == 0) {
					system.setRetrievalMethod(new StudentsFromFile());
					try {
						GroupSystem.students = system.getRetrievalMethod().getStudents();
					} catch (IOException e) { e.printStackTrace(); }
				} //else other method of getting students
				System.out.println("Added students '"+stuRetrievalBox.getSelectedItem()+"': "+GroupSystem.students.size());
				if (genStrategyBox.getSelectedIndex() == 0) {
					 system.getGroupManager().setStrategy(new SimpleStrat());
					 btnGenerateButton.setEnabled(true);
				} else if (genStrategyBox.getSelectedIndex() == 1) {
					system.getGroupManager().setStrategy(new ParameterStrat());
					 qUI = new QuestionsUI(system);
					 qUI.setVisible(true);
				}
				system.setDescription(txtDescription.getText());
				System.out.println("Description: "+system.getDescription());
		      }
		    });
		btnGenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				StringBuilder stringBuilder = new StringBuilder();
				GeneratorStrategy gs = system.getGroupManager().getStrategy();
				ArrayList<Group> aa = system.getGroupManager().generateGroups(gs);
				int grpNum = 1;
				stringBuilder.append("\nGenerating groups using "+genStrategyBox.getSelectedItem()+" strategy: ");
				for (Group grp: aa) {
					stringBuilder.append("\n\n --Group "+grpNum); grpNum++; 
					for (Student stu: grp.getStudents()) {
						stringBuilder.append("\n\t"+stu.getName());
					}
				}
				
				String groupOutput = stringBuilder.toString();		//Add all groups to a String
				JOptionPane.showMessageDialog(contentPane, groupOutput); //Output in pop-up
			}
		});
		
		btnSubmitButton.setBounds(315, 370, 75, 20);
		contentPane.add(btnSubmitButton);
		btnGenerateButton.setBounds(165, 370, 135, 20);
		contentPane.add(btnGenerateButton);
	}
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemUI frame = new SystemUI();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
