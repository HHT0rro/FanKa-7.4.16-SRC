package com.google.android.exoplayer2.extractor.ts;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: TsBinarySearchSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d0 extends BinarySearchSeeker {

    /* compiled from: TsBinarySearchSeeker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements BinarySearchSeeker.e {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.f0 f20390a;

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f20391b = new ParsableByteArray();

        /* renamed from: c, reason: collision with root package name */
        public final int f20392c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20393d;

        public a(int i10, com.google.android.exoplayer2.util.f0 f0Var, int i11) {
            this.f20392c = i10;
            this.f20390a = f0Var;
            this.f20393d = i11;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public BinarySearchSeeker.TimestampSearchResult a(d5.d dVar, long j10) throws IOException {
            long position = dVar.getPosition();
            int min = (int) Math.min(this.f20393d, dVar.b() - position);
            this.f20391b.L(min);
            dVar.j(this.f20391b.d(), 0, min);
            return c(this.f20391b, j10, position);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public void b() {
            this.f20391b.M(com.google.android.exoplayer2.util.j0.f22995f);
        }

        public final BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j10, long j11) {
            int a10;
            int a11;
            int f10 = parsableByteArray.f();
            long j12 = -1;
            long j13 = -1;
            long j14 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188 && (a11 = (a10 = i0.a(parsableByteArray.d(), parsableByteArray.e(), f10)) + 188) <= f10) {
                long c4 = i0.c(parsableByteArray, a10, this.f20392c);
                if (c4 != -9223372036854775807L) {
                    long b4 = this.f20390a.b(c4);
                    if (b4 > j10) {
                        if (j14 == -9223372036854775807L) {
                            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(b4, j11);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j11 + j13);
                    }
                    if (100000 + b4 > j10) {
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j11 + a10);
                    }
                    j13 = a10;
                    j14 = b4;
                }
                parsableByteArray.P(a11);
                j12 = a11;
            }
            if (j14 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j14, j11 + j12);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }
    }

    public d0(com.google.android.exoplayer2.util.f0 f0Var, long j10, long j11, int i10, int i11) {
        super(new BinarySearchSeeker.b(), new a(i10, f0Var, i11), j10, 0L, j10 + 1, 0L, j11, 188L, MetricsProto.MetricsEvent.ENTERPRISE_PRIVACY_DEFAULT_APPS);
    }
}
