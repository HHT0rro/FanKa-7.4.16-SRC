package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.b0;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @RecentlyNonNull
    public static final int f23516a = d.f23519a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f23517b = new b();

    @RecentlyNonNull
    public static b f() {
        return f23517b;
    }

    public static String j(@Nullable Context context, @Nullable String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("gcore_");
        sb2.append(f23516a);
        sb2.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append("-");
        if (context != null) {
            sb2.append(context.getPackageName());
        }
        sb2.append("-");
        if (context != null) {
            try {
                sb2.append(d7.b.a(context).d(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb2.toString();
    }

    @RecentlyNonNull
    public int a(@RecentlyNonNull Context context) {
        return d.a(context);
    }

    @RecentlyNullable
    public Intent b(@Nullable Context context, @RecentlyNonNull int i10, @Nullable String str) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            return b0.b("com.google.android.gms");
        }
        if (context != null && b7.g.e(context)) {
            return b0.a();
        }
        return b0.c("com.google.android.gms", j(context, str));
    }

    @RecentlyNullable
    public PendingIntent c(@RecentlyNonNull Context context, @RecentlyNonNull int i10, @RecentlyNonNull int i11) {
        return d(context, i10, i11, null);
    }

    @RecentlyNullable
    public PendingIntent d(@RecentlyNonNull Context context, @RecentlyNonNull int i10, @RecentlyNonNull int i11, @Nullable String str) {
        Intent b4 = b(context, i10, str);
        if (b4 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i11, b4, 134217728);
    }

    @NonNull
    public String e(@RecentlyNonNull int i10) {
        return d.b(i10);
    }

    @RecentlyNonNull
    public int g(@RecentlyNonNull Context context) {
        return h(context, f23516a);
    }

    @RecentlyNonNull
    public int h(@RecentlyNonNull Context context, @RecentlyNonNull int i10) {
        int e2 = d.e(context, i10);
        if (d.f(context, e2)) {
            return 18;
        }
        return e2;
    }

    @RecentlyNonNull
    public boolean i(@RecentlyNonNull int i10) {
        return d.h(i10);
    }
}
