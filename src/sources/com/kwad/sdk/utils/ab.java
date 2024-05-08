package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ab {
    @WorkerThread
    public static String a(Context context, String str, ac.a aVar, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String am = ac.am(context, ac.a(str, aVar));
        String cx = av.cx(context);
        if (!TextUtils.isEmpty(cx)) {
            am = am.replace("__MAC__", cx).replace("__MAC2__", ad.bu(cx)).replace("__MAC3__", ad.bu(cx.replace(com.huawei.openalliance.ad.constant.u.bD, "")));
        }
        String cv = av.cv(context);
        if (!TextUtils.isEmpty(cv)) {
            am = am.replace("__IMEI__", cv).replace("__IMEI2__", ad.bu(cv)).replace("__IMEI3__", ad.gy(cv));
        }
        String oaid = av.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            am = am.replace("__OAID__", oaid).replace("__OAID2__", ad.bu(oaid));
        }
        String cw = av.cw(context);
        if (!TextUtils.isEmpty(cw)) {
            am = am.replace("__ANDROIDID2__", ad.bu(cw)).replace("__ANDROIDID3__", ad.gy(cw)).replace("__ANDROIDID__", cw);
        }
        return ac.c(context, am, z10);
    }
}
