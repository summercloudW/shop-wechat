package com.wy.shop.result;

public class Result<T> {
	
	private int errno;
	private String errmsg;
	private T data;
	
	/**
	 *  成功时候的调用
	 * */
	public static  <T> Result<T> success(T data){
		return new Result<T>(data);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	
	private Result(T data) {
		this.data = data;
		this.errmsg = "";
	}
	
	private Result(int code, String msg) {
		this.errno = code;
		this.errmsg = msg;
	}
	
	private Result(CodeMsg codeMsg) {
		if(codeMsg != null) {
			this.errno = codeMsg.getCode();
			this.errmsg = codeMsg.getMsg();
		}
	}


	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
