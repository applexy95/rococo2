package presentation.showCommoditiesui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.DataChooser.DateChooser;
import presentation.mainui.Stockmanui;

public class ShowCommoditiesui extends JPanel{

	private JFrame f;
	private DateChooser startTimeChooser;
	private DateChooser endTimeChooser;
	private JTextField startFlag;
	private JTextField endFlag;
	private JTable commodityTable;
	private String []columnTitle;
	private String [][] info;
	private JScrollPane js; 
	private JPanel commodityPanel;
	private JButton back;
	
	public ShowCommoditiesui(final JFrame frame) {
		f = frame;
		
		commodityPanel = new JPanel();
		commodityPanel.setLayout(null);
		commodityPanel.setBounds(0, 0, 600, 420);
		commodityPanel.setOpaque(false);
		
		startFlag = new JTextField("start time");
		endFlag = new JTextField("end time");
		startTimeChooser = DateChooser.getInstance("yyyy-MM-dd");
		startTimeChooser.register(startFlag);
		startFlag.setBounds(30, 90, 100, 30);
		commodityPanel.add(startFlag);
		
		endTimeChooser = DateChooser.getInstance("yyyy-MM-dd");
		endTimeChooser.register(endFlag);
		endFlag.setBounds(160, 90, 100, 30);
		commodityPanel.add(endFlag);
		
		commodityTable = new JTable();
		columnTitle = new String[]{"出库数量","入库数量","库存数量"};
		refreshTable();
		commodityPanel.add(js);
		
		back = new JButton("back");
		back.setBounds(10, 10, 30, 30);
		back.addActionListener(new BackListener());
		commodityPanel.add(back);
		
		commodityPanel.setVisible(true);
		f.add(commodityPanel);
	}

	private void refreshTable() {
		info = new String[0][0];
		commodityTable = new JTable(info,columnTitle);
		js = new JScrollPane();
		js.setBounds(40, 120, 350, 220);
		js.add(commodityTable);
		js.setVisible(true);
	}
	
	class BackListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.remove(commodityPanel);
			f.add(new Stockmanui(f));
			f.repaint();
		}
		
	}
	
}
