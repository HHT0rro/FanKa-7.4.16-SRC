package com.jd.ad.sdk.mdt.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface JADFoundationService {
    @Nullable
    Application getApplication();

    boolean isNetAvailable();

    void loadImage(@NonNull Context context, @NonNull String str, @NonNull OnImageLoadListener onImageLoadListener);

    void preloadImage(@NonNull Context context, @NonNull String str, @NonNull OnImageLoadListener onImageLoadListener);
}
