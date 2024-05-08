package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.p;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: HlsSampleStreamWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p implements Loader.b<x5.f>, Loader.f, m0, d5.e, l0.d {
    public static final Set<Integer> Y = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public Format F;

    @Nullable
    public Format G;
    public boolean H;
    public TrackGroupArray I;
    public Set<TrackGroup> J;
    public int[] K;
    public int L;
    public boolean M;
    public boolean[] N;
    public boolean[] O;
    public long P;
    public long Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public long V;

    @Nullable
    public DrmInitData W;

    @Nullable
    public i X;

    /* renamed from: b, reason: collision with root package name */
    public final int f21577b;

    /* renamed from: c, reason: collision with root package name */
    public final b f21578c;

    /* renamed from: d, reason: collision with root package name */
    public final e f21579d;

    /* renamed from: e, reason: collision with root package name */
    public final o6.b f21580e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Format f21581f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21582g;

    /* renamed from: h, reason: collision with root package name */
    public final b.a f21583h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21584i;

    /* renamed from: k, reason: collision with root package name */
    public final z.a f21586k;

    /* renamed from: l, reason: collision with root package name */
    public final int f21587l;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<i> f21589n;

    /* renamed from: o, reason: collision with root package name */
    public final List<i> f21590o;

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f21591p;

    /* renamed from: q, reason: collision with root package name */
    public final Runnable f21592q;

    /* renamed from: r, reason: collision with root package name */
    public final Handler f21593r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList<l> f21594s;

    /* renamed from: t, reason: collision with root package name */
    public final Map<String, DrmInitData> f21595t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public x5.f f21596u;

    /* renamed from: v, reason: collision with root package name */
    public d[] f21597v;

    /* renamed from: x, reason: collision with root package name */
    public Set<Integer> f21599x;

    /* renamed from: y, reason: collision with root package name */
    public SparseIntArray f21600y;

    /* renamed from: z, reason: collision with root package name */
    public TrackOutput f21601z;

    /* renamed from: j, reason: collision with root package name */
    public final Loader f21585j = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: m, reason: collision with root package name */
    public final e.b f21588m = new e.b();

    /* renamed from: w, reason: collision with root package name */
    public int[] f21598w = new int[0];

    /* compiled from: HlsSampleStreamWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b extends m0.a<p> {
        void l(Uri uri);

        void onPrepared();
    }

    /* compiled from: HlsSampleStreamWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c implements TrackOutput {

        /* renamed from: g, reason: collision with root package name */
        public static final Format f21602g = new Format.b().e0("application/id3").E();

        /* renamed from: h, reason: collision with root package name */
        public static final Format f21603h = new Format.b().e0("application/x-emsg").E();

        /* renamed from: a, reason: collision with root package name */
        public final p5.a f21604a = new p5.a();

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f21605b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f21606c;

        /* renamed from: d, reason: collision with root package name */
        public Format f21607d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f21608e;

        /* renamed from: f, reason: collision with root package name */
        public int f21609f;

        public c(TrackOutput trackOutput, int i10) {
            this.f21605b = trackOutput;
            if (i10 == 1) {
                this.f21606c = f21602g;
            } else if (i10 == 3) {
                this.f21606c = f21603h;
            } else {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unknown metadataType: ");
                sb2.append(i10);
                throw new IllegalArgumentException(sb2.toString());
            }
            this.f21608e = new byte[0];
            this.f21609f = 0;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void a(ParsableByteArray parsableByteArray, int i10) {
            d5.p.b(this, parsableByteArray, i10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void b(Format format) {
            this.f21607d = format;
            this.f21605b.b(this.f21606c);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int c(o6.g gVar, int i10, boolean z10) {
            return d5.p.a(this, gVar, i10, z10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void d(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
            com.google.android.exoplayer2.util.a.e(this.f21607d);
            ParsableByteArray i13 = i(i11, i12);
            if (!j0.c(this.f21607d.f19544m, this.f21606c.f19544m)) {
                if ("application/x-emsg".equals(this.f21607d.f19544m)) {
                    EventMessage c4 = this.f21604a.c(i13);
                    if (!g(c4)) {
                        com.google.android.exoplayer2.util.m.h("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f21606c.f19544m, c4.getWrappedMetadataFormat()));
                        return;
                    }
                    i13 = new ParsableByteArray((byte[]) com.google.android.exoplayer2.util.a.e(c4.getWrappedMetadataBytes()));
                } else {
                    String valueOf = String.valueOf(this.f21607d.f19544m);
                    com.google.android.exoplayer2.util.m.h("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                }
            }
            int a10 = i13.a();
            this.f21605b.a(i13, a10);
            this.f21605b.d(j10, i10, a10, i12, cryptoData);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int e(o6.g gVar, int i10, boolean z10, int i11) throws IOException {
            h(this.f21609f + i10);
            int read = gVar.read(this.f21608e, this.f21609f, i10);
            if (read != -1) {
                this.f21609f += read;
                return read;
            }
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(ParsableByteArray parsableByteArray, int i10, int i11) {
            h(this.f21609f + i10);
            parsableByteArray.j(this.f21608e, this.f21609f, i10);
            this.f21609f += i10;
        }

        public final boolean g(EventMessage eventMessage) {
            Format wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && j0.c(this.f21606c.f19544m, wrappedMetadataFormat.f19544m);
        }

        public final void h(int i10) {
            byte[] bArr = this.f21608e;
            if (bArr.length < i10) {
                this.f21608e = Arrays.copyOf(bArr, i10 + (i10 / 2));
            }
        }

        public final ParsableByteArray i(int i10, int i11) {
            int i12 = this.f21609f - i11;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f21608e, i12 - i10, i12));
            byte[] bArr = this.f21608e;
            System.arraycopy((Object) bArr, i12, (Object) bArr, 0, i11);
            this.f21609f = i11;
            return parsableByteArray;
        }
    }

    /* compiled from: HlsSampleStreamWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends l0 {
        public final Map<String, DrmInitData> I;

        @Nullable
        public DrmInitData J;

        @Override // com.google.android.exoplayer2.source.l0, com.google.android.exoplayer2.extractor.TrackOutput
        public void d(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
            super.d(j10, i10, i11, i12, cryptoData);
        }

        @Nullable
        public final Metadata h0(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int d10 = metadata.d();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= d10) {
                    i11 = -1;
                    break;
                }
                Metadata.Entry c4 = metadata.c(i11);
                if ((c4 instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) c4).f20912c)) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return metadata;
            }
            if (d10 == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[d10 - 1];
            while (i10 < d10) {
                if (i10 != i11) {
                    entryArr[i10 < i11 ? i10 : i10 - 1] = metadata.c(i10);
                }
                i10++;
            }
            return new Metadata(entryArr);
        }

        public void i0(@Nullable DrmInitData drmInitData) {
            this.J = drmInitData;
            I();
        }

        public void j0(i iVar) {
            f0(iVar.f21532k);
        }

        @Override // com.google.android.exoplayer2.source.l0
        public Format w(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.J;
            if (drmInitData2 == null) {
                drmInitData2 = format.f19547p;
            }
            if (drmInitData2 != null && (drmInitData = this.I.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata h02 = h0(format.f19542k);
            if (drmInitData2 != format.f19547p || h02 != format.f19542k) {
                format = format.a().L(drmInitData2).X(h02).E();
            }
            return super.w(format);
        }

        public d(o6.b bVar, Looper looper, com.google.android.exoplayer2.drm.c cVar, b.a aVar, Map<String, DrmInitData> map) {
            super(bVar, looper, cVar, aVar);
            this.I = map;
        }
    }

    public p(int i10, b bVar, e eVar, Map<String, DrmInitData> map, o6.b bVar2, long j10, @Nullable Format format, com.google.android.exoplayer2.drm.c cVar, b.a aVar, com.google.android.exoplayer2.upstream.h hVar, z.a aVar2, int i11) {
        this.f21577b = i10;
        this.f21578c = bVar;
        this.f21579d = eVar;
        this.f21595t = map;
        this.f21580e = bVar2;
        this.f21581f = format;
        this.f21582g = cVar;
        this.f21583h = aVar;
        this.f21584i = hVar;
        this.f21586k = aVar2;
        this.f21587l = i11;
        Set<Integer> set = Y;
        this.f21599x = new HashSet(set.size());
        this.f21600y = new SparseIntArray(set.size());
        this.f21597v = new d[0];
        this.O = new boolean[0];
        this.N = new boolean[0];
        ArrayList<i> arrayList = new ArrayList<>();
        this.f21589n = arrayList;
        this.f21590o = Collections.unmodifiableList(arrayList);
        this.f21594s = new ArrayList<>();
        this.f21591p = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                p.this.R();
            }
        };
        this.f21592q = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.n
            @Override // java.lang.Runnable
            public final void run() {
                p.this.a0();
            }
        };
        this.f21593r = j0.x();
        this.P = j10;
        this.Q = j10;
    }

    public static com.google.android.exoplayer2.extractor.d B(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Unmapped track with id ");
        sb2.append(i10);
        sb2.append(" of type ");
        sb2.append(i11);
        com.google.android.exoplayer2.util.m.h("HlsSampleStreamWrapper", sb2.toString());
        return new com.google.android.exoplayer2.extractor.d();
    }

    public static Format E(@Nullable Format format, Format format2, boolean z10) {
        String d10;
        String str;
        if (format == null) {
            return format2;
        }
        int l10 = com.google.android.exoplayer2.util.q.l(format2.f19544m);
        if (j0.J(format.f19541j, l10) == 1) {
            d10 = j0.K(format.f19541j, l10);
            str = com.google.android.exoplayer2.util.q.g(d10);
        } else {
            d10 = com.google.android.exoplayer2.util.q.d(format.f19541j, format2.f19544m);
            str = format2.f19544m;
        }
        Format.b I = format2.a().S(format.f19533b).U(format.f19534c).V(format.f19535d).g0(format.f19536e).c0(format.f19537f).G(z10 ? format.f19538g : -1).Z(z10 ? format.f19539h : -1).I(d10);
        if (l10 == 2) {
            I.j0(format.f19549r).Q(format.f19550s).P(format.f19551t);
        }
        if (str != null) {
            I.e0(str);
        }
        int i10 = format.f19557z;
        if (i10 != -1 && l10 == 1) {
            I.H(i10);
        }
        Metadata metadata = format.f19542k;
        if (metadata != null) {
            Metadata metadata2 = format2.f19542k;
            if (metadata2 != null) {
                metadata = metadata2.b(metadata);
            }
            I.X(metadata);
        }
        return I.E();
    }

    public static boolean I(Format format, Format format2) {
        String str = format.f19544m;
        String str2 = format2.f19544m;
        int l10 = com.google.android.exoplayer2.util.q.l(str);
        if (l10 != 3) {
            return l10 == com.google.android.exoplayer2.util.q.l(str2);
        }
        if (j0.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || format.E == format2.E;
        }
        return false;
    }

    public static int L(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 1;
        }
        return 3;
    }

    public static boolean N(x5.f fVar) {
        return fVar instanceof i;
    }

    public void A() {
        if (this.D) {
            return;
        }
        b(this.P);
    }

    public final l0 C(int i10, int i11) {
        int length = this.f21597v.length;
        boolean z10 = true;
        if (i11 != 1 && i11 != 2) {
            z10 = false;
        }
        d dVar = new d(this.f21580e, this.f21593r.getLooper(), this.f21582g, this.f21583h, this.f21595t);
        dVar.b0(this.P);
        if (z10) {
            dVar.i0(this.W);
        }
        dVar.a0(this.V);
        i iVar = this.X;
        if (iVar != null) {
            dVar.j0(iVar);
        }
        dVar.d0(this);
        int i12 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f21598w, i12);
        this.f21598w = copyOf;
        copyOf[length] = i10;
        this.f21597v = (d[]) j0.y0(this.f21597v, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.O, i12);
        this.O = copyOf2;
        copyOf2[length] = z10;
        this.M = copyOf2[length] | this.M;
        this.f21599x.add(Integer.valueOf(i11));
        this.f21600y.append(i11, length);
        if (L(i11) > L(this.A)) {
            this.B = length;
            this.A = i11;
        }
        this.N = Arrays.copyOf(this.N, i12);
        return dVar;
    }

    public final TrackGroupArray D(TrackGroup[] trackGroupArr) {
        for (int i10 = 0; i10 < trackGroupArr.length; i10++) {
            TrackGroup trackGroup = trackGroupArr[i10];
            Format[] formatArr = new Format[trackGroup.f21168b];
            for (int i11 = 0; i11 < trackGroup.f21168b; i11++) {
                Format a10 = trackGroup.a(i11);
                formatArr[i11] = a10.b(this.f21582g.c(a10));
            }
            trackGroupArr[i10] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    public final void F(int i10) {
        com.google.android.exoplayer2.util.a.g(!this.f21585j.j());
        while (true) {
            if (i10 >= this.f21589n.size()) {
                i10 = -1;
                break;
            } else if (z(i10)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        long j10 = J().f54513h;
        i G = G(i10);
        if (this.f21589n.isEmpty()) {
            this.Q = this.P;
        } else {
            ((i) g0.f(this.f21589n)).n();
        }
        this.T = false;
        this.f21586k.D(this.A, G.f54512g, j10);
    }

    public final i G(int i10) {
        i iVar = this.f21589n.get(i10);
        ArrayList<i> arrayList = this.f21589n;
        j0.G0(arrayList, i10, arrayList.size());
        for (int i11 = 0; i11 < this.f21597v.length; i11++) {
            this.f21597v[i11].u(iVar.l(i11));
        }
        return iVar;
    }

    public final boolean H(i iVar) {
        int i10 = iVar.f21532k;
        int length = this.f21597v.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.N[i11] && this.f21597v[i11].Q() == i10) {
                return false;
            }
        }
        return true;
    }

    public final i J() {
        return this.f21589n.get(r0.size() - 1);
    }

    @Nullable
    public final TrackOutput K(int i10, int i11) {
        com.google.android.exoplayer2.util.a.a(Y.contains(Integer.valueOf(i11)));
        int i12 = this.f21600y.get(i11, -1);
        if (i12 == -1) {
            return null;
        }
        if (this.f21599x.add(Integer.valueOf(i11))) {
            this.f21598w[i12] = i10;
        }
        if (this.f21598w[i12] == i10) {
            return this.f21597v[i12];
        }
        return B(i10, i11);
    }

    public final void M(i iVar) {
        this.X = iVar;
        this.F = iVar.f54509d;
        this.Q = -9223372036854775807L;
        this.f21589n.add(iVar);
        ImmutableList.a builder = ImmutableList.builder();
        for (d dVar : this.f21597v) {
            builder.a(Integer.valueOf(dVar.G()));
        }
        iVar.m(this, builder.k());
        for (d dVar2 : this.f21597v) {
            dVar2.j0(iVar);
            if (iVar.f21535n) {
                dVar2.g0();
            }
        }
    }

    public final boolean O() {
        return this.Q != -9223372036854775807L;
    }

    public boolean P(int i10) {
        return !O() && this.f21597v[i10].K(this.T);
    }

    public final void Q() {
        int i10 = this.I.f21172b;
        int[] iArr = new int[i10];
        this.K = iArr;
        Arrays.fill(iArr, -1);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = 0;
            while (true) {
                d[] dVarArr = this.f21597v;
                if (i12 >= dVarArr.length) {
                    break;
                }
                if (I((Format) com.google.android.exoplayer2.util.a.i(dVarArr[i12].F()), this.I.a(i11).a(0))) {
                    this.K[i11] = i12;
                    break;
                }
                i12++;
            }
        }
        Iterator<l> iterator2 = this.f21594s.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b();
        }
    }

    public final void R() {
        if (!this.H && this.K == null && this.C) {
            for (d dVar : this.f21597v) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.I != null) {
                Q();
                return;
            }
            y();
            j0();
            this.f21578c.onPrepared();
        }
    }

    public void S() throws IOException {
        this.f21585j.a();
        this.f21579d.m();
    }

    public void T(int i10) throws IOException {
        S();
        this.f21597v[i10].N();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void n(x5.f fVar, long j10, long j11, boolean z10) {
        this.f21596u = null;
        com.google.android.exoplayer2.source.m mVar = new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, fVar.e(), fVar.d(), j10, j11, fVar.a());
        this.f21584i.c(fVar.f54506a);
        this.f21586k.r(mVar, fVar.f54508c, this.f21577b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        if (z10) {
            return;
        }
        if (O() || this.E == 0) {
            e0();
        }
        if (this.E > 0) {
            this.f21578c.k(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void o(x5.f fVar, long j10, long j11) {
        this.f21596u = null;
        this.f21579d.o(fVar);
        com.google.android.exoplayer2.source.m mVar = new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, fVar.e(), fVar.d(), j10, j11, fVar.a());
        this.f21584i.c(fVar.f54506a);
        this.f21586k.u(mVar, fVar.f54508c, this.f21577b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        if (!this.D) {
            b(this.P);
        } else {
            this.f21578c.k(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Loader.c q(x5.f fVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c cVar;
        int i11;
        boolean N = N(fVar);
        if (N && !((i) fVar).p() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i11 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i11 == 404)) {
            return Loader.f22730d;
        }
        long a10 = fVar.a();
        com.google.android.exoplayer2.source.m mVar = new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, fVar.e(), fVar.d(), j10, j11, a10);
        h.c cVar2 = new h.c(mVar, new MediaLoadData(fVar.f54508c, this.f21577b, fVar.f54509d, fVar.f54510e, fVar.f54511f, com.google.android.exoplayer2.h.e(fVar.f54512g), com.google.android.exoplayer2.h.e(fVar.f54513h)), iOException, i10);
        h.b b4 = this.f21584i.b(com.google.android.exoplayer2.trackselection.c.a(this.f21579d.j()), cVar2);
        boolean l10 = (b4 == null || b4.f22890a != 2) ? false : this.f21579d.l(fVar, b4.f22891b);
        if (l10) {
            if (N && a10 == 0) {
                ArrayList<i> arrayList = this.f21589n;
                com.google.android.exoplayer2.util.a.g(arrayList.remove(arrayList.size() - 1) == fVar);
                if (this.f21589n.isEmpty()) {
                    this.Q = this.P;
                } else {
                    ((i) g0.f(this.f21589n)).n();
                }
            }
            cVar = Loader.f22732f;
        } else {
            long a11 = this.f21584i.a(cVar2);
            if (a11 != -9223372036854775807L) {
                cVar = Loader.h(false, a11);
            } else {
                cVar = Loader.f22733g;
            }
        }
        Loader.c cVar3 = cVar;
        boolean z10 = !cVar3.c();
        this.f21586k.w(mVar, fVar.f54508c, this.f21577b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h, iOException, z10);
        if (z10) {
            this.f21596u = null;
            this.f21584i.c(fVar.f54506a);
        }
        if (l10) {
            if (!this.D) {
                b(this.P);
            } else {
                this.f21578c.k(this);
            }
        }
        return cVar3;
    }

    public void X() {
        this.f21599x.clear();
    }

    public boolean Y(Uri uri, h.c cVar, boolean z10) {
        h.b b4;
        if (!this.f21579d.n(uri)) {
            return true;
        }
        long j10 = (z10 || (b4 = this.f21584i.b(com.google.android.exoplayer2.trackselection.c.a(this.f21579d.j()), cVar)) == null || b4.f22890a != 2) ? -9223372036854775807L : b4.f22891b;
        return this.f21579d.p(uri, j10) && j10 != -9223372036854775807L;
    }

    public void Z() {
        if (this.f21589n.isEmpty()) {
            return;
        }
        i iVar = (i) g0.f(this.f21589n);
        int b4 = this.f21579d.b(iVar);
        if (b4 == 1) {
            iVar.u();
        } else if (b4 == 2 && !this.T && this.f21585j.j()) {
            this.f21585j.f();
        }
    }

    @Override // com.google.android.exoplayer2.source.l0.d
    public void a(Format format) {
        this.f21593r.post(this.f21591p);
    }

    public final void a0() {
        this.C = true;
        R();
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        List<i> list;
        long max;
        if (this.T || this.f21585j.j() || this.f21585j.i()) {
            return false;
        }
        if (O()) {
            list = Collections.emptyList();
            max = this.Q;
            for (d dVar : this.f21597v) {
                dVar.b0(this.Q);
            }
        } else {
            list = this.f21590o;
            i J = J();
            if (J.g()) {
                max = J.f54513h;
            } else {
                max = Math.max(this.P, J.f54512g);
            }
        }
        List<i> list2 = list;
        long j11 = max;
        this.f21588m.a();
        this.f21579d.d(j10, j11, list2, this.D || !list2.isEmpty(), this.f21588m);
        e.b bVar = this.f21588m;
        boolean z10 = bVar.f21519b;
        x5.f fVar = bVar.f21518a;
        Uri uri = bVar.f21520c;
        if (z10) {
            this.Q = -9223372036854775807L;
            this.T = true;
            return true;
        }
        if (fVar == null) {
            if (uri != null) {
                this.f21578c.l(uri);
            }
            return false;
        }
        if (N(fVar)) {
            M((i) fVar);
        }
        this.f21596u = fVar;
        this.f21586k.A(new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, this.f21585j.n(fVar, this, this.f21584i.d(fVar.f54508c))), fVar.f54508c, this.f21577b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        return true;
    }

    public void b0(TrackGroup[] trackGroupArr, int i10, int... iArr) {
        this.I = D(trackGroupArr);
        this.J = new HashSet();
        for (int i11 : iArr) {
            this.J.add(this.I.a(i11));
        }
        this.L = i10;
        Handler handler = this.f21593r;
        final b bVar = this.f21578c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.m
            @Override // java.lang.Runnable
            public final void run() {
                p.b.this.onPrepared();
            }
        });
        j0();
    }

    @Override // d5.e
    public TrackOutput c(int i10, int i11) {
        TrackOutput trackOutput;
        if (!Y.contains(Integer.valueOf(i11))) {
            int i12 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.f21597v;
                if (i12 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                }
                if (this.f21598w[i12] == i10) {
                    trackOutput = trackOutputArr[i12];
                    break;
                }
                i12++;
            }
        } else {
            trackOutput = K(i10, i11);
        }
        if (trackOutput == null) {
            if (this.U) {
                return B(i10, i11);
            }
            trackOutput = C(i10, i11);
        }
        if (i11 != 5) {
            return trackOutput;
        }
        if (this.f21601z == null) {
            this.f21601z = new c(trackOutput, this.f21587l);
        }
        return this.f21601z;
    }

    public int c0(int i10, s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        Format format;
        if (O()) {
            return -3;
        }
        int i12 = 0;
        if (!this.f21589n.isEmpty()) {
            int i13 = 0;
            while (i13 < this.f21589n.size() - 1 && H(this.f21589n.get(i13))) {
                i13++;
            }
            j0.G0(this.f21589n, 0, i13);
            i iVar = this.f21589n.get(0);
            Format format2 = iVar.f54509d;
            if (!format2.equals(this.G)) {
                this.f21586k.i(this.f21577b, format2, iVar.f54510e, iVar.f54511f, iVar.f54512g);
            }
            this.G = format2;
        }
        if (!this.f21589n.isEmpty() && !this.f21589n.get(0).p()) {
            return -3;
        }
        int S = this.f21597v[i10].S(s0Var, decoderInputBuffer, i11, this.T);
        if (S == -5) {
            Format format3 = (Format) com.google.android.exoplayer2.util.a.e(s0Var.f21132b);
            if (i10 == this.B) {
                int Q = this.f21597v[i10].Q();
                while (i12 < this.f21589n.size() && this.f21589n.get(i12).f21532k != Q) {
                    i12++;
                }
                if (i12 < this.f21589n.size()) {
                    format = this.f21589n.get(i12).f54509d;
                } else {
                    format = (Format) com.google.android.exoplayer2.util.a.e(this.F);
                }
                format3 = format3.e(format);
            }
            s0Var.f21132b = format3;
        }
        return S;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
        */
    @Override // com.google.android.exoplayer2.source.m0
    public long d() {
        /*
            r7 = this;
            boolean r0 = r7.T
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.O()
            if (r0 == 0) goto L10
            long r0 = r7.Q
            return r0
        L10:
            long r0 = r7.P
            com.google.android.exoplayer2.source.hls.i r2 = r7.J()
            boolean r3 = r2.g()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.i> r2 = r7.f21589n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.i> r2 = r7.f21589n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.i r2 = (com.google.android.exoplayer2.source.hls.i) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.f54513h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.C
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.p$d[] r2 = r7.f21597v
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.p.d():long");
    }

    public void d0() {
        if (this.D) {
            for (d dVar : this.f21597v) {
                dVar.R();
            }
        }
        this.f21585j.m(this);
        this.f21593r.removeCallbacksAndMessages(null);
        this.H = true;
        this.f21594s.clear();
    }

    @Override // com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        if (this.f21585j.i() || O()) {
            return;
        }
        if (this.f21585j.j()) {
            com.google.android.exoplayer2.util.a.e(this.f21596u);
            if (this.f21579d.u(j10, this.f21596u, this.f21590o)) {
                this.f21585j.f();
                return;
            }
            return;
        }
        int size = this.f21590o.size();
        while (size > 0 && this.f21579d.b(this.f21590o.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f21590o.size()) {
            F(size);
        }
        int g3 = this.f21579d.g(j10, this.f21590o);
        if (g3 < this.f21589n.size()) {
            F(g3);
        }
    }

    public final void e0() {
        for (d dVar : this.f21597v) {
            dVar.W(this.R);
        }
        this.R = false;
    }

    @Override // com.google.android.exoplayer2.source.m0
    public long f() {
        if (O()) {
            return this.Q;
        }
        if (this.T) {
            return Long.MIN_VALUE;
        }
        return J().f54513h;
    }

    public final boolean f0(long j10) {
        int length = this.f21597v.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.f21597v[i10].Z(j10, false) && (this.O[i10] || !this.M)) {
                return false;
            }
        }
        return true;
    }

    public boolean g0(long j10, boolean z10) {
        this.P = j10;
        if (O()) {
            this.Q = j10;
            return true;
        }
        if (this.C && !z10 && f0(j10)) {
            return false;
        }
        this.Q = j10;
        this.T = false;
        this.f21589n.clear();
        if (this.f21585j.j()) {
            if (this.C) {
                for (d dVar : this.f21597v) {
                    dVar.r();
                }
            }
            this.f21585j.f();
        } else {
            this.f21585j.g();
            e0();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean h0(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.p.h0(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void i0(@Nullable DrmInitData drmInitData) {
        if (j0.c(this.W, drmInitData)) {
            return;
        }
        this.W = drmInitData;
        int i10 = 0;
        while (true) {
            d[] dVarArr = this.f21597v;
            if (i10 >= dVarArr.length) {
                return;
            }
            if (this.O[i10]) {
                dVarArr[i10].i0(drmInitData);
            }
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21585j.j();
    }

    public final void j0() {
        this.D = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void k() {
        for (d dVar : this.f21597v) {
            dVar.T();
        }
    }

    public void k0(boolean z10) {
        this.f21579d.s(z10);
    }

    @Override // d5.e
    public void l() {
        this.U = true;
        this.f21593r.post(this.f21592q);
    }

    public void l0(long j10) {
        if (this.V != j10) {
            this.V = j10;
            for (d dVar : this.f21597v) {
                dVar.a0(j10);
            }
        }
    }

    public TrackGroupArray m() {
        w();
        return this.I;
    }

    public int m0(int i10, long j10) {
        if (O()) {
            return 0;
        }
        d dVar = this.f21597v[i10];
        int E = dVar.E(j10, this.T);
        i iVar = (i) g0.g(this.f21589n, null);
        if (iVar != null && !iVar.p()) {
            E = Math.min(E, iVar.l(i10) - dVar.C());
        }
        dVar.e0(E);
        return E;
    }

    public void n0(int i10) {
        w();
        com.google.android.exoplayer2.util.a.e(this.K);
        int i11 = this.K[i10];
        com.google.android.exoplayer2.util.a.g(this.N[i11]);
        this.N[i11] = false;
    }

    public final void o0(SampleStream[] sampleStreamArr) {
        this.f21594s.clear();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.f21594s.add((l) sampleStream);
            }
        }
    }

    @Override // d5.e
    public void r(com.google.android.exoplayer2.extractor.i iVar) {
    }

    public void s() throws IOException {
        S();
        if (this.T && !this.D) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    public void t(long j10, boolean z10) {
        if (!this.C || O()) {
            return;
        }
        int length = this.f21597v.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f21597v[i10].q(j10, z10, this.N[i10]);
        }
    }

    public final void w() {
        com.google.android.exoplayer2.util.a.g(this.D);
        com.google.android.exoplayer2.util.a.e(this.I);
        com.google.android.exoplayer2.util.a.e(this.J);
    }

    public int x(int i10) {
        w();
        com.google.android.exoplayer2.util.a.e(this.K);
        int i11 = this.K[i10];
        if (i11 == -1) {
            return this.J.contains(this.I.a(i10)) ? -3 : -2;
        }
        boolean[] zArr = this.N;
        if (zArr[i11]) {
            return -2;
        }
        zArr[i11] = true;
        return i11;
    }

    public final void y() {
        int length = this.f21597v.length;
        int i10 = 0;
        int i11 = 7;
        int i12 = -1;
        while (true) {
            int i13 = 2;
            if (i10 >= length) {
                break;
            }
            String str = ((Format) com.google.android.exoplayer2.util.a.i(this.f21597v[i10].F())).f19544m;
            if (!com.google.android.exoplayer2.util.q.s(str)) {
                if (com.google.android.exoplayer2.util.q.p(str)) {
                    i13 = 1;
                } else {
                    i13 = com.google.android.exoplayer2.util.q.r(str) ? 3 : 7;
                }
            }
            if (L(i13) > L(i11)) {
                i12 = i10;
                i11 = i13;
            } else if (i13 == i11 && i12 != -1) {
                i12 = -1;
            }
            i10++;
        }
        TrackGroup i14 = this.f21579d.i();
        int i15 = i14.f21168b;
        this.L = -1;
        this.K = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.K[i16] = i16;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i17 = 0; i17 < length; i17++) {
            Format format = (Format) com.google.android.exoplayer2.util.a.i(this.f21597v[i17].F());
            if (i17 == i12) {
                Format[] formatArr = new Format[i15];
                if (i15 == 1) {
                    formatArr[0] = format.e(i14.a(0));
                } else {
                    for (int i18 = 0; i18 < i15; i18++) {
                        formatArr[i18] = E(i14.a(i18), format, true);
                    }
                }
                trackGroupArr[i17] = new TrackGroup(formatArr);
                this.L = i17;
            } else {
                trackGroupArr[i17] = new TrackGroup(E((i11 == 2 && com.google.android.exoplayer2.util.q.p(format.f19544m)) ? this.f21581f : null, format, false));
            }
        }
        this.I = D(trackGroupArr);
        com.google.android.exoplayer2.util.a.g(this.J == null);
        this.J = Collections.emptySet();
    }

    public final boolean z(int i10) {
        for (int i11 = i10; i11 < this.f21589n.size(); i11++) {
            if (this.f21589n.get(i11).f21535n) {
                return false;
            }
        }
        i iVar = this.f21589n.get(i10);
        for (int i12 = 0; i12 < this.f21597v.length; i12++) {
            if (this.f21597v[i12].C() > iVar.l(i12)) {
                return false;
            }
        }
        return true;
    }
}
