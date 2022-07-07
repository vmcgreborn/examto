package com.app.model.exception;

/**
 * Enumerador para las excepciones
 *
 * @author vmcgn
 */
public enum BussinesErrorEnumImp implements BussinesErrorEnum {

    UNEXPECTED_EXCEPTION("EG000"),
    DATA_NOT_EXIST("EG001"),
    EXTERNAL_REST_SERVICE_ERROR("ES001"),
   

    ;


    private String code;

    private BussinesErrorEnumImp(String code0) {
        code = code0;
    }


    @Override
    public String getCode() {
        return code;
    }


}
