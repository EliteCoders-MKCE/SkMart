package market;
import java.awt.Button;
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


public class LoginFrame extends Frame {
	

	private static final long serialVersionUID = 1L;

	
	Panel panel = new Panel();
	Label username_Label = new Label("Username");
	Label password_Label = new Label("Password");
	TextField username = new TextField();
	TextField password = new TextField();
	Button login_Button = new Button("Login");
	
	
      	

	LoginFrame(){
		setLayout(null);
		setVisible(true);
		setTitle("Login");
		setSize(800,600);
	    
		add_Layout();
		panelSet();
		
		addActionEvent();
		
		
		}
	
	public void panelSet() {
		add(username_Label);
		add(password_Label);
		add(username);
		add(password);
		add(login_Button);
	}
	
	public void addActionEvent() {
		
	addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent componentEvent) {
			System.out.print(getHeight()+" "+getWidth());
		}
	});
	login_Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
       	 System.out.println("Login");
            //login();
        }
    });
	
	super.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent args)
		{
			System.exit(0);
		}
		});
	}
	
	
	

	public void add_Layout() {
		
		
		username_Label.setBounds(250,200,100,30);
		username_Label.setFont(new Font("Times new Roman",Font.BOLD,22));
		password_Label.setBounds(250,250,100,30);
		password_Label.setFont(new Font("Times new Roman",Font.BOLD,22));
		username.setBounds(400,200,150,30);
		username.setSize(230,30);
		password.setBounds(400,250,150,30);
		password.setSize(230, 30);
		login_Button.setBounds(380,350,100,30);
		login_Button.setSize(150,35);
		
		
	}

	 
	
}