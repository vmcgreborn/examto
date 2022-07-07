package com.app.model.base;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author vmcgr
 *
 *	Generic and standard  way to form a request.
 *
 * @param <T> Generic type that contains the particular request data
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<I,O> implements Serializable {

    /**
     *
     */
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = 5083442142904199681L;
    /**
     * Contains the specific response data object.
     */
    private I input;
    
    private O output;


}
