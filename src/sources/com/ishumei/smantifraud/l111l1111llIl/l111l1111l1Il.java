package com.ishumei.smantifraud.l111l1111llIl;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111l1Il {
    private static final String l1111l111111Il = "Smlog.cost";
    private static long l111l11111I1l;
    private static String l111l11111lIl;

    private static void l1111l111111Il() {
        if (TextUtils.isEmpty(l111l11111lIl)) {
            throw new IllegalStateException("no started");
        }
        long currentTimeMillis = System.currentTimeMillis() - l111l11111I1l;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l111l11111lIl);
        sb2.append(" cost：");
        sb2.append(currentTimeMillis);
        sb2.append(", ");
        sb2.append((Object) null);
        l111l11111lIl = null;
    }

    private static void l1111l111111Il(Object obj) {
        if (TextUtils.isEmpty(l111l11111lIl)) {
            throw new IllegalStateException("no started");
        }
        long currentTimeMillis = System.currentTimeMillis() - l111l11111I1l;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l111l11111lIl);
        sb2.append(" cost：");
        sb2.append(currentTimeMillis);
        sb2.append(", ");
        sb2.append((Object) null);
        l111l11111lIl = null;
    }

    private static void l1111l111111Il(String str) {
        if (!TextUtils.isEmpty(l111l11111lIl)) {
            throw new IllegalStateException("no stopped");
        }
        l111l11111lIl = str;
        l111l11111I1l = System.currentTimeMillis();
    }
}
