package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.CommentDao;
import com.util.Dbutil;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class giao extends JFrame {

	private JPanel contentPane;
	private JTable CommentTable;
	Dbutil dbutil = new Dbutil();
	CommentDao commentDao=new CommentDao();
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giao frame = new giao();
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
	public giao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		
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
		
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.SOUTH);
		this.fillTable(new Comment());
	}
	private void fillTable(Comment comment) {
		DefaultTableModel dtm = (DefaultTableModel) CommentTable.getModel();

		dtm.setRowCount(0);//要把前面的数据释放掉
		Connection con = null;
		try {
			con=dbutil.getCon();
			ResultSet rs=commentDao.CommentList(con);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("楼数"));
				v.add(rs.getString("评论"));
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
}