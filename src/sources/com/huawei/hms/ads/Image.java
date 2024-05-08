package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class Image {
    @GlobalApi
    public abstract Drawable getDrawable();

    @GlobalApi
    public int getHeight() {
        return -1;
    }

    @GlobalApi
    public abstract double getScale();

    @GlobalApi
    public abstract Uri getUri();

    @GlobalApi
    public int getWidth() {
        return -1;
    }
}
