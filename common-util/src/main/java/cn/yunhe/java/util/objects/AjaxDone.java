package cn.yunhe.java.util.objects;

import java.io.Serializable;

/**
 * ajax请求返回结果封装
 * @author Administrator
 *
 */
public class AjaxDone implements Serializable{
	private static final long serialVersionUID = 1L;
	private String statusCode;
	private String message;
	private String forwardUrl;
	private Object model;
  
	public AjaxDone() {
		super();
	}     

	public AjaxDone(String statusCode,String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public AjaxDone(String statusCode, String message, String forwardUrl, Object model) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.forwardUrl = forwardUrl;
		this.model = model;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}
}
