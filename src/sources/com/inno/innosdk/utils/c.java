package com.inno.innosdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: AppsInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f35580a;

    /* renamed from: b, reason: collision with root package name */
    public String f35581b;

    /* renamed from: c, reason: collision with root package name */
    public String f35582c;

    /* renamed from: d, reason: collision with root package name */
    public String f35583d;

    /* renamed from: e, reason: collision with root package name */
    public String f35584e;

    /* renamed from: f, reason: collision with root package name */
    public String f35585f;

    /* renamed from: g, reason: collision with root package name */
    public String f35586g;

    /* renamed from: h, reason: collision with root package name */
    public StringBuilder f35587h;

    /* renamed from: i, reason: collision with root package name */
    public String f35588i = "";

    /* renamed from: j, reason: collision with root package name */
    public List<PackageInfo> f35589j;

    public c(Context context) {
        if (com.inno.innosdk.a.c.p().isAppList()) {
            try {
                context.getPackageManager();
                if (this.f35589j == null && com.inno.innosdk.a.c.l() != null) {
                    this.f35589j = com.inno.innosdk.a.c.l().getPackageInfoList();
                }
                List<PackageInfo> list = this.f35589j;
                if (list != null && list.size() != 0) {
                    b(context);
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    public static c a(Context context) {
        if (f35580a == null) {
            synchronized (c.class) {
                if (f35580a == null) {
                    f35580a = new c(context);
                }
            }
        }
        return f35580a;
    }

    public void b(Context context) {
        String[] strArr;
        StringBuilder sb2;
        int i10;
        boolean z10;
        if (com.inno.innosdk.a.c.p().isAppList()) {
            ArrayList arrayList = new ArrayList(160);
            this.f35587h = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            String[] strArr2 = null;
            this.f35582c = null;
            this.f35583d = null;
            this.f35584e = null;
            this.f35585f = null;
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = 0;
            try {
                strArr2 = com.inno.innosdk.b.a.o().split(",");
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
            int i11 = 0;
            boolean z11 = false;
            int i12 = 0;
            int i13 = 0;
            while (i11 < this.f35589j.size()) {
                PackageInfo packageInfo = this.f35589j.get(i11);
                if (strArr2 == null || strArr2.length <= 0) {
                    strArr = strArr2;
                } else {
                    int length = strArr2.length;
                    int i14 = 0;
                    while (i14 < length) {
                        int i15 = length;
                        String str = strArr2[i14];
                        String[] strArr3 = strArr2;
                        if (packageInfo.packageName.equals(str)) {
                            StringBuilder sb4 = this.f35587h;
                            if (sb4 != null) {
                                if (sb4.length() > 0) {
                                    StringBuilder sb5 = this.f35587h;
                                    sb5.append(",");
                                    sb5.append(str);
                                } else {
                                    this.f35587h.append(str);
                                }
                            }
                            z11 = true;
                        }
                        i14++;
                        length = i15;
                        strArr2 = strArr3;
                    }
                    strArr = strArr2;
                    sb3.append(packageInfo.packageName);
                    if (i11 != this.f35589j.size() - 1) {
                        sb3.append(",");
                    }
                }
                if (TextUtils.isEmpty(packageInfo.packageName)) {
                    sb2 = sb3;
                    i10 = i11;
                    z10 = z11;
                } else if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    if (!context.getPackageName().equals(packageInfo.packageName)) {
                        sb2 = sb3;
                        long j11 = packageInfo.firstInstallTime;
                        i10 = i11;
                        z10 = z11;
                        long j12 = packageInfo.lastUpdateTime;
                        if (j11 != j12 && j10 < j12) {
                            this.f35584e = packageInfo.packageName + "," + packageInfo.firstInstallTime + "," + packageInfo.lastUpdateTime;
                            j10 = j12;
                        }
                        long j13 = packageInfo.firstInstallTime;
                        long j14 = packageInfo.lastUpdateTime;
                        if (j13 != j14 && currentTimeMillis > j14) {
                            this.f35585f = packageInfo.packageName + "," + packageInfo.firstInstallTime + "," + packageInfo.lastUpdateTime;
                            currentTimeMillis = j14;
                        }
                    } else {
                        sb2 = sb3;
                        i10 = i11;
                        z10 = z11;
                        this.f35582c = String.valueOf(packageInfo.firstInstallTime);
                        this.f35583d = String.valueOf(packageInfo.lastUpdateTime);
                    }
                    arrayList.add(packageInfo.packageName);
                    i12++;
                } else {
                    sb2 = sb3;
                    i10 = i11;
                    z10 = z11;
                    i13++;
                }
                i11 = i10 + 1;
                sb3 = sb2;
                z11 = z10;
                strArr2 = strArr;
            }
            StringBuilder sb6 = sb3;
            if (z11) {
                this.f35586g = sb6.toString();
            } else {
                this.f35586g = "";
            }
            this.f35581b = i12 + "," + i13;
            if (arrayList.isEmpty()) {
                return;
            }
            Collections.sort(arrayList);
            StringBuilder sb7 = new StringBuilder();
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                sb7.append((String) iterator2.next());
            }
            this.f35588i = q.b(sb7.toString());
        }
    }

    public String c() {
        return this.f35588i;
    }

    public String d() {
        StringBuilder sb2 = this.f35587h;
        return sb2 == null ? "" : sb2.toString();
    }

    public String e() {
        return this.f35585f;
    }

    public String f() {
        return this.f35584e;
    }

    public String g() {
        return this.f35582c;
    }

    public String h() {
        return this.f35583d;
    }

    public List<PackageInfo> i() {
        return this.f35589j;
    }

    public String a() {
        return this.f35581b;
    }

    public String b() {
        return this.f35586g;
    }
}
