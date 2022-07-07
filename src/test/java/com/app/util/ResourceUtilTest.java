package com.app.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author victor camacho
 */
public class ResourceUtilTest {
    @Test
    public void loadProperties() {
    	ResourceUtil resourceUtil=new ResourceUtil();
        assertNotNull(resourceUtil.loadProperties("dum.properties"));


        assertTrue(resourceUtil.loadProperties("unexisted.properties").isEmpty());

    }

}
