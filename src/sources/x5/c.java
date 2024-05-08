package x5;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.l0;
import x5.g;

/* compiled from: BaseMediaChunkOutput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements g.b {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f54485a;

    /* renamed from: b, reason: collision with root package name */
    public final l0[] f54486b;

    public c(int[] iArr, l0[] l0VarArr) {
        this.f54485a = iArr;
        this.f54486b = l0VarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f54486b.length];
        int i10 = 0;
        while (true) {
            l0[] l0VarArr = this.f54486b;
            if (i10 >= l0VarArr.length) {
                return iArr;
            }
            iArr[i10] = l0VarArr[i10].G();
            i10++;
        }
    }

    public void b(long j10) {
        for (l0 l0Var : this.f54486b) {
            l0Var.a0(j10);
        }
    }

    @Override // x5.g.b
    public TrackOutput c(int i10, int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = this.f54485a;
            if (i12 < iArr.length) {
                if (i11 == iArr[i12]) {
                    return this.f54486b[i12];
                }
                i12++;
            } else {
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append("Unmatched track of type: ");
                sb2.append(i11);
                com.google.android.exoplayer2.util.m.c("BaseMediaChunkOutput", sb2.toString());
                return new com.google.android.exoplayer2.extractor.d();
            }
        }
    }
}
