package cyd.com.cn;

import java.util.Scanner;

/**
 * 
 * @author chengyd24567
 * 
 */
//判断奇数与偶数
public class Demo1 {
	public static void main(String[] args){
		int x;
		Scanner s=new Scanner(System.in);
		sop("请输入一个数");
		x=s.nextInt();
		int  result=x%2;
		if (result!=0)
			sop(x+"是奇数");
		else
		{
		sop(x+"是偶数");
		}
	}
	public static  void sop(Object o){
		System.out.println(o);
	}
}
