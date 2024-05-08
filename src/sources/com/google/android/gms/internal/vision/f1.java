package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f1 extends AbstractCollection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdp f25461b;

    public f1(zzdp zzdpVar) {
        this.f25461b = zzdpVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f25461b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        return this.f25461b.zzg();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25461b.size();
    }
}
