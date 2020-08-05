/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.young.common.exception;

import com.young.common.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public ResponseResult handleRRException(RRException e){
		ResponseResult responseResult = new ResponseResult();
		responseResult.put("code", e.getCode());
		responseResult.put("msg", e.getMessage());

		return responseResult;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handlerNoFoundException(Exception e) {
		logger.error(e.getMessage(), e);
		return ResponseResult.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseResult handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return ResponseResult.error("数据库中已存在该记录");
	}

//	@ExceptionHandler(AuthorizationException.class)
//	public ResponseResult handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return ResponseResult.error("没有权限，请联系管理员授权");
//	}

	@ExceptionHandler(Exception.class)
	public ResponseResult handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResponseResult.error();
	}
}
