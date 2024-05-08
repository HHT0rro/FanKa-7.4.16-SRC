package com.jd.ad.sdk.jad_sf;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SPUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_dq {
    public static final Map<String, jad_dq> jad_bo = new HashMap();
    public final SharedPreferences jad_an;

    public jad_dq(String str, int i10) {
        this.jad_an = com.jd.ad.sdk.jad_do.jad_bo.jad_an().getSharedPreferences(str, i10);
    }

    public static jad_dq jad_an(String str) {
        boolean z10;
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = true;
                break;
            }
            if (!Character.isWhitespace(str.charAt(i10))) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10) {
            str = "spUtils";
        }
        Map<String, jad_dq> map = jad_bo;
        jad_dq jad_dqVar = (jad_dq) ((HashMap) map).get(str);
        if (jad_dqVar == null) {
            synchronized (jad_dq.class) {
                jad_dqVar = (jad_dq) ((HashMap) map).get(str);
                if (jad_dqVar == null) {
                    jad_dqVar = new jad_dq(str, 0);
                    ((HashMap) map).put(str, jad_dqVar);
                }
            }
        }
        return jad_dqVar;
    }
}
