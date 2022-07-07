package com.app.util;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.exception.AppException;
import com.app.model.exception.BussinesErrorEnum;
import com.app.model.exception.BussinesErrorEnumImp;


/**
 * Utileria para validaciones
 *
 * @author vcamacho
 */
@Component
public class ValidationUtil {
    /**
     * Hiden Utility constructor
     */
    protected ValidationUtil() {
        // Hiden Utility constructor
    }
    

    

    /**
     * Valida si existe resultados
     */
    public  void validateExistData(Object data, BussinesErrorEnum customenum, boolean validate,Object input) {

        if (validate) {
            if (this.isNull(customenum)) {
                customenum = BussinesErrorEnumImp.DATA_NOT_EXIST;
            }
            validateAndThrows(data, customenum,input);
        }
    }

    
    
    /**
     * Valida si existe resultados
     */
    public  <T> T validateExistData(Optional<T> data, BussinesErrorEnum customenum,Object input) {

  
            if (this.isNull(customenum)) {
                customenum = BussinesErrorEnumImp.DATA_NOT_EXIST;
            }
            if(data.isPresent()) {
            	return data.get();
            }else {
            	AppException.throwExcepcion(customenum,input);
            }
        
        return null;
    }

    /**
     * validate a object or collection or empty string if is null throws  Bussiness exception
     *
     * @param data
     * @param error
     */
    public  void validateAndThrows(Object data, BussinesErrorEnum error,Object input,Object...params) {
        if (this.isNull(data)
                || (data instanceof List<?> && (this.isNullOrEmpty((List<?>) data))) ||
                (data instanceof String && this.isNullOrEmpty((String) data))) {
            AppException.throwExcepcion(error,params,input);
        }
    }












    /**
     * regresa true si el objeto no es nulo
     *
     * @param object
     * @return
     */
    public  boolean isNotNull(Object object) {
        return !this.isNull(object);
    }

    /**
     * regresa true si el objeto es nulo
     *
     * @param object
     * @return
     */
    public  boolean isNull(Object object) {
        return object == null;
    }

    /**
     * regresa true si la coleccion no es nula ni vacia
     *
     * @param col
     * @return
     */
    public  boolean isNotNullOrEmpty(Collection<?> col) {
        return isNotNull(col) && !col.isEmpty();
    }

    public  boolean isNullOrEmpty(Collection<?> col) {
        return !isNotNullOrEmpty(col);
    }

    /**
     * regresa true si la coleccion no es nula ni vacia
     *
     * @return
     */
    public  boolean isNotNullOrEmpty(String cadena) {
        return isNotNull(cadena) && !cadena.isEmpty();
    }

    /**
     * regresa true si la coleccion no es nula ni vacia
     *
     * @return
     */
    public  boolean isNullOrEmpty(String cadena) {
        return !isNotNullOrEmpty(cadena);
    }


    /**
     * true si es 0
     *
     * @param number
     * @return
     */
    public  boolean isZero(Long number) {
        return number == 0;
    }

    /**
     * true si no es 0
     *
     * @param number
     * @return
     */
    public  boolean isNotZero(Long number) {
        return !isZero(number);
    }

    /**
     * true si no es null y no es 0
     *
     * @param number
     * @return
     */
    public  boolean isNotNullAndNotZero(Long number) {
        return isNotNull(number) && isNotZero(number);
    }

    /**
     * true si no es null y es 0
     *
     * @param number
     * @return
     */
    public  boolean isNotNullAndZero(Long number) {
        return isNotNull(number) && isZero(number);
    }

    
}