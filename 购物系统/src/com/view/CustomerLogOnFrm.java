/*
 * CustomerLogOnFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.dao.CustomerUserDao;
import com.dao.ProductChosenDao;
import com.model.Customer;
import com.util.Dbutil;
import com.util.StringUtil;

///////////////购物车结账时通过登陆支付///////////////
public class CustomerLogOnFrm extends javax.swing.JFrame {
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_logon;
	private javax.swing.JButton jb_reset;
	private javax.swing.JPasswordField passwordTxt;
	private javax.swing.JTextField userNameTxt;

	Dbutil dbUtil = new Dbutil();
	CustomerUserDao customerUserDao = new CustomerUserDao();
	ProductChosenDao productChosenDao = new ProductChosenDao();

	public CustomerLogOnFrm() {
		initComponents();
		//设置frame居中显示
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		passwordTxt = new javax.swing.JPasswordField();
		jb_logon = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				79,
																				79,
																				79)
																		.addComponent(
																				jLabel1))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				34,
																				34,
																				34)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel2))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								passwordTxt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								195,
																								Short.MAX_VALUE)
																						.addComponent(
																								userNameTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								195,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(103, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(68, 68,
										68).addComponent(jb_logon).addGap(63,
										63, 63).addComponent(jb_reset)
										.addContainerGap(115, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(48, 48, 48)
										.addComponent(jLabel1)
										.addGap(48, 48, 48)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																userNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(39, 39, 39)
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
										.addGap(32, 32, 32)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jb_reset)
														.addComponent(jb_logon))
										.addContainerGap()));

		pack();
	}
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}

	private void jb_logonActionPerformed(java.awt.event.ActionEvent evt) {
		//首先要获取页面上 的信息。
		String customerName = userNameTxt.getText();
		String password1 = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(customerName)) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
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
				//成功登陆后

				try {
					con = dbUtil.getCon();

					ResultSet rs = productChosenDao.customerList(con, customer);
					while (rs.next()) {

						String id = rs.getString("id");
						String money = rs.getString("money");
						Float buyNum = productChosenDao.productSum(con);

						if (Float.parseFloat(money) - buyNum < 0) {
							JOptionPane.showMessageDialog(null, "您的金额不足，支付失败");
							return;
						} else {
							Customer customer2 = new Customer(Integer
									.parseInt(id), Float.parseFloat(money));

							int sumNum = productChosenDao.productBuy(con,
									buyNum, customer2);

							if (sumNum == 1) {
								JOptionPane.showMessageDialog(null, "支付成功");

								
								return;

							} else {
								JOptionPane.showMessageDialog(null, "支付失败");

							}
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "支付失败");
				}

			} else {
				JOptionPane.showMessageDialog(null, "学号或密码输入错误");
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

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CustomerLogOnFrm().setVisible(true);
			}
		});
	}



}