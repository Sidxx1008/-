
package com.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class ViewMainFrm extends javax.swing.JFrame {
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton jb_ManagetLogOn;
	private javax.swing.JButton jb_viewProduct;


	public ViewMainFrm() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}

		initComponents();
		//设置frame居中显示
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jb_viewProduct = new javax.swing.JButton();
		jb_ManagetLogOn = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 30));
		jLabel1.setText("WELCOME!");

		jb_viewProduct.setText("浏览商品");
		jb_viewProduct.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_viewProductActionPerformed(evt);
			}
		});

		jb_ManagetLogOn.setText("管理员登陆");
		jb_ManagetLogOn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_ManagetLogOnActionPerformed(evt);
			}
		});

		jButton3.setText("注册新用户");
		
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_viewProductActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap(111,
						Short.MAX_VALUE).addComponent(jLabel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 301,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()).addGroup(
				layout.createSequentialGroup().addGap(27, 27, 27).addComponent(
						jb_viewProduct).addGap(57, 57, 57).addComponent(
						jb_ManagetLogOn).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51,
						Short.MAX_VALUE).addComponent(jButton3).addGap(22, 22,
						22)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jb_viewProduct)
														.addComponent(
																jb_ManagetLogOn)
														.addComponent(jButton3))
										.addContainerGap(87, Short.MAX_VALUE)));

		pack();
	}

	private void jb_viewProductActionPerformed(java.awt.event.ActionEvent evt) {
		new FuntionMainFrm().setVisible(true);
	}

	private void jb_ManagetLogOnActionPerformed(java.awt.event.ActionEvent evt) {
		new ManagerLogOnFrm().setVisible(true);
	}


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewMainFrm().setVisible(true);
			}
		});
	}

}