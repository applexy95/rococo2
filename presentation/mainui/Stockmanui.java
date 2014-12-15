package presentation.mainui;

import java.awt.event.*;

import javax.swing.*;

import presentation.commodityui.CommodityUI;
import presentation.commodityui.CommodityUI_new;
import presentation.mainui.Image;
import presentation.showCommoditiesui.ShowCommoditiesui;
import presentation.stockCheckui.StockCheckui;
import presentation.userui.Loginui;

/**
 * 库存管理员界面
 * @author 瑜钦
 * @version 2014-11-28
 */
public class Stockmanui extends JPanel{

	private JFrame f;
	private JPanel stockmanPanel;
	private JButton returnButton;
	private JButton commodityButton;
	private JButton stockButton;
	private JButton todayButton;
	private JButton giftButton;
	private JButton warningButton;
	private JLabel stockmanBg;
	
	public Stockmanui(final JFrame frame){
		f = frame;
		
		stockmanPanel = new JPanel();
		stockmanPanel.setLayout(null);
		stockmanPanel.setBounds(0, 0, 600, 420);
		stockmanPanel.setOpaque(false);
		
		stockmanBg = new JLabel(Image.stockmanBg);
		stockmanBg.setBounds(0, 0, 600, 420);
		stockmanPanel.add(stockmanBg, -1);
		
		returnButton = new JButton(Image.stockmanReturnButton);
		returnButton.setBounds(18, 18, 35, 35);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setRolloverIcon(Image.stockmanReturnButtonClicked);
		returnButton.setFocusPainted(false);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.remove(stockmanPanel);
				f.add(new Loginui(f));
				f.repaint();
			}
		});
		stockmanPanel.add(returnButton, 0);
		
		commodityButton = new JButton(Image.stockmanCommodityButton);
		commodityButton.setContentAreaFilled(false);
		commodityButton.setBorderPainted(false);
		commodityButton.setRolloverIcon(Image.stockmanCommodityButtonClicked);
		commodityButton.setFocusPainted(false);
		commodityButton.setBounds(305, 77, 146, 146);
		commodityButton.addActionListener(new CommodityListener());
		stockmanPanel.add(commodityButton, 0);
		
		todayButton = new JButton(Image.stockmanTodayButton);
		todayButton.setContentAreaFilled(false);
		todayButton.setBorderPainted(false);
		todayButton.setRolloverIcon(Image.stockmanTodayButtonClicked);
		todayButton.setFocusPainted(false);
		todayButton.setBounds(130, 254, 119, 119);
		todayButton.addActionListener(new TodayListener());
		stockmanPanel.add(todayButton, 0);
		
		stockButton = new JButton(Image.stockmanStockButton);
		stockButton.setContentAreaFilled(false);
		stockButton.setBorderPainted(false);
		stockButton.setRolloverIcon(Image.stockmanStockButtonClicked);
		stockButton.setFocusPainted(false);
		stockButton.setBounds(312, 254, 102, 102);
		stockButton.addActionListener(new StockListener());
		stockmanPanel.add(stockButton, 0);
		
		giftButton = new JButton(Image.stockmanGiftButton);
		giftButton.setContentAreaFilled(false);
		giftButton.setBorderPainted(false);
		giftButton.setRolloverIcon(Image.stockmanGiftButtonClicked);
		giftButton.setFocusPainted(false);
		giftButton.setBounds(203, 153, 74, 74);
		giftButton.addActionListener(new GiftListener());
		stockmanPanel.add(giftButton, 0);
		
		warningButton = new JButton(Image.stockmanWorningButton);
		warningButton.setContentAreaFilled(false);
		warningButton.setBorderPainted(false);
		warningButton.setRolloverIcon(Image.stockmanWorningButtonClicked);
		warningButton.setFocusPainted(false);
		warningButton.setBounds(53, 186, 68, 68);
		warningButton.addActionListener(new WarningListener());
		stockmanPanel.add(warningButton, 0);
	
		stockmanPanel.setVisible(true);
		f.add(stockmanPanel);
		
	}
	
	class CommodityListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(stockmanPanel);
			f.add(new CommodityUI_new(f));
			f.repaint();
		}	
	}
	
	class ClassifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class TodayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(stockmanPanel);
			f.add(new StockCheckui(f));
			f.repaint();
		}	
	}
	
	class WarningListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
	
	class StockListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.remove(stockmanPanel);
			f.add(new ShowCommoditiesui(f));
			f.repaint();
		}	
	}
	
	class GiftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}	
	}

}
