package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingAccumulator extends JFrame{
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum;
	
	public SwingAccumulator() {
		Container cp = getContentPane();
		
		setLayout(new GridLayout(2, 2));
		
		cp.add(new JLabel("Enter an Integer"));
		
		tfInput = new JTextField(10);
		tfInput.addActionListener(new TFInputListener());
		cp.add(tfInput);
		
		
		cp.add(new JLabel("The accumulative sum is: "));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("Swing accumulator");
		setSize(350, 120);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	private class TFInputListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			int NumberIn = Integer.parseInt(tfInput.getText());
			sum += NumberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
	
}
