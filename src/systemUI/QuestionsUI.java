package systemUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import parameters.*;


public class QuestionsUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuery;
	private JTextField txtName;
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	QuestionsUI(){
		
		prepareGUI();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		QuestionsUI questionsUI = new QuestionsUI();
		questionsUI.showQuestionCombobox();
	
	}

	/**
	 * Create the frame.
	 */
	private void prepareGUI(){
		mainFrame = new JFrame("Add Questions");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3,1));
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		headerLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		
		statusLabel.setSize(350,100);
		
		controlPanel = new JPanel();
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		}
	
	private void showQuestionCombobox(){
		headerLabel.setText("Select a question to ask the students");
		
		final DefaultComboBoxModel studentQuestions = new DefaultComboBoxModel();
		
		studentQuestions.addElement("What is your current GPA?");
		studentQuestions.addElement("Do you have any prior experience on this topic?");
		//students.addElement("");
		
		final JComboBox questionCombo = new JComboBox(studentQuestions);
		questionCombo.setSelectedIndex(0);
		questionCombo.setToolTipText("Hello");
		JScrollPane questionScrollPane = new JScrollPane(questionCombo);
		
		JButton showButton = new JButton("Add");
		JButton closeButton = new JButton("Done");
		
		showButton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				
				String tmpString = "";
				ParameterSpec tmpSpec = new ParameterSpec();
				if (questionCombo.getSelectedIndex() != -1){
					
					 tmpString = "Question Added: " 
			                  + questionCombo.getItemAt
			                    (questionCombo.getSelectedIndex());
			                    
					tmpSpec.addProperty(Param.QUERY,
							(String) questionCombo.getItemAt
							(questionCombo.getSelectedIndex()));
					if(questionCombo.getSelectedIndex()==0){
						tmpSpec.addProperty(Param.NAME,"GPA");
					}
					else if(questionCombo.getSelectedIndex()==1){
						tmpSpec.addProperty(Param.NAME,"EXP");
					}
				}
				statusLabel.setText(tmpString);

			}
		});
		
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				mainFrame.dispose();
			}
		});
		controlPanel.add(questionScrollPane);
		controlPanel.add(showButton);
		controlPanel.add(closeButton);
		mainFrame.setVisible(true);
	}
	
}
