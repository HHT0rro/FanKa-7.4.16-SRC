package d5;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;

/* compiled from: FlacFrameReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* compiled from: FlacFrameReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f48636a;
    }

    public static boolean a(ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.g gVar, int i10) {
        int j10 = j(parsableByteArray, i10);
        return j10 != -1 && j10 <= gVar.f20060b;
    }

    public static boolean b(ParsableByteArray parsableByteArray, int i10) {
        return parsableByteArray.D() == j0.v(parsableByteArray.d(), i10, parsableByteArray.e() - 1, 0);
    }

    public static boolean c(ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.g gVar, boolean z10, a aVar) {
        try {
            long K = parsableByteArray.K();
            if (!z10) {
                K *= gVar.f20060b;
            }
            aVar.f48636a = K;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.g gVar, int i10, a aVar) {
        int e2 = parsableByteArray.e();
        long F = parsableByteArray.F();
        long j10 = F >>> 16;
        if (j10 != i10) {
            return false;
        }
        return g((int) (15 & (F >> 4)), gVar) && f((int) ((F >> 1) & 7), gVar) && !(((F & 1) > 1L ? 1 : ((F & 1) == 1L ? 0 : -1)) == 0) && c(parsableByteArray, gVar, ((j10 & 1) > 1L ? 1 : ((j10 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(parsableByteArray, gVar, (int) ((F >> 12) & 15)) && e(parsableByteArray, gVar, (int) ((F >> 8) & 15)) && b(parsableByteArray, e2);
    }

    public static boolean e(ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.g gVar, int i10) {
        int i11 = gVar.f20063e;
        if (i10 == 0) {
            return true;
        }
        if (i10 <= 11) {
            return i10 == gVar.f20064f;
        }
        if (i10 == 12) {
            return parsableByteArray.D() * 1000 == i11;
        }
        if (i10 > 14) {
            return false;
        }
        int J = parsableByteArray.J();
        if (i10 == 14) {
            J *= 10;
        }
        return J == i11;
    }

    public static boolean f(int i10, com.google.android.exoplayer2.extractor.g gVar) {
        return i10 == 0 || i10 == gVar.f20067i;
    }

    public static boolean g(int i10, com.google.android.exoplayer2.extractor.g gVar) {
        return i10 <= 7 ? i10 == gVar.f20065g - 1 : i10 <= 10 && gVar.f20065g == 2;
    }

    public static boolean h(d dVar, com.google.android.exoplayer2.extractor.g gVar, int i10, a aVar) throws IOException {
        long o10 = dVar.o();
        byte[] bArr = new byte[2];
        dVar.j(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
            dVar.m();
            dVar.q((int) (o10 - dVar.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy((Object) bArr, 0, (Object) parsableByteArray.d(), 0, 2);
        parsableByteArray.O(f.c(dVar, parsableByteArray.d(), 2, 14));
        dVar.m();
        dVar.q((int) (o10 - dVar.getPosition()));
        return d(parsableByteArray, gVar, i10, aVar);
    }

    public static long i(d dVar, com.google.android.exoplayer2.extractor.g gVar) throws IOException {
        dVar.m();
        dVar.q(1);
        byte[] bArr = new byte[1];
        dVar.j(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        dVar.q(2);
        int i10 = z10 ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        parsableByteArray.O(f.c(dVar, parsableByteArray.d(), 0, i10));
        dVar.m();
        a aVar = new a();
        if (c(parsableByteArray, gVar, z10, aVar)) {
            return aVar.f48636a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(ParsableByteArray parsableByteArray, int i10) {
        switch (i10) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT << (i10 - 2);
            case 6:
                return parsableByteArray.D() + 1;
            case 7:
                return parsableByteArray.J() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }
}
