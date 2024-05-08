package com.huawei.quickcard.views.image.view;

import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class c {
    public static void a(IImageHost iImageHost) {
        CardLogUtils.d(IImageHost.TAG, "on render command end");
        iImageHost.loadImage();
    }

    public static void b(IImageHost iImageHost) {
        CardLogUtils.d(IImageHost.TAG, "on render command start");
    }
}
