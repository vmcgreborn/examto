package com.app.util;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.app.model.exception.BussinesErrorEnumImp;

/**
 * Utileria para validaciones
 *
 * @author vcamacho
 */
public class ValidationUtilTest {
	ValidationUtil testClass=new ValidationUtil();
	
    @Test
    public void validateExistData() {
    	testClass.validateExistData("some", BussinesErrorEnumImp.DATA_NOT_EXIST, true,"");

    }

    @Test
    public void validateAndThrows() {
    	testClass.validateAndThrows("some", BussinesErrorEnumImp.DATA_NOT_EXIST,"");
    }



 


    @Test
    public void isNotNull() {
    	testClass.isNotNull("string");
    }

    @Test
    public void isNull() {
    	testClass.isNull(null);
    }

    @Test
    public void isNotNullOrEmptyoverCol() {


        Collection<String> list = new ArrayList<String>();
        list.add("some");
        testClass.isNotNullOrEmpty(list);
    }

    @Test
    public void isNullOrEmptyOverCol() {
    	testClass.isNullOrEmpty((Collection<String>) null);
    }

    @Test
    public void isNotNullOrEmpty() {
    	testClass.isNotNullOrEmpty("hola");
    }

    @Test
    public void isNullOrEmpty() {
    	testClass.isNotNullOrEmpty("");
    }

    @Test
    public void isZero() {
    	testClass.isZero(0l);
    }

    @Test
    public void isNotZero() {
    	testClass.isNotZero(1l);
    }

    @Test
    public void isNotNullAndNotZero() {
    	testClass.isNotNullAndNotZero(1l);
    }

    @Test
    public void isNotNullAndZero() {
    	testClass.isNotNullAndZero(0l);
    }


}