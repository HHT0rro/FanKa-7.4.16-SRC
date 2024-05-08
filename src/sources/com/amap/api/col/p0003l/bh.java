package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TaskManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    private static bh f5119a;

    /* renamed from: b, reason: collision with root package name */
    private jd f5120b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedHashMap<String, je> f5121c = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f5122d = true;

    private bh() {
        try {
            if (this.f5120b == null) {
                this.f5120b = jd.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static bh a() {
        return c();
    }

    private static synchronized bh c() {
        bh bhVar;
        synchronized (bh.class) {
            try {
                bh bhVar2 = f5119a;
                if (bhVar2 == null) {
                    f5119a = new bh();
                } else if (bhVar2.f5120b == null) {
                    bhVar2.f5120b = jd.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            bhVar = f5119a;
        }
        return bhVar;
    }

    private void d() {
        synchronized (this.f5121c) {
            if (this.f5121c.size() <= 0) {
                return;
            }
            for (Map.Entry<String, je> entry : this.f5121c.entrySet()) {
                entry.getKey();
                ((bd) entry.getValue()).a();
            }
            this.f5121c.clear();
        }
    }

    private static void e() {
        f5119a = null;
    }

    public final void b() {
        d();
        this.f5120b.e();
        this.f5120b = null;
        e();
    }

    public final void a(bg bgVar) {
        synchronized (this.f5121c) {
            bd bdVar = (bd) this.f5121c.get(bgVar.b());
            if (bdVar == null) {
                return;
            }
            bdVar.a();
            this.f5121c.remove(bgVar.b());
        }
    }

    public final void b(bg bgVar) {
        bd bdVar = (bd) this.f5121c.get(bgVar.b());
        if (bdVar != null) {
            synchronized (this.f5121c) {
                bdVar.b();
                this.f5121c.remove(bgVar.b());
            }
        }
    }

    public final void a(bg bgVar, Context context) throws fi {
        if (!this.f5121c.containsKey(bgVar.b())) {
            bd bdVar = new bd((bx) bgVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.f5121c) {
                this.f5121c.put(bgVar.b(), bdVar);
            }
        }
        this.f5120b.a(this.f5121c.get(bgVar.b()));
    }
}
