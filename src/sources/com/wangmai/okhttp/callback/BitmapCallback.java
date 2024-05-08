package com.wangmai.okhttp.callback;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.wangmai.okhttp.convert.BitmapConvert;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BitmapCallback extends AbsCallback<Bitmap> {
    public BitmapConvert convert;

    public BitmapCallback() {
        this.convert = new BitmapConvert();
    }

    @Override // com.wangmai.okhttp.convert.Converter
    public Bitmap convertResponse(Response response) throws Throwable {
        Bitmap convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }

    public BitmapCallback(int i10, int i11) {
        this.convert = new BitmapConvert(i10, i11);
    }

    public BitmapCallback(int i10, int i11, Bitmap.Config config, ImageView.ScaleType scaleType) {
        this.convert = new BitmapConvert(i10, i11, config, scaleType);
    }
}
