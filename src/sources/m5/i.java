package m5;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import x4.v;

/* compiled from: C2Mp3TimestampTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public long f51867a;

    /* renamed from: b, reason: collision with root package name */
    public long f51868b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51869c;

    public final long a(long j10) {
        return this.f51867a + Math.max(0L, ((this.f51868b - 529) * 1000000) / j10);
    }

    public long b(Format format) {
        return a(format.A);
    }

    public void c() {
        this.f51867a = 0L;
        this.f51868b = 0L;
        this.f51869c = false;
    }

    public long d(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.f51868b == 0) {
            this.f51867a = decoderInputBuffer.f19884f;
        }
        if (this.f51869c) {
            return decoderInputBuffer.f19884f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f19882d);
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 = (i10 << 8) | (byteBuffer.get(i11) & 255);
        }
        int m10 = v.m(i10);
        if (m10 == -1) {
            this.f51869c = true;
            this.f51868b = 0L;
            this.f51867a = decoderInputBuffer.f19884f;
            com.google.android.exoplayer2.util.m.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return decoderInputBuffer.f19884f;
        }
        long a10 = a(format.A);
        this.f51868b += m10;
        return a10;
    }
}
