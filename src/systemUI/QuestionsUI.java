package systemUI;

import groupSystem.GroupSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import parameters.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumMap;
import java.util.List;

public class QuestionsUI extends JFrame {

	private JPanel contentPane;
	private JTextArea txtQuery;
	private JTextField txtName;
	//private EnumMap<Param,String> tmpMap; 
	private GroupSystem system;

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

	public QuestionsUI() { system = new GroupSystem(); }
	public QuestionsUI(GroupSystem sys) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		system = sys;
		List<GroupParameter> tmpList = system.getParameterList();
		
		JLabel lblEnterParamName = new JLabel("Enter a parameter name (ie, GPA, experience):");
		lblEnterParamName.setBounds(12, 12, 337, 27);
		contentPane.add(lblEnterParamName);
		
		txtName = new JTextField();
		txtName.setBounds(12, 46, 120, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEnterParamQuery = new JLabel("Please enter your question for the students:");
		lblEnterParamQuery.setBounds(12, 79, 365, 41);
		contentPane.add(lblEnterParamQuery);
		
		txtQuery = new JTextArea(2,10);
		JScrollPane sp = new JScrollPane(txtQuery);
		sp.setBounds(12, 116, 327, 32);
		add(sp);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				EnumMap<Param,String> tmpMap = new EnumMap<Param,String>(Param.class);
				tmpMap.put(Param.NAME, txtName.getText()); 
				tmpMap.put(Param.QUERY, txtQuery.getText());
				tmpMap.put(Param.RESPONSE, null);
				system.getParameterList().add(new GroupParameter(new ParameterSpec(tmpMap)));
				System.out.println(system.getParameterList().size());
			}
		});
		btnAdd.setBounds(261, 162, 71, 25);
		contentPane.add(btnAdd);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		btnDone.setBounds(178, 162, 71, 25);
		contentPane.add(btnDone);
		
	}
}
