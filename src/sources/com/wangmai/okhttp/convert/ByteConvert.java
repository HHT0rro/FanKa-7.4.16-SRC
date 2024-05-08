package com.wangmai.okhttp.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ByteConvert implements Converter<byte[]> {
    @Override // com.wangmai.okhttp.convert.Converter
    public byte[] convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return body.bytes();
    }
}
