package cn.yunhe.java.pojo;

import java.io.Serializable;

public class MallGoodsClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer gcId;

    private Integer typeId;

    private String gcName;

    private Integer gcParentId;
    
    private String gcParentName;

    private Short gcSort;

    private String gcDescription;

    private String gcPicpath;
    
    private Integer childNum;

    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName == null ? null : gcName.trim();
    }

    public Integer getGcParentId() {
        return gcParentId;
    }

    public void setGcParentId(Integer gcParentId) {
        this.gcParentId = gcParentId;
    }

    public Short getGcSort() {
        return gcSort;
    }

    public void setGcSort(Short gcSort) {
        this.gcSort = gcSort;
    }

    public String getGcDescription() {
        return gcDescription;
    }

    public void setGcDescription(String gcDescription) {
        this.gcDescription = gcDescription == null ? null : gcDescription.trim();
    }

    public String getGcPicpath() {
        return gcPicpath;
    }

    public void setGcPicpath(String gcPicpath) {
        this.gcPicpath = gcPicpath == null ? null : gcPicpath.trim();
    }

	public String getGcParentName() {
		return gcParentName;
	}

	public void setGcParentName(String gcParentName) {
		this.gcParentName = gcParentName;
	}

	public Integer getChildNum() {
		return childNum;
	}

	public void setChildNum(Integer childNum) {
		this.childNum = childNum;
	}
    
    
}