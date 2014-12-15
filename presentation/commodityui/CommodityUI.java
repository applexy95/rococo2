package presentation.commodityui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import constant.ResultMessage;
import vo.CommodityVo;
import businesslogicservice.commodityblservice.CommodityblService_Stub;





public class CommodityUI extends JPanel{
	private JFrame f;
	private DefaultMutableTreeNode top;
	private JTree tree;
	private JButton add;
	private JButton cancel;
	private JButton ok;
	private JPanel addPanel;
	private JPanel bottom;
	private JTextField name;
	private JTextField model;
	private JTextField bid;
	private JTextField price;
	private JLabel lname;
	private JLabel lmodel;
	private JLabel lbid;
	private JLabel lprice;
	private JTable table;
	private JScrollPane js;
	private JScrollPane jsNew;
	private CommodityblService_Stub stub;
	private ArrayList<CommodityVo> commodityList; 
	
	public CommodityUI(JFrame frame) {
		f = frame;
		stub = new CommodityblService_Stub();
		commodityList = stub.findCommodity("");
		
		f = new JFrame();
		f.setBounds(320, 150, 930, 480);
		f.setTitle("进销存系统 - 商品管理");
		f.setLayout(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		bottom = new JPanel();
		bottom.setBounds(0, 0, 930, 480);
		bottom.setLayout(null);
		
		add = new JButton("添加商品");
        add.setBounds(523, 35, 120, 32);
        add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel = new JPanel();
				addPanel.setBounds(500, 95, 399, 236);
				addPanel.setBackground(Color.GRAY);
				addPanel.setLayout(null);
				
				ok = new JButton("确定");
				ok.setBounds(102, 187, 65, 32);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						js.setVisible(false);
						
						String nameS = name.getText();
						String modelS = model.getText();
						String priceInDe = bid.getText();
						String priceOutDe = price.getText();
						ResultMessage isSucceed = stub.addCommodity(nameS, modelS, "默认分类");
						if(isSucceed == ResultMessage.SUCCESS) {
							String[][] info = new String[8][8];
							info[0][0] = nameS;
							info[0][1] = modelS;
							info[0][2] = "0";
							info[0][3] = "默认分类";
							info[0][4] = priceInDe;
							info[0][5] = priceOutDe;
							info[0][6] = "-";
							info[0][7] = "-";
							
							String[] columnTitle = new String[]{"名称", "型号", "数量", "商品分类", "默认进价",
									"默认售价", "最后一次进价", "最后一次售价"};
							table = new JTable(info, columnTitle);
							table.setVisible(true);
							table.setSize(430, 250);
							table.repaint();
							
							jsNew = new JScrollPane();
							jsNew.setViewportView(table);
							jsNew.setVisible(true);
							jsNew.setBounds(53, 85, 430, 270);
							bottom.add(jsNew);
							bottom.repaint();
							
						}else{
							System.out.println("添加商品失败");
						}
						addPanel.setVisible(false);
					}
				});
				addPanel.add(ok);
				
				cancel = new JButton("取消");
				cancel.setBounds(224, 187, 91, 32);
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addPanel.setVisible(false);
					}
				});
				addPanel.add(cancel);
				name = new JTextField();
				name.setBounds(169, 34, 177, 20);
				addPanel.add(name);
				
				model = new JTextField();
				model.setBounds(169, 75, 177, 20);
				addPanel.add(model);
				
				bid = new JTextField();
				bid.setBounds(169, 115, 177, 20);
				addPanel.add(bid);
				
				price = new JTextField();
				price.setBounds(169, 155, 177, 20);
				addPanel.add(price);
				
				lname = new JLabel("商品名称");
				lname.setBounds(89, 34, 60, 20);
				addPanel.add(lname);
				
				lmodel = new JLabel("商品型号");
				lmodel.setBounds(89, 75, 60, 20);
				addPanel.add(lmodel);
				
				lbid = new JLabel("默认进价");
				lbid.setBounds(89, 115, 60, 20);
				addPanel.add(lbid);
				
				lprice = new JLabel("默认售价");
				lprice.setBounds(89, 155, 60, 20);
				addPanel.add(lprice);
				
				addPanel.setVisible(true);
				bottom.add(addPanel);
				bottom.repaint();
			}
		});
        bottom.add(add);
        
		String[][] info = new String[8][8];
		String[] columnTitle = new String[]{"名称", "型号", "数量", "商品分类", "默认进价",
				"默认售价", "最后一次进价", "最后一次售价"};
		table = new JTable(info, columnTitle);
		table.setVisible(true);
		table.setSize(430, 250);
		
		js = new JScrollPane();
		js.setViewportView(table);
		js.setVisible(true);
		js.setBounds(53, 85, 430, 270);
		bottom.add(js);
		bottom.repaint();
		   
        f.add(bottom);
        f.repaint();
    }
	
}

