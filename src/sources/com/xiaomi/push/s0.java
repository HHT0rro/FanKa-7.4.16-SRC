package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public ic.e f48146b;

    /* renamed from: c, reason: collision with root package name */
    public Context f48147c;

    public void a(Context context) {
        this.f48147c = context;
    }

    public void b(ic.e eVar) {
        this.f48146b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w0 b4;
        String str;
        long currentTimeMillis;
        try {
            ic.e eVar = this.f48146b;
            if (eVar != null) {
                eVar.a();
            }
            fc.c.m("begin read and send perf / event");
            ic.e eVar2 = this.f48146b;
            if (eVar2 instanceof ic.a) {
                b4 = w0.b(this.f48147c);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (!(eVar2 instanceof ic.b)) {
                    return;
                }
                b4 = w0.b(this.f48147c);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            b4.d("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }
}
