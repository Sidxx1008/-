package Test;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.util.StringUtil;

public class Test extends JFrame {
	private int count=5;//这是自己添加的东西
	private int i=0;//这是自己添加的东西
	private int s=1;//这是自己添加的东西
	private String [] TEXT= new String[10];//这是自己添加的东西
public static JTextArea text;      //输出JTextArea
private static class System       //覆盖System.out.pringln()
{
     private static class out
{

private static void println(String a)
{
     text.append(a);
}
}
}

public static void main(String args[]) {

try {
Test frame = new Test();
frame.setVisible(true);
frame.评论添加("你妈死了");
JOptionPane.showMessageDialog(null, "评论添加成功！");
frame.打印评论();

} catch (Exception e) {
e.printStackTrace();
}
}

public Test() {
super();
setBounds(100, 100, 500, 375);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

text = new JTextArea();
getContentPane().add(text, BorderLayout.CENTER);

//测试按钮
final JButton button = new JButton();
button.addMouseListener(new MouseAdapter() {
public void mouseClicked(final MouseEvent e) {
dispose();
}
});
button.setText("关闭");
getContentPane().add(button, BorderLayout.SOUTH);
}
public void 打印评论() {
	TEXT[0]="这个有点小贵，能不能便宜点？";
	TEXT[1]="这个是99成新，价格其实不算贵了";
	TEXT[2]="不过我可以再降10元，需要你自己过来拿"	;	
	TEXT[3]="好的，明天中午12：15在一饭堂的正门口等你可以么？我的电话是10086。";
	TEXT[4]="好，我的电话是：12345，明天见。"	;
	TEXT[5]="这个商品我一共出售两件，如果还有其他想要的同学可以继续与我约定时间交易。";
while(s!=11) {
	if(StringUtil.isEmpty(TEXT[i])){
		break;
	}
	System.out.println(s+"楼：");
	System.out.println("\n");
	System.out.println(TEXT[i]);
	System.out.println("\n");
	i++;
	s++;
}
}
public void 评论添加(String str) {
	TEXT[0]="这个有点小贵，能不能便宜点？";
	TEXT[1]="这个是99成新，价格其实不算贵了";
	TEXT[2]="不过我可以再降10元，需要你自己过来拿"	;	
	TEXT[3]="好的，明天中午12：15在一饭堂的正门口等你可以么？我的电话是10086。";
	TEXT[4]="好，我的电话是：12345，明天见。"	;
	TEXT[5]="这个商品我一共出售两件，如果还有其他想要的同学可以继续与我约定时间交易。";
	count++;
	TEXT[count]=str;
}
}