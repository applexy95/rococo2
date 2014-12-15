package presentation.stockCheckui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.excel.ExportExcel;
import presentation.mainui.Stockmanui;
import vo.CheckStockItemVo;
import vo.CheckStockVo;
import businesslogicservice.commodityblservice.CommodityblService;
import businesslogicservice.commodityblservice.CommodityblService_Stub;

public class StockCheckui extends JPanel{
	
	private JFrame f;
	private JPanel checkPanel;
	private JButton excel;
	private JButton back;
	private JTable checkTable;
	private JScrollPane js;
	private String [] columnTitle;
	private String [][] info; 
	
	private CommodityblService commodity;
	
	public StockCheckui(final JFrame frame) {
		f = frame;
		commodity = new CommodityblService_Stub();
	
		checkPanel = new JPanel();
		checkPanel.setLayout(null);
		checkPanel.setBounds(0, 0, 600, 420);
		checkPanel.setOpaque(false);
		
		back = new JButton("back");
		back.setBounds(10, 10, 60, 60);
		back.addActionListener(new BackListener());
		checkPanel.add(back);
		
		excel = new JButton("导出");
		excel.setBounds(500, 300, 60, 60);
		excel.addActionListener(new ExcelListener());
		checkPanel.add(excel);
		
		checkTable = new JTable();
		columnTitle = new String[]{"行号","名称","型号","库存数量","库存均价","批次","批号"};
		refreshTable();
		checkPanel.add(js);
		
		checkPanel.setVisible(true);
		f.add(checkPanel);
	}
	
	private void refreshTable() {
		CheckStockVo list = commodity.check();
		ArrayList<CheckStockItemVo> listInfo = list.getItem();
		int size = listInfo.size();
		info = new String [size][7];
		
		for(int i = 0;i < size; ++i) {
			info[i][0] = Integer.toString(i);
			info[i][1] = listInfo.get(i).getName();
			info[i][2] = listInfo.get(i).getType();
			info[i][3] = Integer.toString(listInfo.get(i).getStock_number());
			info[i][4] = Double.toString(listInfo.get(i).getStock_average_imports());
			info[i][5] = list.getBatch_number();
			info[i][6] = list.getLot_number();
		}
		
		checkTable = new JTable(info,columnTitle);
		js = new JScrollPane();
		js.setViewportView(checkTable);
		js.setBounds(35, 107, 532, 253);
		js.setOpaque(false);
		js.getViewport().setOpaque(true);
		js.setVisible(true);
	}
	
	class BackListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.remove(checkPanel);
			f.add(new Stockmanui(f));
			f.repaint();
		}
		
	}
	
	class ExcelListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ExportExcel exp = new ExportExcel();
			try {
				exp.exportTable(checkTable, new File("库存盘点.xls"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
