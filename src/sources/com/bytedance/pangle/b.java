package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    public static void a() {
        com.bytedance.pangle.flipped.c aVar;
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 30 || (i10 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            aVar = new FlippedV2Impl();
        } else {
            if (i10 >= 28 || (i10 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z10 = true;
            }
            if (z10) {
                aVar = new com.bytedance.pangle.flipped.b();
            } else {
                aVar = new com.bytedance.pangle.flipped.a();
            }
        }
        aVar.invokeHiddenApiRestrictions();
    }
}
