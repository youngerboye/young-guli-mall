/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.young.gulimall.gulimallcommon.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ResponseResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public ResponseResult() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static ResponseResult error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static ResponseResult error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static ResponseResult error(int code, String msg) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.put("code", code);
		responseResult.put("msg", msg);
		return responseResult;
	}

	public static ResponseResult ok(String msg) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.put("msg", msg);
		return responseResult;
	}
	
	public static ResponseResult ok(Map<String, Object> map) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.putAll(map);
		return responseResult;
	}
	
	public static ResponseResult ok() {
		return new ResponseResult();
	}

	public ResponseResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
