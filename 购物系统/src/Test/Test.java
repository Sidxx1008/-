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
	private int count=5;//�����Լ���ӵĶ���
	private int i=0;//�����Լ���ӵĶ���
	private int s=1;//�����Լ���ӵĶ���
	private String [] TEXT= new String[10];//�����Լ���ӵĶ���
public static JTextArea text;      //���JTextArea
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

public static void main(String args[]) {

try {
Test frame = new Test();
frame.setVisible(true);
frame.�������("��������");
JOptionPane.showMessageDialog(null, "������ӳɹ���");
frame.��ӡ����();

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

//���԰�ť
final JButton button = new JButton();
button.addMouseListener(new MouseAdapter() {
public void mouseClicked(final MouseEvent e) {
dispose();
}
});
button.setText("�ر�");
getContentPane().add(button, BorderLayout.SOUTH);
}
public void ��ӡ����() {
	TEXT[0]="����е�С���ܲ��ܱ��˵㣿";
	TEXT[1]="�����99���£��۸���ʵ�������";
	TEXT[2]="�����ҿ����ٽ�10Ԫ����Ҫ���Լ�������"	;	
	TEXT[3]="�õģ���������12��15��һ���õ����ſڵ������ô���ҵĵ绰��10086��";
	TEXT[4]="�ã��ҵĵ绰�ǣ�12345���������"	;
	TEXT[5]="�����Ʒ��һ�������������������������Ҫ��ͬѧ���Լ�������Լ��ʱ�佻�ס�";
while(s!=11) {
	if(StringUtil.isEmpty(TEXT[i])){
		break;
	}
	System.out.println(s+"¥��");
	System.out.println("\n");
	System.out.println(TEXT[i]);
	System.out.println("\n");
	i++;
	s++;
}
}
public void �������(String str) {
	TEXT[0]="����е�С���ܲ��ܱ��˵㣿";
	TEXT[1]="�����99���£��۸���ʵ�������";
	TEXT[2]="�����ҿ����ٽ�10Ԫ����Ҫ���Լ�������"	;	
	TEXT[3]="�õģ���������12��15��һ���õ����ſڵ������ô���ҵĵ绰��10086��";
	TEXT[4]="�ã��ҵĵ绰�ǣ�12345���������"	;
	TEXT[5]="�����Ʒ��һ�������������������������Ҫ��ͬѧ���Լ�������Լ��ʱ�佻�ס�";
	count++;
	TEXT[count]=str;
}
}