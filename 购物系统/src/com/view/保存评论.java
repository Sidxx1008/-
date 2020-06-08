package com.view;

import com.util.StringUtil;

public class 保存评论 {
private String Text;
private static int count=6;
private int i=0;
private int s=1;
private String [] TEXT= new String[10];

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
public void 打印评论() {
while(s!=6) {
	if(StringUtil.isEmpty(TEXT[i])){
		break;
	}
	System.out.println(s+"楼：");
	System.out.println(TEXT[i]);
	i++;
	s++;
}
}
public static void main(String[] args) {
	保存评论 A=new 保存评论();
	A.评论添加("WDNMD");	
	A.打印评论();
	count++;
	System.out.println(count);
}
}
