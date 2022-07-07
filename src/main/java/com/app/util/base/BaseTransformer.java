package com.app.util.base;


/**
 * @param <I> Bean entrada
 * @param <O> Bean Salida
 * @author vcamacho
 */
public interface BaseTransformer<I, O> {
    /**
     * Transform a imput Bean type  I to output Bean type O
     *
     * @param in Bean de Entrada
     * @return
     */
    public O getResponse(I in);

}
