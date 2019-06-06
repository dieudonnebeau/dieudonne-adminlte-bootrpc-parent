package com.dieudonne.adminlte.bootrpc.web.consumer.common;


import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * 
 * @ClassName:  ExceptionAdvice   
 * @Description:全局异常处理器 
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 上午10:13:56   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@ControllerAdvice
public class ExceptionAdvice {
	
	public static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	  /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String handleValidationException(ValidationException e, Model model) {
        logger.error("Validation Exception, "+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Vérification des paramètres échoue, "+e.getMessage());
        return "error/500";
    }
	 /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e, Model model) {
        logger.error("Http Message Not Readable Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","L’analyse des paramètres échoue,"+e.getMessage());
        return "error/500";
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, Model model) {
        logger.error("Http Request Method Not Supported Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Les méthodes de demande actuelles ne sont pas favorables,"+e.getMessage());
        return "error/500";
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public String handleHttpMediaTypeNotSupportedException(Exception e,Model model) {
        logger.error("Http Media Type Not Supported Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Le type de média est insupportable,"+e.getMessage());
        return "error/500";
    }

    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException e, Model model) {
        logger.error("No Handler Found Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Les ressources ne sont pas disponibles,"+e.getMessage());
        return "error/500";
        
    }
    
    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e,Model model) {
        logger.error("Null Pointer Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Null Pointer Exception,"+e.getMessage());
        return "error/500";
    }
    
    /**
     * 500
     * @param e
     * @param model
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e,Model model) {
        logger.error("Server internal Exception,"+e.getMessage());
        e.printStackTrace();
        model.addAttribute("error","Server internal Exception,"+e.getMessage());
        return "error/500";
    }
}
