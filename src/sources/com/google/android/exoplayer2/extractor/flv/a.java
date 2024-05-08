package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import x4.a;

/* compiled from: AudioTagPayloadReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends TagPayloadReader {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f20049e = {5512, 11025, 22050, 44100};

    /* renamed from: b, reason: collision with root package name */
    public boolean f20050b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20051c;

    /* renamed from: d, reason: collision with root package name */
    public int f20052d;

    public a(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.f20050b) {
            int D = parsableByteArray.D();
            int i10 = (D >> 4) & 15;
            this.f20052d = i10;
            if (i10 == 2) {
                this.f20048a.b(new Format.b().e0("audio/mpeg").H(1).f0(f20049e[(D >> 2) & 3]).E());
                this.f20051c = true;
            } else if (i10 == 7 || i10 == 8) {
                this.f20048a.b(new Format.b().e0(i10 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").H(1).f0(8000).E());
                this.f20051c = true;
            } else if (i10 != 10) {
                int i11 = this.f20052d;
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Audio format not supported: ");
                sb2.append(i11);
                throw new TagPayloadReader.UnsupportedFormatException(sb2.toString());
            }
            this.f20050b = true;
        } else {
            parsableByteArray.Q(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j10) throws ParserException {
        if (this.f20052d == 2) {
            int a10 = parsableByteArray.a();
            this.f20048a.a(parsableByteArray, a10);
            this.f20048a.d(j10, 1, a10, 0, null);
            return true;
        }
        int D = parsableByteArray.D();
        if (D == 0 && !this.f20051c) {
            int a11 = parsableByteArray.a();
            byte[] bArr = new byte[a11];
            parsableByteArray.j(bArr, 0, a11);
            a.b g3 = x4.a.g(bArr);
            this.f20048a.b(new Format.b().e0("audio/mp4a-latm").I(g3.f54365c).H(g3.f54364b).f0(g3.f54363a).T(Collections.singletonList(bArr)).E());
            this.f20051c = true;
            return false;
        }
        if (this.f20052d == 10 && D != 1) {
            return false;
        }
        int a12 = parsableByteArray.a();
        this.f20048a.a(parsableByteArray, a12);
        this.f20048a.d(j10, 1, a12, 0, null);
        return true;
    }
}
