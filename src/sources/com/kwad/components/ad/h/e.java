package com.kwad.components.ad.h;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {

    /* renamed from: od, reason: collision with root package name */
    private final AtomicBoolean f36495od;
    private final List<com.kwad.components.ad.b.a.b> oe;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final e of = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    public static e eV() {
        return a.of;
    }

    public final boolean S() {
        return this.f36495od.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.oe.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.oe.remove(bVar);
        }
    }

    public final void eR() {
        this.f36495od.set(true);
        Iterator<com.kwad.components.ad.b.a.b> iterator2 = this.oe.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().T();
        }
    }

    public final void eT() {
        this.f36495od.set(false);
        Iterator<com.kwad.components.ad.b.a.b> iterator2 = this.oe.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().U();
        }
    }

    private e() {
        this.f36495od = new AtomicBoolean();
        this.oe = new CopyOnWriteArrayList();
    }
}
