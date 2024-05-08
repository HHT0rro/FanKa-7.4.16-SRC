package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x2 extends d3 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u2 f24097c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(u2 u2Var) {
        super(u2Var, null);
        this.f24097c = u2Var;
    }

    public /* synthetic */ x2(u2 u2Var, v2 v2Var) {
        this(u2Var);
    }

    @Override // com.google.android.gms.internal.clearcut.d3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        return new w2(this.f24097c, null);
    }
}
