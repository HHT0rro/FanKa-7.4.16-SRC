package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.ObjectStreamConstants;
import java.util.Arrays;
import okio.Utf8;
import x4.w;

/* compiled from: OpusReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g extends StreamReader {

    /* renamed from: o, reason: collision with root package name */
    public static final byte[] f20319o = {79, 112, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_OBJECT, 72, 101, 97, 100};

    /* renamed from: n, reason: collision with root package name */
    public boolean f20320n;

    public static boolean o(ParsableByteArray parsableByteArray) {
        int a10 = parsableByteArray.a();
        byte[] bArr = f20319o;
        if (a10 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.j(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long f(ParsableByteArray parsableByteArray) {
        return c(n(parsableByteArray.d()));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(ParsableByteArray parsableByteArray, long j10, StreamReader.SetupData setupData) {
        if (!this.f20320n) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f());
            setupData.format = new Format.b().e0("audio/opus").H(w.c(copyOf)).f0(48000).T(w.a(copyOf)).E();
            this.f20320n = true;
            return true;
        }
        com.google.android.exoplayer2.util.a.e(setupData.format);
        boolean z10 = parsableByteArray.n() == 1332770163;
        parsableByteArray.P(0);
        return z10;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f20320n = false;
        }
    }

    public final long n(byte[] bArr) {
        int i10 = bArr[0] & 255;
        int i11 = i10 & 3;
        int i12 = 2;
        if (i11 == 0) {
            i12 = 1;
        } else if (i11 != 1 && i11 != 2) {
            i12 = bArr[1] & Utf8.REPLACEMENT_BYTE;
        }
        int i13 = i10 >> 3;
        return i12 * (i13 >= 16 ? 2500 << r1 : i13 >= 12 ? 10000 << (r1 & 1) : (i13 & 3) == 3 ? 60000 : 10000 << r1);
    }
}
