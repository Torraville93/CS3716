package systemUI;

import groupSystem.GroupSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import parameters.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * GUI class to handle responses added by students.
 * Allows students to add custom responses, but may have been wise to 
 * make it more concrete to show how it works, and reduce possible errors.
 */
public class ResponseUI extends JFrame {

	private JPanel contentPane;
	private JTextArea txtQuery;
	private JTextArea txtResponse;
	private GroupSystem system;
	private int count;
	private List<GroupParameter> tmpList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponseUI frame = new ResponseUI();
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
	public ResponseUI() { system = new GroupSystem();}
	public ResponseUI(GroupSystem sys) {
		super("Student Responses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		system = sys;
		//-----------------------------
		tmpList = system.getParameterList();
		//fillList(tmpList);
		System.out.println("ParamListSize"+tmpList.size());
		//-----------------------------
		JLabel lblAllParameters = new JLabel("Instructor question: ");
		lblAllParameters.setBounds(12, 12, 337, 27);
		contentPane.add(lblAllParameters);
		txtQuery = new JTextArea(2,10); txtQuery.setEditable(false);
		JScrollPane sp1 = new JScrollPane(txtQuery);
		sp1.setBounds(12, 46, 327, 64);
		add(sp1);
		//-----------------------------
		txtQuery.setText(showParameterString(tmpList.get(0)));
		//-----------------------------
		JLabel lblEnterResponse = new JLabel("Please enter a response: ");
		lblEnterResponse.setBounds(12, 111, 365, 41);
		contentPane.add(lblEnterResponse);
		txtResponse = new JTextArea(2,10);
		JScrollPane sp2 = new JScrollPane(txtResponse);
		sp2.setBounds(12, 148, 327, 40);
		add(sp2);
		
		// Listens for Response button press.
		final JButton btnAdd = new JButton("Respond");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (count < tmpList.size()) {
					tmpList.get(count).getSpec().addProperty(Param.RESPONSE,txtResponse.getText());
					count++;
					if (count < tmpList.size())
					txtQuery.setText(showParameterString(tmpList.get(count)));
					else btnAdd.setEnabled(false);
					txtResponse.setText(null);
				}
			}
		});
		btnAdd.setBounds(261, 212, 86, 25);
		contentPane.add(btnAdd);
		
		// Listens for Done button press
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//-----------------------------
				for (int i=0; i< tmpList.size(); i++) {
					System.out.println(tmpList.get(i).toString());
				}
				//-----------------------------
				dispose();
			}
		});
		btnDone.setBounds(178, 212, 71, 25);
		contentPane.add(btnDone);
	}
	
	/**
	 * Simplifies method call to create string representations 
	 * of instructor-added parameter's name and query.
	 * @param groupParameter - the given GroupParameter
	 * @return - parameter name and query
	 */
	private String showParameterString(GroupParameter groupParameter) {
		return "Name: "+groupParameter.toString().split(",")[0]+
				"\nQuestion: "+groupParameter.toString().split(",")[1].trim();
	}
}
