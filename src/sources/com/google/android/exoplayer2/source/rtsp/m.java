package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;

/* compiled from: UdpDataSourceRtpDataChannelFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m implements a.InterfaceC0200a {

    /* renamed from: a, reason: collision with root package name */
    public final long f22015a;

    public m(long j10) {
        this.f22015a = j10;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a.InterfaceC0200a
    public a.InterfaceC0200a a() {
        return new k(this.f22015a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a.InterfaceC0200a
    public a b(int i10) throws IOException {
        l lVar = new l(this.f22015a);
        l lVar2 = new l(this.f22015a);
        try {
            lVar.a(b6.i.a(0));
            int c4 = lVar.c();
            boolean z10 = c4 % 2 == 0;
            lVar2.a(b6.i.a(z10 ? c4 + 1 : c4 - 1));
            if (z10) {
                lVar.n(lVar2);
                return lVar;
            }
            lVar2.n(lVar);
            return lVar2;
        } catch (IOException e2) {
            j0.n(lVar);
            j0.n(lVar2);
            throw e2;
        }
    }
}
