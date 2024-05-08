package c6;

import androidx.annotation.Nullable;
import b6.h;
import com.alibaba.security.biometrics.service.build.ah;

/* compiled from: DefaultRtpPayloadReaderFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    @Nullable
    public e a(h hVar) {
        String str = (String) com.google.android.exoplayer2.util.a.e(hVar.f1342c.f19544m);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c4 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(ah.f2598d)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new b(hVar);
            case 1:
                return new c(hVar);
            case 2:
                return new d(hVar);
            default:
                return null;
        }
    }
}
