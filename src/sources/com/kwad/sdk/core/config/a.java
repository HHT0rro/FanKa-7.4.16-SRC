package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static final String[] aqs = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean bW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (dh(host)) {
                return true;
            }
            return di(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean dh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aqs) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> iterator2 = d.BF().iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }
}
