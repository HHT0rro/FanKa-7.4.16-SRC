package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: PsBinarySearchSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w extends BinarySearchSeeker {

    /* compiled from: PsBinarySearchSeeker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements BinarySearchSeeker.e {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.f0 f20651a;

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f20652b;

        public static void d(ParsableByteArray parsableByteArray) {
            int k10;
            int f10 = parsableByteArray.f();
            if (parsableByteArray.a() < 10) {
                parsableByteArray.P(f10);
                return;
            }
            parsableByteArray.Q(9);
            int D = parsableByteArray.D() & 7;
            if (parsableByteArray.a() < D) {
                parsableByteArray.P(f10);
                return;
            }
            parsableByteArray.Q(D);
            if (parsableByteArray.a() < 4) {
                parsableByteArray.P(f10);
                return;
            }
            if (w.k(parsableByteArray.d(), parsableByteArray.e()) == 443) {
                parsableByteArray.Q(4);
                int J = parsableByteArray.J();
                if (parsableByteArray.a() < J) {
                    parsableByteArray.P(f10);
                    return;
                }
                parsableByteArray.Q(J);
            }
            while (parsableByteArray.a() >= 4 && (k10 = w.k(parsableByteArray.d(), parsableByteArray.e())) != 442 && k10 != 441 && (k10 >>> 8) == 1) {
                parsableByteArray.Q(4);
                if (parsableByteArray.a() < 2) {
                    parsableByteArray.P(f10);
                    return;
                }
                parsableByteArray.P(Math.min(parsableByteArray.f(), parsableByteArray.e() + parsableByteArray.J()));
            }
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public BinarySearchSeeker.TimestampSearchResult a(d5.d dVar, long j10) throws IOException {
            long position = dVar.getPosition();
            int min = (int) Math.min(20000L, dVar.b() - position);
            this.f20652b.L(min);
            dVar.j(this.f20652b.d(), 0, min);
            return c(this.f20652b, j10, position);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public void b() {
            this.f20652b.M(com.google.android.exoplayer2.util.j0.f22995f);
        }

        public final BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j10, long j11) {
            int i10 = -1;
            long j12 = -9223372036854775807L;
            int i11 = -1;
            while (parsableByteArray.a() >= 4) {
                if (w.k(parsableByteArray.d(), parsableByteArray.e()) != 442) {
                    parsableByteArray.Q(1);
                } else {
                    parsableByteArray.Q(4);
                    long l10 = x.l(parsableByteArray);
                    if (l10 != -9223372036854775807L) {
                        long b4 = this.f20651a.b(l10);
                        if (b4 > j10) {
                            if (j12 == -9223372036854775807L) {
                                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(b4, j11);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j11 + i11);
                        }
                        if (100000 + b4 > j10) {
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j11 + parsableByteArray.e());
                        }
                        i11 = parsableByteArray.e();
                        j12 = b4;
                    }
                    d(parsableByteArray);
                    i10 = parsableByteArray.e();
                }
            }
            if (j12 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j12, j11 + i10);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        public b(com.google.android.exoplayer2.util.f0 f0Var) {
            this.f20651a = f0Var;
            this.f20652b = new ParsableByteArray();
        }
    }

    public w(com.google.android.exoplayer2.util.f0 f0Var, long j10, long j11) {
        super(new BinarySearchSeeker.b(), new b(f0Var), j10, 0L, j10 + 1, 0L, j11, 188L, 1000);
    }

    public static int k(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }
}
