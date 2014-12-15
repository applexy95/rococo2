package presentation.mainui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import presentation.userui.Loginui;

/**
 * 总经理主界面
 * @author 瑜钦
 * @version 2014-11-28
 */
public class Managerui extends JPanel{

	private JPanel managerPanel;
	private JButton returnButton;
	private JButton formsButton;
	private JButton promotionButton;
	private JButton checklistButton;
	private JLabel managerBg;
	
	public Managerui(final JFrame frame){
		managerPanel = new JPanel();
		managerPanel.setLayout(null);
		managerPanel.setBounds(0, 0, 600, 420);
		managerPanel.setOpaque(false);
		
		managerBg = new JLabel(Image.managerBg);
		managerBg.setBounds(0, 0, 600, 420);
		managerPanel.add(managerBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(managerPanel);
				frame.add(new Loginui(frame));
				frame.repaint();
			}
		});
		managerPanel.add(returnButton, 0);
		
		formsButton = new JButton(Image.managerFormsButton);
		formsButton.setContentAreaFilled(false);
		formsButton.setBorderPainted(false);
		formsButton.setRolloverIcon(Image.managerFormsButtonClicked);
		formsButton.setFocusPainted(false);
		formsButton.setBounds(166, 266, 141, 140);
		formsButton.addActionListener(new FormsListener());
		managerPanel.add(formsButton, 0);
		
		promotionButton = new JButton(Image.managerPromotionButton);
		promotionButton.setContentAreaFilled(false);
		promotionButton.setBorderPainted(false);
		promotionButton.setRolloverIcon(Image.managerPromotionButtonClicked);
		promotionButton.setFocusPainted(false);
		promotionButton.setBounds(296, 147, 119, 119);
		promotionButton.addActionListener(new PromotionListener());
		managerPanel.add(promotionButton, 0);
		
		checklistButton = new JButton(Image.managerChecklistButton);
		checklistButton.setContentAreaFilled(false);
		checklistButton.setBorderPainted(false);
		checklistButton.setRolloverIcon(Image.managerChecklistButtonClicked);
		checklistButton.setFocusPainted(false);
		checklistButton.setBounds(66, 113, 149, 149);
		checklistButton.addActionListener(new ChecklistListener());
		managerPanel.add(checklistButton, 0);
		
		managerPanel.setVisible(true);
		frame.add(managerPanel);
	}
	
	class ChecklistListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class PromotionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class FormsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
