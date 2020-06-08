/*
 * ProductAddInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.dao.ProductDao;
import com.dao.ProductTypeDao;
import com.model.Product;
import com.model.ProductType;
import com.util.Dbutil;
import com.util.StringUtil;


public class ProductAddInterFrm extends javax.swing.JInternalFrame {
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JComboBox jcb_ProductType;
	private javax.swing.JTextField priceTxt;
	private javax.swing.JTextArea productDescTxt;
	private javax.swing.JTextField productNameTxt;
	private javax.swing.JTextField productTimeTxt;

	Dbutil dbutil = new Dbutil();
	ProductTypeDao productTypeDao = new ProductTypeDao();
	ProductDao productDao = new ProductDao();

	/** Creates new form ProductAddInterFrm */
	public ProductAddInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillProductType();
		if (this.jcb_ProductType.getItemCount() > 0) {

			this.jcb_ProductType.setSelectedIndex(0);
		}
	}

	private void fillProductType() {
		Connection con = null;
		ProductType productType = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = productTypeDao.productTypeList(con,
					new ProductType());
			while (rs.next()) {
				productType = new ProductType();
				productType.setId(rs.getInt("id"));
				productType.setProductTypeName(rs.getString("productTypeName"));
				this.jcb_ProductType.addItem(productType);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void initComponents() {

jLabel1 = new javax.swing.JLabel();
productNameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
productTimeTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
priceTxt = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
jcb_ProductType = new javax.swing.JComboBox();
jLabel5 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();
productDescTxt = new javax.swing.JTextArea();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setClosable(true);
setIconifiable(true);
setTitle("商品添加");

jLabel1.setText("商品名称");

jLabel2.setText("生产日期");

jLabel3.setText("价格");

jLabel4.setText("商品类别");


jLabel5.setText("商品描述");

productDescTxt.setColumns(20);
productDescTxt.setRows(5);
jScrollPane1.setViewportView(productDescTxt);

jButton1.setIcon(new javax.swing.ImageIcon("./images/add.png")); 
jButton1.setText("添加");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setIcon(new javax.swing.ImageIcon("./images/reset.png")); 
jButton2.setText("重置");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
.addComponent(jLabel4)
.addGap(27, 27, 27)
.addComponent(jcb_ProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addGap(23, 23, 23)
.addComponent(jButton1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
.addComponent(jButton2)
.addGap(90, 90, 90)))
.addGap(90, 90, 90))
.addGroup(layout.createSequentialGroup()
.addComponent(jLabel5)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(147, Short.MAX_VALUE))
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel1)
.addComponent(jLabel3))
.addGap(27, 27, 27)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(priceTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
.addComponent(productNameTxt, javax.swing.GroupLayout.Alignment.TRAILING))
.addGap(59, 59, 59)
.addComponent(jLabel2)
.addGap(38, 38, 38)
.addComponent(productTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(75, Short.MAX_VALUE))))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addGap(36, 36, 36)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel2)
.addComponent(productTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3)
.addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(17, 17, 17)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel4)
.addComponent(jcb_ProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel5)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
.addComponent(jButton2)
.addGap(43, 43, 43))
.addGroup(layout.createSequentialGroup()
.addGap(18, 18, 18)
.addComponent(jButton1)
.addContainerGap())))
);

pack();
}
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String productName = this.productNameTxt.getText();
		String productTime = this.productTimeTxt.getText();
		String price = this.priceTxt.getText();
		String productDesc = this.productDescTxt.getText();

		if (StringUtil.isEmpty(productName)) {
			JOptionPane.showMessageDialog(null, " 商品名称不能为空!");
			return;
		}
		if (StringUtil.isEmpty(productTime)) {
			JOptionPane.showMessageDialog(null, " 生产日期不能为空!");
			return;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, " 价钱不能为空!");
			return;
		}

		ProductType productType = (ProductType) this.jcb_ProductType
				.getSelectedItem();
		int productTypeId = productType.getId();

		Product product = new Product(productName, productTime, Float
				.parseFloat(price), productDesc, productTypeId);

		Connection con = null;
		try {
			con = dbutil.getCon();
			int addNum = productDao.productAdd(con, product);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "商品添加成功");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "商品添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "商品添加失败");

		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	private void resetValue() {
		this.productNameTxt.setText("");
		this.productTimeTxt.setText("");
		this.priceTxt.setText("");
		if (this.jcb_ProductType.getItemCount() > 0) {

			this.jcb_ProductType.setSelectedIndex(0);
		}
		this.productDescTxt.setText("");
	}



}