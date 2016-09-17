import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.SystemColor;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox comboBox_4;
	
	String subUnit;
	private JTextField textField_2;
	//private JText
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Frame1() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 652, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox_3.setEnabled(false);
		comboBox_3.addItem("Parallel");
		comboBox_3.addItem("Series");
		comboBox_3.addContainerListener(new ContainerAdapter() {
				
			

			@Override
			public void componentAdded(ContainerEvent arg0) {
					}
		});
		comboBox_3.setBounds(107, 128, 114, 20);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.setSelectedIndex(-1);
		//comboBox_4.setSelectedIndex(-1);
		
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.setEnabled(false);
		btnAdd.setBackground(new Color(0, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField_1.getText();
				double Relia=0.0;
				boolean isSet = rdbtnNewRadioButton.isSelected();
				boolean isSet1 = rdbtnNewRadioButton_1.isSelected();
				
				
				if(isSet){
					int i;
					boolean flag = false;
					for(i =0; i < comboBox_4.getItemCount(); i++){
						String str = (String) comboBox_4.getItemAt(i);
						if(str.equals(s))
							flag = true;
					}
					if(flag != true)
						comboBox_4.addItem(s);
					textField_1.setText("");
					
					
				}
				if(isSet){
					Relia = 0.0;
				}
				if(isSet1){
					Relia = Double.parseDouble(textField_2.getText());
					textField_2.setText("");
					textField_1.setText("");
				}
				
				if(isSet){
					 subUnit = "no";
				}
				else{ subUnit = "yes";}
				

				
				//from
				
				try {
					String rel = String.valueOf(comboBox_3.getSelectedItem());
					
					
					
					String superU = String.valueOf(comboBox_4.getSelectedItem());
			
					database.insert(rel,superU,s,subUnit,"","",111,Relia);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//to
			}
		});
		btnAdd.setBounds(272, 77, 67, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblRelationship.setBounds(15, 131, 82, 14);
		frame.getContentPane().add(lblRelationship);
		
		JLabel lblSuperUnit = new JLabel("Super Unit");
		lblSuperUnit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblSuperUnit.setBounds(15, 193, 82, 14);
		frame.getContentPane().add(lblSuperUnit);
		
		JLabel lblNewLabel = new JLabel("Enter the Name of your System :");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 22, 196, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(242, 19, 235, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		rdbtnNewRadioButton = new JRadioButton("This contains more sub units");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBounds(374, 81, 256, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("This is the lowest maintainable unit");
		rdbtnNewRadioButton_1.setEnabled(false);
		rdbtnNewRadioButton_1.setBounds(374, 110, 256, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setEnabled(false);
		comboBox_4.setBounds(107, 190, 152, 20);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.setSelectedIndex(-1);
		
		JLabel lblSubUnit = new JLabel("Sub Unit");
		lblSubUnit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblSubUnit.setBounds(27, 81, 77, 14);
		frame.getContentPane().add(lblSubUnit);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(107, 78, 145, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = 	new JTextField();
		textField_2.setBounds(477, 156, 77, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNext = new JButton("Next ");
		btnNext.setToolTipText("once you select this , you cannot change name of your system");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField.getText();
				if(s != ""){
				
				comboBox_4.setEnabled(true);
				comboBox_4.addItem(s);
				textField_1.setEnabled(true);
				textField.setEnabled(false);
				comboBox_3.setEnabled(true);
				btnAdd.setEnabled(true);
				rdbtnNewRadioButton.setEnabled(true);
				rdbtnNewRadioButton_1.setEnabled(true);
				}
			}
		});
		
		
		btnNext.setBackground(new Color(51, 204, 255));
		btnNext.setBounds(487, 20, 67, 18);
		frame.getContentPane().add(btnNext);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					database.calculate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCalculate.setBounds(537, 235, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
	
		JLabel lblEnterRelibiltyOf = new JLabel("Enter Relibilty of Basic Unit");
		lblEnterRelibiltyOf.setBounds(324, 159, 182, 14);
		frame.getContentPane().add(lblEnterRelibiltyOf);
	
	}
}
/*
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.SystemColor;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox comboBox_4;
	
	String subUnit;
	private JTextField textField_2;
	//private JText
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame1() {
		initialize();
	}

		private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 652, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox_3.setEnabled(false);
		comboBox_3.addItem("Parallel");
		comboBox_3.addItem("Series");
		comboBox_3.addContainerListener(new ContainerAdapter() {
				
			

			@Override
			public void componentAdded(ContainerEvent arg0) {
					}
		});
		comboBox_3.setBounds(33, 94, 114, 20);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.setSelectedIndex(-1);
		//comboBox_4.setSelectedIndex(-1);
		
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.setEnabled(false);
		btnAdd.setBackground(new Color(0, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField_1.getText();
				double Relia = 0.0;
				boolean isSet = rdbtnNewRadioButton.isSelected();
				boolean isSet1 = rdbtnNewRadioButton_1.isSelected();
				
				
				if(isSet){
					int i;
					boolean flag = false;
					for(i =0; i < comboBox_4.getItemCount(); i++){
						String str = (String) comboBox_4.getItemAt(i);
						if(str.equals(s))
							flag = true;
					}
					if(flag != true)
						comboBox_4.addItem(s);
					textField_1.setText("");
					
				}
				if(isSet){
					Relia = 0.0;
				}
				if(isSet1){
					Relia = Double.parseDouble(textField_2.getText());
					textField_2.setText("");
					textField_1.setText("");
				}
				
				if(isSet){
					 subUnit = "no";
				}
				else{ subUnit = "yes";}
				

				
				//from
				
				try {
					String rel = String.valueOf(comboBox_3.getSelectedItem());
					
					
					
					String superU = String.valueOf(comboBox_4.getSelectedItem());
					if(isSet){
						Relia = 1.0;
					}
					database.insert(rel,superU,s,subUnit,1,11,111,Relia);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//to
			}
		});
		btnAdd.setBounds(508, 93, 67, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblRelationship.setBounds(41, 73, 82, 14);
		frame.getContentPane().add(lblRelationship);
		
		JLabel lblSuperUnit = new JLabel("Super Unit");
		lblSuperUnit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblSuperUnit.setBounds(200, 73, 82, 14);
		frame.getContentPane().add(lblSuperUnit);
		
		JLabel lblNewLabel = new JLabel("Enter the Name of your System :");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 22, 196, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(242, 19, 235, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		rdbtnNewRadioButton = new JRadioButton("This contains more sub units");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBounds(353, 126, 256, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("This is the lowest maintainable unit");
		rdbtnNewRadioButton_1.setEnabled(false);
		rdbtnNewRadioButton_1.setBounds(353, 152, 256, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setEnabled(false);
		comboBox_4.setBounds(175, 94, 152, 20);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.setSelectedIndex(-1);
		
		JLabel lblSubUnit = new JLabel("Sub Unit");
		lblSubUnit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblSubUnit.setBounds(400, 73, 77, 14);
		frame.getContentPane().add(lblSubUnit);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(353, 94, 145, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = 	new JTextField();
		textField_2.setBounds(353, 212, 77, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNext = new JButton("Next ");
		btnNext.setToolTipText("once you select this , you cannot change name of your system");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField.getText();
				if(s != ""){
				
				comboBox_4.setEnabled(true);
				comboBox_4.addItem(s);
				textField_1.setEnabled(true);
				textField.setEnabled(false);
				comboBox_3.setEnabled(true);
				btnAdd.setEnabled(true);
				rdbtnNewRadioButton.setEnabled(true);
				rdbtnNewRadioButton_1.setEnabled(true);
				}
			}
		});
		
		
		btnNext.setBackground(new Color(51, 204, 255));
		btnNext.setBounds(487, 20, 67, 18);
		frame.getContentPane().add(btnNext);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					database.calculate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCalculate.setBounds(486, 319, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
	
		JLabel lblEnterRelibiltyOf = new JLabel("Enter Relibilty of Basic Unit");
		lblEnterRelibiltyOf.setBounds(353, 193, 182, 14);
		frame.getContentPane().add(lblEnterRelibiltyOf);
		
		JButton btnReliability = new JButton("Reliability");
		btnReliability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Reliability.calculateReliability();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnReliability.setBounds(353, 318, 97, 25);
		frame.getContentPane().add(btnReliability);
	
	}
}
*/