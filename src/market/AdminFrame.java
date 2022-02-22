package market;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.List;

public class AdminFrame {
	 Frame frame = new Frame();
	 Button product_Details_button = new Button("Product Details");
	 Button add_Product_Button = new Button("Add Product");
	 Button delete_Product_Button = new Button("Delete Product");
	 Button edit_Product_Button = new Button("Edit product");
	 Button add_User_Button = new Button("Add User");
	 Button edit_User_button = new Button("Edit User");
	 Button logout_Button = new Button("Logout");
	 
	
	 
	 
	 
	AdminFrame(String id){
	
	
	 frame.setTitle("Admin - "+id);
	 frame.setBounds(250,70,800,600);
	 frame.setVisible(true);
	 frame.setLayout(null);
	add_Layout();
	addElements();
	database_Connection();
	addActionEvent();
	 
	}
private void add_Layout() {
	
	product_Details_button.setBounds(20,50,200,70);
	add_Product_Button.setBounds(20,140,200,70);
	delete_Product_Button.setBounds(20,230,200,70);
	edit_Product_Button.setBounds(20,320,200,70);
	add_User_Button.setBounds(20,410,200,70);
	edit_User_button.setBounds(20,500,200,70);
	logout_Button.setBounds(frame.getWidth()-110,30,100,30);
	logout_Button.setBackground(Color.red);
			
	}


	 private void addActionEvent() {
		 
		 frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent args)
				{
					System.exit(0);
				}
				});
		 
		 logout_Button.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
				 LoginFrame login = new LoginFrame();				 
			 }
			 
		 });
		 
		 product_Details_button.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 System.out.println("product details");
				 Panel product_Details_Panel = new Panel();
				 List product_List = new List();
				 frame.add(product_Details_Panel);
				 product_Details_Panel.add(product_List);
				 product_Details_Panel.setBounds(250,100,450, 450);
				 product_List.setBounds(0,0,450, 450);
				 //frame.add(product_Details_Panel);
				 
				 product_List.add("i am N.sasikumar From mechsnicsl department m.kumarsamy college of engineering ");
				 
				 				 
			 }
			 
		 });
		
		
	}



	private void database_Connection() {
		
		
	}



	private void addElements() {
		frame.add(add_Product_Button);
		frame.add(product_Details_button);
		frame.add(delete_Product_Button);
		frame.add(edit_Product_Button);
		frame.add(add_User_Button);
		frame.add(edit_User_button);
		frame.add(logout_Button);
		
		
		
	}



	

}
