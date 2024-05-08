package l5;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import java.io.IOException;
import java.util.zip.ZipUtils;

/* compiled from: WavHeaderReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* compiled from: WavHeaderReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f51662a;

        /* renamed from: b, reason: collision with root package name */
        public final long f51663b;

        public a(int i10, long j10) {
            this.f51662a = i10;
            this.f51663b = j10;
        }

        public static a a(d5.d dVar, ParsableByteArray parsableByteArray) throws IOException {
            dVar.j(parsableByteArray.d(), 0, 8);
            parsableByteArray.P(0);
            return new a(parsableByteArray.n(), parsableByteArray.t());
        }
    }

    @Nullable
    public static c a(d5.d dVar) throws IOException {
        byte[] bArr;
        com.google.android.exoplayer2.util.a.e(dVar);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (a.a(dVar, parsableByteArray).f51662a != 1380533830) {
            return null;
        }
        dVar.j(parsableByteArray.d(), 0, 4);
        parsableByteArray.P(0);
        int n10 = parsableByteArray.n();
        if (n10 != 1463899717) {
            StringBuilder sb2 = new StringBuilder(36);
            sb2.append("Unsupported RIFF format: ");
            sb2.append(n10);
            m.c("WavHeaderReader", sb2.toString());
            return null;
        }
        a a10 = a.a(dVar, parsableByteArray);
        while (a10.f51662a != 1718449184) {
            dVar.q((int) a10.f51663b);
            a10 = a.a(dVar, parsableByteArray);
        }
        com.google.android.exoplayer2.util.a.g(a10.f51663b >= 16);
        dVar.j(parsableByteArray.d(), 0, 16);
        parsableByteArray.P(0);
        int v2 = parsableByteArray.v();
        int v10 = parsableByteArray.v();
        int u10 = parsableByteArray.u();
        int u11 = parsableByteArray.u();
        int v11 = parsableByteArray.v();
        int v12 = parsableByteArray.v();
        int i10 = ((int) a10.f51663b) - 16;
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            dVar.j(bArr2, 0, i10);
            bArr = bArr2;
        } else {
            bArr = j0.f22995f;
        }
        return new c(v2, v10, u10, u11, v11, v12, bArr);
    }

    public static Pair<Long, Long> b(d5.d dVar) throws IOException {
        com.google.android.exoplayer2.util.a.e(dVar);
        dVar.m();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        a a10 = a.a(dVar, parsableByteArray);
        while (true) {
            int i10 = a10.f51662a;
            if (i10 != 1684108385) {
                if (i10 != 1380533830 && i10 != 1718449184) {
                    StringBuilder sb2 = new StringBuilder(39);
                    sb2.append("Ignoring unknown WAV chunk: ");
                    sb2.append(i10);
                    m.h("WavHeaderReader", sb2.toString());
                }
                long j10 = a10.f51663b + 8;
                int i11 = a10.f51662a;
                if (i11 == 1380533830) {
                    j10 = 12;
                }
                if (j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                    dVar.r((int) j10);
                    a10 = a.a(dVar, parsableByteArray);
                } else {
                    StringBuilder sb3 = new StringBuilder(51);
                    sb3.append("Chunk is too large (~2GB+) to skip; id: ");
                    sb3.append(i11);
                    throw ParserException.createForUnsupportedContainerFeature(sb3.toString());
                }
            } else {
                dVar.r(8);
                long position = dVar.getPosition();
                long j11 = a10.f51663b + position;
                long b4 = dVar.b();
                if (b4 != -1 && j11 > b4) {
                    StringBuilder sb4 = new StringBuilder(69);
                    sb4.append("Data exceeds input length: ");
                    sb4.append(j11);
                    sb4.append(", ");
                    sb4.append(b4);
                    m.h("WavHeaderReader", sb4.toString());
                    j11 = b4;
                }
                return Pair.create(Long.valueOf(position), Long.valueOf(j11));
            }
        }
    }
}
