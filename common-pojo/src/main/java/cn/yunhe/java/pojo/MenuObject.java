package cn.yunhe.java.pojo;

import java.io.Serializable;

public class MenuObject implements Serializable {

    private Integer menuId ;
    private String  rel;
    private String icon;
    private String menuName;
    private String url;
    private Integer pMenuId;
    private Integer  menuOrder;
    private Integer  subMenuNumbers;

    public MenuObject() {
    }


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getpMenuId() {
        return pMenuId;
    }

    public void setpMenuId(Integer pMenuId) {
        this.pMenuId = pMenuId;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getSubMenuNumbers() {
        return subMenuNumbers;
    }

    public void setSubMenuNumbers(Integer subMenuNumbers) {
        this.subMenuNumbers = subMenuNumbers;
    }
}
