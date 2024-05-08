package d5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: ExtractorUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {
    public static void a(boolean z10, @Nullable String str) throws ParserException {
        if (!z10) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean b(d dVar, byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        try {
            return dVar.l(bArr, i10, i11, z10);
        } catch (EOFException e2) {
            if (z10) {
                return false;
            }
            throw e2;
        }
    }

    public static int c(d dVar, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int h10 = dVar.h(bArr, i10 + i12, i11 - i12);
            if (h10 == -1) {
                break;
            }
            i12 += h10;
        }
        return i12;
    }

    public static boolean d(d dVar, byte[] bArr, int i10, int i11) throws IOException {
        try {
            dVar.readFully(bArr, i10, i11);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(d dVar, int i10) throws IOException {
        try {
            dVar.r(i10);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
