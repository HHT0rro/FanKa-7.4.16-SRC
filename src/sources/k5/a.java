package k5;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d5.d;
import d5.e;
import d5.n;
import java.io.IOException;

/* compiled from: RawCcExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final Format f50655a;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f50657c;

    /* renamed from: e, reason: collision with root package name */
    public int f50659e;

    /* renamed from: f, reason: collision with root package name */
    public long f50660f;

    /* renamed from: g, reason: collision with root package name */
    public int f50661g;

    /* renamed from: h, reason: collision with root package name */
    public int f50662h;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f50656b = new ParsableByteArray(9);

    /* renamed from: d, reason: collision with root package name */
    public int f50658d = 0;

    public a(Format format) {
        this.f50655a = format;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f50658d = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(e eVar) {
        eVar.r(new i.b(-9223372036854775807L));
        TrackOutput c4 = eVar.c(0, 3);
        this.f50657c = c4;
        c4.b(this.f50655a);
        eVar.l();
    }

    public final boolean c(d dVar) throws IOException {
        this.f50656b.L(8);
        if (!dVar.f(this.f50656b.d(), 0, 8, true)) {
            return false;
        }
        if (this.f50656b.n() == 1380139777) {
            this.f50659e = this.f50656b.D();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    public final void d(d dVar) throws IOException {
        while (this.f50661g > 0) {
            this.f50656b.L(3);
            dVar.readFully(this.f50656b.d(), 0, 3);
            this.f50657c.a(this.f50656b, 3);
            this.f50662h += 3;
            this.f50661g--;
        }
        int i10 = this.f50662h;
        if (i10 > 0) {
            this.f50657c.d(this.f50660f, 1, i10, 0, null);
        }
    }

    public final boolean e(d dVar) throws IOException {
        int i10 = this.f50659e;
        if (i10 == 0) {
            this.f50656b.L(5);
            if (!dVar.f(this.f50656b.d(), 0, 5, true)) {
                return false;
            }
            this.f50660f = (this.f50656b.F() * 1000) / 45;
        } else if (i10 == 1) {
            this.f50656b.L(9);
            if (!dVar.f(this.f50656b.d(), 0, 9, true)) {
                return false;
            }
            this.f50660f = this.f50656b.w();
        } else {
            StringBuilder sb2 = new StringBuilder(39);
            sb2.append("Unsupported version number: ");
            sb2.append(i10);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
        this.f50661g = this.f50656b.D();
        this.f50662h = 0;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d dVar, n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f50657c);
        while (true) {
            int i10 = this.f50658d;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        d(dVar);
                        this.f50658d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                }
                if (e(dVar)) {
                    this.f50658d = 2;
                } else {
                    this.f50658d = 0;
                    return -1;
                }
            } else {
                if (!c(dVar)) {
                    return -1;
                }
                this.f50658d = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d dVar) throws IOException {
        this.f50656b.L(8);
        dVar.j(this.f50656b.d(), 0, 8);
        return this.f50656b.n() == 1380139777;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
