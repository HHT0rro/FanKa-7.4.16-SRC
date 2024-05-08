package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fv {
    private static final byte[] I = new byte[0];
    private static fv V;
    private final Map<String, Class<? extends ac>> B;
    private final Map<String, ac> Z = new HashMap();

    private fv() {
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        hashMap.put(ai.B, fy.class);
    }

    public static fv Code() {
        fv fvVar;
        synchronized (I) {
            if (V == null) {
                V = new fv();
            }
            fvVar = V;
        }
        return fvVar;
    }

    public ac Code(String str) {
        StringBuilder sb2;
        String str2;
        String sb3;
        if (!TextUtils.isEmpty(str)) {
            ac acVar = this.Z.get(str);
            if (acVar == null) {
                gl.Code("JsbPlacementManger", "create command " + str);
                Class<? extends ac> cls = this.B.get(str);
                if (cls == null) {
                    sb2 = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        acVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        gl.I("JsbPlacementManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        gl.I("JsbPlacementManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (acVar == null) {
                        sb2 = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, acVar);
                    }
                }
                sb2.append(str2);
                sb2.append(str);
                sb3 = sb2.toString();
            }
            return acVar;
        }
        sb3 = "get cmd, method is empty";
        gl.I("JsbPlacementManger", sb3);
        return null;
    }
}
