package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q7 implements Iterator<String> {

    /* renamed from: b, reason: collision with root package name */
    public Iterator<String> f25616b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f25617c;

    public q7(o7 o7Var) {
        o5 o5Var;
        this.f25617c = o7Var;
        o5Var = o7Var.f25575b;
        this.f25616b = o5Var.iterator2();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25616b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f25616b.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
