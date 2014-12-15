package presentation.memberui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import businesslogicservice.memberblservice.MemberblService;
import businesslogicservice.memberblservice.MemberblService_Stub;
import presentation.mainui.Image;
import presentation.mainui.Salesmanui;
import vo.MemberVo;

/**
 * 客户管理界面，进货销售人员操作
 * @author 瑜钦
 * @version 2014-12-01
 *
 */

public class Memberui extends JPanel{
	private JPanel memberPanel;
	private JButton returnButton;
	private JButton addButton;
	private JButton delButton;
	private JButton finButton;
	private JButton editButton;
	private JButton searchButton;
	private JLabel memberBg;
	private JTable memberTable;
	private JLabel timer;
	private JTextField searchText;
	private JScrollPane js;
	
	public Memberui(final JFrame frame){
		memberPanel = new JPanel();
		memberPanel.setLayout(null);
		memberPanel.setBounds(0, 0, 600, 420);
		memberPanel.setOpaque(false);
		
		memberBg = new JLabel(Image.memberBg);
		memberBg.setBounds(0, 0, 600, 420);
		memberPanel.add(memberBg, -1);
		
		searchText = new JTextField();
		searchText.setBounds(40, 141, 146, 20);
		searchText.setOpaque(false);
		searchText.setBorder(null);
		searchText.setForeground(Color.white);
		memberPanel.add(searchText, 0);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(memberPanel);
				frame.add(new Salesmanui(frame));
				frame.repaint();
			}
		});
		memberPanel.add(returnButton, 0);
		
		addButton = new JButton(Image.memberAddButton);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setRolloverIcon(Image.memberAddButtonClicked);
		addButton.setFocusPainted(false);
		addButton.setBounds(89, 93, 80, 24);
		addButton.addActionListener(new AddListener());
		memberPanel.add(addButton, 0);
		
		delButton = new JButton(Image.memberDelButton);
		delButton.setContentAreaFilled(false);
		delButton.setBorderPainted(false);
		delButton.setRolloverIcon(Image.memberDelButtonClicked);
		delButton.setFocusPainted(false);
		delButton.setBounds(203, 93, 80, 24);
		delButton.addActionListener(new DelListener());
		memberPanel.add(delButton, 0);
		
		finButton = new JButton(Image.memberFinButton);
		finButton.setContentAreaFilled(false);
		finButton.setBorderPainted(false);
		finButton.setRolloverIcon(Image.memberFinButtonClicked);
		finButton.setFocusPainted(false);
		finButton.setBounds(319, 93, 80, 24);
		finButton.addActionListener(new FinListener());
		memberPanel.add(finButton, 0);
		
		editButton = new JButton(Image.memberEditButton);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		editButton.setRolloverIcon(Image.memberEditButtonClicked);
		editButton.setFocusPainted(false);
		editButton.setBounds(434, 93, 80, 24);
		editButton.addActionListener(new EditListener());
		memberPanel.add(editButton, 0);
		
		searchButton = new JButton(Image.memberSearchButton);
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		searchButton.setRolloverIcon(Image.memberSearchButtonClicked);
		searchButton.setFocusPainted(false);
		searchButton.setBounds(181, 136, 30, 30);
		searchButton.addActionListener(new SearchListener());
		memberPanel.add(searchButton, 0);
		
		String[] columnTitle = new String[]{"编号", "类别", "级别","姓名","电话","地址","邮编","电子邮箱","额度","应收","应付","默认业务员"};
		String[][] info ;
		MemberblService memberController;
		memberController = new MemberblService_Stub();
		ArrayList<MemberVo> memberInfo = memberController.showAllMembers();
		int size = memberInfo.size();
		info = new String[size][12];
		
		for(int i=0;i<size;++i) {
			MemberVo temp = memberInfo.get(i);
			info[i][0] = temp.getMember_number();
			switch(temp.getType()) {
			case PURCHASE : info[i][1] = "进货商";
									break;
			case SALE : info[i][1] = "销售商";
							break;
			case BOTH : info[i][1] = "进销商";
							break;
			}
			info[i][2] = temp.getLevel().toString();
			info[i][3] = temp.getName();
			info[i][4] = temp.getTel();
			info[i][5] = temp.getAddress();
			info[i][6] = temp.getPostcode();
			info[i][7] = temp.getEmail();
			info[i][8] = Integer.toString(temp.getDabt_limit());
			info[i][9] = Double.toString(temp.getReceivable());
			info[i][10] = Double.toString(temp.getPayments());
			info[i][11] = temp.getDefault_salesman().getId();
		}
		memberTable = new JTable(info, columnTitle);
		memberTable.setVisible(true);
		memberTable.setSize(532, 213);
		memberTable.setOpaque(false);
		js = new JScrollPane();
		js.setViewportView(memberTable);
		js.setVisible(true);
		js.setBounds(35, 177, 532, 213);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		memberPanel.add(js, 0);
		
		memberPanel.setVisible(true);
		frame.add(memberPanel);
	}
	
	class EditListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class FinListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class DelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class SearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}

}
