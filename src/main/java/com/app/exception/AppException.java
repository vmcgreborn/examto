package com.app.exception;


import com.app.model.exception.BussinesErrorEnum;

/**
 * @author vmcgn
 */
public class AppException extends RuntimeException {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1918283082404410227L;

    private final BussinesErrorEnum errorEnum;
    
    private Object input;

    private Object[] params;




    public AppException(Throwable e, BussinesErrorEnum errorEnum,Object input, Object... params0) {
        super.initCause(e);
        this.errorEnum = errorEnum;
        this.params = params0;
        this.input=input;
    }

    public BussinesErrorEnum getErrorEnum() {
        return errorEnum;
    }

 

    public static void throwExcepcion(BussinesErrorEnum errorEnum,Object input, Object... params) {
        Throwable e = new Throwable("BusinesException");
        throw new AppException(e, errorEnum, input,params);
    }

    public static void throwExcepcion(BussinesErrorEnum errorEnum) {
        throwExcepcion(errorEnum,null);
    }

    public Object[] getParams() {
        return params;
    }

	public Object getInput() {
		return input;
	}

}
