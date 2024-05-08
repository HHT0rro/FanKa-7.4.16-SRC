package com.alimm.tanx.core.image.util;

import android.widget.ImageView;
import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifConfig extends BaseBean {
    public int gifRes;
    public String gifUrl;
    public ImageView gifView;

    public GifConfig(ImageView imageView, int i10) {
        this.gifView = imageView;
        this.gifRes = i10;
    }

    public int getGifRes() {
        return this.gifRes;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public ImageView getGifView() {
        return this.gifView;
    }

    public void setGifRes(int i10) {
        this.gifRes = i10;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public void setGifView(ImageView imageView) {
        this.gifView = imageView;
    }

    public GifConfig(ImageView imageView, String str) {
        this.gifRes = -1;
        this.gifView = imageView;
        this.gifUrl = str;
    }
}
