package o6;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: TeeDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f52358a;

    /* renamed from: b, reason: collision with root package name */
    public final i f52359b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52360c;

    /* renamed from: d, reason: collision with root package name */
    public long f52361d;

    public u(com.google.android.exoplayer2.upstream.a aVar, i iVar) {
        this.f52358a = (com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(aVar);
        this.f52359b = (i) com.google.android.exoplayer2.util.a.e(iVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long a10 = this.f52358a.a(bVar);
        this.f52361d = a10;
        if (a10 == 0) {
            return 0L;
        }
        if (bVar.f22774h == -1 && a10 != -1) {
            bVar = bVar.f(0L, a10);
        }
        this.f52360c = true;
        this.f52359b.a(bVar);
        return this.f52361d;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        try {
            this.f52358a.close();
        } finally {
            if (this.f52360c) {
                this.f52360c = false;
                this.f52359b.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f52358a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        return this.f52358a.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f52358a.i();
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f52361d == 0) {
            return -1;
        }
        int read = this.f52358a.read(bArr, i10, i11);
        if (read > 0) {
            this.f52359b.write(bArr, i10, read);
            long j10 = this.f52361d;
            if (j10 != -1) {
                this.f52361d = j10 - read;
            }
        }
        return read;
    }
}
