package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.MediaContent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bs implements MediaContent {
    private float Code;
    private Image V;

    public bs() {
        this.V = new t();
    }

    public bs(Image image) {
        this.V = image;
        this.Code = (float) image.getScale();
    }

    public boolean Code(String str) {
        Uri uri;
        Image image = this.V;
        if (image == null || (uri = image.getUri()) == null) {
            return false;
        }
        return TextUtils.equals(str, uri.toString());
    }

    @Override // com.huawei.hms.ads.nativead.MediaContent
    public float getAspectRatio() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.nativead.MediaContent
    public Drawable getImage() {
        Image image = this.V;
        if (image == null) {
            return null;
        }
        return image.getDrawable();
    }

    @Override // com.huawei.hms.ads.nativead.MediaContent
    public void setImage(Drawable drawable) {
        Image image = this.V;
        if (image instanceof t) {
            ((t) image).Code(drawable);
        }
    }
}
