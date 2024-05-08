package com.huawei.quickcard.views.image.view;

import android.graphics.Bitmap;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface BitmapHolder {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnBitmapAvailable {
        void onAvailable(View view, Bitmap bitmap);
    }

    void setOnBitmapAvailable(OnBitmapAvailable onBitmapAvailable, LayoutHolder layoutHolder);
}
