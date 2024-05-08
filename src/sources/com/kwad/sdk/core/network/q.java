package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q {
    private static volatile q aws;
    private final Map<String, String> ava = new ConcurrentHashMap();

    private q() {
    }

    public static q DQ() {
        if (aws == null) {
            synchronized (q.class) {
                if (aws == null) {
                    aws = new q();
                }
            }
        }
        return aws;
    }

    public final void U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ava.put(str, str2);
    }

    public final String dP(String str) {
        return this.ava.get(str);
    }
}
