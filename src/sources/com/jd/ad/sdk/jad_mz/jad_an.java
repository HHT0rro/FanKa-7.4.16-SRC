package com.jd.ad.sdk.jad_mz;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_sf.jad_an;

/* compiled from: ANRequestBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an {
    public static long jad_an() {
        Object jad_an;
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        Class<Long> cls = Long.TYPE;
        jad_anVar.getClass();
        if (TextUtils.isEmpty("cat")) {
            jad_an = null;
        } else {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("cat");
            jad_an2.append(JADYunSdk.getAppId());
            jad_an = jad_anVar.jad_an(jad_an2.toString(), (Class<Object>) cls);
        }
        long longValue = (jad_an == null || !(jad_an instanceof Long)) ? 0L : ((Long) jad_an).longValue();
        if (com.jd.ad.sdk.jad_pc.jad_an.jad_bo()) {
            return longValue;
        }
        return 0L;
    }
}
