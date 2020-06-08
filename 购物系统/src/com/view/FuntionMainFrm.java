/*
 * FuntionMainFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import javax.swing.JFrame;

public class FuntionMainFrm extends javax.swing.JFrame {

	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jmi_customerAdd;
	private javax.swing.JMenu jmi_registerMember;
	private javax.swing.JMenu jmi_viewProduct;
	javax.swing.JDesktopPane table;

	/** Creates new form FuntionMainFrm */
	public FuntionMainFrm() {
		initComponents();
		//设置最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jmi_viewProduct = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jmi_registerMember = new javax.swing.JMenu();
		jmi_customerAdd = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jmi_viewProduct.setText("浏览商品");
		jmi_viewProduct.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_viewProductActionPerformed(evt);
			}
		});

		jMenuItem1.setText("浏览商品");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jmi_viewProduct.add(jMenuItem1);

		jMenuBar1.add(jmi_viewProduct);

		jmi_registerMember.setText("注册会员");

		jmi_customerAdd.setText("注册会员");
		jmi_customerAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_customerAddActionPerformed(evt);
			}
		});
		jmi_registerMember.add(jmi_customerAdd);

		jMenuBar1.add(jmi_registerMember);

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

	private void jmi_customerAddActionPerformed(java.awt.event.ActionEvent evt) {
		CustomerAddInterFrm CustomerAddInterFrm = new CustomerAddInterFrm();
		CustomerAddInterFrm.setVisible(true);
		this.table.add(CustomerAddInterFrm);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		ProductBuyInterFrm productBuyInterFrm = new ProductBuyInterFrm();
		productBuyInterFrm.setVisible(true);
		this.table.add(productBuyInterFrm);
	}

	private void jmi_viewProductActionPerformed(java.awt.event.ActionEvent evt) {
		ProductBuyInterFrm productBuyInterFrm = new ProductBuyInterFrm();
		productBuyInterFrm.setVisible(true);
		this.table.add(productBuyInterFrm);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FuntionMainFrm().setVisible(true);
			}
		});
	}


}