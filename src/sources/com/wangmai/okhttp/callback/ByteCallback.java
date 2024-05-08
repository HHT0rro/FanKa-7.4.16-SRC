package com.wangmai.okhttp.callback;

import com.wangmai.okhttp.convert.ByteConvert;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ByteCallback extends AbsCallback<byte[]> {
    public ByteConvert convert = new ByteConvert();

    @Override // com.wangmai.okhttp.convert.Converter
    public byte[] convertResponse(Response response) throws Throwable {
        byte[] convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
