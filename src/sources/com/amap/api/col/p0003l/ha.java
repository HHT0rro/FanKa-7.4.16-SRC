package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CrashManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ha {

    /* renamed from: a, reason: collision with root package name */
    private fu f6237a;

    /* compiled from: CrashManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, ha> f6238a = new HashMap();
    }

    private ha(fu fuVar) {
        this.f6237a = fuVar;
    }

    public static ha a(fu fuVar) {
        if (a.f6238a.get(fuVar.a()) == null) {
            a.f6238a.put(fuVar.a(), new ha(fuVar));
        }
        return a.f6238a.get(fuVar.a());
    }

    public final boolean b(Context context) {
        try {
            return Boolean.parseBoolean(hd.a(context, this.f6237a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void a(Context context, boolean z10, boolean z11) {
        hd.a(context, this.f6237a, "sckey", String.valueOf(z10));
        if (z10) {
            hd.a(context, this.f6237a, "scisf", String.valueOf(z11));
        }
    }

    public final boolean a(Context context) {
        try {
            return Boolean.parseBoolean(hd.a(context, this.f6237a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }
}
