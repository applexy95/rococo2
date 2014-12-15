package presentation.userui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;
import businesslogicservice.userblservice.UserblService_Stub;
import presentation.mainui.Financialui;
import presentation.mainui.Image;
import presentation.mainui.Managerui;
import presentation.mainui.Salesmanui;
import presentation.mainui.Stockmanui;
import vo.UserVo;

/**
 * 登录界面
 * @author 瑜钦
 * @version 2014-11-27
 */

public class Loginui extends JPanel {

	private static JFrame frame;
	private JPanel loginPanel;
	private JLabel loginBg;
	private JButton loginButton;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	
	public Loginui(final JFrame mainframe) {
		frame = mainframe;
		
		loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 600, 420);
		
		loginBg = new JLabel(Image.LoginBg);
		loginBg.setBounds(0, 0, 600, 420);
		loginPanel.add(loginBg, -1);
			
		usernameTextField = new JTextField();
		usernameTextField.setBounds(418, 171, 155, 23);
		usernameTextField.setOpaque(false);
		usernameTextField.setBorder(null);
		loginPanel.add(usernameTextField, 0);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(418, 224, 155, 23);
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		loginPanel.add(passwordField, 0);
		
		loginButton = new JButton(Image.loginButton);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(false);
		loginButton.setRolloverIcon(Image.loginButtonClicked);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(389, 273, 180, 30);
		loginButton.addActionListener(new loginButtonListener());
		loginPanel.add(loginButton, 0);
		
		frame.add(loginPanel);
	}
	
	class loginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			//登录
			String username = usernameTextField.getText();
			String password = String.valueOf(passwordField.getPassword());
			UserblService userController;
			userController = new UserblService_Stub();
			
			frame.remove(loginPanel);
		//	UserVo uvo = new UserVo();
		//	uvo.setId(username);
		//	uvo.setPassword(password);
			switch(userController.login(username,password).getType()) {
			case ADMIN : frame.add(new Userui(frame));
								break;
			case STOCK_MANAGER : frame.add(new Stockmanui(frame));
								break;
			case IMEX_MANAGER : frame.add(new Salesmanui(frame));
								break;
			case FINANCE_MANAGER : frame.add(new Financialui(frame));
								break;
			case MANAGER : frame.add(new Managerui(frame));
								break;
			case WRONG : //错误！
								break;
			}
			frame.repaint();
		}
	}
		
}
