package com.huawei.quickcard.image.listener;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BitmapListener implements RequestListener<Bitmap> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34046c = "IImageHostView";

    /* renamed from: a, reason: collision with root package name */
    private final String f34047a;

    /* renamed from: b, reason: collision with root package name */
    private final long f34048b;

    public BitmapListener(String str, long j10) {
        this.f34047a = str;
        this.f34048b = j10;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Bitmap> target, boolean z10) {
        String str = "image:: " + this.f34047a + " ::load failed";
        if (glideException != null) {
            str = str + ", " + glideException.getMessage();
        }
        CardLogUtils.w("IImageHostView", str + ", isFirstResource = " + z10);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z10) {
        CardLogUtils.d("IImageHostView", "image:: " + this.f34047a + " ::load success cost time = " + (System.currentTimeMillis() - this.f34048b));
        return false;
    }
}
