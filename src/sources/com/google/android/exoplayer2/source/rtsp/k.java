package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.a;

/* compiled from: TransferRtpDataChannelFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements a.InterfaceC0200a {

    /* renamed from: a, reason: collision with root package name */
    public final long f22012a;

    public k(long j10) {
        this.f22012a = j10;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a.InterfaceC0200a
    public /* synthetic */ a.InterfaceC0200a a() {
        return b6.b.a(this);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a.InterfaceC0200a
    public a b(int i10) {
        j jVar = new j(this.f22012a);
        jVar.a(b6.i.a(i10 * 2));
        return jVar;
    }
}
