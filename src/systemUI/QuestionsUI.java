package systemUI;

import groupSystem.GroupSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import parameters.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EnumMap;

/**
 * GUI class to handle questions added by instructor.
 * Originally allowed instructor to add custom questions, but was asked to 
 * make it more concrete to show how it works, and reduce possible errors.
 */
public class QuestionsUI extends JFrame {
	
	private static final String[] questions = {"Please enter your current GPA",
		"Do you have any prior experience on this topic?"};

	private JPanel contentPane;
	private JTextArea txtQuery;
	private GroupSystem system;
	private JComboBox paramNameBox;
	private ResponseUI rUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionsUI frame = new QuestionsUI(new GroupSystem());
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructors. Initialise GUI with specified widgets.
	 */
	public QuestionsUI() { system = new GroupSystem(); }
	public QuestionsUI(GroupSystem sys) {
		super("Instructor Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		system = sys;
		
		JLabel lblEnterParamName = new JLabel("Choose a parameter name (ie, GPA, experience):");
		lblEnterParamName.setBounds(12, 12, 337, 27);
		contentPane.add(lblEnterParamName);
		
		String[] paramNames = { "GPA", "Experience"};
		paramNameBox = new JComboBox(paramNames);
		paramNameBox.setBounds(12, 46, 120, 32);
		contentPane.add(paramNameBox);
		
		JLabel lblEnterParamQuery = new JLabel("Chosen question for the students:");
		lblEnterParamQuery.setBounds(12, 79, 365, 41);
		contentPane.add(lblEnterParamQuery);
		
		txtQuery = new JTextArea(2,10); txtQuery.setEditable(false);
		JScrollPane sp = new JScrollPane(txtQuery);
		sp.setBounds(12, 116, 327, 32);
		add(sp);
		txtQuery.setText(questions[0]); //Default question choice
		
		// Listens for parameter name combobox selection.
		paramNameBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		        if (e.getItem().equals("GPA")) { 
		        	txtQuery.setText(questions[0]); 
		        }
		        if (e.getItem().equals("Experience")) { 
		        	txtQuery.setText(questions[1]); 
		        }
			}
	    });
		
		// Listens for Add button press.
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				EnumMap<Param,String> tmpMap = new EnumMap<Param,String>(Param.class);
				tmpMap.put(Param.NAME, (String) paramNameBox.getSelectedItem()); 
				tmpMap.put(Param.QUERY, txtQuery.getText());
				tmpMap.put(Param.RESPONSE, null);
				system.getParameterList().add(new GroupParameter(new ParameterSpec(tmpMap)));
				//-----------------------------
				System.out.println(system.getParameterList().size());
				//-----------------------------
				txtQuery.setText(null);
			}
		});
		btnAdd.setBounds(261, 162, 71, 25);
		contentPane.add(btnAdd);
		
		// Listens for Done button press
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				system.initStuParamLists();
				//-----------------------------
				for (int i=0; i< system.getParameterList().size(); i++) {
					System.out.println(system.getParameterList().get(i).toString());
				}
				//-----------------------------

				//For each student, open ResponseUI to get their responses
				//Would ideally have a thread for each student instead.
//				for(Student student: system.students){
//					rUI = new ResponseUI(system, student);
//					rUI.setVisible(true);
//				}
				rUI = new ResponseUI(system);
				rUI.setVisible(true);
				dispose();
			}
		});
		btnDone.setBounds(178, 162, 71, 25);
		contentPane.add(btnDone);
		
	}
}
