package com.wccwin.api.bean.resp;

import com.alibaba.fastjson.JSON;
import com.wccwin.api.pub.BusinessException;
import com.wccwin.api.pub.ErrorMsgConfig;

public class RespModel<T> {
	
	private Integer status;//1为正常
	
	private T data;//返回的数据
	
	private String msg;//返回消息
	
	private RespModel(T data){
		this.data = data;
	}

	public RespModel() {
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
	 * @param status
	 * @param data
	 * @param e
	 * @return 
	 * @author kation
	 * @data 2017年11月3日 下午2:15:22
	 */
	public static <T> RespModel<T> error(Integer status, T data, Exception e){
		RespModel<T> result = new RespModel<>(data);
		if(e instanceof BusinessException){//业务异常
			int code = ((BusinessException) e).getStatus();
			result.setStatus(0- code);
			result.setMsg(ErrorMsgConfig.getErrorMsg(code));
		}else{//其他异常
			result.setStatus(status);
			result.setMsg(e.getMessage());

		}
		return result;
		
	}

	/**
	 * 异常返回
	 * @param data
	 * @param e
	 * @return
	 * @author kation
	 * @data 2017年11月3日 下午2:15:22
	 */
	public static <T> RespModel<T> error(T data, BusinessException e){
		RespModel<T> result = new RespModel<>(data);
		int code = e.getStatus();
		result.setStatus(0- code);
		result.setMsg(ErrorMsgConfig.getErrorMsg(code));
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

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
