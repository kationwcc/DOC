package com.wccwin.doc.Bean;

/**
 * 返回的公共结构
 * @author kation
 *
 * @param 返回的模型
 */
public class RespModel<T> {
	
	private Integer status;//1为正常
	
	private T data;//返回的数据
	
	private String msg;//返回消息
	
	private RespModel(T data){
		this.data = data;
	}
	
	/**
	 * 成功返回
	 * @param data
	 * @return 
	 * @author kation
	 * @data 2017年11月3日 下午2:15:11
	 */
	public static <T> RespModel<T> success(T data){
		RespModel<T> result = new RespModel<T>(data);
		result.setStatus(1);
		result.setMsg("success");
		return result;
	}
	
	/**
	 * 异常返回
	 * @param 异常码(不能为1)
	 * @param data
	 * @param e
	 * @return 
	 * @author kation
	 * @data 2017年11月3日 下午2:15:22
	 */
	public static <T> RespModel<T> error(Integer status, T data, Exception e){
		RespModel<T> result = new RespModel<T>(data);
		result.setStatus(status);
		result.setMsg(e.getMessage());
		return result;
		
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
