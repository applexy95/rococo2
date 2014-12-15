package presentation.mainui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.importsui.Importsui;
import presentation.memberui.Memberui;
import presentation.userui.Loginui;

import javax.swing.*;

/**
 * 进货销售员主界面
 * @author 瑜钦
 * @version 2014-11-28
 */
public class Salesmanui extends JPanel{
	private JFrame f;
	private JPanel salesmanPanel;
	private JButton returnButton;
	private JButton menberButton;
	private JButton importsButton;
	private JButton exportsButton;
	private JLabel salesmanBg;
	
	public Salesmanui(final JFrame frame){
		f = frame;
		
		salesmanPanel = new JPanel();
		salesmanPanel.setLayout(null);
		salesmanPanel.setBounds(0, 0, 600, 420);
		salesmanPanel.setOpaque(false);
		
		salesmanBg = new JLabel(Image.salesmanBg);
		salesmanBg.setBounds(0, 0, 600, 420);
		salesmanPanel.add(salesmanBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(salesmanPanel);
				frame.add(new Loginui(frame));
				frame.repaint();
			}
		});
		salesmanPanel.add(returnButton, 0);
		
		menberButton = new JButton(Image.salesmanMemberButton);
		menberButton.setContentAreaFilled(false);
		menberButton.setBorderPainted(false);
		menberButton.setRolloverIcon(Image.salesmanMemberButtonClicked);
		menberButton.setFocusPainted(false);
		menberButton.setBounds(207, 97, 141, 140);
		menberButton.addActionListener(new MemberListener());
		salesmanPanel.add(menberButton, 0);
		
		importsButton = new JButton(Image.salesmanImportsButton);
		importsButton.setContentAreaFilled(false);
		importsButton.setBorderPainted(false);
		importsButton.setRolloverIcon(Image.salesmanImportsButtonClicked);
		importsButton.setFocusPainted(false);
		importsButton.setBounds(302, 258, 102, 102);
		importsButton.addActionListener(new ImportsListener());
		salesmanPanel.add(importsButton, 0);
		
		exportsButton = new JButton(Image.salesmanExportsButton);
		exportsButton.setContentAreaFilled(false);
		exportsButton.setBorderPainted(false);
		exportsButton.setRolloverIcon(Image.salesmanExportsButtonClicked);
		exportsButton.setFocusPainted(false);
		exportsButton.setBounds(426, 147, 119, 119);
		exportsButton.addActionListener(new ExportsListener());
		salesmanPanel.add(exportsButton, 0);
		
		salesmanPanel.setVisible(true);
		frame.add(salesmanPanel);
	}
	
	class MemberListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(salesmanPanel);
			f.add(new Memberui(f));
			f.repaint();
		}	
	}
	
	class ImportsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(salesmanPanel);
			f.add(new Importsui(f));
			f.repaint();
		}	
	}
	
	class ExportsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(salesmanPanel);
			//f.add(new Exportsui(f));
			f.repaint();
		}	
	}

}
