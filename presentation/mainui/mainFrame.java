package presentation.mainui;

import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

import presentation.userui.Loginui;
/**
 * 主窗体
 * @author 瑜钦
 * @version 2014-11-28
 */

public class mainFrame extends JFrame{

	private JFrame frame;
	private JButton exitButton;
	private JButton minButton;
	
	public mainFrame(){
		frame = new JFrame();
		frame.setBounds(370, 180, 600, 420);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		exitButton = new JButton(Image.loginExitButton);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setRolloverIcon(Image.loginExitButtonClicked);
		exitButton.setFocusPainted(false);
		exitButton.setBounds(541, 9, 51, 51);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(exitButton);
		
		minButton = new JButton(Image.loginMinButton);
		minButton.setContentAreaFilled(false);
		minButton.setBorderPainted(false);
		minButton.setRolloverIcon(Image.loginMinButtonClicked);
		minButton.setFocusPainted(false);
		minButton.setBounds(489, 10, 50, 50);
		minButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}			
		});
		frame.add(minButton);
		
		frame.add(new Loginui(frame));
		
		setDragable(frame);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		mainFrame frame = new mainFrame();
	}
	
	private Point loc = null;
	private Point tmp = null;
	private boolean isDragged = false;

	public void setDragable(JFrame jframe) {
		jframe.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}
		});
		jframe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if(isDragged) {
					loc = new Point(frame.getLocation().x + e.getX() - tmp.x,
							frame.getLocation().y + e.getY() - tmp.y);
					frame.setLocation(loc);
				}
			}
		});
	}
}
