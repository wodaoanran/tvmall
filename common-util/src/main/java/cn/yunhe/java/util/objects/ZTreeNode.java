package cn.yunhe.java.util.objects;

import java.io.Serializable;
import java.util.List;

public class ZTreeNode implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean checked;
	private List<ZTreeNode> children ;
	private String click ;
	private String id ;
	private boolean isParent ;
	private Object model ;
	private String name ;
	private boolean open ;
	private String pId ;
	private String target ;
	private String url ;
	private String rel;
	private String temp;

	public ZTreeNode(){}
	
	public ZTreeNode(String name,String id) {
		super();
		this.id = id;		
		this.name = name;
	}

	public ZTreeNode(boolean checked, List<ZTreeNode> children, String click,
			String id, boolean isParent,String name,
			boolean open, String pId, String target, String url) {
		super();
		this.checked = checked;
		this.children = children;
		this.click = click;
		this.id = id;
		this.isParent = isParent;		
		this.name = name;
		this.open = open;
		this.pId = pId;
		this.target = target;
		this.url = url;
	}

	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<ZTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<ZTreeNode> children) {
		this.children = children;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public boolean isParent() { return isParent; }
	 * 
	 * public void setParent(boolean isParent) { this.isParent = isParent; }
	 */

	
	public boolean getIsParent() { 
		  return isParent; 
	} 
	  
	public void setIsParent(boolean isParent) { 
		  this.isParent = isParent; 
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}
}
