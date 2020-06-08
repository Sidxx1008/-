package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.CommentDao;
import com.util.Dbutil;
import com.util.StringUtil;

import Test.Comment;
import Test.Test;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ���� extends JFrame {
	Dbutil dbutil = new Dbutil();
	CommentDao commentDao=new CommentDao();
	private JPanel contentPane;
	private JTextField Message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					���� frame = new ����();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ����() {
		setResizable(false);
		setTitle("\u8BC4\u8BBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u53D1\u8868");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  getmessage(e);
			}
		});
		
		Message = new JTextField();
		Message.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		Message.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(Message, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(90))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(Message, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
		);
		
		CommentTable = new JTable();
		CommentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u697C\u6570", "\u8BC4\u8BBA"
			}
		));
		CommentTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		CommentTable.getColumnModel().getColumn(1).setPreferredWidth(300);
		scrollPane.setViewportView(CommentTable);
		this.fillTable(new Comment());
		contentPane.setLayout(gl_contentPane);
	}
/**
 * ��������ǽ���Ϣ���浽һ�����С�
 * @param evt
 */
	private void fillTable(Comment comment) {
		DefaultTableModel dtm = (DefaultTableModel) CommentTable.getModel();

		dtm.setRowCount(0);//Ҫ��ǰ��������ͷŵ�
		Connection con = null;
		try {
			con=dbutil.getCon();
			ResultSet rs=commentDao.CommentList(con);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("¥��"));
				v.add(rs.getString("����"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
                    dbutil.closeCon(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
	private void getmessage(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String str=this.Message.getText();
		if(StringUtil.isEmpty(str)) {
			JOptionPane.showMessageDialog(null, "��û�������κζ������޷�����");
		}
		else {
			try {
				commentDao.addComment(str);				
				JOptionPane.showMessageDialog(null, "������ӳɹ������ٴδ����ۼ��ɿ����������ۣ�");
				dispose();				
				} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}
	public static JTextArea text;      //���JTextArea
	private JTable CommentTable;
	private static class System       //����System.out.pringln()
	{
	     private static class out
	{

	private static void println(String a)
	{
	     text.append(a);
	}
	}
	}
}
