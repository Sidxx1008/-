/*
 * ProductManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.ProductDao;
import com.dao.ProductTypeDao;
import com.model.Product;
import com.model.ProductType;
import com.util.Dbutil;
import com.util.StringUtil;

public class ProductManageInterFrm extends javax.swing.JInternalFrame {
	private javax.swing.JTextField idTxt;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_search;
	private javax.swing.JComboBox jcb_productType;
	private javax.swing.JTextField priceTxt;
	private javax.swing.JTextArea productDescTxt;
	private javax.swing.JTextField productNameTxt;
	private javax.swing.JTable productTable;
	private javax.swing.JTextField productTimeTxt;
	private javax.swing.JComboBox s_jcbProductType;
	private javax.swing.JTextField s_productNameTxt;
	private javax.swing.JTextField s_productTimeTxt;

	Dbutil dbutil = new Dbutil();
	ProductDao productDao = new ProductDao();
	ProductTypeDao productTypeDao = new ProductTypeDao();

	/** Creates new form ProductManageInterFrm */
	public ProductManageInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Product());
		this.fillProductType("search");
		this.fillProductType("modify");
	}

	private void fillProductType(String type) {
		Connection con = null;
		ProductType productType = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = productTypeDao.productTypeList(con,
					new ProductType());

			if ("search".equals(type)) {

				productType = new ProductType();
				productType.setProductTypeName("请选择....");
				productType.setId(-1);
				this.s_jcbProductType.addItem(productType);
			}
			while (rs.next()) {
				productType = new ProductType();
				productType.setId(rs.getInt("id"));
				productType.setProductTypeName(rs.getString("productTypeName"));

				if ("search".equals(type)) {
					this.s_jcbProductType.addItem(productType);
				} else if ("modify".equals(type)) {
					this.jcb_productType.addItem(productType);
				}
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

	private void fillTable(Product product) {
		DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();

		dtm.setRowCount(0);//要把前面的数据释放掉
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = productDao.productList(con, product);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("productName"));
				v.add(rs.getString("productTime"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("productDesc"));
				v.add(rs.getString("productTypeName"));

				dtm.addRow(v);
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

jScrollPane1 = new javax.swing.JScrollPane();
productTable = new javax.swing.JTable();
jPanel1 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
s_productNameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
s_productTimeTxt = new javax.swing.JTextField();
s_jcbProductType = new javax.swing.JComboBox();
jLabel3 = new javax.swing.JLabel();
jb_search = new javax.swing.JButton();
jPanel2 = new javax.swing.JPanel();
jLabel4 = new javax.swing.JLabel();
idTxt = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
productNameTxt = new javax.swing.JTextField();
jLabel6 = new javax.swing.JLabel();
priceTxt = new javax.swing.JTextField();
jLabel7 = new javax.swing.JLabel();
productTimeTxt = new javax.swing.JTextField();
jLabel8 = new javax.swing.JLabel();
jcb_productType = new javax.swing.JComboBox();
jLabel9 = new javax.swing.JLabel();
jScrollPane2 = new javax.swing.JScrollPane();
productDescTxt = new javax.swing.JTextArea();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setClosable(true);
setIconifiable(true);

productTable.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"编号", "商品名称", "生产日期", "商品价格", "商品描述", "商品类别"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
productTable.addMouseListener(new java.awt.event.MouseAdapter() {
public void mousePressed(java.awt.event.MouseEvent evt) {
productTableMousePressed(evt);
}
});
productTable.addAncestorListener(new javax.swing.event.AncestorListener() {
public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
}
public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
productTableAncestorAdded(evt);
}
public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
}
});
jScrollPane1.setViewportView(productTable);

jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("搜索条件"));
jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
}
public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
jPanel1AncestorAdded(evt);
}
public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
}
});

jLabel1.setText("商品名称");

jLabel2.setText("生产日期");


jLabel3.setText("商品类别");

jb_search.setIcon(new javax.swing.ImageIcon("./images/search.png")); // NOI18N
jb_search.setText("搜索");
jb_search.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_searchActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addGap(31, 31, 31)
.addComponent(jLabel1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(s_productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jLabel2)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(s_productTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jLabel3)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(s_jcbProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jb_search)
.addContainerGap(86, Short.MAX_VALUE))
);
jPanel1Layout.setVerticalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(jLabel2)
.addComponent(s_productTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel3)
.addComponent(jb_search)
.addComponent(s_jcbProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(s_productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addContainerGap(48, Short.MAX_VALUE))
);

jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("表单操作"));

jLabel4.setText("编号");

idTxt.setEditable(false);

jLabel5.setText("商品名称");

jLabel6.setText("价格");

jLabel7.setText("生产日期");

jLabel8.setText("商品类别");


jLabel9.setText("商品描述");

productDescTxt.setColumns(20);
productDescTxt.setRows(5);
jScrollPane2.setViewportView(productDescTxt);

jButton1.setIcon(new javax.swing.ImageIcon("./images/modify.gif")); 
jButton1.setText("修改");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setIcon(new javax.swing.ImageIcon("./images/delete.png")); 
jButton2.setText("删除");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
.addComponent(jLabel6)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(priceTxt))
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
.addComponent(jLabel4)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addGroup(jPanel2Layout.createSequentialGroup()
.addComponent(jLabel5)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(jPanel2Layout.createSequentialGroup()
.addComponent(jLabel7)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jButton2)
.addComponent(productTimeTxt))))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addComponent(jLabel8)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jcb_productType, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addComponent(jButton1))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
);
jPanel2Layout.setVerticalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
.addGroup(jPanel2Layout.createSequentialGroup()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel4)
.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel5)
.addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel9))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel6)
.addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel7)
.addComponent(productTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel8)
.addComponent(jcb_productType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(34, 34, 34)))
.addGap(25, 25, 25))
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton1)
.addComponent(jButton2))
.addContainerGap())))
);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
.addContainerGap())
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addContainerGap())
);

pack();
}// </editor-fold>

	//GEN-END:initComponents
	private void productTableAncestorAdded(javax.swing.event.AncestorEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String productName = this.productNameTxt.getText();
		String productTime = this.productTimeTxt.getText();
		String price = this.priceTxt.getText();
		String productDesc = this.productDescTxt.getText();
		//取值后要判空
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
		ProductType productType = (ProductType) this.jcb_productType
				.getSelectedItem();
		int productTypeId = productType.getId();

		Product product = new Product(Integer.parseInt(id), productName,
				productTime, Float.parseFloat(price), productDesc,
				productTypeId);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int modifyNum = productDao.productModify(con, product);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new Product());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		//获取编号
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的数据");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条数据吗？");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbutil.getCon();
				int deleteNum = productDao.productDelete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Product());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void productTableMousePressed(java.awt.event.MouseEvent evt) {
		//获取选中的行
		int row = this.productTable.getSelectedRow();
		this.idTxt.setText((Integer) productTable.getValueAt(row, 0) + "");
		this.productNameTxt.setText((String) productTable.getValueAt(row, 1));
		this.productTimeTxt.setText((String) productTable.getValueAt(row, 2));
		this.priceTxt.setText((Float) productTable.getValueAt(row, 3) + "");
		this.productDescTxt.setText((String) productTable.getValueAt(row, 4));
		String productTypeName = (String) productTable.getValueAt(row, 5);
		int n = this.jcb_productType.getItemCount();
		for (int i = 0; i < n; i++) {
			ProductType item = (ProductType) this.jcb_productType.getItemAt(i);
			if (item.getProductTypeName().equals(productTypeName)) {
				this.jcb_productType.setSelectedIndex(i);
			}
		}
	}

	private void resetValue() {
		this.idTxt.setText("");
		this.productNameTxt.setText("");
		this.productTimeTxt.setText("");
		this.priceTxt.setText("");
		this.productDescTxt.setText("");
		if (this.jcb_productType.getItemCount() > 0) {
			this.jcb_productType.setSelectedIndex(0);
		}
	}

	private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {

	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String productName = this.s_productNameTxt.getText();
		String productTime = this.s_productTimeTxt.getText();
		ProductType productType = (ProductType) this.s_jcbProductType
				.getSelectedItem();
		int productTypeId = productType.getId();
		Product product = new Product(productName, productTime, productTypeId);
		this.fillTable(product);
		this.resetValue();
	}



}