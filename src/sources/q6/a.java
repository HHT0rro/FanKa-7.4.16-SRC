package q6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AvcConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f53031a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53032b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53033c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53034d;

    /* renamed from: e, reason: collision with root package name */
    public final float f53035e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f53036f;

    public a(List<byte[]> list, int i10, int i11, int i12, float f10, @Nullable String str) {
        this.f53031a = list;
        this.f53032b = i10;
        this.f53033c = i11;
        this.f53034d = i12;
        this.f53035e = f10;
        this.f53036f = str;
    }

    public static byte[] a(ParsableByteArray parsableByteArray) {
        int J = parsableByteArray.J();
        int e2 = parsableByteArray.e();
        parsableByteArray.Q(J);
        return com.google.android.exoplayer2.util.c.d(parsableByteArray.d(), e2, J);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a b(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        int i10;
        float f10;
        try {
            parsableByteArray.Q(4);
            int D = (parsableByteArray.D() & 3) + 1;
            if (D != 3) {
                ArrayList arrayList = new ArrayList();
                int D2 = parsableByteArray.D() & 31;
                for (int i11 = 0; i11 < D2; i11++) {
                    arrayList.add(a(parsableByteArray));
                }
                int D3 = parsableByteArray.D();
                for (int i12 = 0; i12 < D3; i12++) {
                    arrayList.add(a(parsableByteArray));
                }
                int i13 = -1;
                if (D2 > 0) {
                    NalUnitUtil.SpsData i14 = NalUnitUtil.i((byte[]) arrayList.get(0), D, ((byte[]) arrayList.get(0)).length);
                    int i15 = i14.width;
                    int i16 = i14.height;
                    float f11 = i14.pixelWidthAspectRatio;
                    str = com.google.android.exoplayer2.util.c.a(i14.profileIdc, i14.constraintsFlagsAndReservedZero2Bits, i14.levelIdc);
                    i13 = i15;
                    i10 = i16;
                    f10 = f11;
                } else {
                    str = null;
                    i10 = -1;
                    f10 = 1.0f;
                }
                return new a(arrayList, D, i13, i10, f10, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e2);
        }
    }
}
