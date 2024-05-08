package o6;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: PriorityDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f52351a;

    /* renamed from: b, reason: collision with root package name */
    public final PriorityTaskManager f52352b;

    /* renamed from: c, reason: collision with root package name */
    public final int f52353c;

    public s(com.google.android.exoplayer2.upstream.a aVar, PriorityTaskManager priorityTaskManager, int i10) {
        this.f52351a = (com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(aVar);
        this.f52352b = (PriorityTaskManager) com.google.android.exoplayer2.util.a.e(priorityTaskManager);
        this.f52353c = i10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f52352b.b(this.f52353c);
        return this.f52351a.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f52351a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f52351a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        return this.f52351a.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f52351a.i();
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        this.f52352b.b(this.f52353c);
        return this.f52351a.read(bArr, i10, i11);
    }
}
