package market;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginFrame extends Frame {
	

	private static final long serialVersionUID = 1L;

	
	Label userId_Label = new Label("User Id");
	Label password_Label = new Label("Password");
	TextField userId = new TextField();
	TextField password = new TextField();
	Button login_Button = new Button("Login");
	
	
	
      	

	LoginFrame(){
		setLayout(null);
		setVisible(true);
		setTitle("Login");
		setSize(800,600);
	    
		add_Layout();
		addElements();
		
		addActionEvent();
		
		
		}
	
	public void addElements() {
		add(userId_Label);
		add(password_Label);
		add(userId);
		add(password);
		add(login_Button);
		
	}
	
	public void addActionEvent() {
		
	addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent componentEvent) {
		
			if(getHeight()>=700 && getWidth()>=1150) {
				
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
				
				
					
			}
			
			else if(getHeight()>=400 && getHeight()<=650 && getWidth()<=1000 && getWidth()>=600) {
				
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
				
				
			}
			else if(getHeight()>=500 && getHeight()<=750 && getWidth()<=800 && getWidth()>=650){
		
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
	}
		}
	});
	login_Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
       	 
            login();
        }
    });
	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent args)
		{
			System.exit(0);
		}
		});
	}
	public void login() {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/sk_mart","root","sasisk");
		
		Statement stmt=con.createStatement();  
		String user_id = userId.getText();
		String pass_word = password.getText();
		ResultSet rs=stmt.executeQuery("select * from employee_details where emp_id='"+user_id+"'"); 
	
		if(rs.next())
		{
			do {
			
			
			if(pass_word.equals(rs.getString("emp_password")))
			{
				if(rs.getString("emp_status").equals("true"))
					System.out.println("Login succes fully");
				else
				{
					
					Label warning_Label = new Label("Id problem contact Admin");
					warning_Label.setBounds( getWidth()/2,30,300, 30);
					warning_Label.setForeground(Color.red);
					warning_Label.setFont(new Font("Times new Roman",Font.BOLD,15));
					add(warning_Label);
					Thread.sleep(1000);
					remove(warning_Label);
				}
				
			}
			else {
				
				Label warning_Label = new Label("Incorrect password");
				warning_Label.setBounds( getWidth()/2,30,300, 30);
				warning_Label.setForeground(Color.red);
				warning_Label.setFont(new Font("Times new Roman",Font.BOLD,15));
				add(warning_Label);
				password.setText("");
				Thread.sleep(1500);
				remove(warning_Label);
				
			}
		}while(rs.next());
			
		}
		else{
			
			Label warning_Label = new Label("Incorrect User ID");
			warning_Label.setBounds( getWidth()/2,30,300, 30);
			warning_Label.setForeground(Color.red);
			warning_Label.setFont(new Font("Times new Roman",Font.BOLD,15));
			add(warning_Label);
			userId.setText("");
			Thread.sleep(1500);
			remove(warning_Label);
			
		}
		
		
		con.close();  
		}
		catch(Exception e ) {
			System.out.println(e);
		}
	}
	
	
	

	public void add_Layout() {
		
		
		userId_Label.setBounds(220,200,150,30);
		userId_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		password_Label.setBounds(220,250,150,30);
		password_Label.setFont(new Font("Times new Roman",Font.BOLD,25));
		userId.setBounds(400,200,150,30);
		userId.setSize(230, 35);
		password.setBounds(400,250,150,30);
		password.setSize(230, 35);
		login_Button.setBounds(350,350,100,30);
		login_Button.setSize(100,40);
		login_Button.setBackground(Color.GREEN);
		
		
	}

	 
	
}