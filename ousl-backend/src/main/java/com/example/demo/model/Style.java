package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "style" )
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "style_code")
	private String styleCode;
	
	@Column(name = "style_name")
	private String  styleName;
	
	
	@Column(name = "style_quantity")
	private int styleQuantity ;
	
	@Column(name = "style_status")
	private String styleStatus;
	
	@Column(name = "style_Type")
	private String styleType;

	
	@Column(name = "style_category")
	private String styleCategory;
	
	@Column(name = "style_item_code")
	private String styleItemCode;
	
	public Style() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Style(String stylCode, String styleName, int styleQuantity, String styleStatus, String styleType) {
		super();
		this.styleCode = stylCode;
		this.styleName = styleName;
		this.styleQuantity = styleQuantity;
		this.styleStatus = styleStatus;
		this.styleType = styleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyleCode() {
		return styleCode;
	}

	public void setStyleCode(String stylCode) {
		this.styleCode = stylCode;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public int getStyleQuantity() {
		return styleQuantity;
	}

	public void setStyleQuantity(int styleQuantity) {
		this.styleQuantity = styleQuantity;
	}

	public String getStyleStatus() {
		return styleStatus;
	}

	public void setStyleStatus(String styleStatus) {
		this.styleStatus = styleStatus;
	}

	public String getStyleType() {
		return styleType;
	}

	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}


	public String getStyleCategory() {
		return styleCategory;
	}


	public void setStyleCategory(String styleCategory) {
		this.styleCategory = styleCategory;
	}


	public String getStyleItemCode() {
		return styleItemCode;
	}


	public void setStyleItemCode(String styleItemCode) {
		this.styleItemCode = styleItemCode;
	}

	

}
