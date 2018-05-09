package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午5:11:16
 * 类描述：菜单信息实体类
 * 版本：v1.0 
 */
public class Menu {
	private int menuId;		//菜单ID
	private int parentId;	//父菜单ID
	private String name;	//菜单名称
	private String description;		//菜单描述
	private String link;		//菜单链接
	private boolean checked;	//菜单是否被选中
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
