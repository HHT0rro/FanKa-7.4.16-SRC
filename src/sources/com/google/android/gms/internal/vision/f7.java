package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f7 implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public int f25465b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25466c;

    /* renamed from: d, reason: collision with root package name */
    public Iterator f25467d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x6 f25468e;

    public f7(x6 x6Var) {
        this.f25468e = x6Var;
        this.f25465b = -1;
    }

    public final Iterator a() {
        if (this.f25467d == null) {
            this.f25467d = x6.l(this.f25468e).entrySet().iterator2();
        }
        return this.f25467d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25465b + 1 < x6.g(this.f25468e).size() || (!x6.l(this.f25468e).isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f25466c = true;
        int i10 = this.f25465b + 1;
        this.f25465b = i10;
        if (i10 < x6.g(this.f25468e).size()) {
            return (Map.Entry) x6.g(this.f25468e).get(this.f25465b);
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f25466c) {
            this.f25466c = false;
            x6.f(this.f25468e);
            if (this.f25465b < x6.g(this.f25468e).size()) {
                x6 x6Var = this.f25468e;
                int i10 = this.f25465b;
                this.f25465b = i10 - 1;
                x6.c(x6Var, i10);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ f7(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
