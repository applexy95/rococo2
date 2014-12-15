package presentation.userui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import constant.ResultMessage;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;
import businesslogicservice.userblservice.UserblService_Stub;
import presentation.mainui.Image;
import vo.UserVo;

/**
 * 用户管理界面，管理员进行操作
 * @author 瑜钦
 * @version 2014-12-01
 */
public class Userui extends JPanel{
	
	private JPanel adminPanel;
	private JButton returnButton;
	private JButton addButton;
	private JButton delButton;
	private JButton finButton;
	private JButton editButton;
	private JLabel adminBg;
	private JTable userTable;
	private JLabel timer;
	private JScrollPane js;
	private UserblService user;
	private String[][] info;
	private String[] columnTitle;
	
	public Userui(final JFrame frame){
		user = new UserblService_Stub();
		
		adminPanel = new JPanel();
		adminPanel.setLayout(null);
		adminPanel.setBounds(0, 0, 600, 420);
		adminPanel.setOpaque(false);
		
		adminBg = new JLabel(Image.adminBg);
		adminBg.setBounds(0, 0, 600, 420);
		adminPanel.add(adminBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(adminPanel);
				frame.add(new Loginui(frame));
				frame.repaint();
			}
		});
		adminPanel.add(returnButton, 0);
		
		addButton = new JButton(Image.adminAddButton);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setRolloverIcon(Image.adminAddButtonClicked);
		addButton.setFocusPainted(false);
		addButton.setBounds(89, 93, 80, 24);
		addButton.addActionListener(new AddListener());
		adminPanel.add(addButton, 0);
		
		delButton = new JButton(Image.adminDelButton);
		delButton.setContentAreaFilled(false);
		delButton.setBorderPainted(false);
		delButton.setRolloverIcon(Image.adminDelButtonClicked);
		delButton.setFocusPainted(false);
		delButton.setBounds(203, 93, 80, 24);
		delButton.addActionListener(new DelListener());
		adminPanel.add(delButton, 0);
		
		finButton = new JButton(Image.adminFinButton);
		finButton.setContentAreaFilled(false);
		finButton.setBorderPainted(false);
		finButton.setRolloverIcon(Image.adminFinButtonClicked);
		finButton.setFocusPainted(false);
		finButton.setBounds(319, 93, 80, 24);
		finButton.addActionListener(new FinListener());
		adminPanel.add(finButton, 0);
		
		editButton = new JButton(Image.adminEditButton);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		editButton.setRolloverIcon(Image.adminEditButtonClicked);
		editButton.setFocusPainted(false);
		editButton.setBounds(434, 93, 80, 24);
		editButton.addActionListener(new EditListener());
		adminPanel.add(editButton, 0);
		
		columnTitle = new String[]{"姓名", "用户名", "密码", "职位", "权限"};
		ArrayList<UserVo> userInfo = user.showAllUsers();
		refreshTable(userInfo);
		userTable.setVisible(true);
		userTable.setSize(532, 249);
		userTable.setOpaque(false);
		js = new JScrollPane();
		js.setViewportView(userTable);
		js.setVisible(true);
		js.setBounds(35, 141, 532, 249);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		adminPanel.add(js, 0);
		
		adminPanel.setVisible(true);
		frame.add(adminPanel);
	}
	
	private void refreshTable(ArrayList<UserVo> userInfo) {
		int i=0;
		int size = userInfo.size();
		info = new String[size][5];//  wait for message
		UserVo temp = new UserVo();
		for(;i<size;++i) {
			temp = userInfo.get(i);
			info[i][0] = temp.getName();
			info[i][1] = temp.getId();
			info[i][2] = temp.getPassword();
			switch(temp.getType()) {
			case ADMIN : info[i][3] = "系统管理员";
						break;
			case STOCK_MANAGER : info[i][3] = "库存管理员";
						break;
			case IMEX_MANAGER : info[i][3] = "进货销售员";
						break;
			case FINANCE_MANAGER : info[i][3] = "财务人员";
						break;
			case MANAGER : info[i][3] = "总经理";
						break;
			default:
				break;
					
			}
			boolean isHighest = temp.getAuthorization();
			if(isHighest)
				info[i][4] = "最高权限";
			else
				info[i][4] = "普通权限";
		}
		userTable = new JTable(info, columnTitle) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
			
			public String getToolTipText(MouseEvent e) {
		           java.awt.Point p = e.getPoint();
		           int rowIndex = rowAtPoint(p);
		           int colIndex = columnAtPoint(p);
				return (String) this.getValueAt(rowIndex, colIndex);
			}
		};
	}
	class EditListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int rowNum = userTable.getSelectedRow();
			
			String edit_id = (String) userTable.getValueAt(rowNum, 1); 
			String edit_name = (String)userTable.getValueAt(rowNum, 0);
			String edit_authorization = (String)userTable.getValueAt(rowNum, 4);
			
/*			if(user.deleteUser(edit_id).equals(ResultMessage.SUCCESS)) {
				js.setVisible(false);
				ArrayList<UserVo> userInfo = user.showAllUsers();
				System.out.println("size: " + userInfo.size());
				int i=0;
				int size = userInfo.size();
				info = new String[size][5];//  wait for message
				UserVo temp = new UserVo();
				for(;i<size;++i) {
					temp = userInfo.get(i);
					info[i][0] = temp.getName();
					info[i][1] = temp.getId();
					info[i][2] = temp.getPassword();
					switch(temp.getType()) {
					case ADMIN : info[i][3] = "系统管理员";
								break;
					case STOCK_MANAGER : info[i][3] = "库存管理员";
								break;
					case IMEX_MANAGER : info[i][3] = "进货销售员";
								break;
					case FINANCE_MANAGER : info[i][3] = "财务人员";
								break;
					case MANAGER : info[i][3] = "总经理";
								break;
					default:
						break;
							
					}
					boolean isHighest = temp.getAuthorization();
					if(isHighest)
						info[i][4] = "最高权限";
					else
						info[i][4] = "普通权限";
				}
				userTable = new JTable(info, columnTitle);
				js.setViewportView(userTable);
			
				js.setVisible(true);
			}*/
			//  其他意外情况未完成
		}	
	}
	
	class FinListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class DelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int rowNum = userTable.getSelectedRow();
			String del_id = (String) userTable.getValueAt(rowNum, 1); 
			if(user.deleteUser(del_id).equals(ResultMessage.SUCCESS)) {
				js.setVisible(false);
				ArrayList<UserVo> userInfo = user.showAllUsers();
				refreshTable(userInfo);
				js.setViewportView(userTable);
				js.setVisible(true);
			}
			//  其他意外情况未完成
		}	
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}

}
