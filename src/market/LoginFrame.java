package market;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginFrame {
	
	Frame frame = new Frame();
	Label userId_Label = new Label("User Id");
	Label password_Label = new Label("Password");
	TextField userId = new TextField();
	TextField password = new TextField();
	Button login_Button = new Button("Login");
	String login_Type="User";
	Button admin_Button = new Button();
	Connection con;
	Statement stmt;
	
	LoginFrame(){
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Login");
		frame.setBounds(250,70,800,600);
		
		add_Layout();
		addElements();
		database_Connection();
		addActionEvent();
		
		}
	
	private void database_Connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/sk_mart","root","sasisk");
			stmt=con.createStatement();
			
			}
			catch(Exception em){
				warning_Label("Database Probelm Contact Admin");
				
			}
		
	}

	private void addElements() {
		frame.add(userId_Label);
		frame.add(password_Label);
		frame.add(userId);
		frame.add(password);
		frame.add(login_Button);
		frame.add(admin_Button);
		
	}
	
	private void addActionEvent() {
		
		frame.addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent componentEvent) {
		
			if(frame.getHeight()>=700 && frame.getWidth()>=1150) {
				
				userId_Label.setBounds(400,250,150,30);
				userId_Label.setFont(new Font("Times new Roman",Font.BOLD,30));
				password_Label.setBounds(400,350,150,30);
				password_Label.setFont(new Font("Times new Roman",Font.BOLD,30));
				userId.setBounds(600,250,150,30);
				userId.setSize(350, 45);
				password.setBounds(600,350,150,30);
				password.setSize(350, 45);
				login_Button.setBounds(580,500,100,30);
				login_Button.setBackground(Color.GREEN);
				login_Button.setSize(160,50);
				admin_Button.setBounds(10,30, 100, 30);
				admin_Button.setBackground(Color.LIGHT_GRAY);
				admin_Button.setSize(100, 30);
				admin_Button.setLabel(login_Type);
				
				
					
			}
			
			else if(frame.getHeight()>=400 && frame.getHeight()<=650 && frame.getWidth()<=1000 && frame.getWidth()>=600) {
				
				userId_Label.setBounds(220,200,150,30);
				userId_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
				password_Label.setBounds(220,250,150,30);
				password_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
				userId.setBounds(400,200,150,30);
				userId.setSize(230, 35);
				password.setBounds(400,250,150,30);
				password.setSize(230, 35);
				login_Button.setBounds(350,350,100,30);
				login_Button.setSize(150,45);
				login_Button.setBackground(Color.GREEN);
				admin_Button.setBounds(10,30, 100, 30);
				admin_Button.setBackground(Color.LIGHT_GRAY);
				admin_Button.setSize(100, 30);
				admin_Button.setLabel(login_Type);
				
				
			}
			else if(frame.getHeight()>=500 && frame.getHeight()<=750 && frame.getWidth()<=800 && frame.getWidth()>=650){
		
		userId_Label.setBounds(120,300,150,30);
		userId_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		password_Label.setBounds(120,350,150,30);
		password_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		userId.setBounds(300,300,150,30);
		userId.setSize(230, 35);
		password.setBounds(300,350,150,30);
		password.setSize(230, 35);
		login_Button.setBounds(270,450,100,30);
		login_Button.setSize(150,45);
		login_Button.setBackground(Color.GREEN);
		admin_Button.setBounds(10,30, 100, 30);
		admin_Button.setBackground(Color.LIGHT_GRAY);
		admin_Button.setSize(100, 30);
		admin_Button.setLabel(login_Type);
	}
		}
	});
		password.addKeyListener((KeyListener) new KeyListener() {
		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			user_Login();
			
		}

	
	

		
		
	});
	admin_Button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(login_Type.equals("User"))
			{
				login_Type="Admin";
				add_Layout();
				userId.setText("");
				password.setText("");
			}
			else
			{
				login_Type = "User";
			add_Layout();
			userId.setText("");
			password.setText("");
			}
		}
	});
	login_Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	if(login_Type.equals("User"))
        		 user_Login();
				
			else
				admin_Login();
				
           
        }
    });
	
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent args)
		{
			System.exit(0);
		}
		});
	}
	
	
	
	private void admin_Login() {
		try {
			
			  
			String admin_id = userId.getText();
			String pass_word = password.getText();
			ResultSet rs=this.stmt.executeQuery("select * from admin_details where admin_id='"+admin_id+"'"); 
		
			if(rs.next())
			{
				do {
				
				
				if(pass_word.equals(rs.getString("password")))
				{
					if(rs.getString("admin_access").equals("moderator"))
					{
						con.close();  
						System.out.println("Admin Login succes fully");
					    frame.dispose();
						AdminFrame admin = new AdminFrame(admin_id);
					}
					else
					{
						
						warning_Label("Id problem contact Main Admin");
						
					}
					
				}
				else {
					password.setText("");
					warning_Label("Incorrect password");
				
					
				}
			}while(rs.next());
				
			}
			else{
				userId.setText("");
				password.setText("");
				warning_Label("Incorrect User ID");
				
				
			}
			
			}
			catch(Exception e ) {System.out.println(e);}
		
	}
	private void user_Login() {
		try {
			
		  
		String user_id = userId.getText();
		String pass_word = password.getText();
		ResultSet rs=this.stmt.executeQuery("select * from employee_details where emp_id='"+user_id+"'"); 
	
		if(rs.next())
		{
			do {
			
			
			if(pass_word.equals(rs.getString("emp_password")))
			{
				if(rs.getString("emp_status").equals("true"))
				{
					con.close();  
					System.out.println("Login succes fully");
				}
				else
				{
					
					warning_Label("Id problem contact Admin");
					
				}
				
			}
			else {
				password.setText("");
				warning_Label("Incorrect password");
			
				
			}
		}while(rs.next());
			
		}
		else{
			userId.setText("");
			password.setText("");
			warning_Label("Incorrect User ID");
			
			
		}
		
		}
		catch(Exception e ) {System.out.println(e);}
	}
	
	

	private void add_Layout() {
		
		frame.setBounds(250,70,800,600);
		userId_Label.setBounds(220,200,150,30);
		userId_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		password_Label.setBounds(220,250,150,30);
		password_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		userId.setBounds(400,200,150,30);
		userId.setSize(230, 35);
		password.setBounds(400,250,150,30);
		password.setSize(230, 35);
		login_Button.setBounds(350,350,150,45);
		login_Button.setSize(150,45);
		login_Button.setBackground(Color.GREEN);
		admin_Button.setBounds(10,30, 100, 30);
		admin_Button.setBackground(Color.LIGHT_GRAY);
		admin_Button.setSize(100, 30);
		admin_Button.setLabel(login_Type);
		
		
		
	}
	private void warning_Label(String warning) {
		Label warning_Label = new Label(warning);
		warning_Label.setBounds( frame.getWidth()/2,30,300, 30);
		warning_Label.setForeground(Color.red);
		warning_Label.setFont(new Font("Times new Roman",Font.BOLD,15));
		frame.add(warning_Label);
		try {Thread.sleep(1500);}
		catch(Exception e){System.out.println(e);}
		frame.remove(warning_Label);
		
	}
 
	
}