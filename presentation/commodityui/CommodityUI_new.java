package presentation.commodityui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import vo.CategoryVo;
import businesslogicservice.commodityblservice.CommodityblService;
import businesslogicservice.commodityblservice.CommodityblService_Stub;
import businesslogicservice.commoditycategoryblservice.CommodityCategoryblService;
import businesslogicservice.commoditycategoryblservice.CommodityCategoryblService_Stub;

public class CommodityUI_new extends JPanel{

	private JFrame f;
	private JTree tree;
	private JPanel commodityPanel;
	private DefaultMutableTreeNode top;
	private CommodityblService commodity;
	private CommodityCategoryblService category;
	private JScrollPane treeView;
	private JButton addCategory;
	private JButton delCategory;
	private JButton editCategory;
	private JButton addCommodity;
//	private TreeNode presentSelected;
	
	public CommodityUI_new(JFrame frame) {
		f = frame;
		f.setVisible(false);
		commodity = new CommodityblService_Stub();
		category = new CommodityCategoryblService_Stub();
		
		commodityPanel  = new JPanel();
		commodityPanel.setLayout(null);
		commodityPanel.setBounds(0, 0, 600, 420);
		commodityPanel.setOpaque(false);
		
		addCategory = new JButton("添加类别");
		addCategory.setBounds(89, 93, 80, 25);
		addCategory.addActionListener( new AddListener());
		commodityPanel.add(addCategory);
		
		delCategory = new JButton("删除类别");
		delCategory.setBounds(180, 93, 90, 25);
		delCategory.addActionListener(new DelListener());
		commodityPanel.add(delCategory);
		
		editCategory = new JButton("编辑类别");
		editCategory.setBounds(270, 93, 90, 25);
		editCategory.addActionListener(new EditListener());
		commodityPanel.add(editCategory);
		
		addCommodity = new JButton("添加商品");
		addCommodity.setBounds(360, 93, 90, 25);
		
		
		top = new DefaultMutableTreeNode("商品类别",true);
		createTree();
		commodityPanel.add(treeView);
		
		commodityPanel.setVisible(true);
		f.add(commodityPanel);
		f.setVisible(true);
	}
	
	private void createTree() {
		createNodes();
		tree = new JTree(top);
	    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(node.isLeaf()) {
					CategoryVo vo = (CategoryVo)node.getUserObject();
					String id = vo.getId();
					//显示商品Panel
				}
			}
	    	
	    });
		treeView = new JScrollPane(tree);
		treeView.setBounds(35, 177, 182, 213);
		treeView.setVisible(true);
	}
	private void createNodes() {
		ArrayList<CategoryVo> categoryInfo = category.showAllCatagories();
		
		Collections.sort(categoryInfo);
		
		DefaultMutableTreeNode node;
		int i = 0;
		int size = categoryInfo.size();
		
		for(int t = 0;t<size;t++)
			System.out.println(categoryInfo.get(t).getId());
		int prelength = 0;
		ArrayList<DefaultMutableTreeNode> nodes = new ArrayList<DefaultMutableTreeNode>();
		nodes.add(top);
		 for(i = 0 ;i < size; ++i) {
			 if(categoryInfo.get(i).getId().length() > prelength) {
			 node = new DefaultMutableTreeNode(categoryInfo.get(i));
			 node.setUserObject(categoryInfo.get(i));
			 nodes.get(nodes.size()-1).add(node);
			 nodes.add(node);
			 prelength = categoryInfo.get(i).getId().length();
			 } else{
				 node = new DefaultMutableTreeNode(categoryInfo.get(i));
				 int index = nodes.size()-1;
				 while(index!=0 && (categoryInfo.get(index-1).getId().length()>=categoryInfo.get(i).getId().length() )){
					 index--;
				 }
				 node.setUserObject(categoryInfo.get(i));
				 nodes.get(index).add(node);
				 nodes.add(node);
				 prelength = categoryInfo.get(i).getId().length();
			 }
		 
		 }
		 
	}
	
	/**public void visitAllNodes(JTree tree) {
	      TreeNode root = (TreeNode)tree.getModel().getRoot();
	      visitAllNodes(root);
	}
	public void visitAllNodes(TreeNode node) {
	       // node is visited exactly once
	       if (node.getChildCount() >= 0) {
	           for (Enumeration e=node.children(); e.hasMoreElements(); ) {
	               TreeNode n = (TreeNode)e.nextElement();
	               visitAllNodes(n);
	           }
	       }
	}
	*/
	class AddListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			CategoryVo vo = (CategoryVo)node.getUserObject();
			String id = vo.getId();
			if(node.isLeaf()) {
				//添加
			}else {
				System.out.println("wrong! 不是叶节点");
			}
		}
		
	}
	
	class DelListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			CategoryVo vo = (CategoryVo)node.getUserObject();
			String id = vo.getId();
			if(node.isLeaf()) {
				//检查是否有商品
			}else {
				System.out.println("wrong! 不是叶节点");
			}
		}
		
	}
	
	class EditListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	
}
