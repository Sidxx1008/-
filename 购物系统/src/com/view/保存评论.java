package com.view;

import com.util.StringUtil;

public class �������� {
private String Text;
private static int count=6;
private int i=0;
private int s=1;
private String [] TEXT= new String[10];

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
public void ��ӡ����() {
while(s!=6) {
	if(StringUtil.isEmpty(TEXT[i])){
		break;
	}
	System.out.println(s+"¥��");
	System.out.println(TEXT[i]);
	i++;
	s++;
}
}
public static void main(String[] args) {
	�������� A=new ��������();
	A.�������("WDNMD");	
	A.��ӡ����();
	count++;
	System.out.println(count);
}
}
