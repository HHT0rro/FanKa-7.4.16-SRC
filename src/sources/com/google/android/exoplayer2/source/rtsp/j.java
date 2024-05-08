package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: TransferRtpDataChannel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j extends o6.f implements a, g.b {

    /* renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue<byte[]> f22008e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22009f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f22010g;

    /* renamed from: h, reason: collision with root package name */
    public int f22011h;

    public j(long j10) {
        super(true);
        this.f22009f = j10;
        this.f22008e = new LinkedBlockingQueue<>();
        this.f22010g = new byte[0];
        this.f22011h = -1;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) {
        this.f22011h = bVar.f22767a.getPort();
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    public int c() {
        return this.f22011h;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return null;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    public String k() {
        com.google.android.exoplayer2.util.a.g(this.f22011h != -1);
        return j0.D("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f22011h), Integer.valueOf(this.f22011h + 1));
    }

    @Override // com.google.android.exoplayer2.source.rtsp.g.b
    public void n(byte[] bArr) {
        this.f22008e.add(bArr);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.a
    public g.b p() {
        return this;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int min = Math.min(i11, this.f22010g.length);
        System.arraycopy((Object) this.f22010g, 0, (Object) bArr, i10, min);
        int i12 = min + 0;
        byte[] bArr2 = this.f22010g;
        this.f22010g = Arrays.copyOfRange(bArr2, min, bArr2.length);
        if (i12 == i11) {
            return i12;
        }
        try {
            byte[] poll = this.f22008e.poll(this.f22009f, TimeUnit.MILLISECONDS);
            if (poll == null) {
                return -1;
            }
            int min2 = Math.min(i11 - i12, poll.length);
            System.arraycopy((Object) poll, 0, (Object) bArr, i10 + i12, min2);
            if (min2 < poll.length) {
                this.f22010g = Arrays.copyOfRange(poll, min2, poll.length);
            }
            return i12 + min2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
