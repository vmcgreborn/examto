package com.app.handler;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.app.exception.AppException;
import com.app.util.ResourceUtil;
import com.app.vo.FriendVO;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;


public class MainApiExceptionHandlerTest {

    @Tested
    private MainApiExceptionHandler test;

    @Injectable
    private Logger LOGGER;
    @Injectable
    private ResourceUtil resourceUtil;

    @Test
    public void handleExceptionHandler() {
    	new Expectations() {

    		{
    			
    			resourceUtil.loadProperties(anyString);
    			result= getProperties();
    		}
    	};
    	test.handleExceptionHandler(new Exception());
    }

    @Test
    public void handleAppExceptionHandler() {
    	new Expectations() {

    		{
    			
    			resourceUtil.loadProperties(anyString);
    			result= getProperties();
    		}
    	};
       try {
    	   AppException.throwExcepcion(null, new FriendVO(), "some");
       }catch(AppException e) {
    	   test.handleExceptionHandler(e);
       }
    }
    
    private Properties getProperties() {
    	ResourceUtil resourceUtil=new ResourceUtil();
    	return resourceUtil.loadProperties("dum.properties");
    }

}
