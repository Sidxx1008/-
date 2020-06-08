/*
 * ProductTypeManageInterFrm.java
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
import com.model.ProductType;
import com.util.Dbutil;
import com.util.StringUtil;

public class ProductTypeManageInterFrm extends javax.swing.JInternalFrame {
	private javax.swing.JTable ProductTypeTable;
	private javax.swing.JTextField idTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_modify;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextArea productTypeDescTxt;
	private javax.swing.JTextField productTypeNameTxt;
	private javax.swing.JTextField s_ProductTypeNameTxt;

	Dbutil dbutil = new Dbutil();
	ProductTypeDao productTypeDao = new ProductTypeDao();
	ProductDao productDao = new ProductDao();

	/** Creates new form ProductTypeManageInterFrm */
	public ProductTypeManageInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new ProductType());
	}

	private void fillTable(ProductType productType) {
		DefaultTableModel dtm = (DefaultTableModel) ProductTypeTable.getModel();

		dtm.setRowCount(0);//要把前面的数据释放掉
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = productTypeDao.productTypeList(con, productType);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("productTypeName"));
				v.add(rs.getString("productTypeDesc"));
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

		jLabel1 = new javax.swing.JLabel();
		s_ProductTypeNameTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		ProductTypeTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		idTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		productTypeNameTxt = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jb_modify = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		productTypeDescTxt = new javax.swing.JTextArea();

		setClosable(true);
		setIconifiable(true);

		jLabel1.setText("商品类别名称");

		jb_search.setText("搜索");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_searchActionPerformed(evt);
			}
		});

		ProductTypeTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "编号", "商品类别名称", "商品类别描述" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		ProductTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				ProductTypeTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(ProductTypeTable);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("表单操作"));

		jLabel2.setText("编号");

		idTxt.setEditable(false);

		jLabel3.setText("商品类别名称");

		jLabel4.setText("描述");

		jb_modify.setIcon(new javax.swing.ImageIcon(
				"./images/modify.gif")); 
		jb_modify.setText("修改");
		jb_modify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_modifyActionPerformed(evt);
			}
		});

		jb_delete.setIcon(new javax.swing.ImageIcon(
				"./images/delete.png")); // NOI18N
		jb_delete.setText("删除");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_deleteActionPerformed(evt);
			}
		});

		productTypeDescTxt.setColumns(20);
		productTypeDescTxt.setRows(5);
		jScrollPane2.setViewportView(productTypeDescTxt);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel2))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												idTxt,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												48,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel3)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												productTypeNameTxt))
																						.addComponent(
																								jScrollPane2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								302,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				61,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				13,
																				13,
																				13)
																		.addComponent(
																				jb_modify)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				185,
																				Short.MAX_VALUE)
																		.addComponent(
																				jb_delete)
																		.addGap(
																				40,
																				40,
																				40)))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(
																idTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																productTypeNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																88,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jb_modify)
														.addComponent(jb_delete))
										.addGap(32, 32, 32)));

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
										.addGap(46, 46, 46)
										.addComponent(jLabel1)
										.addGap(41, 41, 41)
										.addComponent(
												s_ProductTypeNameTxt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												145,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												49, Short.MAX_VALUE)
										.addComponent(jb_search).addGap(45, 45,
												45))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										14, Short.MAX_VALUE).addComponent(
										jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										429,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																s_ProductTypeNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1)
														.addComponent(jb_search))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												172,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												244,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(38, Short.MAX_VALUE)));

		pack();
	}

	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		String id = this.idTxt.getText();
		String productTypeName = this.productTypeNameTxt.getText();
		String productTypeDesc = this.productTypeDescTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据");
			return;
		}
		//将String id转化为int型，配合构造方法。
		ProductType productType = new ProductType(Integer.parseInt(id),
				productTypeName, productTypeDesc);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int modifyNum = productTypeDao.productTypeModify(con, productType);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new ProductType());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
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
				boolean flag = productDao.getProductByProductTypeId(con, id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "当前类别下有商品，不能删除此类别");
					return;
				}

				int deleteNum = productTypeDao.productTypeDelete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new ProductType());
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

	private void resetValue() {
		this.idTxt.setText("");
		this.productTypeNameTxt.setText("");
		this.productTypeDescTxt.setText("");
	}

	private void ProductTypeTableMousePressed(java.awt.event.MouseEvent evt) {
		//获取选中的行
		int row = ProductTypeTable.getSelectedRow();
		this.idTxt.setText((String) ProductTypeTable.getValueAt(row, 0));
		this.productTypeNameTxt.setText((String) ProductTypeTable.getValueAt(
				row, 1));
		this.productTypeDescTxt.setText((String) ProductTypeTable.getValueAt(
				row, 2));
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String s_productTypeName = this.s_ProductTypeNameTxt.getText();
		ProductType productType = new ProductType();
		productType.setProductTypeName(s_productTypeName);
		this.fillTable(productType);
	}



}