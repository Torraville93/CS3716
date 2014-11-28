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
					ResponseUI frame = new ResponseUI(new GroupSystem());
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ResponseUI() {}
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
		tmpList = sys.getParameterList();
		fillList(tmpList);
		System.out.println(tmpList.size());
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
		
		JButton btnAdd = new JButton("Respond");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (count < tmpList.size()-1) {
					tmpList.get(count).getSpec().addProperty(Param.RESPONSE,txtResponse.getText());
					count++;
					txtQuery.setText(showParameterString(tmpList.get(count)));
					txtResponse.setText(null);
				}
			}
		});
		btnAdd.setBounds(261, 212, 86, 25);
		contentPane.add(btnAdd);
		
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

	private String showParameterString(GroupParameter groupParameter) {
		return groupParameter.toString().split(",")[0]+
				"\n"+groupParameter.toString().split(",")[1].trim();
	}

	private void fillList(List<GroupParameter> tmpList) {
		for (int i=0; i < 3; i++) {
			EnumMap<Param,String> tmpMap = new EnumMap<Param,String>(Param.class);
			tmpMap.put(Param.NAME, "name "+i); tmpMap.put(Param.QUERY, "query "+i);
			tmpMap.put(Param.RESPONSE, null);
			tmpList.add(new GroupParameter(new ParameterSpec(tmpMap)));
		}
	}
}
