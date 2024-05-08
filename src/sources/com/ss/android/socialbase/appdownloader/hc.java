package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.util.i;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hc {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        private String dk;
        private Drawable ej;

        /* renamed from: hc, reason: collision with root package name */
        private boolean f38865hc;

        /* renamed from: l, reason: collision with root package name */
        private String f38866l;

        /* renamed from: m, reason: collision with root package name */
        private String f38867m;

        /* renamed from: n, reason: collision with root package name */
        private int f38868n;
        private String np;

        public m(String str, String str2, Drawable drawable, String str3, String str4, int i10, boolean z10) {
            dk(str2);
            m(drawable);
            m(str);
            ej(str3);
            l(str4);
            m(i10);
            m(z10);
        }

        public boolean dk() {
            return this.f38865hc;
        }

        public String ej() {
            return this.f38867m;
        }

        public String hc() {
            return this.np;
        }

        public String l() {
            return this.dk;
        }

        public Drawable m() {
            return this.ej;
        }

        public int n() {
            return this.f38868n;
        }

        public String np() {
            return this.f38866l;
        }

        public String toString() {
            return "{\n  pkg name: " + ej() + "\n  app icon: " + ((Object) m()) + "\n  app name: " + l() + "\n  app path: " + np() + "\n  app v name: " + hc() + "\n  app v code: " + n() + "\n  is system: " + dk() + i.f4738d;
        }

        public void dk(String str) {
            this.dk = str;
        }

        public void ej(String str) {
            this.f38866l = str;
        }

        public void l(String str) {
            this.np = str;
        }

        public void m(Drawable drawable) {
            this.ej = drawable;
        }

        public void m(boolean z10) {
            this.f38865hc = z10;
        }

        public void m(String str) {
            this.f38867m = str;
        }

        public void m(int i10) {
            this.f38868n = i10;
        }
    }

    public static m dk(String str) {
        try {
            PackageManager packageManager = DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return m(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean ej(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int m(String str) {
        if (ej(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static m m(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String charSequence = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new m(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
