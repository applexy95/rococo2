package presentation.accountantui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import constant.ResultMessage;
import businesslogicservice.accoutantblservice.AccountantblService;
import businesslogicservice.accoutantblservice.AccountantblService_Stub;
import presentation.mainui.Financialui;
import presentation.mainui.Image;
import vo.AccountVo;

/**
 * 账户管理界面，财务人员操作
 * @author 瑜钦
 *
 */
public class Accountantui extends JPanel{
	private JFrame f;
	private JPanel accountantPanel;
	private JButton returnButton;
	private JButton addButton;
	private JButton delButton;
	private JButton editButton;
	private JButton searchButton;
	private JLabel accountantBg;
	private JTable accountantTable;
	private JLabel timer;
	private JTextField searchText;
	private JScrollPane js;
	private String[] columnTitle;
	private String[][] info;
	private AccountantblService accountant;
	
	public Accountantui(JFrame frame){
		f = frame;
		accountant = new AccountantblService_Stub();
		
		accountantPanel = new JPanel();
		accountantPanel.setLayout(null);
		accountantPanel.setBounds(0, 0, 600, 420);
		accountantPanel.setOpaque(false);
		
		accountantBg = new JLabel(Image.accountantBg);
		accountantBg.setBounds(0, 0, 600, 420);
		accountantPanel.add(accountantBg, -1);
		
		searchText = new JTextField();
		searchText.setBounds(412, 94, 146, 20);
		searchText.setOpaque(false);
		searchText.setBorder(null);
		searchText.setForeground(Color.white);
		accountantPanel.add(searchText, 0);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.remove(accountantPanel);
				f.add(new Financialui(f));
				f.repaint();
			}
		});
		accountantPanel.add(returnButton, 0);
		
		addButton = new JButton(Image.accountantAddButton);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setRolloverIcon(Image.accountantAddButtonClicked);
		addButton.setFocusPainted(false);
		addButton.setBounds(89, 93, 80, 24);
		addButton.addActionListener(new AddListener());
		accountantPanel.add(addButton, 0);
		
		delButton = new JButton(Image.accountantDelButton);
		delButton.setContentAreaFilled(false);
		delButton.setBorderPainted(false);
		delButton.setRolloverIcon(Image.accountantDelButtonClicked);
		delButton.setFocusPainted(false);
		delButton.setBounds(203, 93, 80, 24);
		delButton.addActionListener(new DelListener());
		accountantPanel.add(delButton, 0);
		
		editButton = new JButton(Image.accountantEditButton);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		editButton.setRolloverIcon(Image.accountantEditButtonClicked);
		editButton.setFocusPainted(false);
		editButton.setBounds(319, 93, 80, 24);
		editButton.addActionListener(new EditListener());
		accountantPanel.add(editButton, 0);
		
		searchButton = new JButton(Image.memberSearchButton);
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		searchButton.setRolloverIcon(Image.memberSearchButtonClicked);
		searchButton.setFocusPainted(false);
		searchButton.setBounds(554, 90, 30, 30);
		searchButton.addActionListener(new SearchListener());
		accountantPanel.add(searchButton, 0);
		
		columnTitle = new String[]{"账户ID","账户名称","账户余额"};
		ArrayList<AccountVo> accountInfo = accountant.showAllAccounts();
		refreshTable(accountInfo);
		accountantTable.setVisible(true);
		accountantTable.setSize(532, 213);
		accountantTable.setOpaque(false);
		js = new JScrollPane();
		js.setViewportView(accountantTable);
		js.setVisible(true);
		js.setBounds(35, 177, 532, 213);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		accountantPanel.add(js, 0);
		
		accountantPanel.setVisible(true);
		f.add(accountantPanel);
	}
	
	private void refreshTable(ArrayList<AccountVo> accountInfo) {
		int i=0;
		int size = accountInfo.size();
		info = new String[size][3];
	
		for(;i<size;++i) {
			AccountVo temp = accountInfo.get(i);
			info[i][0] = temp.getId();
			info[i][1] = temp.getName();
			info[i][2] = Double.toString(temp.getMoney());
		}
		accountantTable = new JTable(info, columnTitle) {
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
			
		}	
	}
	
	class FinListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class DelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int rowNum = accountantTable.getSelectedRow();
			if(rowNum!=-1) {
				String del_name = (String) accountantTable.getValueAt(rowNum, 1); 
				if(accountant.deleteAccount(del_name).equals(ResultMessage.SUCCESS)) {
					js.setVisible(false);
					ArrayList<AccountVo> accountInfo = accountant.showAllAccounts();
					refreshTable(accountInfo);
					js.setViewportView(accountantTable);
					js.setVisible(true);
				}
			}
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
