package x4;

import com.google.android.exoplayer2.util.j0;

/* compiled from: WavUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y {
    public static int a(int i10, int i11) {
        if (i10 != 1) {
            if (i10 == 3) {
                return i11 == 32 ? 4 : 0;
            }
            if (i10 != 65534) {
                return 0;
            }
        }
        return j0.Y(i11);
    }
}
