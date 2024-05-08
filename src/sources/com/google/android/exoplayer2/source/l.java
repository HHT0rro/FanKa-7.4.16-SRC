package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: IcyDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21767a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21768b;

    /* renamed from: c, reason: collision with root package name */
    public final a f21769c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f21770d;

    /* renamed from: e, reason: collision with root package name */
    public int f21771e;

    /* compiled from: IcyDataSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(ParsableByteArray parsableByteArray);
    }

    public l(com.google.android.exoplayer2.upstream.a aVar, int i10, a aVar2) {
        com.google.android.exoplayer2.util.a.a(i10 > 0);
        this.f21767a = aVar;
        this.f21768b = i10;
        this.f21769c = aVar2;
        this.f21770d = new byte[1];
        this.f21771e = i10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(o6.v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f21767a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        return this.f21767a.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f21767a.i();
    }

    public final boolean n() throws IOException {
        if (this.f21767a.read(this.f21770d, 0, 1) == -1) {
            return false;
        }
        int i10 = (this.f21770d[0] & 255) << 4;
        if (i10 == 0) {
            return true;
        }
        byte[] bArr = new byte[i10];
        int i11 = i10;
        int i12 = 0;
        while (i11 > 0) {
            int read = this.f21767a.read(bArr, i12, i11);
            if (read == -1) {
                return false;
            }
            i12 += read;
            i11 -= read;
        }
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        if (i10 > 0) {
            this.f21769c.a(new ParsableByteArray(bArr, i10));
        }
        return true;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f21771e == 0) {
            if (!n()) {
                return -1;
            }
            this.f21771e = this.f21768b;
        }
        int read = this.f21767a.read(bArr, i10, Math.min(this.f21771e, i11));
        if (read != -1) {
            this.f21771e -= read;
        }
        return read;
    }
}
