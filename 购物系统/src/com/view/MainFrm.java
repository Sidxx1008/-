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
	////����Ա��½���������//////
	public MainFrm() {
		initComponents();
		//������� ��
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
		setTitle("����ϵͳ������");

		jMenu1.setIcon(new javax.swing.ImageIcon(
				"./images/base.png")); 
		jMenu1.setText("��������ά��");

		jMenu3.setIcon(new javax.swing.ImageIcon(
				"./images/manager.gif")); 
		jMenu3.setText("��Ʒ�������");

		jmiProductTypeAdd.setIcon(new javax.swing.ImageIcon(
				"./images/add.png")); 
		jmiProductTypeAdd.setText("��Ʒ������");
		jmiProductTypeAdd
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jmiProductTypeAddActionPerformed(evt);
					}
				});
		jMenu3.add(jmiProductTypeAdd);

		jmiProductTypeModify.setIcon(new javax.swing.ImageIcon(
				"./images/modify.gif")); 
		jmiProductTypeModify.setText("��Ʒ���ά��");
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
		jMenu4.setText("��Ʒ����");

		jmiProductAdd.setIcon(new javax.swing.ImageIcon(
				"./images/shopadd.gif")); 
		jmiProductAdd.setText("��Ʒ���");
		jmiProductAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiProductAddActionPerformed(evt);
			}
		});
		jMenu4.add(jmiProductAdd);

		jmiProductModify.setIcon(new javax.swing.ImageIcon(
				"./images/modify.gif")); // NOI18N
		jmiProductModify.setText("��Ʒά��");
		jmiProductModify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiProductModifyActionPerformed(evt);
			}
		});
		jMenu4.add(jmiProductModify);

		jMenu1.add(jMenu4);

		jmiExit.setIcon(new javax.swing.ImageIcon(
				"./images/exit.png")); 
		jmiExit.setText("�˳�ϵͳ");
		jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiExitActionPerformed(evt);
			}
		});
		jMenu1.add(jmiExit);

		jMenuBar1.add(jMenu1);

		jMenu2.setIcon(new javax.swing.ImageIcon(
				"./images/about.png")); 
		jMenu2.setText("��������");

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
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ��˳�ϵͳ");
		if (result == 0) {
			this.dispose();//�ۿ����Ĵ�ֵȻ�������
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