package com.cyd.entity;

public class Personal_Con {
private int id;//编号
private String pc_create_name;//创建者名字
private String pc_create_identicard_id;//创建者身份证
private String pc_object;//关系对象
private String object_company;//关系对象公司
private String object_mobile ;//关系对象联系方式
private String object_con;//与对象关系
private String object_job;//关系对象工作
private String object_info;//关系对象备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPc_create_name() {
	return pc_create_name;
}
public void setPc_create_name(String pc_create_name) {
	this.pc_create_name = pc_create_name;
}
public String getPc_create_identicard_id() {
	return pc_create_identicard_id;
}
public void setPc_create_identicard_id(String pc_create_identicard_id) {
	this.pc_create_identicard_id = pc_create_identicard_id;
}
public String getPc_object() {
	return pc_object;
}
public void setPc_object(String pc_object) {
	this.pc_object = pc_object;
}
public String getObject_company() {
	return object_company;
}
public void setObject_company(String object_company) {
	this.object_company = object_company;
}
public String getObject_mobile() {
	return object_mobile;
}
public void setObject_mobile(String object_mobile) {
	this.object_mobile = object_mobile;
}
public String getObject_con() {
	return object_con;
}
public void setObject_con(String object_con) {
	this.object_con = object_con;
}
public String getObject_job() {
	return object_job;
}
public void setObject_job(String object_job) {
	this.object_job = object_job;
}
public String getObject_info() {
	return object_info;
}
public void setObject_info(String object_info) {
	this.object_info = object_info;
}
@Override
public String toString() {
	return "Personal_Con [id=" + id + ", pc_create_name=" + pc_create_name + ", pc_create_identicard_id="
			+ pc_create_identicard_id + ", pc_object=" + pc_object + ", object_company=" + object_company
			+ ", object_mobile=" + object_mobile + ", object_con=" + object_con + ", object_job=" + object_job
			+ ", object_info=" + object_info + "]";
}


}
