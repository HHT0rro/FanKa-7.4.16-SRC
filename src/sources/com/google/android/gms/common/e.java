package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static e f23545b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f23546a;

    public e(Context context) {
        this.f23546a = context.getApplicationContext();
    }

    @RecentlyNonNull
    public static e a(@RecentlyNonNull Context context) {
        com.google.android.gms.common.internal.h.h(context);
        synchronized (e.class) {
            if (f23545b == null) {
                h.a(context);
                f23545b = new e(context);
            }
        }
        return f23545b;
    }

    public static zzd b(PackageInfo packageInfo, zzd... zzdVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzg zzgVar = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < zzdVarArr.length; i10++) {
            if (zzdVarArr[i10].equals(zzgVar)) {
                return zzdVarArr[i10];
            }
        }
        return null;
    }

    @RecentlyNonNull
    public static boolean c(@RecentlyNonNull PackageInfo packageInfo, @RecentlyNonNull boolean z10) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z10 ? b(packageInfo, i.f23549a) : b(packageInfo, i.f23549a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
