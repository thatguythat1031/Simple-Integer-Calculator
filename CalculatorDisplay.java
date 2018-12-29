import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CalculatorDisplay 
{
	
	//for now will only work with 2-part operations: i.e if you do 1 + 1 or
	// 2 / 2, etc. Doing 3 or more part operations without pressing "=" would
	//require dynamically creating fields.
	//maybe add function to be able to do operations to the answer later.
	
	private String displayString;
	private int answer;
	private JButton plusButton;
	private JLabel padOne;
	private JLabel padTwo;
	private JLabel padThree;
	private JLabel padFour;
	private JButton minusButton;
	private JButton divButton;
	private JButton multButton;
	private JButton quit;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;
	private JButton eq;
	private TextField finalDisplay;
	private TextField stringDisplay;
	
	//these two are for doing operations.
	private int tempStorageOne;
	private int tempStorageTwo;
	private String operatorString;
	
	public static void main(String args[])
	{
		new CalculatorDisplay();
	}
	
	/**
	 * Creates a new Calculator instance.
	 * Sets up all the buttons.
	 */
	public CalculatorDisplay()
	{
		//create frame and set layout.
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(7, 2));
		
		//create display text
		displayString = "";
		finalDisplay = new TextField("The answer is: " + answer);
		stringDisplay = new TextField("The current input is: " + displayString);
		
		//create button text
		padOne = new JLabel();
		padTwo = new JLabel();
		padThree = new JLabel();
		padFour = new JLabel();
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		plusButton = new JButton("+"); //add actions later, will go in as parameter. (.addActionListener(name of actionlistener))
		minusButton = new JButton("-");
		divButton = new JButton("/");
		multButton = new JButton("*");
		quit = new JButton("Quit");
		eq = new JButton("=");
		
		//set button colors
		padOne.setBackground(Color.gray); 
		padTwo.setBackground(Color.gray);
		padThree.setBackground(Color.gray);
		padFour.setBackground(Color.gray);
		plusButton.setBackground(Color.orange);
		minusButton.setBackground(Color.orange);
		divButton.setBackground(Color.orange);
		multButton.setBackground(Color.orange);
		quit.setBackground(Color.RED);
		eq.setBackground(Color.orange);
		
		//add top two rows.
		frame.add(padOne);
		frame.add(finalDisplay); 
		frame.add(padTwo); 
		frame.add(padThree);
		frame.add(stringDisplay);
		frame.add(eq);
		
		//add the rest of the rows.
		frame.add(one);
		frame.add(two);
		frame.add(plusButton);
		frame.add(three);
		frame.add(four);
		frame.add(minusButton);
		frame.add(five);
		frame.add(six);
		frame.add(divButton);
		frame.add(seven);
		frame.add(eight);
		frame.add(multButton);
		frame.add(nine);
		frame.add(zero);
		frame.add(quit);
		
		//Make frame visible and set size and title
		frame.setTitle("Simple Calculator");
	    frame.setSize(600, 375); 
	    frame.setVisible(true);
	    
	    //make displays non-editable.
	    finalDisplay.setEditable(false);
	    stringDisplay.setEditable(false);
	    
	    //make actionListeners for buttons
	    quit.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		System.exit(0);
	    	}
	    });
	    
	    one.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("1");
	    	}
	    });
	    
	    two.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("2");
	    	}
	    });
	    
	    three.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("3");
	    	}
	    });
	    
	    four.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("4");
	    	}
	    });
	    
	    five.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("5");
	    	}
	    });
	    
	    six.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("6");
	    	}
	    });
	    
	    seven.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("7");
	    	}
	    });
	    
	    eight.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("8");
	    	}
	    });
	    
	    nine.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("9");
	    	}
	    });
	    
	    zero.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("0");
	    	}
	    });
	    
	    plusButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("+");
	    	}
	    });
	    
	    minusButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("-");
	    	}
	    });
	    
	    divButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("/");
	    	}
	    });
	    
	    multButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("*");
	    	}
	    });
	    
	    eq.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		updateDisplayString("=");
	    		
	    		if (operatorString.equals("+"))
	    		{
	    			answer = tempStorageOne + tempStorageTwo;
	    			finalDisplay.setText("The answer is: " + answer);
	    			
	    		}
	    		else if (operatorString.equals("-"))
	    		{
	    			answer = tempStorageOne - tempStorageTwo;
	    			finalDisplay.setText("The answer is: " + answer);
	    		}
	    		else if (operatorString.equals("/"))
	    		{
	    			answer = tempStorageOne / tempStorageTwo;
	    			finalDisplay.setText("The answer is: " + answer);
	    		}
	    		else if (operatorString.equals("*"))
	    		{
	    			answer = tempStorageOne * tempStorageTwo;
	    			finalDisplay.setText("The answer is: " + answer);
	    		}
	    		resetMem();
	    	}
	    });
	    
	}
	
	/**
	 * Updates the displayString field. Adds the  number
	 * to the previous number if a number had already been
	 * entered or there was no number, otherwise replaces
	 * the previous input with the update.
	 * @param update new string that represents last
	 * button press.
	 * THIS METHOD WILL NEED TO BE UPDATED once calc does 
	 * more than 2 part operations. and also once operations
	 * are put in.
	 */
	public void updateDisplayString(String update)
	{
		//going to need to make an "=" button.
		if (tempStorageOne == 0)
		{
			if (isInteger(update))
			{
				displayString += update;
				stringDisplay.setText("The current input is: " + displayString);
			}
			else
			{
				tempStorageOne = Integer.parseInt(displayString);
				displayString = update;
				operatorString = update;
				stringDisplay.setText("The current input is: " + displayString);
			}
		}
		else if (tempStorageOne > 0)
		{
			if (isInteger(update) && displayString.length() == 1)
			{
				displayString = "0" + update;
				stringDisplay.setText("The current input is: " + displayString);
			}
			else if (isInteger(update))
			{
				displayString += update;
				stringDisplay.setText("The current input is: " + displayString);
			}
			else if (update.equals("="))
			{
				tempStorageTwo = Integer.parseInt(displayString);
				displayString = update;
				stringDisplay.setText("The current input is: " + displayString);
			}
			
		}
	}
	
	/**
	 * Checks whether the input can be converted
	 * to an integer.
	 * Credit to stackoverflow users Bill the Lizard
	 * and Ovidiu Pacurar.
	 * @param input string to be checked.
	 * @return true if it can be converted to an 
	 * integer, false otherwise.
	 */
	public boolean isInteger(String input)
	{
		try 
		{
	        Integer.parseInt(input);
	        return true;
	    }
	    catch(NumberFormatException e) 
		{
	        return false;
	    }
	}
	
	/**
	 * @return the answer once it has
	 * been computed (i.e. the "=" button
	 * has been pressed.
	 */
	public int getAnswer()
	{
		return answer;
	}
	
	/**
	 * @return The current displayed
	 * character as a string.
	 */
	public String getDisplayString()
	{
		return displayString;
	}
	
	/**
	 * Resets the app so it can calculate another
	 * problem.
	 */
	public void resetMem()
	{
		tempStorageOne = 0;
		tempStorageTwo = 0;
		displayString = "";
		stringDisplay.setText("The current input is: " + displayString);
	}
}
