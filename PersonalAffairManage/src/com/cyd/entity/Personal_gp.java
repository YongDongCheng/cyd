package com.cyd.entity;

public class Personal_gp {
private int id;//编号
private String pgp_create_name;//创建者名字
private String pgp_create_identicard_id;//创建者身份证
private int getmoney;//进账
private int paymoney;//出账
private String pgp_info;//备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPgp_create_name() {
	return pgp_create_name;
}
public void setPgp_create_name(String pgp_create_name) {
	this.pgp_create_name = pgp_create_name;
}
public String getPgp_create_identicard_id() {
	return pgp_create_identicard_id;
}
public void setPgp_create_identicard_id(String pgp_create_identicard_id) {
	this.pgp_create_identicard_id = pgp_create_identicard_id;
}
public int getGetmoney() {
	return getmoney;
}
public void setGetmoney(int getmoney) {
	this.getmoney = getmoney;
}
public int getPaymoney() {
	return paymoney;
}
public void setPaymoney(int paymoney) {
	this.paymoney = paymoney;
}
public String getPgp_info() {
	return pgp_info;
}
public void setPgp_info(String pgp_info) {
	this.pgp_info = pgp_info;
}

}
