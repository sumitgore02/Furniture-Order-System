package asd;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//3
//Online Shopping System : Testing using Junit
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.Font;
import java.awt.Frame;
public class Login {
private static JFrame frame;
private JTextField username;
private JPasswordField pass;
public static String pwd ;
public static String Uname ;
public boolean conncheck = false;
public static void main(String[] args) {
	@SuppressWarnings("unused")
    WindowStateListener listener = new WindowAdapter() {


        public void windowStateChanged(WindowEvent evt) {
          int oldState = evt.getOldState();
          if ((oldState & Frame.ICONIFIED) == 0)
            minimize_button=true;

          if ((oldState & Frame.MAXIMIZED_BOTH) == 0) {
              maximize_button=true;

          }
        }
      };
      
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Login window = new Login();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public Login(int x)
{ }
public Login() {
initialize();
}
public boolean does_exist(String name)
{
try {
String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior" + "";
 Connection conn=DriverManager.getConnection(JdbcURL,"root","Sumit");
 Statement s = conn.createStatement();
 
 String q ="select password,address from account where fname = '"+name+"'";
 ResultSet rs = s.executeQuery(q);
 if(rs.next()==false)
 return false;
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return true;
}
public static boolean minimize_button=false;
public static boolean maximize_button=false;
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 650, 500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
frame.setVisible(true);
JPanel panel = new JPanel();
panel.setBackground(new Color(189, 163, 247));
panel.setBounds(100, 31, 415, 373);
frame.getContentPane().add(panel);
panel.setLayout(null);
pass = new JPasswordField();
pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
pass.setBounds(103, 195, 211, 22);
panel.add(pass);
JLabel lblNewLabel = new JLabel("Furniture Ordering");
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblNewLabel.setBounds(113, 36, 230, 36);
panel.add(lblNewLabel);
lblNewLabel.setBackground(Color.LIGHT_GRAY);
lblNewLabel.setForeground(Color.BLACK);
JLabel uname = new JLabel("Username");
uname.setFont(new Font("Tahoma", Font.PLAIN, 15));
uname.setBounds(103, 102, 121, 16);
panel.add(uname);
username = new JTextField();
username.setFont(new Font("Tahoma", Font.PLAIN, 15));
username.setBounds(103, 131, 211, 22);
panel.add(username);
username.setColumns(10);
JLabel lblNewLabel_1 = new JLabel("Password");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
lblNewLabel_1.setBounds(103, 166, 196, 16);
panel.add(lblNewLabel_1);
JButton Login = new JButton("Login");
Login.setFont(new Font("Tahoma", Font.PLAIN, 15));
Login.setBounds(103, 252, 97, 25);
panel.add(Login);

Login.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	frame.dispose();
Uname=username.getText();
pwd = pass.getText();
try {
 String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior" +"";
 Connection conn=DriverManager.getConnection(JdbcURL,"root","Sumit");
 Statement s = conn.createStatement();
String q ="select password,address ,fname from account where fname = '"+Uname+"'";
ResultSet rs = s.executeQuery(q);
if(rs.next()==false)
{
JOptionPane.showMessageDialog(null, "Account doesn't exist!", "Error",
JOptionPane.INFORMATION_MESSAGE);
frame.setVisible(true);
username.setText("");
pass.setText("");
}
else {
String address=rs.getString("address");
String name=rs.getString("fname");
String db_pwd= rs.getString("password");
if(pwd.equals(db_pwd))
{
OrderPage o=new OrderPage(address,name);
JOptionPane.showMessageDialog(null, "Login successfull !!!", "Success",
JOptionPane.INFORMATION_MESSAGE);
frame.dispose();
o.NewScreen();
}
else {
JOptionPane.showMessageDialog(null, "Incorrect Password", "Error",
JOptionPane.INFORMATION_MESSAGE);
frame.setVisible(true);
username.setText("");
pass.setText("");}
}
}
catch(Exception e1)
{
e1.printStackTrace();
}
}
});
//Login.setBackground(Color.LIGHT_GRAY);
JButton btn = new JButton("LogOut");
btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
btn.setBounds(217, 252, 97, 25);
panel.add(btn);
btn.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null, "Thank You For Shopping With Us !!!", "",
JOptionPane.INFORMATION_MESSAGE);
System.exit(0);
}
});
JButton Signup = new JButton("SignUp");
Signup.setFont(new Font("Tahoma", Font.PLAIN, 15));
Signup.setBounds(160, 300, 97, 25);
panel.add(Signup);
Signup.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Signup s = new Signup();
frame.dispose();
s.NewScreen();
}
});
}
public boolean minimize_button()
{
   return minimize_button; 
}
public boolean maximize_button()
{
   return maximize_button; 
}
public boolean mysqlconn() throws SQLException {
	String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior" +
			"";
			 Connection conn=DriverManager.getConnection(JdbcURL,"root","Sumit");
			 Statement s = conn.createStatement();
			 System.out.println("Connection established");
			 return true;
}
public boolean getConnection() throws SQLException {
	Login l = new Login();
	if(l.mysqlconn())
		return true;
	return false;
}

public int recordcheck() throws SQLException {
	String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior" +
			"";
			 Connection conn=DriverManager.getConnection(JdbcURL,"root","Sumit");
			 Statement s = conn.createStatement();
//			 System.out.println("Connection established");
			 String q = "Select count(*) from account";
			 ResultSet rs1 = s.executeQuery(q);
             //Retrieving the result
             rs1.next();
             int count = rs1.getInt(1);
             if(count>0)
                 return count;
             return 0;
}
public boolean closeConnection() throws SQLException {
	String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior" +
			"";
			 Connection conn=DriverManager.getConnection(JdbcURL,"root","Sumit");
			 Statement s = conn.createStatement();
//			 System.out.println("Connection established");
			 
			 boolean con_close=false;
		        if(conn!=null)
		        {
		            conn.close();
		            con_close=true;
		        }
		        return con_close;

		    }


	
       
}