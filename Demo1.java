package cyd.com.cn;

import java.util.Scanner;

/**
 * 
 * @author chengyd24567
 * 
 */
//�ж�������ż��
public class Demo1 {
	public static void main(String[] args){
		int x;
		Scanner s=new Scanner(System.in);
		sop("������һ����");
		x=s.nextInt();
		int  result=x%2;
		if (result!=0)
			sop(x+"������");
		else
		{
		sop(x+"��ż��");
		}
	}
	public static  void sop(Object o){
		System.out.println(o);
	}
}
