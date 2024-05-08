package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.j0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.Map;
import o6.v;

/* compiled from: UdpDataSourceRtpDataChannel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements a {

    /* renamed from: a, reason: collision with root package name */
    public final UdpDataSource f22013a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public l f22014b;

    public l(long j10) {
        this.f22013a = new UdpDataSource(2000, Ints.c(j10));
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        return this.f22013a.a(bVar);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    public int c() {
        int c4 = this.f22013a.c();
        if (c4 == -1) {
            return -1;
        }
        return c4;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.f22013a.close();
        l lVar = this.f22014b;
        if (lVar != null) {
            lVar.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        this.f22013a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map e() {
        return o6.j.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22013a.i();
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    public String k() {
        int c4 = c();
        com.google.android.exoplayer2.util.a.g(c4 != -1);
        return j0.D("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(c4), Integer.valueOf(c4 + 1));
    }

    public void n(l lVar) {
        com.google.android.exoplayer2.util.a.a(this != lVar);
        this.f22014b = lVar;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    @Nullable
    public g.b p() {
        return null;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.f22013a.read(bArr, i10, i11);
        } catch (UdpDataSource.UdpDataSourceException e2) {
            if (e2.reason == 2002) {
                return -1;
            }
            throw e2;
        }
    }
}
