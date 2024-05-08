package com.jd.ad.sdk.jad_do;

import android.app.Activity;
import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp {
    public static boolean jad_an(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
