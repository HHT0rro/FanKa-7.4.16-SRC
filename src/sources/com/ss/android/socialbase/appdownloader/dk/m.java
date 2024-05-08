package com.ss.android.socialbase.appdownloader.dk;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: m, reason: collision with root package name */
    public static final String f38843m;

    static {
        StringBuilder sb2 = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z10 = !TextUtils.isEmpty(str);
        boolean z11 = !TextUtils.isEmpty(Build.ID);
        boolean z12 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb2.append("AppDownloader");
        if (z10) {
            sb2.append("/");
            sb2.append(str);
        }
        sb2.append(" (Linux; U; Android");
        if (z10) {
            sb2.append(" ");
            sb2.append(str);
        }
        if (z12 || z11) {
            sb2.append(";");
            if (z12) {
                sb2.append(" ");
                sb2.append(Build.MODEL);
            }
            if (z11) {
                sb2.append(" Build/");
                sb2.append(Build.ID);
            }
        }
        sb2.append(")");
        f38843m = sb2.toString();
    }
}
