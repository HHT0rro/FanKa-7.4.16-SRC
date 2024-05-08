package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

/* compiled from: ForwardingTimeline.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class k extends Timeline {

    /* renamed from: c, reason: collision with root package name */
    public final Timeline f21765c;

    public k(Timeline timeline) {
        this.f21765c = timeline;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int a(boolean z10) {
        return this.f21765c.a(z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int b(Object obj) {
        return this.f21765c.b(obj);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int c(boolean z10) {
        return this.f21765c.c(z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int e(int i10, int i11, boolean z10) {
        return this.f21765c.e(i10, i11, z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
        return this.f21765c.g(i10, bVar, z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int i() {
        return this.f21765c.i();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int l(int i10, int i11, boolean z10) {
        return this.f21765c.l(i10, i11, z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object m(int i10) {
        return this.f21765c.m(i10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.c o(int i10, Timeline.c cVar, long j10) {
        return this.f21765c.o(i10, cVar, j10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int p() {
        return this.f21765c.p();
    }
}
