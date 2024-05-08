package com.alipay.sdk.data;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4590a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f4591b;

    public b(a aVar, Context context) {
        this.f4591b = aVar;
        this.f4590a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a10 = new com.alipay.sdk.packet.impl.b().a(this.f4590a);
            if (a10 != null) {
                this.f4591b.b(a10.b());
                this.f4591b.i();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
