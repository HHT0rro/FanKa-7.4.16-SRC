package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface LruPoolStrategy {
    @Nullable
    Bitmap get(int i10, int i11, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i10, int i11, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
