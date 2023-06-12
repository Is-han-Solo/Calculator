import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class main implements ActionListener
{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 60);
	
	double numOne = 0, numTwo = 0, result = 0;
	char operator;
	
	
	main()
	{
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(840, 1100);
		frame.setLayout(null);
		
		
		
		textfield = new JTextField();
		textfield.setBounds(100, 50, 600, 100);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for (int i = 0; i < functionButtons.length; i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i));
			
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(100, 860, 200, 100);
		delButton.setBounds(300, 860, 200, 100);
		clrButton.setBounds(500, 860, 200, 100);
		
		panel = new JPanel();
		panel.setBounds(100, 200, 600, 600);
		panel.setLayout(new GridLayout(4, 4, 20, 20));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.add(textfield);
		
		
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		main calc = new main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < 10; i++)
		{
			if (e.getSource() == numberButtons[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if (e.getSource() == decButton)
		{
			textfield.setText(textfield.getText().concat(String.valueOf(".")));
		}
		
		if (e.getSource() == addButton)
		{
			numOne = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if (e.getSource() == subButton)
		{
			numOne = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if (e.getSource() == mulButton)
		{
			numOne = Double.parseDouble(textfield.getText());
			operator = 'x';
			textfield.setText("");
		}
		
		if (e.getSource() == divButton)
		{
			numOne = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if (e.getSource() == equButton)
		{
			numTwo = Double.parseDouble(textfield.getText());
			switch (operator)
			{
			case '+':
				result = numOne + numTwo;
				break;
			case '-':
				result = numOne - numTwo;
				break;
			case 'x':
				result = numOne * numTwo;
				break;
			case '/':
				if (numTwo == 0)
				{
					result = 0;
				}
				else
				{
					result = numOne / numTwo;
				}
				
				break;
			default:
				textfield.setText("Calculator is broken");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e1) {
					
				}
				System.exit(0);
			}
			
			textfield.setText(String.valueOf(result));
			numOne = result;
		}
		
		if (e.getSource() == clrButton)
		{
			textfield.setText("");
		}
		
		if (e.getSource() == delButton)
		{
			String currentText = textfield.getText();
			textfield.setText("");
			
			for (int i = 0; i < currentText.length() - 1; i++)
			{
				textfield.setText(textfield.getText() + currentText.charAt(i));
			}
		}
		
		if (e.getSource() == negButton)
		{
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
