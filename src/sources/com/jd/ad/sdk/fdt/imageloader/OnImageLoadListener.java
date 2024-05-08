package com.jd.ad.sdk.fdt.imageloader;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface OnImageLoadListener {
    void onLoadFailed(int i10, String str, @Nullable Drawable drawable);

    void onLoadSuccess(@NonNull Drawable drawable);
}
