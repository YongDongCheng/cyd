package com.cyd.entity;

public class User_Schedule {
private int id;//编号
private String us_create_name;//创建者名字
private String us_create_identicard_id;//创建者身份证
private String us_content;//日程内容
private String us_place;//地点
private String us_info;//备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUs_create_name() {
	return us_create_name;
}
public void setUs_create_name(String us_create_name) {
	this.us_create_name = us_create_name;
}
public String getUs_create_identicard_id() {
	return us_create_identicard_id;
}
public void setUs_create_identicard_id(String us_create_identicard_id) {
	this.us_create_identicard_id = us_create_identicard_id;
}
public String getUs_content() {
	return us_content;
}
public void setUs_content(String us_content) {
	this.us_content = us_content;
}
public String getUs_place() {
	return us_place;
}
public void setUs_place(String us_place) {
	this.us_place = us_place;
}
public String getUs_info() {
	return us_info;
}
public void setUs_info(String us_info) {
	this.us_info = us_info;
}
}
