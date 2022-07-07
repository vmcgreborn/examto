package com.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * @author victor camacho
 */
@Component
public class ResourceUtil implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8623534882197493817L;

	public  Properties loadProperties(String dir) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = ResourceUtil.class.getClassLoader().getResourceAsStream(dir);
            prop.load(is);
        } catch (IOException | NullPointerException e) {
            System.out.println(e.toString());
        }

        return prop;
    }

}
