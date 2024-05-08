package o6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BaseDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f52297a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<v> f52298b = new ArrayList<>(1);

    /* renamed from: c, reason: collision with root package name */
    public int f52299c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f52300d;

    public f(boolean z10) {
        this.f52297a = z10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        if (this.f52298b.contains(vVar)) {
            return;
        }
        this.f52298b.add(vVar);
        this.f52299c++;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map e() {
        return j.a(this);
    }

    public final void t(int i10) {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) j0.j(this.f52300d);
        for (int i11 = 0; i11 < this.f52299c; i11++) {
            this.f52298b.get(i11).d(this, bVar, this.f52297a, i10);
        }
    }

    public final void u() {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) j0.j(this.f52300d);
        for (int i10 = 0; i10 < this.f52299c; i10++) {
            this.f52298b.get(i10).b(this, bVar, this.f52297a);
        }
        this.f52300d = null;
    }

    public final void v(com.google.android.exoplayer2.upstream.b bVar) {
        for (int i10 = 0; i10 < this.f52299c; i10++) {
            this.f52298b.get(i10).i(this, bVar, this.f52297a);
        }
    }

    public final void w(com.google.android.exoplayer2.upstream.b bVar) {
        this.f52300d = bVar;
        for (int i10 = 0; i10 < this.f52299c; i10++) {
            this.f52298b.get(i10).e(this, bVar, this.f52297a);
        }
    }
}
