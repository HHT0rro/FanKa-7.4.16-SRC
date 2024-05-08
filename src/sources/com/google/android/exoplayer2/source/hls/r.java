package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r implements Extractor {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f21733g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f21734h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f21735a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f21736b;

    /* renamed from: d, reason: collision with root package name */
    public d5.e f21738d;

    /* renamed from: f, reason: collision with root package name */
    public int f21740f;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f21737c = new ParsableByteArray();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f21739e = new byte[1024];

    public r(@Nullable String str, f0 f0Var) {
        this.f21735a = str;
        this.f21736b = f0Var;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f21738d = eVar;
        eVar.r(new i.b(-9223372036854775807L));
    }

    public final TrackOutput c(long j10) {
        TrackOutput c4 = this.f21738d.c(0, 3);
        c4.b(new Format.b().e0("text/vtt").V(this.f21735a).i0(j10).E());
        this.f21738d.l();
        return c4;
    }

    public final void d() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f21739e);
        m6.i.e(parsableByteArray);
        long j10 = 0;
        long j11 = 0;
        for (String p10 = parsableByteArray.p(); !TextUtils.isEmpty(p10); p10 = parsableByteArray.p()) {
            if (p10.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f21733g.matcher(p10);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer(p10.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(p10) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "), null);
                }
                Matcher matcher2 = f21734h.matcher(p10);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer(p10.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(p10) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "), null);
                }
                j11 = m6.i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
                j10 = f0.f(Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1))));
            }
        }
        Matcher a10 = m6.i.a(parsableByteArray);
        if (a10 == null) {
            c(0L);
            return;
        }
        long d10 = m6.i.d((String) com.google.android.exoplayer2.util.a.e(a10.group(1)));
        long b4 = this.f21736b.b(f0.j((j10 + d10) - j11));
        TrackOutput c4 = c(b4 - d10);
        this.f21737c.N(this.f21739e, this.f21740f);
        c4.a(this.f21737c, this.f21740f);
        c4.d(b4, 1, this.f21740f, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f21738d);
        int b4 = (int) dVar.b();
        int i10 = this.f21740f;
        byte[] bArr = this.f21739e;
        if (i10 == bArr.length) {
            this.f21739e = Arrays.copyOf(bArr, ((b4 != -1 ? b4 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f21739e;
        int i11 = this.f21740f;
        int read = dVar.read(bArr2, i11, bArr2.length - i11);
        if (read != -1) {
            int i12 = this.f21740f + read;
            this.f21740f = i12;
            if (b4 == -1 || i12 != b4) {
                return 0;
            }
        }
        d();
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        dVar.l(this.f21739e, 0, 6, false);
        this.f21737c.N(this.f21739e, 6);
        if (m6.i.b(this.f21737c)) {
            return true;
        }
        dVar.l(this.f21739e, 6, 3, false);
        this.f21737c.N(this.f21739e, 9);
        return m6.i.b(this.f21737c);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
