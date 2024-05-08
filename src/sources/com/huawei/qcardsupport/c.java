package com.huawei.qcardsupport;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huawei.flexiblelayout.log.Log;

/* compiled from: GlideLoadListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements RequestListener<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33098a = "GlideLoadListener";

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z10) {
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z10) {
        Log.w(f33098a, "Failed to load image, url: " + (obj instanceof String ? (String) obj : "") + ".", glideException);
        return false;
    }
}
