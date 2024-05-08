package com.ss.android.downloadlib.dk;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w {
    public static boolean m(@NonNull com.ss.android.downloadad.api.m.m mVar) {
        return com.ss.android.socialbase.appdownloader.n.np.np() && Build.VERSION.SDK_INT < 29 && c.ve() != null && c.ve().m() && com.ss.android.downloadlib.hc.np.m(mVar).optInt("invoke_app_form_background_switch") == 1 && mVar.t();
    }
}
