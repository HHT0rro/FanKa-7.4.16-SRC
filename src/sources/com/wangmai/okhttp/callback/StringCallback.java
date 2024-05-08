package com.wangmai.okhttp.callback;

import com.wangmai.okhttp.convert.StringConvert;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class StringCallback extends AbsCallback<String> {
    public StringConvert convert = new StringConvert();

    @Override // com.wangmai.okhttp.convert.Converter
    public String convertResponse(Response response) throws Throwable {
        String convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
