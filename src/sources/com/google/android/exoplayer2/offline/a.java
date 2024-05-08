package com.google.android.exoplayer2.offline;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.scheduler.Requirements;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import v5.a;

/* compiled from: DownloadManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final Requirements f21023l = new Requirements(1);

    /* renamed from: a, reason: collision with root package name */
    public final Context f21024a;

    /* renamed from: b, reason: collision with root package name */
    public final a.c f21025b;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<InterfaceC0192a> f21026c;

    /* renamed from: d, reason: collision with root package name */
    public int f21027d;

    /* renamed from: e, reason: collision with root package name */
    public int f21028e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21029f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21030g;

    /* renamed from: h, reason: collision with root package name */
    public int f21031h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21032i;

    /* renamed from: j, reason: collision with root package name */
    public List<u5.a> f21033j;

    /* renamed from: k, reason: collision with root package name */
    public v5.a f21034k;

    /* compiled from: DownloadManager.java */
    /* renamed from: com.google.android.exoplayer2.offline.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0192a {
        void a(a aVar, Requirements requirements, int i10);

        void b(a aVar, boolean z10);
    }

    public void a(DownloadRequest downloadRequest, int i10) {
        this.f21027d++;
        throw null;
    }

    public void b(InterfaceC0192a interfaceC0192a) {
        com.google.android.exoplayer2.util.a.e(interfaceC0192a);
        this.f21026c.add(interfaceC0192a);
    }

    public List<u5.a> c() {
        return this.f21033j;
    }

    public boolean d() {
        return this.f21030g;
    }

    public Requirements e() {
        return this.f21034k.f();
    }

    public boolean f() {
        return this.f21028e == 0 && this.f21027d == 0;
    }

    public boolean g() {
        return this.f21029f;
    }

    public boolean h() {
        return this.f21032i;
    }

    public final void i() {
        Iterator<InterfaceC0192a> iterator2 = this.f21026c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(this, this.f21032i);
        }
    }

    public final void j(v5.a aVar, int i10) {
        Requirements f10 = aVar.f();
        if (this.f21031h == i10) {
            boolean r10 = r();
            Iterator<InterfaceC0192a> iterator2 = this.f21026c.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(this, f10, i10);
            }
            if (r10) {
                i();
                return;
            }
            return;
        }
        this.f21031h = i10;
        this.f21027d++;
        throw null;
    }

    public void k() {
        o(true);
    }

    public void l() {
        this.f21027d++;
        throw null;
    }

    public void m(String str) {
        this.f21027d++;
        throw null;
    }

    public void n() {
        o(false);
    }

    public final void o(boolean z10) {
        if (this.f21030g == z10) {
            return;
        }
        this.f21030g = z10;
        this.f21027d++;
        throw null;
    }

    public void p(Requirements requirements) {
        if (requirements.equals(this.f21034k.f())) {
            return;
        }
        this.f21034k.j();
        v5.a aVar = new v5.a(this.f21024a, this.f21025b, requirements);
        this.f21034k = aVar;
        j(this.f21034k, aVar.i());
    }

    public void q(@Nullable String str, int i10) {
        this.f21027d++;
        throw null;
    }

    public final boolean r() {
        boolean z10;
        if (!this.f21030g && this.f21031h != 0) {
            for (int i10 = 0; i10 < this.f21033j.size(); i10++) {
                if (this.f21033j.get(i10).f53824a == 0) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        boolean z11 = this.f21032i != z10;
        this.f21032i = z10;
        return z11;
    }
}
