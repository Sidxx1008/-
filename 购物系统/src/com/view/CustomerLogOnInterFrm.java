/*
 * CustomerLogOnInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.dao.CustomerUserDao;
import com.model.Customer;
import com.model.ManagerUser;
import com.util.Dbutil;
import com.util.StringUtil;

public class CustomerLogOnInterFrm extends javax.swing.JInternalFrame {

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_logon;
	private javax.swing.JButton jb_reset;
	private javax.swing.JPasswordField passwordTxt;
	private javax.swing.JTextField userNameTxt;

	Dbutil dbUtil = new Dbutil();
	CustomerUserDao customerUserDao = new CustomerUserDao();

	public CustomerLogOnInterFrm() {
		initComponents();
	}
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		passwordTxt = new javax.swing.JPasswordField();
		jb_logon = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
				formAncestorAdded(evt);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1
				.setText("请输入您的学生账号和密码");

		jLabel2.setIcon(new javax.swing.ImageIcon(
				"./images/userName.png")); 
		jLabel2.setText("学号：");

		jLabel3.setIcon(new javax.swing.ImageIcon(
				"./images/password.png")); 
		jLabel3.setText("密码：");

		jb_logon.setIcon(new javax.swing.ImageIcon(
				"./images/login.png")); 
		jb_logon.setText("支付");
		jb_logon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_logonActionPerformed(evt);
			}
		});

		jb_reset.setIcon(new javax.swing.ImageIcon(
				"./images/reset.png")); 
		jb_reset.setText("重置");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(56, 56, 56)
										.addComponent(jb_logon)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												89, Short.MAX_VALUE)
										.addComponent(jb_reset).addGap(135,
												135, 135))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(38, 38, 38)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(jLabel3))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												59, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																passwordTxt)
														.addComponent(
																userNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																195,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(66, 66, 66)).addGroup(
								layout.createSequentialGroup().addGap(85, 85,
										85).addComponent(jLabel1)
										.addContainerGap(93, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(39, 39, 39)
										.addComponent(jLabel1)
										.addGap(47, 47, 47)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																userNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																passwordTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(29, 29, 29)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jb_reset)
														.addComponent(jb_logon))
										.addGap(36, 36, 36)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jb_logonActionPerformed(java.awt.event.ActionEvent evt) {
		//首先要获取页面上 的信息。
		String customerName = userNameTxt.getText();
		String password1 = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(customerName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password1)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		Customer customer = new Customer(customerName, password1);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Customer currentManagerUser = customerUserDao.login(con, customer);
			if (currentManagerUser != null) {
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "登陆失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}


}