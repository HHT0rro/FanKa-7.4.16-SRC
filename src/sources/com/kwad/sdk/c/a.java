package com.kwad.sdk.c;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.framework.a.a.It.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
