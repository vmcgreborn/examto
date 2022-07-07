package com.app.util;

import com.app.util.base.BaseTransformer;

public class DummyTransformer implements BaseTransformer<String, String> {

    @Override
    public String getResponse(String in) {
        return in;
    }

}