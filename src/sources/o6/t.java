package o6;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: StatsDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f52354a;

    /* renamed from: b, reason: collision with root package name */
    public long f52355b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f52356c = Uri.EMPTY;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f52357d = Collections.emptyMap();

    public t(com.google.android.exoplayer2.upstream.a aVar) {
        this.f52354a = (com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f52356c = bVar.f22767a;
        this.f52357d = Collections.emptyMap();
        long a10 = this.f52354a.a(bVar);
        this.f52356c = (Uri) com.google.android.exoplayer2.util.a.e(i());
        this.f52357d = e();
        return a10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f52354a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f52354a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        return this.f52354a.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f52354a.i();
    }

    public long n() {
        return this.f52355b;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.f52354a.read(bArr, i10, i11);
        if (read != -1) {
            this.f52355b += read;
        }
        return read;
    }

    public Uri t() {
        return this.f52356c;
    }

    public Map<String, List<String>> u() {
        return this.f52357d;
    }

    public void v() {
        this.f52355b = 0L;
    }
}
