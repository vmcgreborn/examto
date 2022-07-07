package com.app.handler;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.exception.AppException;
import com.app.exception.ExceptionOutput;
import com.app.model.base.GenericResponse;
import com.app.model.exception.BussinesErrorEnumImp;
import com.app.util.ResourceUtil;


@ControllerAdvice
public class MainApiExceptionHandler {

	private static final String RESPONSE_ERROR_PROPERTIES = "responseError.properties";

	@Autowired
	ResourceUtil resourceUtil;
	
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    

    
    
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Object handleExceptionHandler(Throwable exception) {
    	LOGGER.error(exception.getLocalizedMessage(), exception);
    	GenericResponse<Object,ExceptionOutput> response= new GenericResponse<Object,ExceptionOutput>();
    	
    	 response.setOutput(
         		getExceptionOutput(new AppException(exception
         				,BussinesErrorEnumImp.UNEXPECTED_EXCEPTION
         				, null
         				, null
         				, null))
         		);
        return response; 
    }

    @ResponseBody
    @ExceptionHandler({AppException.class})
    public Object handleAppExceptionHandler(AppException exception) {
        GenericResponse<Object,ExceptionOutput> response= new GenericResponse<Object,ExceptionOutput>();
        response.setInput(exception.getInput());
        response.setOutput(
        		getExceptionOutput(exception)
        		);
       
        
        return response;
    }
    

    /**
     * Se puede reutilizar el manejo de excepcion por medio de este metodo
     *
     * @param exception
     * @param url
     * @return
     */
    public ExceptionOutput getExceptionOutput(AppException exception ) {
    	Properties errorProp = resourceUtil.loadProperties(RESPONSE_ERROR_PROPERTIES);
        ExceptionOutput excOut=new ExceptionOutput();
        excOut.setErrors(new ArrayList<String>());
        excOut.getErrors().add(MessageFormat.format(errorProp.getProperty(exception.getErrorEnum().name()), exception.getParams()));
        excOut.setErrorCode(exception.getErrorEnum().getCode());
        return excOut;
    }
}
