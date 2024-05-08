package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f46989b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f46990c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e0 f46991d;

    public f0(e0 e0Var, String[] strArr, Context context) {
        this.f46991d = e0Var;
        this.f46989b = strArr;
        this.f46990c = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = 0;
        while (true) {
            try {
                String[] strArr = this.f46989b;
                if (i10 >= strArr.length) {
                    return;
                }
                if (!TextUtils.isEmpty(strArr[i10])) {
                    if (i10 > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f46990c.getPackageManager().getPackageInfo(this.f46989b[i10], 4);
                    if (packageInfo != null) {
                        this.f46991d.h(this.f46990c, packageInfo);
                    }
                }
                i10++;
            } catch (Throwable th) {
                fc.c.k(th);
                return;
            }
        }
    }
}
