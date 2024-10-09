package asd;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderPage {
public int ChairCNT = 0, dTable = 0, LounCNT = 0, bedCNT = 0, sofaCnt = 0;
static int TotalPrice = 0;
static String address;
static String name;
String op = "";
private JFrame frame;
private final JLabel lblNewLabel = new JLabel("");
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
public static void NewScreen() {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
try {
OrderPage window = new OrderPage(address,name);
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public OrderPage(String address,String name) {
this.address = address;
this.name = name;
initialize();
}
public OrderPage(int i) {
	// TODO Auto-generated constructor stub
}
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(189, 163, 247));
frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 10));
frame.setBounds(100, 100, 830, 550);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("");
lblNewLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Sumit\\Final Year\\furniture10\\Product\\Chair.jpg")
.getImage().getScaledInstance(120, 120,
Image.SCALE_DEFAULT)));
lblNewLabel.setBounds(108, 39, 153, 167);
frame.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1
.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Sumit\\Final Year\\furniture10\\Product\\Dining Table.jpg")
.getImage().getScaledInstance(120, 120,
Image.SCALE_DEFAULT)));
lblNewLabel_1.setBounds(359, 39, 135, 153);
frame.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2
.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Sumit\\Final Year\\furniture10\\Product\\lounge.jpeg")
.getImage().getScaledInstance(120, 120,
Image.SCALE_DEFAULT)));
lblNewLabel_2.setBounds(592, 39, 135, 153);
frame.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setIcon(new ImageIcon(new
ImageIcon("C:\\Users\\Admin\\Desktop\\Sumit\\Final Year\\furniture10\\Product\\Bed.jpg")
.getImage().getScaledInstance(120, 120,
Image.SCALE_DEFAULT)));
lblNewLabel_3.setBounds(512, 231, 129, 153);
frame.getContentPane().add(lblNewLabel_3);
JLabel lblNewLabel_4 = new JLabel("");
lblNewLabel_4.setIcon(new ImageIcon(new
ImageIcon("C:\\Users\\Admin\\Desktop\\Sumit\\Final Year\\furniture10\\Product\\Sofa.jpg")
.getImage().getScaledInstance(120, 120,
Image.SCALE_DEFAULT)));
lblNewLabel_4.setBounds(206, 231, 129, 153);
frame.getContentPane().add(lblNewLabel_4);
//setting name of store
JLabel lblNewLabel_5 = new JLabel("Furniture store");
lblNewLabel_5.setFont(new Font("FreeSans", Font.BOLD, 20));
lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_5.setBounds(334, 0, 175, 27);
frame.getContentPane().add(lblNewLabel_5);
//adding cart button to display number of items selected
JButton btnNewButton_5 = new JButton("Cart");
btnNewButton_5.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
op = "Products Count Total\n";
if (ChairCNT > 0)
op += "Chair " + ChairCNT + " = Rs " + ChairCNT * 1000;
if (dTable > 0)
op += "\nDinning Table " + dTable + " = Rs " + dTable * 3000;
if (LounCNT > 0)
op += "\nChaise Lounge " + LounCNT + " = Rs " +
LounCNT * 5000;
if (sofaCnt > 0)
op += "\nSofa " + sofaCnt + " = Rs " + sofaCnt * 7000;
if (bedCNT > 0)
op += "\nBed " + bedCNT + " = Rs " + bedCNT * 10000;
TotalPrice = ChairCNT * 1000 + dTable * 3000 + LounCNT *
5000 + sofaCnt * 7000 + bedCNT * 10000;
op += "\n--------------------------";
op += "\nTotal Price\t=\tRs " + TotalPrice;
if(TotalPrice != 0){
   JOptionPane.showMessageDialog(frame, op); 
}else{
    JOptionPane.showMessageDialog(null, "Please select at least one object.", "Cart",
JOptionPane.INFORMATION_MESSAGE);
}

}
});
btnNewButton_5.setBounds(12, 13, 117, 25);
frame.getContentPane().add(btnNewButton_5);
//maintaining count of chairs ordered
//code for adding chairs
JButton btnNewButton = new JButton("+");
btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
btnNewButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
ChairCNT++; // incrementing count when '+' button is pressed
textField.setText(Integer.toString(ChairCNT));
}
});
btnNewButton.setBounds(193, 204, 44, 25);
frame.getContentPane().add(btnNewButton);
//code for displaying number of chairs selected
textField_1 = new JTextField(); // to display count of tables
textField_1.setText("0");
textField_1.setHorizontalAlignment(SwingConstants.CENTER);
textField_1.setColumns(10);
textField_1.setBounds(402, 204, 38, 25);
frame.getContentPane().add(textField_1);
//code for decrementing chair count
JButton btnNewButton_4 = new JButton("-");
btnNewButton_4.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (ChairCNT != 0) // decrementing count when '-' button is pressed
ChairCNT--;
textField.setText(Integer.toString(ChairCNT));
}
});
btnNewButton_4.setBounds(108, 204, 42, 25);
frame.getContentPane().add(btnNewButton_4);
//code for displaying name of preoduct
JLabel lblNewLabel_6 = new JLabel("Chair : Rs.1000");
lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_6.setBounds(96, 191, 153, 15);
frame.getContentPane().add(lblNewLabel_6);
//for table
JButton btnNewButton_1 = new JButton("+");
btnNewButton_1.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
dTable++;
textField_1.setText(Integer.toString(dTable));
}
});
btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
btnNewButton_1.setBounds(442, 204, 44, 25);
frame.getContentPane().add(btnNewButton_1);
textField_4 = new JTextField();
textField_4.setText("0");
textField_4.setHorizontalAlignment(SwingConstants.CENTER);
textField_4.setColumns(10);
textField_4.setBounds(554, 396, 38, 25);
frame.getContentPane().add(textField_4);
JButton btnNewButton_4_1 = new JButton("-");
btnNewButton_4_1.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (dTable != 0)
dTable--;
textField_1.setText(Integer.toString(dTable));
}
});
btnNewButton_4_1.setBounds(359, 204, 42, 25);
frame.getContentPane().add(btnNewButton_4_1);
JLabel lblNewLabel_6_1 = new JLabel("Dinning Table : Rs.3000");
lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_6_1.setBounds(347, 191, 147, 15);
frame.getContentPane().add(lblNewLabel_6_1);
//for lounge
JButton btnNewButton_1_1 = new JButton("+");
btnNewButton_1_1.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
LounCNT++;
textField_2.setText(Integer.toString(LounCNT));
}
});
btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
btnNewButton_1_1.setBounds(675, 204, 44, 25);
frame.getContentPane().add(btnNewButton_1_1);
textField_2 = new JTextField();
textField_2.setText("0");
textField_2.setHorizontalAlignment(SwingConstants.CENTER);
textField_2.setColumns(10);
textField_2.setBounds(636, 204, 38, 25);
frame.getContentPane().add(textField_2);
JButton btnNewButton_4_2 = new JButton("-");
btnNewButton_4_2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (LounCNT != 0)
LounCNT--;
textField_2.setText(Integer.toString(LounCNT));
}
});
btnNewButton_4_2.setBounds(592, 204, 42, 25);
frame.getContentPane().add(btnNewButton_4_2);
JLabel lblNewLabel_6_1_1 = new JLabel("Chaise Lounge : Rs.5000");
lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_6_1_1.setBounds(592, 181, 153, 25);
frame.getContentPane().add(lblNewLabel_6_1_1);
//for sofa
JButton btnNewButton_1_2 = new JButton("+");
btnNewButton_1_2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
sofaCnt++;
textField_3.setText(Integer.toString(sofaCnt));
}
});
btnNewButton_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
btnNewButton_1_2.setBounds(284, 395, 44, 25);
frame.getContentPane().add(btnNewButton_1_2);
textField_3 = new JTextField();
textField_3.setText("0");
textField_3.setHorizontalAlignment(SwingConstants.CENTER);
textField_3.setColumns(10);
textField_3.setBounds(246, 396, 38, 25);
frame.getContentPane().add(textField_3);
JButton btnNewButton_4_3 = new JButton("-");
btnNewButton_4_3.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (sofaCnt != 0)
sofaCnt--;
textField_3.setText(Integer.toString(sofaCnt));
}
});
btnNewButton_4_3.setBounds(206, 396, 42, 25);
frame.getContentPane().add(btnNewButton_4_3);
JLabel lblNewLabel_6_1_2 = new JLabel("Sofa : Rs.7000");
lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
lblNewLabel_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_6_1_2.setBounds(206, 376, 129, 15);
frame.getContentPane().add(lblNewLabel_6_1_2);
//for bed
JButton btnNewButton_1_3 = new JButton("+");
btnNewButton_1_3.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
bedCNT++;
textField_4.setText(Integer.toString(bedCNT));
}
});
btnNewButton_1_3.setFont(new Font("Dialog", Font.BOLD, 12));
btnNewButton_1_3.setBounds(592, 395, 44, 25);
frame.getContentPane().add(btnNewButton_1_3);
textField = new JTextField();
textField.setHorizontalAlignment(SwingConstants.CENTER);
textField.setText("0"); // to display count of chair
textField.setBounds(153, 204, 38, 25);
frame.getContentPane().add(textField);
textField.setColumns(10);
JButton btnNewButton_4_4 = new JButton("-");
btnNewButton_4_4.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (bedCNT != 0)
bedCNT--;
textField_4.setText(Integer.toString(bedCNT));
}
});
btnNewButton_4_4.setBounds(512, 395, 42, 25);
frame.getContentPane().add(btnNewButton_4_4);
JLabel lblNewLabel_6_1_3 = new JLabel("Bed : Rs.10000");
lblNewLabel_6_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
lblNewLabel_6_1_3.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_6_1_3.setBounds(493, 376, 158, 15);
frame.getContentPane().add(lblNewLabel_6_1_3);
///code for place order button
JButton btnNewButton_2 = new JButton("Place Order");
btnNewButton_2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
    if(TotalPrice != 0){
 ConfirmOrder c = new ConfirmOrder(TotalPrice, address,name,op);
frame.dispose();
c.NewScreen();
}else{
JOptionPane.showMessageDialog(null, "Your cart is empty.", "Place Order",
JOptionPane.INFORMATION_MESSAGE);
}
}
});
btnNewButton_2.setBounds(370, 465, 110, 25);
frame.getContentPane().add(btnNewButton_2);

//code for logout button
JButton btnNewButton_3 = new JButton("Back To Login");
btnNewButton_3.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
//int reply = JOptionPane.showConfirmDialog(null, "Really Quit?", "Quit", JOptionPane.YES_NO_OPTION);
//if (reply == JOptionPane.YES_OPTION)
Login l = new Login();
frame.dispose();
//l.NewScreen();
}
});
btnNewButton_3.setBounds(690, 13, 120, 25);
frame.getContentPane().add(btnNewButton_3);
}

public boolean chairtest1(int i) {
	
	if (i >= 0)
		return true;
	else if(i<0) {
		return false;
	
}
	return false;
}
public boolean diningtest1(int i1) {
	
	if (i1 >= 0)
		return true;
	else if(i1<0) {
		return false;
	
}
	return false;
}
public boolean loungetest1(int i2) {
	
	if (i2 >= 0)
		return true;
	else if(i2<0) {
		return false;
	
}
	return false;
}
public boolean sofatest1(int i3) {
	
	if (i3 >= 0)
		return true;
	else if(i3<0) {
		return false;
	
}
	return false;
}
public boolean bedtest1(int i4) {
	
	if (i4 >= 0)
		return true;
	else if(i4<0) {
		return false;
	
}
	return false;
}
}