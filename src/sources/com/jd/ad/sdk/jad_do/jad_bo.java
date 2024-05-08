package com.jd.ad.sdk.jad_do;

import android.app.Application;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    public static Application jad_an;

    @Nullable
    public static Application jad_an() {
        Application application = jad_an;
        if (application != null) {
            return application;
        }
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            Logger.w("get application error: ", e2.getMessage());
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e10) {
                Logger.w("get application error: ", e10.getMessage());
                return null;
            }
        }
    }
}
