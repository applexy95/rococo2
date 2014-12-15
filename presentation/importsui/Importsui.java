package presentation.importsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import presentation.mainui.Image;
import presentation.mainui.Salesmanui;
import presentation.userui.Loginui;

/**
 * 进货和进货退货界面，销售人员操作
 * @author 瑜钦
 * @version 2014-12-01
 */
public class Importsui extends JPanel{

	private JPanel importsPanel;
	private JButton returnButton;
	private JButton addImportsButton;
	private JButton importsNoteButton;
	private JButton returnNoteButton;
	private JButton returnImportsButton;
	private JLabel importsBg;
	private JTable importsTable;
	private JLabel timer;
	private JScrollPane js;
	
	public Importsui(final JFrame frame){
		importsPanel = new JPanel();
		importsPanel.setLayout(null);
		importsPanel.setBounds(0, 0, 600, 420);
		importsPanel.setOpaque(false);
		
		importsBg = new JLabel(Image.importsBg);
		importsBg.setBounds(0, 0, 600, 420);
		importsPanel.add(importsBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(importsPanel);
				frame.add(new Salesmanui(frame));
				frame.repaint();
			}
		});
		importsPanel.add(returnButton, 0);
		
		importsNoteButton = new JButton(Image.importsImportsNoteButton);
		importsNoteButton.setContentAreaFilled(false);
		importsNoteButton.setBorderPainted(false);
		importsNoteButton.setRolloverIcon(Image.importsImportsNoteButtonClicked);
		importsNoteButton.setFocusPainted(false);
		importsNoteButton.setBounds(89, 93, 80, 24);
		importsNoteButton.addActionListener(new ImportsNoteListener());
		importsPanel.add(importsNoteButton, 0);
		
		returnNoteButton = new JButton(Image.importsReturnNoteButton);
		returnNoteButton.setContentAreaFilled(false);
		returnNoteButton.setBorderPainted(false);
		returnNoteButton.setRolloverIcon(Image.importsReturnNoteButtonClicked);
		returnNoteButton.setFocusPainted(false);
		returnNoteButton.setBounds(203, 93, 80, 24);
		returnNoteButton.addActionListener(new ReturnNoteListener());
		importsPanel.add(returnNoteButton, 0);
		
		addImportsButton = new JButton(Image.importsAddImportsButton);
		addImportsButton.setContentAreaFilled(false);
		addImportsButton.setBorderPainted(false);
		addImportsButton.setRolloverIcon(Image.importsAddImportsButtonClicked);
		addImportsButton.setFocusPainted(false);
		addImportsButton.setBounds(319, 93, 80, 24);
		addImportsButton.addActionListener(new AddImportsListener());
		importsPanel.add(addImportsButton, 0);
		
		returnImportsButton = new JButton(Image.importsReturnImportsButton);
		returnImportsButton.setContentAreaFilled(false);
		returnImportsButton.setBorderPainted(false);
		returnImportsButton.setRolloverIcon(Image.importsReturnImportsButtonClicked);
		returnImportsButton.setFocusPainted(false);
		returnImportsButton.setBounds(434, 93, 80, 24);
		returnImportsButton.addActionListener(new ReturnImportsListener());
		importsPanel.add(returnImportsButton, 0);
		
		String[] columnTitle = new String[]{"A", "B", "C"};
		String[][] info = {{"a", "b", "c"}};
		importsTable = new JTable(info, columnTitle);
		importsTable.setVisible(true);
		importsTable.setSize(532, 249);
		importsTable.setOpaque(false);
		js = new JScrollPane();
		js.setViewportView(importsTable);
		js.setVisible(true);
		js.setBounds(35, 141, 532, 249);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		importsPanel.add(js, 0);
		
		importsPanel.setVisible(true);
		frame.add(importsPanel);
	}
	
	class ReturnImportsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class AddImportsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class ReturnNoteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class ImportsNoteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}

}
