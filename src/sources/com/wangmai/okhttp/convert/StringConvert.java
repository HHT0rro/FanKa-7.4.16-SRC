package com.wangmai.okhttp.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StringConvert implements Converter<String> {
    @Override // com.wangmai.okhttp.convert.Converter
    public String convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return body.string();
    }
}
