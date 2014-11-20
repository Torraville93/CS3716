package SystemUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupPreferenceManager_UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseNumber;
	private JTextField txtGroupSize;
	public String courseNum;
	public int groupSize;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
				courseNum = txtCourseNumber.getText();
				groupSize = Integer.parseInt(txtGroupSize.getText());
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
}
