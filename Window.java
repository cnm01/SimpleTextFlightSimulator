package main;

//all the classes used in this class are imported to be able to construct the frame using the swing library
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//window is a subclass of JFrame class
public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//window must contain the following variables(slider for x and y values, reset button, and textPanel)
	private JSlider xslider;
	private JSlider yslider;
	private int xvalue;
	private int yvalue;
	private JButton resetButton;
	private JTextPane textPanel;
	private boolean reset;
	
	//constructor initialises the variables and sets the value of xvalue to 5 and yvalue to 0
	public Window() {
		
		super("Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialise();
		xvalue = 5;
		yvalue = 0;
		
	}
	
	//creates the frame and the widgets contained in the frame
	public void initialise() {
		
				//creates a new JFrame called simulator
				JFrame frame = new JFrame("Simulator");
				//sets the layout manager of the JFrame to gridlayout
				frame.setLayout(new GridLayout(2, 1));
				//limits the minimum size of the JFrame to 900x1000
				frame.setMinimumSize(new Dimension(900, 1000));
				
				//lower section of grid contains a panel
				JPanel south = new JPanel();
				
				//center section contains text label wrapped in a JScrollPanel
				JTextPane textPanel = new JTextPane();
				//sets editable to false so user cannot change text in panel
				textPanel.setEditable(false);
	
				JScrollPane jspText = new JScrollPane (textPanel);
				this.textPanel = textPanel;
				
				//allows the screen to follow new text being created and automatically scrolls down
				DefaultCaret caret = (DefaultCaret)textPanel.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
				
				//creates two scroll bars for the scrollpane
				jspText.createVerticalScrollBar();
				jspText.createHorizontalScrollBar();
				//sets the font for the text in the textPanel
				textPanel.setFont(new Font("Verdana", Font.PLAIN, 30));
				
				//adds the text panel to the frame
				frame.add(jspText);
				
				//adds the south panel to the lower section of the frame
				frame.add(south);
				
				
				//south is split into North/Centre/South using borderlayout manager
				south.setLayout(new BorderLayout());
				
				//southNorth has the x slider
				//screates new slider with min=0 max=10 and start=5
				JSlider xslider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
				xslider.setMajorTickSpacing(1);
				//automatically snaps to the closest tick to make it more precise
				xslider.setSnapToTicks(true);
				//makes ticks and tick numbers visible so player can see which speed they are setting to 
				xslider.setPaintTicks(true);
				xslider.setPaintLabels(true);
				xslider.setFont(new Font("Arial", Font.PLAIN, 20));
				//associates widget action with xsliderAction class
				xslider.addChangeListener(new xsliderAction());
				this.xslider = xslider;
				
				
				//southCenter has the y slider
				//does the same as the xslider except is vertical and not horizontal and is contained in the centre panel of the south section
				JSlider yslider = new JSlider(JSlider.VERTICAL, 0, 10, 0);
				yslider.setMajorTickSpacing(1);
				yslider.setSnapToTicks(true);
				yslider.setPaintTicks(true);
				yslider.setPaintLabels(true);
				yslider.setFont(new Font("Arial", Font.PLAIN, 20));
				yslider.addChangeListener(new ysliderAction());
				this.yslider = yslider;
				
				//southSouth has a reset button
				JButton resetButton = new JButton("Reset");
				resetButton.setFont(new Font("Verdana", Font.PLAIN, 25));
				//associates button click with resetAction class
				resetButton.addActionListener(new resetAction());
				this.resetButton = resetButton;
				
				//all are added to the lower section of the frame
				south.add(xslider, BorderLayout.NORTH);
				south.add(yslider, BorderLayout.CENTER);
				south.add(resetButton, BorderLayout.SOUTH);
				
				//frame is packed to properly organise the layout
				frame.pack();
				
				//makes the window visible
				frame.setVisible(true);
				
	}
	
	//get methods allows fields to be accessed from outside the class
	public JSlider getXSlider() {
		return xslider;
	}
	
	public JSlider getYSlider() {
		return yslider;
	}
	
	public JButton getResetButton() {
		return resetButton;
	}
	
	public JTextPane getTextPanel() {
		return textPanel;
	}
	
	public String getTextInPanel() {
		return textPanel.getText();
	}
	
	public void setTextInPanel(String text) {
		textPanel.setText(text);
	}
	
	public int getXValue() {
		return xvalue;
	}
	
	public int getYValue() {
		return yvalue;
	}
	
	public boolean getReset() {
		return reset;
	}
	
	public void resetResetValue() {
		reset = false;
	}
	
	public void resetXSlider() {
		xslider.setValue(5);
	}
	
	public void resetYSlider() {
		yslider.setValue(0);
	}
	
	//nested class for action allows the value of the yslider to be used and set as the yvalue field
	public class ysliderAction implements ChangeListener {

		public void stateChanged(ChangeEvent arg0) {
			
			yvalue = ((JSlider) arg0.getSource()).getValue();
			
		}
	
	}
	

	//nested class for action allows the value of the xslider to be used and set as the xvalue field
	public class xsliderAction implements ChangeListener {

		public void stateChanged(ChangeEvent arg0) {
			
			xvalue = ((JSlider) arg0.getSource()).getValue();
			
		}
	
	}
	
	//nested class for reset action sets reset field variable value to true
	public class resetAction implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			
			reset = true;
			
		}
		
	}
	
	//reset all method sets reset value to false, returns xslider and ysliders to default position
	public void resetAll() {
		resetResetValue();
		resetXSlider();
		resetYSlider();
	}
	
}
