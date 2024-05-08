package com.xiaomi.push;

import com.xiaomi.push.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r.b f48367b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f48368c;

    public t(r rVar, r.b bVar) {
        this.f48368c = rVar;
        this.f48367b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f48368c.e(this.f48367b);
    }
}
