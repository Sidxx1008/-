
package com.view;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.dao.CustomerUserDao;
import com.dao.ProductChosenDao;
import com.model.Customer;
import com.util.Dbutil;
import com.util.StringUtil;

/////////////////////////添加用户子窗口，实现用户添加/////////////////////
public class CustomerAddInterFrm extends javax.swing.JInternalFrame {
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JButton jb_Add;
	private javax.swing.JTextField moneyTxt;
	private javax.swing.JPasswordField password1Txt;
	private javax.swing.JPasswordField password2Txt;
	private javax.swing.JTextField userNameTxt;

	Dbutil dbutil = new Dbutil();
	CustomerUserDao customerUserDao=new CustomerUserDao();
	ProductChosenDao productChosenDao = new ProductChosenDao();
	
	/** Creates new form CustomerAddInterFrm */
	public CustomerAddInterFrm() {
		initComponents();
		this.setLocation(200, 100);
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();//用户
		userNameTxt = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();//密码
		password1Txt = new javax.swing.JPasswordField();
		jLabel3 = new javax.swing.JLabel();//密码
		password2Txt = new javax.swing.JPasswordField();
		jLabel4 = new javax.swing.JLabel();//存入金额
		moneyTxt = new javax.swing.JTextField();
		jb_Add = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();

		jLabel1.setText("学号：");

		jLabel2.setText("密码：");

		jLabel3.setText("确认密码:");

		jLabel4.setText("存入金额:");

		jb_Add.setText("注册");
		jb_Add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_AddActionPerformed(evt);
			}
		});
		setClosable(true);
		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel5.setText("注册新用户");
		
		////////////////////////////////////////////////

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
										.createSequentialGroup()
										.addGap(56, 56, 56)
										.addGroup(layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(jLabel4))
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabel5)
														.addComponent(
																password1Txt)
														.addComponent(
																userNameTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																167,
																Short.MAX_VALUE)
														.addComponent(
																password2Txt)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				jb_Add)
																		.addComponent(
																				moneyTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				84,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(88, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(14, 14, 14)
										.addComponent(
												jLabel5,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												38, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																userNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(27, 27, 27)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																password1Txt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(28, 28, 28)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3)
														.addComponent(
																password2Txt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(27, 27, 27)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																moneyTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(jb_Add).addContainerGap()));

		pack();
	}
////////////////////////////////注册新用户////////////////////////////////
	private void jb_AddActionPerformed(java.awt.event.ActionEvent evt) {
		String  customerName=this.userNameTxt.getText();//用户名
		String password1=new String(this.password1Txt.getPassword());//设置密码
		String password2=new String(this.password2Txt.getPassword());//确认密码
		
		String money=this.moneyTxt.getText();//设置存入金额
		
		
		/////////////////出错提醒////////////////////////
		if (StringUtil.isEmpty( customerName)) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
			return;
		}
		if (StringUtil.isEmpty(password1)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(!password2.equals(password1)){
			JOptionPane.showMessageDialog(null, "两次密码要相同");
			return;
		}
		if (Float.parseFloat(money)<=0) {
			JOptionPane.showMessageDialog(null, " 存入金钱数需为正!");
			return;
		}
		Customer customer=new Customer( customerName,  password1,
				 password2, Float.parseFloat(money) );
		Connection con=null;
		try {
			con=dbutil.getCon();
			
			////////搜索是否存在相同的用户名，若失败则提醒////////////////
			ResultSet rs = productChosenDao.customerList(con, customer);
			while(rs.next()){
				String customerName1=rs.getString("customerName");
				if(customerName.equals(customerName1)){
					

					JOptionPane.showMessageDialog(null, "用户已存在！");
										return;
									}}
										con = dbutil.getCon();			
										

										int 	addNum=customerUserDao.customerAdd(con, customer);
										if(addNum==1){
											

					JOptionPane.showMessageDialog(null, "注册成功");
											this.dispose();
										}else{
											

					JOptionPane.showMessageDialog(null, "注册失败");
										}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败");
		}finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	

}