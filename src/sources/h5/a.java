package h5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.huawei.openalliance.ad.constant.bb;
import d5.n;
import java.io.IOException;

/* compiled from: JpegExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Extractor {

    /* renamed from: b, reason: collision with root package name */
    public d5.e f49501b;

    /* renamed from: c, reason: collision with root package name */
    public int f49502c;

    /* renamed from: d, reason: collision with root package name */
    public int f49503d;

    /* renamed from: e, reason: collision with root package name */
    public int f49504e;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f49506g;

    /* renamed from: h, reason: collision with root package name */
    public d5.d f49507h;

    /* renamed from: i, reason: collision with root package name */
    public c f49508i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public j f49509j;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f49500a = new ParsableByteArray(6);

    /* renamed from: f, reason: collision with root package name */
    public long f49505f = -1;

    @Nullable
    public static MotionPhotoMetadata e(String str, long j10) throws IOException {
        b a10;
        if (j10 == -1 || (a10 = e.a(str)) == null) {
            return null;
        }
        return a10.a(j10);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        if (j10 == 0) {
            this.f49502c = 0;
            this.f49509j = null;
        } else if (this.f49502c == 5) {
            ((j) com.google.android.exoplayer2.util.a.e(this.f49509j)).a(j10, j11);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f49501b = eVar;
    }

    public final void c(d5.d dVar) throws IOException {
        this.f49500a.L(2);
        dVar.j(this.f49500a.d(), 0, 2);
        dVar.q(this.f49500a.J() - 2);
    }

    public final void d() {
        h(new Metadata.Entry[0]);
        ((d5.e) com.google.android.exoplayer2.util.a.e(this.f49501b)).l();
        this.f49501b.r(new i.b(-9223372036854775807L));
        this.f49502c = 6;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, n nVar) throws IOException {
        int i10 = this.f49502c;
        if (i10 == 0) {
            j(dVar);
            return 0;
        }
        if (i10 == 1) {
            l(dVar);
            return 0;
        }
        if (i10 == 2) {
            k(dVar);
            return 0;
        }
        if (i10 == 4) {
            long position = dVar.getPosition();
            long j10 = this.f49505f;
            if (position != j10) {
                nVar.f48642a = j10;
                return 1;
            }
            m(dVar);
            return 0;
        }
        if (i10 != 5) {
            if (i10 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f49508i == null || dVar != this.f49507h) {
            this.f49507h = dVar;
            this.f49508i = new c(dVar, this.f49505f);
        }
        int f10 = ((j) com.google.android.exoplayer2.util.a.e(this.f49509j)).f(this.f49508i, nVar);
        if (f10 == 1) {
            nVar.f48642a += this.f49505f;
        }
        return f10;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        if (i(dVar) != 65496) {
            return false;
        }
        int i10 = i(dVar);
        this.f49503d = i10;
        if (i10 == 65504) {
            c(dVar);
            this.f49503d = i(dVar);
        }
        if (this.f49503d != 65505) {
            return false;
        }
        dVar.q(2);
        this.f49500a.L(6);
        dVar.j(this.f49500a.d(), 0, 6);
        return this.f49500a.F() == 1165519206 && this.f49500a.J() == 0;
    }

    public final void h(Metadata.Entry... entryArr) {
        ((d5.e) com.google.android.exoplayer2.util.a.e(this.f49501b)).c(1024, 4).b(new Format.b().K(bb.V).X(new Metadata(entryArr)).E());
    }

    public final int i(d5.d dVar) throws IOException {
        this.f49500a.L(2);
        dVar.j(this.f49500a.d(), 0, 2);
        return this.f49500a.J();
    }

    public final void j(d5.d dVar) throws IOException {
        this.f49500a.L(2);
        dVar.readFully(this.f49500a.d(), 0, 2);
        int J = this.f49500a.J();
        this.f49503d = J;
        if (J == 65498) {
            if (this.f49505f != -1) {
                this.f49502c = 4;
                return;
            } else {
                d();
                return;
            }
        }
        if ((J < 65488 || J > 65497) && J != 65281) {
            this.f49502c = 1;
        }
    }

    public final void k(d5.d dVar) throws IOException {
        String x10;
        if (this.f49503d == 65505) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.f49504e);
            dVar.readFully(parsableByteArray.d(), 0, this.f49504e);
            if (this.f49506g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.x()) && (x10 = parsableByteArray.x()) != null) {
                MotionPhotoMetadata e2 = e(x10, dVar.b());
                this.f49506g = e2;
                if (e2 != null) {
                    this.f49505f = e2.f20925e;
                }
            }
        } else {
            dVar.r(this.f49504e);
        }
        this.f49502c = 0;
    }

    public final void l(d5.d dVar) throws IOException {
        this.f49500a.L(2);
        dVar.readFully(this.f49500a.d(), 0, 2);
        this.f49504e = this.f49500a.J() - 2;
        this.f49502c = 2;
    }

    public final void m(d5.d dVar) throws IOException {
        if (!dVar.l(this.f49500a.d(), 0, 1, true)) {
            d();
            return;
        }
        dVar.m();
        if (this.f49509j == null) {
            this.f49509j = new j();
        }
        c cVar = new c(dVar, this.f49505f);
        this.f49508i = cVar;
        if (this.f49509j.g(cVar)) {
            this.f49509j.b(new d(this.f49505f, (d5.e) com.google.android.exoplayer2.util.a.e(this.f49501b)));
            n();
        } else {
            d();
        }
    }

    public final void n() {
        h((Metadata.Entry) com.google.android.exoplayer2.util.a.e(this.f49506g));
        this.f49502c = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        j jVar = this.f49509j;
        if (jVar != null) {
            jVar.release();
        }
    }
}
