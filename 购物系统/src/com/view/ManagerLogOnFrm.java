/*
 * ManagerLogOnFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.dao.ManagerUserDao;
import com.model.ManagerUser;
import com.util.Dbutil;
import com.util.StringUtil;
///////////////管理员登陆界面////////////
public class ManagerLogOnFrm extends javax.swing.JFrame {
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_logon;
	private javax.swing.JButton jb_reset;
	private javax.swing.JPasswordField passwordTxt;
	private javax.swing.JTextField userNameTxt;

	Dbutil dbUtil = new Dbutil();
	ManagerUserDao managerUserDao = new ManagerUserDao();

	/** Creates new form ManagerLogOnFrm */
	public ManagerLogOnFrm() {
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
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		passwordTxt = new javax.swing.JPasswordField();
		jb_logon = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("管理员登陆");

		jLabel2.setIcon(new javax.swing.ImageIcon(
				"./images/userName.png")); 
		jLabel2.setText("学号：");

		jLabel3.setIcon(new javax.swing.ImageIcon(
				"./images/password.png")); 
		jLabel3.setText("密码：");

		userNameTxt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userNameTxtActionPerformed(evt);
			}
		});

		jb_logon.setIcon(new javax.swing.ImageIcon(
				"./images/login.png")); 
		jb_logon.setText("登陆");
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
								layout.createSequentialGroup().addContainerGap(
										148, Short.MAX_VALUE).addComponent(
										jLabel1).addGap(132, 132, 132))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(75, 75, 75)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				25,
																				25,
																				25)
																		.addComponent(
																				jb_logon)
																		.addGap(
																				52,
																				52,
																				52)
																		.addComponent(
																				jb_reset))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3))
																		.addGap(
																				35,
																				35,
																				35)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								passwordTxt)
																						.addComponent(
																								userNameTxt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								161,
																								Short.MAX_VALUE))))
										.addGap(73, 73, 73)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addComponent(jLabel1)
										.addGap(39, 39, 39)
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
										.addGap(33, 33, 33)
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
										.addGap(39, 39, 39)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jb_logon)
														.addComponent(jb_reset))
										.addContainerGap(60, Short.MAX_VALUE)));

		pack();
	}

	private void jb_logonActionPerformed(java.awt.event.ActionEvent evt) {
		//首先要获取页面上 的信息。
		String userName = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		ManagerUser managerUser = new ManagerUser(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ManagerUser currentManagerUser = managerUserDao.login(con,
					managerUser);
			if (currentManagerUser != null) {
				this.dispose();
				new MainFrm().setVisible(true);
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

	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}

	private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ManagerLogOnFrm().setVisible(true);
			}
		});
	}

 

}