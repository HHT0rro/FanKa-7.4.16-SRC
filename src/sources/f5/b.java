package f5;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.g;
import d5.j;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FlacBinarySearchSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends BinarySearchSeeker {

    /* compiled from: FlacBinarySearchSeeker.java */
    /* renamed from: f5.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0732b implements BinarySearchSeeker.e {

        /* renamed from: a, reason: collision with root package name */
        public final g f49114a;

        /* renamed from: b, reason: collision with root package name */
        public final int f49115b;

        /* renamed from: c, reason: collision with root package name */
        public final j.a f49116c;

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public BinarySearchSeeker.TimestampSearchResult a(d5.d dVar, long j10) throws IOException {
            long position = dVar.getPosition();
            long c4 = c(dVar);
            long o10 = dVar.o();
            dVar.q(Math.max(6, this.f49114a.f20061c));
            long c10 = c(dVar);
            long o11 = dVar.o();
            if (c4 <= j10 && c10 > j10) {
                return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(o10);
            }
            if (c10 <= j10) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(c10, o11);
            }
            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(c4, position);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.e
        public /* synthetic */ void b() {
            d5.a.a(this);
        }

        public final long c(d5.d dVar) throws IOException {
            while (dVar.o() < dVar.b() - 6 && !j.h(dVar, this.f49114a, this.f49115b, this.f49116c)) {
                dVar.q(1);
            }
            if (dVar.o() >= dVar.b() - 6) {
                dVar.q((int) (dVar.b() - dVar.o()));
                return this.f49114a.f20068j;
            }
            return this.f49116c.f48636a;
        }

        public C0732b(g gVar, int i10) {
            this.f49114a = gVar;
            this.f49115b = i10;
            this.f49116c = new j.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final g gVar, int i10, long j10, long j11) {
        super(new BinarySearchSeeker.d() { // from class: f5.a
            @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.d
            public final long a(long j12) {
                return g.this.j(j12);
            }
        }, new C0732b(gVar, i10), gVar.g(), 0L, gVar.f20068j, j10, j11, gVar.e(), Math.max(6, gVar.f20061c));
        Objects.requireNonNull(gVar);
    }
}
