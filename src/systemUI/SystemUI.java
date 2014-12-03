package systemUI;

import generator.*;
import groupSystem.*;
import groups.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.io.IOException;
import java.util.ArrayList;

/**
 * Auto-generated UI class for group generating system.
 * Handles main GUI window in which essential information like course name, 
 * group size, deadline, and description is added. Student retrieval method, 
 * and group generating strategy can also be chosen from drop-down menus.
 */
public class SystemUI extends JFrame {

	private static final String NA = "Not available."; 
	
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
	 * All information should be added at this point to avoid exceptions.
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
		
		JLabel lblEnterGrpSize = new JLabel("Enter the desired group size (integer):");
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
		
		// Listens for Submit button press.
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!txtCourseName.getText().isEmpty()) { //If not empty
					system.setCourseName(txtCourseName.getText());
				} else { system.setCourseName(NA); } // Default input
				if (!txtDeadline.getText().isEmpty()) { //If not empty
					system.setDeadline(txtDeadline.getText());
				} else { system.setDeadline(NA); } // Default input
				if (!txtDescription.getText().isEmpty()) { //If not empty
					system.setDescription(txtDescription.getText());
				} else { system.setDescription(NA); } // Default input
				
				System.out.println("Course Name: "+system.getCourseName());
				System.out.println("Group Size: "+system.getGroupManager().getGroupSize());
				System.out.println("Deadline: "+system.getDeadline());
				System.out.println("Description: "+system.getDescription());
				
				// Get selection for student-retrieval method
				if (stuRetrievalBox.getSelectedIndex() == 0) {
					system.setRetrievalMethod(new StudentsFromFile());
					try {
						GroupSystem.students = system.getRetrievalMethod().getStudents();
					} catch (IOException e) { e.printStackTrace(); }
				} else if (stuRetrievalBox.getSelectedIndex() == 1) {
					JOptionPane.showMessageDialog(contentPane,
						    "Adding Students manually is not implemented.\nPlease try again.",
						    "Student Retrieval Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("Added students '"+stuRetrievalBox.getSelectedItem()+"': "+GroupSystem.students.size());
				
				int tmp = system.getGroupManager().getGroupSize(); //Set to default size
				
				//If groupsize is not empty & less equal to number of students
				if (!txtGroupSize.getText().isEmpty() &&
						Integer.parseInt(txtGroupSize.getText()) <= system.students.size()) {
					try {
						tmp = Integer.parseInt(txtGroupSize.getText());
						system.getGroupManager().setGroupSize(tmp);
					} catch(NumberFormatException e){ e.printStackTrace(); }
				} else { // Set default size
					JOptionPane.showMessageDialog(contentPane,
						    "Group size wasn't entered or was too large. "
						    + "Default size of 3 used. \nPlease try again.",
						    "Group Size Error",
						    JOptionPane.ERROR_MESSAGE);
					system.getGroupManager().setGroupSize(tmp);
				}
				
				// Get selection for group generating strategy
				if (genStrategyBox.getSelectedIndex() == 0) {
					 system.getGroupManager().setStrategy(new SimpleStrat());
					 btnGenerateButton.setEnabled(true);
				} else if (genStrategyBox.getSelectedIndex() == 1) {
					system.getGroupManager().setStrategy(new ParameterStrat());
					 qUI = new QuestionsUI(system);
					 qUI.setVisible(true);
					 btnGenerateButton.setEnabled(true);
				}
		      }
		    });
		
		//Generate groups using given information
		btnGenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				if (genStrategyBox.getSelectedIndex() == 1) //Used for demo
					simulateStudentsResponding();
				
				StringBuilder stringBuilder = new StringBuilder();
				GeneratorStrategy gs = system.getGroupManager().getStrategy();
				ArrayList<Group> aa = system.getGroupManager().generateGroups(gs);
				int grpNum = 1;
				stringBuilder.append("\nGenerating groups using "+genStrategyBox.getSelectedItem()+" strategy: ");
				for (Group grp: aa) {
					stringBuilder.append("\n\n --Group "+grpNum); grpNum++; 
					if (genStrategyBox.getSelectedIndex() == 0) {
						for (Student stu: grp.getStudents()) {
							stringBuilder.append("\n\t"+stu.getName());
						}
					} else if (genStrategyBox.getSelectedIndex() == 1) {
						for (Student stu: grp.getStudents()) {
							stringBuilder.append("\n\t"+stu.getName()+": ");
							for (int i=0; i < stu.getParameters().size(); i++) {
							stringBuilder.append(stu.getParameters().get(i).toString().split(",")[0] // parameter name
									+" - "+stu.getParameters().get(i).toString().split(",")[2]+" "); //response
							}
						}
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
	
	/**
	 * Helper method to simulate students each responding to instructors 
	 * questions. However, since we have yet to implement Users, and wanted to 
	 * avoid generating so many ResponseUI's, we're using this temporarily.
	 */
	private void simulateStudentsResponding() {
		//Purely for demonstration purposes.
		//Not needed if users are implemented with multi-threading.
		//Randomly generate student responses to questions
		if (system.getParameterList().size() == 1) { //Only one parameter
			if (system.getParameterList().get(0).getSpec().getProperty(Param.NAME).equalsIgnoreCase("GPA"))
				simulateGPA(0);
			else 
				simulateEXP(0);
		} else if (system.getParameterList().size() == 2) { //Both parameters
			if (system.getParameterList().get(0).getSpec().getProperty(Param.NAME).equalsIgnoreCase("GPA")) {
				simulateGPA(0);
				simulateEXP(1);
			} else {
				simulateEXP(0);
				simulateGPA(1);
			}
		}
	}
	
	/**
	 * Helper method to simulate students responding with their 
	 * respective GPA's. Generated pseudo-randomly with Math.random()
	 */
	private void simulateGPA(int index) {
		for (Student stu: system.students) {
			String myGPA = String.valueOf(Math.random()*3+1);
			String test = myGPA.substring(0, 4);
			stu.getParameters().get(index).getSpec().addProperty(Param.RESPONSE, test);
		}
	}
	
	/**
	 * Helper method to simulate students responding with their 
	 * respective experience. Generated at ~15% chance of 'Yes'.
	 */
	private void simulateEXP(int index) {
		for (Student stu: system.students) {
			int num = (Math.random()<0.15)?0:1; //Generate yes at ~15%
			String test;
			if (num == 0) test = "Yes";
			else test = "No";
			stu.getParameters().get(index).getSpec().addProperty(Param.RESPONSE, test);
		}
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
