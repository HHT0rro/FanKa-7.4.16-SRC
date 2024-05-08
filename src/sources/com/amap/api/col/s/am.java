package com.amap.api.col.s;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.HashMap;

/* compiled from: RequestCacheControl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static volatile am f7092a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, an> f7093b = new HashMap<>();

    /* compiled from: RequestCacheControl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7094a = true;

        /* renamed from: b, reason: collision with root package name */
        private long f7095b = 86400;

        /* renamed from: c, reason: collision with root package name */
        private int f7096c = 10;

        /* renamed from: d, reason: collision with root package name */
        private double f7097d = ShadowDrawableWrapper.COS_45;

        public final boolean a() {
            return this.f7094a;
        }

        public final long b() {
            return this.f7095b;
        }

        public final int c() {
            return this.f7096c;
        }

        public final double d() {
            return this.f7097d;
        }

        public final void a(boolean z10) {
            this.f7094a = z10;
        }

        public final void a(long j10) {
            this.f7095b = j10;
        }

        public final void a(int i10) {
            this.f7096c = i10;
        }

        public final void a(double d10) {
            this.f7097d = d10;
        }
    }

    /* compiled from: RequestCacheControl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f7098a;

        /* renamed from: b, reason: collision with root package name */
        public Object f7099b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f7098a;
                if (str == null) {
                    return bVar.f7098a == null && this.f7099b == bVar.f7099b;
                }
                if (str.equals(bVar.f7098a) && this.f7099b == bVar.f7099b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f7098a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f7099b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* compiled from: RequestCacheControl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f7100a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7101b;

        public c(Object obj, boolean z10) {
            this.f7100a = obj;
            this.f7101b = z10;
        }
    }

    public static am a() {
        if (f7092a == null) {
            synchronized (am.class) {
                if (f7092a == null) {
                    f7092a = new am();
                }
            }
        }
        return f7092a;
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (an anVar : this.f7093b.values()) {
            if (anVar != null && anVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized an a(String str) {
        return this.f7093b.get(str);
    }

    public final synchronized void a(String str, an anVar) {
        this.f7093b.put(str, anVar);
    }

    public final c a(b bVar) {
        c a10;
        if (bVar == null) {
            return null;
        }
        for (an anVar : this.f7093b.values()) {
            if (anVar != null && (a10 = anVar.a(bVar)) != null) {
                return a10;
            }
        }
        return null;
    }

    public final void a(b bVar, Object obj) {
        for (an anVar : this.f7093b.values()) {
            if (anVar != null) {
                anVar.a(bVar, obj);
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (an anVar : this.f7093b.values()) {
            if (anVar != null) {
                anVar.a(aVar);
            }
        }
    }

    public final void a(String str, a aVar) {
        an anVar;
        if (str == null || aVar == null || (anVar = this.f7093b.get(str)) == null) {
            return;
        }
        anVar.a(aVar);
    }
}
