package j5;

import android.util.Pair;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.j0;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import d5.o;

/* compiled from: MlltSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f50302a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f50303b;

    /* renamed from: c, reason: collision with root package name */
    public final long f50304c;

    public c(long[] jArr, long[] jArr2, long j10) {
        this.f50302a = jArr;
        this.f50303b = jArr2;
        this.f50304c = j10 == -9223372036854775807L ? com.google.android.exoplayer2.h.d(jArr2[jArr2.length - 1]) : j10;
    }

    public static c a(long j10, MlltFrame mlltFrame, long j11) {
        int length = mlltFrame.f20910f.length;
        int i10 = length + 1;
        long[] jArr = new long[i10];
        long[] jArr2 = new long[i10];
        jArr[0] = j10;
        long j12 = 0;
        jArr2[0] = 0;
        for (int i11 = 1; i11 <= length; i11++) {
            int i12 = i11 - 1;
            j10 += mlltFrame.f20908d + mlltFrame.f20910f[i12];
            j12 += mlltFrame.f20909e + mlltFrame.f20911g[i12];
            jArr[i11] = j10;
            jArr2[i11] = j12;
        }
        return new c(jArr, jArr2, j11);
    }

    public static Pair<Long, Long> b(long j10, long[] jArr, long[] jArr2) {
        int i10 = j0.i(jArr, j10, true, true);
        long j11 = jArr[i10];
        long j12 = jArr2[i10];
        int i11 = i10 + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Pair.create(Long.valueOf(j10), Long.valueOf(((long) ((jArr[i11] == j11 ? ShadowDrawableWrapper.COS_45 : (j10 - j11) / (r6 - j11)) * (jArr2[i11] - j12))) + j12));
    }

    @Override // j5.g
    public long c(long j10) {
        return com.google.android.exoplayer2.h.d(((Long) b(j10, this.f50302a, this.f50303b).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        Pair<Long, Long> b4 = b(com.google.android.exoplayer2.h.e(j0.s(j10, 0L, this.f50304c)), this.f50303b, this.f50302a);
        return new i.a(new o(com.google.android.exoplayer2.h.d(((Long) b4.first).longValue()), ((Long) b4.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // j5.g
    public long h() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f50304c;
    }
}
