package com.huawei.appgallery.agd.core.api;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Image extends JsonBean {

    @NetworkTransmission
    private int height;

    @NetworkTransmission
    private String imgUrl;

    @NetworkTransmission
    private int width;

    public int getHeight() {
        return this.height;
    }

    public Uri getUri() {
        if (TextUtils.isEmpty(this.imgUrl)) {
            return null;
        }
        return Uri.parse(this.imgUrl);
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }
}
