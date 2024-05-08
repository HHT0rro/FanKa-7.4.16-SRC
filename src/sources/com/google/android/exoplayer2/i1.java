package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: PlaylistTimeline.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i1 extends a {

    /* renamed from: f, reason: collision with root package name */
    public final int f20711f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20712g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f20713h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f20714i;

    /* renamed from: j, reason: collision with root package name */
    public final Timeline[] f20715j;

    /* renamed from: k, reason: collision with root package name */
    public final Object[] f20716k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap<Object, Integer> f20717l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(Collection<? extends b1> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i10 = 0;
        int size = collection.size();
        this.f20713h = new int[size];
        this.f20714i = new int[size];
        this.f20715j = new Timeline[size];
        this.f20716k = new Object[size];
        this.f20717l = new HashMap<>();
        int i11 = 0;
        int i12 = 0;
        for (b1 b1Var : collection) {
            this.f20715j[i12] = b1Var.a();
            this.f20714i[i12] = i10;
            this.f20713h[i12] = i11;
            i10 += this.f20715j[i12].p();
            i11 += this.f20715j[i12].i();
            this.f20716k[i12] = b1Var.getUid();
            this.f20717l.put(this.f20716k[i12], Integer.valueOf(i12));
            i12++;
        }
        this.f20711f = i10;
        this.f20712g = i11;
    }

    @Override // com.google.android.exoplayer2.a
    public int A(int i10) {
        return this.f20714i[i10];
    }

    @Override // com.google.android.exoplayer2.a
    public Timeline D(int i10) {
        return this.f20715j[i10];
    }

    public List<Timeline> E() {
        return Arrays.asList(this.f20715j);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int i() {
        return this.f20712g;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int p() {
        return this.f20711f;
    }

    @Override // com.google.android.exoplayer2.a
    public int s(Object obj) {
        Integer num = this.f20717l.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.a
    public int t(int i10) {
        return com.google.android.exoplayer2.util.j0.h(this.f20713h, i10 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    public int u(int i10) {
        return com.google.android.exoplayer2.util.j0.h(this.f20714i, i10 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    public Object x(int i10) {
        return this.f20716k[i10];
    }

    @Override // com.google.android.exoplayer2.a
    public int z(int i10) {
        return this.f20713h[i10];
    }
}
