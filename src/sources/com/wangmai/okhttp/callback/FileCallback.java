package com.wangmai.okhttp.callback;

import com.wangmai.okhttp.convert.FileConvert;
import java.io.File;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class FileCallback extends AbsCallback<File> {
    public FileConvert convert;

    public FileCallback() {
        this(null);
    }

    public FileCallback(String str) {
        this(null, str);
    }

    @Override // com.wangmai.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        File convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }

    public FileCallback(String str, String str2) {
        FileConvert fileConvert = new FileConvert(str, str2);
        this.convert = fileConvert;
        fileConvert.setCallback(this);
    }
}
