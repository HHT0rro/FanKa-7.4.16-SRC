package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogAdaptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f29615b;

    /* renamed from: a, reason: collision with root package name */
    private int f29614a = 4;

    /* renamed from: c, reason: collision with root package name */
    private d f29616c = new c();

    private void b() {
    }

    public void a(Context context, int i10, String str) {
        this.f29614a = i10;
        this.f29615b = str;
        this.f29616c.a(context, "HMSCore");
    }

    public void b(int i10, String str, String str2, Throwable th) {
        try {
            if (a(i10)) {
                e a10 = a(i10, str, str2, th);
                String str3 = a10.c() + a10.a();
                this.f29616c.a(str3, i10, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.f29616c;
    }

    public void a(d dVar) {
        this.f29616c = dVar;
    }

    public boolean a(int i10) {
        return i10 >= this.f29614a;
    }

    public void a(int i10, String str, String str2) {
        try {
            if (a(i10)) {
                e a10 = a(i10, str, str2, null);
                this.f29616c.a(a10.c() + a10.a(), i10, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e a10 = a(4, str, str2, null);
            this.f29616c.a(a10.c() + '\n' + a10.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i10, String str, String str2, Throwable th) {
        e eVar = new e(8, this.f29615b, i10, str);
        eVar.a((e) str2);
        eVar.a(th);
        return eVar;
    }
}
