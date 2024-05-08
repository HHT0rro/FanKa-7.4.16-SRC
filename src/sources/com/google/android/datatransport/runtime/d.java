package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import n4.h;
import n4.l;
import s4.i;
import s4.m;

/* compiled from: TransportRuntime.java */
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d implements l {

    /* renamed from: e, reason: collision with root package name */
    public static volatile e f19401e;

    /* renamed from: a, reason: collision with root package name */
    public final u4.a f19402a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f19403b;

    /* renamed from: c, reason: collision with root package name */
    public final r4.e f19404c;

    /* renamed from: d, reason: collision with root package name */
    public final i f19405d;

    @Inject
    public d(u4.a aVar, u4.a aVar2, r4.e eVar, i iVar, m mVar) {
        this.f19402a = aVar;
        this.f19403b = aVar2;
        this.f19404c = eVar;
        this.f19405d = iVar;
        mVar.a();
    }

    public static d c() {
        e eVar = f19401e;
        if (eVar != null) {
            return eVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<com.google.android.datatransport.a> d(n4.b bVar) {
        if (bVar instanceof n4.c) {
            return Collections.unmodifiableSet(((n4.c) bVar).a());
        }
        return Collections.singleton(com.google.android.datatransport.a.b("proto"));
    }

    public static void f(Context context) {
        if (f19401e == null) {
            synchronized (d.class) {
                if (f19401e == null) {
                    f19401e = c.d().a(context).build();
                }
            }
        }
    }

    @Override // n4.l
    public void a(h hVar, com.google.android.datatransport.e eVar) {
        this.f19404c.a(hVar.f().e(hVar.c().getPriority()), b(hVar), eVar);
    }

    public final EventInternal b(h hVar) {
        return EventInternal.a().i(this.f19402a.getTime()).k(this.f19403b.getTime()).j(hVar.g()).h(new n4.d(hVar.b(), hVar.d())).g(hVar.c().getCode()).d();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public i e() {
        return this.f19405d;
    }

    public com.google.android.datatransport.d g(n4.b bVar) {
        return new n4.i(d(bVar), TransportContext.a().b(bVar.getName()).c(bVar.getExtras()).a(), this);
    }
}
