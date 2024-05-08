package h5;

import d5.k;

/* compiled from: StartOffsetExtractorInput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends k {

    /* renamed from: b, reason: collision with root package name */
    public final long f49516b;

    public c(d5.d dVar, long j10) {
        super(dVar);
        com.google.android.exoplayer2.util.a.a(dVar.getPosition() >= j10);
        this.f49516b = j10;
    }

    @Override // d5.k, d5.d
    public long b() {
        return super.b() - this.f49516b;
    }

    @Override // d5.k, d5.d
    public long getPosition() {
        return super.getPosition() - this.f49516b;
    }

    @Override // d5.k, d5.d
    public long o() {
        return super.o() - this.f49516b;
    }
}
