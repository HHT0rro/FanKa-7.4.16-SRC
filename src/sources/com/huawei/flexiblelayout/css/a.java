package com.huawei.flexiblelayout.css;

import android.content.Context;

/* compiled from: CSSConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f27963a;

    /* compiled from: CSSConfig.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f27964a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.f27964a;
    }

    public void a(Context context) {
        if (context != null) {
            this.f27963a = context.getApplicationContext();
        }
    }

    private a() {
    }

    public Context a() {
        return this.f27963a;
    }
}
