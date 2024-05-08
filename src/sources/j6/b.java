package j6;

import com.google.android.exoplayer2.util.j0;
import e6.e;
import java.util.Collections;
import java.util.List;

/* compiled from: SubripSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements e {

    /* renamed from: b, reason: collision with root package name */
    public final e6.a[] f50343b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f50344c;

    public b(e6.a[] aVarArr, long[] jArr) {
        this.f50343b = aVarArr;
        this.f50344c = jArr;
    }

    @Override // e6.e
    public long a(int i10) {
        com.google.android.exoplayer2.util.a.a(i10 >= 0);
        com.google.android.exoplayer2.util.a.a(i10 < this.f50344c.length);
        return this.f50344c[i10];
    }

    @Override // e6.e
    public int b() {
        return this.f50344c.length;
    }

    @Override // e6.e
    public int c(long j10) {
        int e2 = j0.e(this.f50344c, j10, false, false);
        if (e2 < this.f50344c.length) {
            return e2;
        }
        return -1;
    }

    @Override // e6.e
    public List<e6.a> f(long j10) {
        int i10 = j0.i(this.f50344c, j10, true, false);
        if (i10 != -1) {
            e6.a[] aVarArr = this.f50343b;
            if (aVarArr[i10] != e6.a.f48882r) {
                return Collections.singletonList(aVarArr[i10]);
            }
        }
        return Collections.emptyList();
    }
}
