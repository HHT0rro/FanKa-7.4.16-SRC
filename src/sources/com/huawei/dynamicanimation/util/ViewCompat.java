package com.huawei.dynamicanimation.util;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewCompat {
    public static float getTranslationZ(View view) {
        if (view != null) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static float getZ(View view) {
        if (view != null) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void setTranslationZ(View view, float f10) {
        if (view != null) {
            view.setTranslationZ(f10);
        }
    }

    public static void setZ(View view, float f10) {
        if (view != null) {
            view.setZ(f10);
        }
    }
}
