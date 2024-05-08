package q6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: DolbyVisionConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f53037a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53038b;

    /* renamed from: c, reason: collision with root package name */
    public final String f53039c;

    public b(int i10, int i11, String str) {
        this.f53037a = i10;
        this.f53038b = i11;
        this.f53039c = str;
    }

    @Nullable
    public static b a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.Q(2);
        int D = parsableByteArray.D();
        int i10 = D >> 1;
        int D2 = ((parsableByteArray.D() >> 3) & 31) | ((D & 1) << 5);
        if (i10 == 4 || i10 == 5 || i10 == 7) {
            str = "dvhe";
        } else if (i10 == 8) {
            str = "hev1";
        } else {
            if (i10 != 9) {
                return null;
            }
            str = "avc3";
        }
        String str2 = D2 < 10 ? ".0" : ".";
        StringBuilder sb2 = new StringBuilder(str.length() + 24 + str2.length());
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i10);
        sb2.append(str2);
        sb2.append(D2);
        return new b(i10, D2, sb2.toString());
    }
}
