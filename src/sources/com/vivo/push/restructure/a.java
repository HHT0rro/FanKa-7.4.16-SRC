package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* compiled from: PushClientController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f46286a;

    /* renamed from: b, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f46287b;

    /* renamed from: c, reason: collision with root package name */
    private d f46288c;

    /* renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f46289d;

    /* renamed from: e, reason: collision with root package name */
    private b f46290e;

    /* renamed from: f, reason: collision with root package name */
    private com.vivo.push.c.a f46291f;

    /* renamed from: g, reason: collision with root package name */
    private k f46292g;

    /* compiled from: PushClientController.java */
    /* renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0658a {

        /* renamed from: a, reason: collision with root package name */
        public static a f46293a = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a a() {
        return C0658a.f46293a;
    }

    public final synchronized Context b() {
        return this.f46286a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f46287b;
    }

    public final d d() {
        return this.f46288c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.f46289d;
    }

    public final b f() {
        return this.f46290e;
    }

    public final com.vivo.push.c.a g() {
        return this.f46291f;
    }

    public final k h() {
        return this.f46292g;
    }

    private a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.f46286a = context;
        com.vivo.push.restructure.b.d dVar = new com.vivo.push.restructure.b.d(new z(context));
        this.f46289d = dVar;
        this.f46287b = new com.vivo.push.restructure.c.b(dVar);
        this.f46288c = new d();
        this.f46290e = new f();
        com.vivo.push.c.a aVar = new com.vivo.push.c.a(context);
        this.f46291f = aVar;
        this.f46292g = new com.vivo.push.z(aVar, e());
    }
}
