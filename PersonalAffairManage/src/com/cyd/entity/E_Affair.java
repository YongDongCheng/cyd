package com.cyd.entity;

public class E_Affair {
private int id;//编号
private String ea_create_name;//创建者名字
private String ea_create_identicard_id;//创建者身份证
private String ea_object;//事务对象
private String ea_place;//地址
private String ea_content;//事务内容
private String ea_info;//备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEa_create_name() {
	return ea_create_name;
}
public void setEa_create_name(String ea_create_name) {
	this.ea_create_name = ea_create_name;
}
public String getEa_create_identicard_id() {
	return ea_create_identicard_id;
}
public void setEa_create_identicard_id(String ea_create_identicard_id) {
	this.ea_create_identicard_id = ea_create_identicard_id;
}
public String getEa_object() {
	return ea_object;
}
public void setEa_object(String ea_object) {
	this.ea_object = ea_object;
}
public String getEa_place() {
	return ea_place;
}
public void setEa_place(String ea_place) {
	this.ea_place = ea_place;
}
public String getEa_content() {
	return ea_content;
}
public void setEa_content(String ea_content) {
	this.ea_content = ea_content;
}
public String getEa_info() {
	return ea_info;
}
public void setEa_info(String ea_info) {
	this.ea_info = ea_info;
}
}
