package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y6 extends e7 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x6 f25706c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6(x6 x6Var) {
        super(x6Var, null);
        this.f25706c = x6Var;
    }

    @Override // com.google.android.gms.internal.vision.e7, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        return new z6(this.f25706c, null);
    }

    public /* synthetic */ y6(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
