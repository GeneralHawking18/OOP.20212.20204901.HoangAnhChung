package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
		//setTitle("Test");
	}
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		cp.add(new JLabel("Label"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		//List<LookAndFeelInfo> lafInfos = Arrays.asList(UIManager.getInstalledLookAndFeels());
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		//LookAndFeelInfo[] test = Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
			      //.toArray(size -> (T[]);
		//lafInfos.add(UIManager.getCrossPlatformLookAndFeelClassName());
		
		String[] lafClassNames = new String[lafInfos.length + 2];
		String[] lafNames = new String[lafInfos.length + 2];
		
		for (int i = 0; i < lafInfos.length; i ++) {
			lafNames[i] = lafInfos[i].getName();
			lafClassNames[i] = lafInfos[i].getClassName();
		}
		lafNames[lafInfos.length] = "Java";
		lafNames[lafInfos.length + 1] = "System";
		lafClassNames[lafInfos.length] = UIManager.getCrossPlatformLookAndFeelClassName();
		lafClassNames[lafInfos.length + 1] = UIManager.getSystemLookAndFeelClassName();
		
		
		
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafClassNames[index]/*.getClassName()*/);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				SwingUtilities.updateComponentTreeUI(frame);
				//setTitle(lafInfos[index].getName() + " Look And Feel");
				setTitle(lafNames[index] + " Look And Feel");
				
			}
		});
	}
	
	public static void main(String... args) {
		new LookAndFeelDemo();
		
	}
	
}
