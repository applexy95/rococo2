package presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import presentation.accountantui.Accountantui;
import presentation.userui.Loginui;

/**
 * 财务人员主界面
 * @author 瑜钦
 * @version 2014-11-28
 */
public class Financialui extends JPanel{

	private JFrame f;
	private JPanel financialPanel;
	private JButton returnButton;
	private JButton formsButton;
	private JButton initialButton;
	private JButton listButton;
	private JButton accountButton;
	private JLabel financialBg;
	
	public Financialui(final JFrame frame){
		f = frame;
		
		financialPanel = new JPanel();
		financialPanel.setLayout(null);
		financialPanel.setBounds(0, 0, 600, 420);
		financialPanel.setOpaque(false);
		
		financialBg = new JLabel(Image.financialBg);
		financialBg.setBounds(0, 0, 600, 420);
		financialPanel.add(financialBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.remove(financialPanel);
				f.add(new Loginui(f));
				f.repaint();
			}
		});
		financialPanel.add(returnButton, 0);
		
		formsButton = new JButton(Image.financialFormsButton);
		formsButton.setContentAreaFilled(false);
		formsButton.setBorderPainted(false);
		formsButton.setRolloverIcon(Image.financialFormsButtonClicked);
		formsButton.setFocusPainted(false);
		formsButton.setBounds(36, 200, 141, 140);
		formsButton.addActionListener(new FormsListener());
		financialPanel.add(formsButton, 0);
		
		initialButton = new JButton(Image.financialInitialButton);
		initialButton.setContentAreaFilled(false);
		initialButton.setBorderPainted(false);
		initialButton.setRolloverIcon(Image.financialInitialButtonClicked);
		initialButton.setFocusPainted(false);
		initialButton.setBounds(199, 114, 90, 90);
		initialButton.addActionListener(new InitialListener());
		financialPanel.add(initialButton, 0);
		
		listButton = new JButton(Image.financialListButton);
		listButton.setContentAreaFilled(false);
		listButton.setBorderPainted(false);
		listButton.setRolloverIcon(Image.financialListButtonClicked);
		listButton.setFocusPainted(false);
		listButton.setBounds(236, 247, 149, 149);
		listButton.addActionListener(new ListListener());
		financialPanel.add(listButton, 0);
		
		accountButton = new JButton(Image.financialAccountButton);
		accountButton.setContentAreaFilled(false);
		accountButton.setBorderPainted(false);
		accountButton.setRolloverIcon(Image.financialAccountButtonClicked);
		accountButton.setFocusPainted(false);
		accountButton.setBounds(352, 107, 119, 119);
		accountButton.addActionListener(new AccountListener());
		financialPanel.add(accountButton, 0);
		
		financialPanel.setVisible(true);
		f.add(financialPanel);
	}
	
	class ListListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class InitialListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class FormsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class AccountListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(financialPanel);
			f.add(new Accountantui(f));
			f.repaint();
			
		}
	}
}
