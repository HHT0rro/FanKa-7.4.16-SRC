package com.google.android.gms.internal.vision;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t1 extends s1 {
    public static int a(int i10, int i11, int i12) {
        if (i11 <= 1073741823) {
            return Math.min(Math.max(i10, i11), View.LAST_APP_AUTOFILL_ID);
        }
        throw new IllegalArgumentException(r0.c("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i11), Integer.valueOf(View.LAST_APP_AUTOFILL_ID)));
    }
}
