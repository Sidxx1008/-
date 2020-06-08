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

///////////////���ﳵ����ʱͨ����½֧��///////////////
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
		//����frame������ʾ
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

		jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel1
				.setText("����������ѧ���˺ź�����");

		jLabel2.setIcon(new javax.swing.ImageIcon(
				"./images/userName.png")); 
		jLabel2.setText("ѧ�ţ�");

		jLabel3.setIcon(new javax.swing.ImageIcon(
				"./images/password.png")); 
		jLabel3.setText("���룺");

		jb_logon.setIcon(new javax.swing.ImageIcon(
				"./images/login.png")); 
		jb_logon.setText("֧��");
		jb_logon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_logonActionPerformed(evt);
			}
		});

		jb_reset.setIcon(new javax.swing.ImageIcon(
				"./images/reset.png")); 
		jb_reset.setText("����");
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
		//����Ҫ��ȡҳ���� ����Ϣ��
		String customerName = userNameTxt.getText();
		String password1 = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(customerName)) {
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
			return;
		}
		if (StringUtil.isEmpty(password1)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		Customer customer = new Customer(customerName, password1);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Customer currentManagerUser = customerUserDao.login(con, customer);
			if (currentManagerUser != null) {
				this.dispose();
				//�ɹ���½��

				try {
					con = dbUtil.getCon();

					ResultSet rs = productChosenDao.customerList(con, customer);
					while (rs.next()) {

						String id = rs.getString("id");
						String money = rs.getString("money");
						Float buyNum = productChosenDao.productSum(con);

						if (Float.parseFloat(money) - buyNum < 0) {
							JOptionPane.showMessageDialog(null, "���Ľ��㣬֧��ʧ��");
							return;
						} else {
							Customer customer2 = new Customer(Integer
									.parseInt(id), Float.parseFloat(money));

							int sumNum = productChosenDao.productBuy(con,
									buyNum, customer2);

							if (sumNum == 1) {
								JOptionPane.showMessageDialog(null, "֧���ɹ�");

								
								return;

							} else {
								JOptionPane.showMessageDialog(null, "֧��ʧ��");

							}
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "֧��ʧ��");
				}

			} else {
				JOptionPane.showMessageDialog(null, "ѧ�Ż������������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��½ʧ��");
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