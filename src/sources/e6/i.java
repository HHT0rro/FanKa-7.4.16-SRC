package e6;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: SubtitleOutputBuffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class i extends z4.e implements e {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public e f48923e;

    /* renamed from: f, reason: collision with root package name */
    public long f48924f;

    @Override // e6.e
    public long a(int i10) {
        return ((e) com.google.android.exoplayer2.util.a.e(this.f48923e)).a(i10) + this.f48924f;
    }

    @Override // e6.e
    public int b() {
        return ((e) com.google.android.exoplayer2.util.a.e(this.f48923e)).b();
    }

    @Override // e6.e
    public int c(long j10) {
        return ((e) com.google.android.exoplayer2.util.a.e(this.f48923e)).c(j10 - this.f48924f);
    }

    @Override // e6.e
    public List<a> f(long j10) {
        return ((e) com.google.android.exoplayer2.util.a.e(this.f48923e)).f(j10 - this.f48924f);
    }

    @Override // z4.a
    public void h() {
        super.h();
        this.f48923e = null;
    }

    public void q(long j10, e eVar, long j11) {
        this.f54863c = j10;
        this.f48923e = eVar;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.f48924f = j10;
    }
}
