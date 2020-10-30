package cn.yunhe.java.util.objects;

import java.io.Serializable;
import java.util.List;

/**
 * Layui 数据表格返回数据对象
 * 
 * @author Administrator
 *
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private Long count;
	private List<?> data;

	public Result() {
		super();
	}

	public Result(String code, String msg, Long count, List<Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}