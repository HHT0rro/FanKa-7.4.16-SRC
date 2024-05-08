package com.tencent.liteav.base.util;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public int f42910a;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final l f42912c;

    /* renamed from: d, reason: collision with root package name */
    public final a f42913d;

    /* renamed from: b, reason: collision with root package name */
    public boolean f42911b = false;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f42914e = new Runnable() { // from class: com.tencent.liteav.base.util.r.1
        @Override // java.lang.Runnable
        public final void run() {
            r rVar = r.this;
            if (rVar.f42911b) {
                rVar.f42912c.c(rVar.f42914e);
                r rVar2 = r.this;
                rVar2.f42912c.b(rVar2.f42914e, rVar2.f42910a);
            }
            a aVar = r.this.f42913d;
            if (aVar != null) {
                aVar.a();
            }
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();
    }

    public r(@NonNull l lVar, a aVar) {
        this.f42912c = lVar;
        this.f42913d = aVar;
    }

    public final synchronized void a() {
        b();
        this.f42910a = 15;
        this.f42911b = true;
        this.f42912c.b(this.f42914e, 0L);
    }

    public final synchronized void b() {
        this.f42912c.c(this.f42914e);
        this.f42911b = false;
    }
}
