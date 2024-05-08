package com.huawei.quickcard.image.listener;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DrawableListener implements RequestListener<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f34049b = "IImageHostView";

    /* renamed from: a, reason: collision with root package name */
    private final String f34050a;

    public DrawableListener(String str) {
        this.f34050a = str;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z10) {
        String str = "image:: " + this.f34050a + " ::load failed";
        if (glideException != null) {
            str = str + ", " + glideException.getMessage();
        }
        CardLogUtils.w("IImageHostView", str + ", isFirstResource = " + z10);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z10) {
        return false;
    }
}
