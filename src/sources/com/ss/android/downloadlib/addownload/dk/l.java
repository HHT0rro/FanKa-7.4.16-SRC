package com.ss.android.downloadlib.addownload.dk;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.ss.android.downloadlib.addownload.c;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private static final String[] ej = {"com", "android", "ss"};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f38572l = {GlobalErrorCode.ERROR_SERVER_CODE_3101, GlobalErrorCode.ERROR_SERVER_CODE_3102, GlobalErrorCode.ERROR_SERVER_CODE_3103, 3201, 3202, GlobalErrorCode.ERROR_SERVER_CODE_3203};

    /* renamed from: m, reason: collision with root package name */
    private static volatile l f38573m;
    private final LinkedList<m> dk = new LinkedList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        public final int dk;
        public final String ej;

        /* renamed from: l, reason: collision with root package name */
        public final String f38574l;

        /* renamed from: m, reason: collision with root package name */
        public final String f38575m;
        public final long np;

        private m(String str, int i10, String str2, String str3, long j10) {
            this.f38575m = str;
            this.dk = i10;
            this.ej = str2 != null ? str2.toLowerCase() : null;
            this.f38574l = str3 != null ? str3.toLowerCase() : null;
            this.np = j10;
        }
    }

    private l() {
    }

    private m ej(String str) {
        try {
            PackageManager packageManager = c.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new m(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static l m() {
        if (f38573m == null) {
            synchronized (l.class) {
                if (f38573m == null) {
                    f38573m = new l();
                }
            }
        }
        return f38573m;
    }

    public void dk(String str) {
        dk();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.dk) {
            Iterator<m> it = this.dk.iterator2();
            while (it.hasNext()) {
                if (str.equals(it.next().f38575m)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void m(String str) {
        m ej2;
        dk();
        if (TextUtils.isEmpty(str) || (ej2 = ej(str)) == null) {
            return;
        }
        synchronized (this.dk) {
            this.dk.add(ej2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.dk.l.m, java.lang.Integer> dk(com.ss.android.downloadad.api.m.dk r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.dk.l.dk(com.ss.android.downloadad.api.m.dk):android.util.Pair");
    }

    public m m(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return null;
        }
        dk();
        synchronized (this.dk) {
            Iterator<m> it = this.dk.iterator2();
            while (it.hasNext()) {
                m next = it.next();
                if (next.np > dkVar.ee()) {
                    return next;
                }
            }
            return null;
        }
    }

    private static boolean m(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z10;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i10 = 0;
            int i11 = 0;
            for (String str3 : split) {
                String[] strArr = ej;
                int length = strArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        z10 = false;
                        break;
                    }
                    String str4 = strArr[i12];
                    if (str4.equals(str3)) {
                        if (i10 < split2.length && str4.equals(split2[i10])) {
                            i10++;
                        }
                        z10 = true;
                    } else {
                        i12++;
                    }
                }
                if (!z10) {
                    int i13 = i11;
                    int i14 = i10;
                    while (i10 < split2.length) {
                        if (str3.equals(split2[i10])) {
                            if (i10 == i14) {
                                i14++;
                            }
                            i13++;
                            if (i13 >= 2) {
                                return true;
                            }
                        }
                        i10++;
                    }
                    i10 = i14;
                    i11 = i13;
                }
            }
            return false;
        }
        return false;
    }

    private void dk() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.dk) {
            Iterator<m> it = this.dk.iterator2();
            while (it.hasNext() && currentTimeMillis - it.next().np > 1800000) {
                it.remove();
            }
        }
    }
}
