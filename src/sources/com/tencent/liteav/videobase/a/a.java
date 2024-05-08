package com.tencent.liteav.videobase.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f43245a = false;

    public abstract com.tencent.liteav.videobase.frame.d a(long j10, com.tencent.liteav.videobase.frame.d dVar);

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        if (this.f43245a) {
            return;
        }
        b(eVar);
        this.f43245a = true;
    }

    public void b() {
    }

    public void b(com.tencent.liteav.videobase.frame.e eVar) {
    }

    public final void a() {
        if (this.f43245a) {
            b();
            this.f43245a = false;
        }
    }
}
