package presentation.exportsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.mainui.Image;
import presentation.mainui.Salesmanui;
import presentation.userui.Loginui;

/**
 * 销售和销售退货界面，进货销售员操作
 * @author 瑜钦
 *
 */
public class Exportsui extends JPanel{
	private JPanel exportPanel;
	private JButton returnButton;
	private JButton addImportsButton;
	private JButton exportsNoteButton;
	private JButton returnNoteButton;
	private JButton returnExportsButton;
	private JLabel exportsBg;
	private JTable exportsTable;
	private JLabel timer;
	private JScrollPane js;
	
	public Exportsui(final JFrame frame){
		exportPanel = new JPanel();
		exportPanel.setLayout(null);
		exportPanel.setBounds(0, 0, 600, 420);
		exportPanel.setOpaque(false);
		
		exportsBg = new JLabel(Image.exportsBg);
		exportsBg.setBounds(0, 0, 600, 420);
		exportPanel.add(exportsBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.remove(exportPanel);
				frame.add(new Salesmanui(frame));
				frame.repaint();
			}
		});
		exportPanel.add(returnButton, 0);
		
		exportsNoteButton = new JButton(Image.exportsExportsNoteButton);
		exportsNoteButton.setContentAreaFilled(false);
		exportsNoteButton.setBorderPainted(false);
		exportsNoteButton.setRolloverIcon(Image.exportsExportsNoteButtonClicked);
		exportsNoteButton.setFocusPainted(false);
		exportsNoteButton.setBounds(89, 93, 80, 24);
		exportsNoteButton.addActionListener(new ImportsNoteListener());
		exportPanel.add(exportsNoteButton, 0);
		
		returnNoteButton = new JButton(Image.exportsReturnNoteButton);
		returnNoteButton.setContentAreaFilled(false);
		returnNoteButton.setBorderPainted(false);
		returnNoteButton.setRolloverIcon(Image.exportsReturnNoteButtonClicked);
		returnNoteButton.setFocusPainted(false);
		returnNoteButton.setBounds(203, 93, 80, 24);
		returnNoteButton.addActionListener(new ReturnNoteListener());
		exportPanel.add(returnNoteButton, 0);
		
		addImportsButton = new JButton(Image.exportsAddExportsButton);
		addImportsButton.setContentAreaFilled(false);
		addImportsButton.setBorderPainted(false);
		addImportsButton.setRolloverIcon(Image.exportsAddExportsButtonClicked);
		addImportsButton.setFocusPainted(false);
		addImportsButton.setBounds(319, 93, 80, 24);
		addImportsButton.addActionListener(new AddImportsListener());
		exportPanel.add(addImportsButton, 0);
		
		returnExportsButton = new JButton(Image.exportsExportsNoteButton);
		returnExportsButton.setContentAreaFilled(false);
		returnExportsButton.setBorderPainted(false);
		returnExportsButton.setRolloverIcon(Image.exportsExportsNoteButtonClicked);
		returnExportsButton.setFocusPainted(false);
		returnExportsButton.setBounds(434, 93, 80, 24);
		returnExportsButton.addActionListener(new ReturnImportsListener());
		exportPanel.add(returnExportsButton, 0);
		
		String[] columnTitle = new String[]{"A", "B", "C"};
		String[][] info = {{"a", "b", "c"}};
		exportsTable = new JTable(info, columnTitle);
		exportsTable.setVisible(true);
		exportsTable.setSize(532, 249);
		exportsTable.setOpaque(false);
		js = new JScrollPane();
		js.setViewportView(exportsTable);
		js.setVisible(true);
		js.setBounds(35, 141, 532, 249);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		exportPanel.add(js, 0);
		
		exportPanel.setVisible(true);
		frame.add(exportPanel);
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
