package q6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* compiled from: HevcConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<byte[]> f53054a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53055b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f53056c;

    public d(@Nullable List<byte[]> list, int i10, @Nullable String str) {
        this.f53054a = list;
        this.f53055b = i10;
        this.f53056c = str;
    }

    public static d a(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.Q(21);
            int D = parsableByteArray.D() & 3;
            int D2 = parsableByteArray.D();
            int e2 = parsableByteArray.e();
            int i10 = 0;
            for (int i11 = 0; i11 < D2; i11++) {
                parsableByteArray.Q(1);
                int J = parsableByteArray.J();
                for (int i12 = 0; i12 < J; i12++) {
                    int J2 = parsableByteArray.J();
                    i10 += J2 + 4;
                    parsableByteArray.Q(J2);
                }
            }
            parsableByteArray.P(e2);
            byte[] bArr = new byte[i10];
            String str = null;
            int i13 = 0;
            for (int i14 = 0; i14 < D2; i14++) {
                int D3 = parsableByteArray.D() & 127;
                int J3 = parsableByteArray.J();
                for (int i15 = 0; i15 < J3; i15++) {
                    int J4 = parsableByteArray.J();
                    byte[] bArr2 = NalUnitUtil.f22925a;
                    System.arraycopy((Object) bArr2, 0, (Object) bArr, i13, bArr2.length);
                    int length = i13 + bArr2.length;
                    System.arraycopy((Object) parsableByteArray.d(), parsableByteArray.e(), (Object) bArr, length, J4);
                    if (D3 == 33 && i15 == 0) {
                        str = com.google.android.exoplayer2.util.c.c(new com.google.android.exoplayer2.util.v(bArr, length, length + J4));
                    }
                    i13 = length + J4;
                    parsableByteArray.Q(J4);
                }
            }
            return new d(i10 == 0 ? null : Collections.singletonList(bArr), D + 1, str);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e10);
        }
    }
}
