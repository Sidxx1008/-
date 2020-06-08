/*
 * MainFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrm extends javax.swing.JFrame {
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jmiExit;
	private javax.swing.JMenuItem jmiProductAdd;
	private javax.swing.JMenuItem jmiProductModify;
	private javax.swing.JMenuItem jmiProductTypeAdd;
	private javax.swing.JMenuItem jmiProductTypeModify;
	private javax.swing.JDesktopPane table;

	/** Creates new form MainFrm */
	////管理员登陆后的主界面//////
	public MainFrm() {
		initComponents();
		//设置最大 化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jmiProductTypeAdd = new javax.swing.JMenuItem();
		jmiProductTypeModify = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jmiProductAdd = new javax.swing.JMenuItem();
		jmiProductModify = new javax.swing.JMenuItem();
		jmiExit = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("购物系统主界面");

		jMenu1.setIcon(new javax.swing.ImageIcon(
				"./images/base.png")); 
		jMenu1.setText("基本数据维护");

		jMenu3.setIcon(new javax.swing.ImageIcon(
				"./images/manager.gif")); 
		jMenu3.setText("商品种类管理");

		jmiProductTypeAdd.setIcon(new javax.swing.ImageIcon(
				"./images/add.png")); 
		jmiProductTypeAdd.setText("商品类别添加");
		jmiProductTypeAdd
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jmiProductTypeAddActionPerformed(evt);
					}
				});
		jMenu3.add(jmiProductTypeAdd);

		jmiProductTypeModify.setIcon(new javax.swing.ImageIcon(
				"./images/modify.gif")); 
		jmiProductTypeModify.setText("商品类别维护");
		jmiProductTypeModify
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jmiProductTypeModifyActionPerformed(evt);
					}
				});
		jMenu3.add(jmiProductTypeModify);

		jMenu1.add(jMenu3);

		jMenu4
				.setIcon(new javax.swing.ImageIcon(
						"./images/product manager.gif")); 
		jMenu4.setText("商品管理");

		jmiProductAdd.setIcon(new javax.swing.ImageIcon(
				"./images/shopadd.gif")); 
		jmiProductAdd.setText("商品添加");
		jmiProductAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiProductAddActionPerformed(evt);
			}
		});
		jMenu4.add(jmiProductAdd);

		jmiProductModify.setIcon(new javax.swing.ImageIcon(
				"./images/modify.gif")); // NOI18N
		jmiProductModify.setText("商品维护");
		jmiProductModify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiProductModifyActionPerformed(evt);
			}
		});
		jMenu4.add(jmiProductModify);

		jMenu1.add(jMenu4);

		jmiExit.setIcon(new javax.swing.ImageIcon(
				"./images/exit.png")); 
		jmiExit.setText("退出系统");
		jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiExitActionPerformed(evt);
			}
		});
		jMenu1.add(jmiExit);

		jMenuBar1.add(jMenu1);

		jMenu2.setIcon(new javax.swing.ImageIcon(
				"./images/about.png")); 
		jMenu2.setText("关于我们");

		jMenuItem6.setIcon(new javax.swing.ImageIcon(
				"./images/me.png")); 
		jMenuItem6.setText("XX AND YZQ");
		jMenu2.add(jMenuItem6);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));

		pack();
	}

	private void jmiProductModifyActionPerformed(java.awt.event.ActionEvent evt) {
		ProductManageInterFrm ProductManageInterFrm = new ProductManageInterFrm();
		ProductManageInterFrm.setVisible(true);
		this.table.add(ProductManageInterFrm);
	}

	private void jmiProductAddActionPerformed(java.awt.event.ActionEvent evt) {
		ProductAddInterFrm ProductAddInterFrm = new ProductAddInterFrm();
		ProductAddInterFrm.setVisible(true);
		this.table.add(ProductAddInterFrm);
	}

	private void jmiProductTypeModifyActionPerformed(
			java.awt.event.ActionEvent evt) {
		ProductTypeManageInterFrm ProductTypeManageInterFrm = new ProductTypeManageInterFrm();
		ProductTypeManageInterFrm.setVisible(true);
		this.table.add(ProductTypeManageInterFrm);
	}

	private void jmiProductTypeAddActionPerformed(java.awt.event.ActionEvent evt) {
		ProductTypeInterFrm productTypeInterFrm = new ProductTypeInterFrm();
		productTypeInterFrm.setVisible(true);
		this.table.add(productTypeInterFrm);
	}

	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
		if (result == 0) {
			this.dispose();//观看它的传值然后定义变量
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrm().setVisible(true);
			}
		});
	}


}