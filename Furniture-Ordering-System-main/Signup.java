package asd;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
/**
 * User Registration using Swing
 *
 * @author javaguides.net
 *
 */
public class Signup extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField name;
private JTextField email;
private JTextField address;
private JTextField mob;
private JPasswordField passwordField;
private JButton btnNewButton;
static public String password;
/**
 * Launch the application.
 */
public static void NewScreen() {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
try {
Signup frame = new Signup();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
 * Create the frame.
 */
public Signup(int x) {
}
public Signup() {
setTitle("Signup");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 190, 650, 500);
setResizable(false);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblNewUserRegister = new JLabel("Sign Up - Create New Account");
lblNewUserRegister.setBounds(128, 13, 381, 34);
lblNewUserRegister.setForeground(new Color(0, 0, 0));
lblNewUserRegister.setBackground(new Color(255, 255, 255));
lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 26));
contentPane.add(lblNewUserRegister);
JLabel labName = new JLabel("Name");
labName.setBounds(89, 78, 99, 29);
labName.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(labName);
JLabel labEmail = new JLabel("Email\r\n address");
labEmail.setBounds(89, 201, 124, 29);
labEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(labEmail);
name = new JTextField();
name.setBackground(new Color(255, 255, 255));
name.setBounds(230, 71, 269, 29);
name.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(name);
name.setColumns(10);
email = new JTextField();
email.setBounds(230, 194, 269, 31);
email.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(email);
email.setColumns(10);
address = new JTextField();
address.setBounds(230, 133, 269, 31);
address.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(address);
address.setColumns(10);
JLabel labAddr = new JLabel("Address");
labAddr.setBounds(89, 140, 99, 29);
labAddr.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(labAddr);
JLabel labPass = new JLabel("Password");
labPass.setBounds(89, 328, 99, 26);
labPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(labPass);
JLabel labmobno = new JLabel("Mobile Number");
labmobno.setBounds(89, 262, 139, 26);
labmobno.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(labmobno);
mob = new JTextField();
mob.setBounds(230, 254, 269, 31);
mob.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(mob);
mob.setColumns(10);
passwordField = new JPasswordField();
passwordField.setBounds(230, 320, 269, 31);
passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
contentPane.add(passwordField);
JButton Login = new JButton("Back");
Login.setFont(new Font("Tahoma", Font.PLAIN, 15));
Login.setBounds(170, 400, 139,30);
contentPane.add(Login);
Login.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Login l = new Login();
dispose();
//l.NewScreen();
}
});
btnNewButton = new JButton("Register");
btnNewButton.setBounds(370, 400, 139, 30);
btnNewButton.setForeground(new Color(0, 0, 0));
btnNewButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String firstName = name.getText();
//String lastName = lastname.getText();
String emailId = email.getText();
String addr = address.getText();
String mobileNumber = mob.getText();
int len = mobileNumber.length();
password = passwordField.getText();
String msg = "" + firstName;
msg += " \n";
if (firstName.length() == 0 || emailId.length() == 0 ||
addr.length() == 0 || password.length() == 0
|| len == 0) {
JOptionPane.showMessageDialog(btnNewButton,
"Enter all fields!");
} else if (len != 10) {
JOptionPane.showMessageDialog(btnNewButton,
"Enter a valid mobile number");
} else if (passValidation(password) == false) {
JOptionPane.showMessageDialog(btnNewButton,
"Enter a valid password again");
} else if (emailValidation(emailId) == false) {
JOptionPane.showMessageDialog(btnNewButton,
"Enter a valid email again");
} else {
try {
String JdbcURL = "jdbc:mysql://localhost:3306/furniture?zeroDateTimeBehavior=convertToNull" + "";
Connection connection =DriverManager.getConnection(JdbcURL, "root", "Sumit");
String query = "INSERT INTO account values('" +
firstName + "','" + addr + "','" + password
+ "','" + emailId + "','" +
mobileNumber + "')";
Statement sta = connection.createStatement();
int x = sta.executeUpdate(query);
if (x == 0) {
JOptionPane.showMessageDialog(btnNewButton, "This account already exists!");
} else {
JOptionPane.showMessageDialog(btnNewButton, "Hello, " + msg + "*Your account is successfully created*");
Login l = new Login();
dispose();
//l.NewScreen();
}
connection.close();
} catch (Exception exception) {
exception.printStackTrace();
}
}
}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
contentPane.add(btnNewButton);
JPanel panel = new JPanel();
panel.setBounds(62, 52, 515, 332);
panel.setBackground(new Color(189, 163, 247));
contentPane.add(panel);
//////////////////////////////////////////////////////////////
}
public boolean passValidation(String pass) {
boolean check = true;
if (pass.length() < 6) {
JOptionPane.showMessageDialog(btnNewButton, "Password length should be minimum 6");
check = false;
}
String ucase = "(.*[A-Z].*)";
if (!pass.matches(ucase)) {
JOptionPane.showMessageDialog(btnNewButton, "Password should contain atleast one upper case alphabet");
check = false;
}
String nos = "(.*[0-9].*)";
if (!pass.matches(nos)) {
JOptionPane.showMessageDialog(btnNewButton, "Password should contain atleast one number");
check = false;
}
String spl = "(.*[,~,!,@,#,$,%,^,&,*,_,?].*$)";
if (!pass.matches(spl)) {
JOptionPane.showMessageDialog(btnNewButton, "Password should contain atleast one special character");
check = false;
}
return check;
}
public boolean emailValidation(String email) {
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +
"(?:[a-zA-Z0-9-]+\\.)+[a-z"
+ "A-Z]{2,7}$";
Pattern pat = Pattern.compile(emailRegex);
if (email == null)
return false;
return pat.matcher(email).matches();
}
public boolean phnValidation(String str) {
if (str.length() == 10)
return true;
else {
JOptionPane.showMessageDialog(btnNewButton, "Phone number should have 10 digits");
return false;

}
}
public boolean addrval(String str) {
	
	if (str != null) {
		return true;}
	else {
		JOptionPane.showMessageDialog(btnNewButton, "Address should not be null");
		return false;
	
}
}
}