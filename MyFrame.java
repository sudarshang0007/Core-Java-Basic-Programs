import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/*
 * <p>UI for Employee Management System
 * @author Amit
 * @version version
 * 
 */
public class MyFrame extends JFrame {

	JLabel fnameLabel;
	JLabel lnameLabel;
	
	private JTextField fnameText;
	JTextField lnameText;
	
	JButton addButton;
	
	public MyFrame()
	{
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(400, 600);
		this.setTitle("Employee Management System");
			
		fnameLabel = new JLabel("First Name : ");
		fnameLabel.setBounds(20, 20, 100, 50);
		this.add(fnameLabel);
		
		fnameText = new JTextField(30);
		fnameText.setBounds(120, 35, 100, 20);
		this.add(fnameText);
			
		lnameLabel = new JLabel("Last Name : ");
		lnameLabel.setBounds(20, 60, 100, 50);
		this.add(lnameLabel);
		
		lnameText = new JTextField(30);
		lnameText.setBounds(120, 70, 100, 20);
		this.add(lnameText);
		
		addButton = new JButton("Add");
		addButton.setBounds(20, 150, 70, 25);
		this.add(addButton);
		addButton.addActionListener(  new AddActionListener() );
		
	
	}
	
	public static void main(String[] args)
	{
		MyFrame mf = new MyFrame();
		
		
	}
	

	class AddActionListener implements ActionListener
	{
	   MyFrame frame;
	   
	   public AddActionListener()
	   {
		   
	   }
	   public AddActionListener(MyFrame f)
	   {
		   this.frame = f;
	   }
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("button is clicked");
			System.out.println(fnameText.getText());
		}
		
	}

}




