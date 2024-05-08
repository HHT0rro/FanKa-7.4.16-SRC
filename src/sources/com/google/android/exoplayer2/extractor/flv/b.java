package com.google.android.exoplayer2.extractor.flv;

import com.alibaba.security.biometrics.service.build.ah;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: VideoTagPayloadReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20053b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20054c;

    /* renamed from: d, reason: collision with root package name */
    public int f20055d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20056e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20057f;

    /* renamed from: g, reason: collision with root package name */
    public int f20058g;

    public b(TrackOutput trackOutput) {
        super(trackOutput);
        this.f20053b = new ParsableByteArray(NalUnitUtil.f22925a);
        this.f20054c = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int D = parsableByteArray.D();
        int i10 = (D >> 4) & 15;
        int i11 = D & 15;
        if (i11 == 7) {
            this.f20058g = i10;
            return i10 != 5;
        }
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("Video format not supported: ");
        sb2.append(i11);
        throw new TagPayloadReader.UnsupportedFormatException(sb2.toString());
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j10) throws ParserException {
        int D = parsableByteArray.D();
        long o10 = j10 + (parsableByteArray.o() * 1000);
        if (D == 0 && !this.f20056e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.j(parsableByteArray2.d(), 0, parsableByteArray.a());
            q6.a b4 = q6.a.b(parsableByteArray2);
            this.f20055d = b4.f53032b;
            this.f20048a.b(new Format.b().e0(ah.f2598d).I(b4.f53036f).j0(b4.f53033c).Q(b4.f53034d).a0(b4.f53035e).T(b4.f53031a).E());
            this.f20056e = true;
            return false;
        }
        if (D != 1 || !this.f20056e) {
            return false;
        }
        int i10 = this.f20058g == 1 ? 1 : 0;
        if (!this.f20057f && i10 == 0) {
            return false;
        }
        byte[] d10 = this.f20054c.d();
        d10[0] = 0;
        d10[1] = 0;
        d10[2] = 0;
        int i11 = 4 - this.f20055d;
        int i12 = 0;
        while (parsableByteArray.a() > 0) {
            parsableByteArray.j(this.f20054c.d(), i11, this.f20055d);
            this.f20054c.P(0);
            int H = this.f20054c.H();
            this.f20053b.P(0);
            this.f20048a.a(this.f20053b, 4);
            this.f20048a.a(parsableByteArray, H);
            i12 = i12 + 4 + H;
        }
        this.f20048a.d(o10, i10, i12, 0, null);
        this.f20057f = true;
        return true;
    }
}
