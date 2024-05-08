package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c3 implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public int f23833b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23834c;

    /* renamed from: d, reason: collision with root package name */
    public Iterator f23835d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u2 f23836e;

    public c3(u2 u2Var) {
        this.f23836e = u2Var;
        this.f23833b = -1;
    }

    public /* synthetic */ c3(u2 u2Var, v2 v2Var) {
        this(u2Var);
    }

    public final Iterator a() {
        if (this.f23835d == null) {
            this.f23835d = u2.j(this.f23836e).entrySet().iterator2();
        }
        return this.f23835d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f23833b + 1 < u2.i(this.f23836e).size() || (!u2.j(this.f23836e).isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f23834c = true;
        int i10 = this.f23833b + 1;
        this.f23833b = i10;
        return (Map.Entry) (i10 < u2.i(this.f23836e).size() ? u2.i(this.f23836e).get(this.f23833b) : a().next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f23834c) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f23834c = false;
        u2.e(this.f23836e);
        if (this.f23833b >= u2.i(this.f23836e).size()) {
            a().remove();
            return;
        }
        u2 u2Var = this.f23836e;
        int i10 = this.f23833b;
        this.f23833b = i10 - 1;
        u2.c(u2Var, i10);
    }
}
