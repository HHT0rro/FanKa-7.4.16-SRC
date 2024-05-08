package b6;

import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.build.ah;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: RtpPayloadFormat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f1340a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1341b;

    /* renamed from: c, reason: collision with root package name */
    public final Format f1342c;

    /* renamed from: d, reason: collision with root package name */
    public final ImmutableMap<String, String> f1343d;

    public h(Format format, int i10, int i11, Map<String, String> map) {
        this.f1340a = i10;
        this.f1341b = i11;
        this.f1342c = format;
        this.f1343d = ImmutableMap.copyOf((Map) map);
    }

    public static String a(String str) {
        String g3 = com.google.common.base.a.g(str);
        g3.hashCode();
        char c4 = 65535;
        switch (g3.hashCode()) {
            case -1922091719:
                if (g3.equals("MPEG4-GENERIC")) {
                    c4 = 0;
                    break;
                }
                break;
            case 64593:
                if (g3.equals("AC3")) {
                    c4 = 1;
                    break;
                }
                break;
            case 2194728:
                if (g3.equals("H264")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "audio/mp4a-latm";
            case 1:
                return "audio/ac3";
            case 2:
                return ah.f2598d;
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static boolean b(a aVar) {
        String g3 = com.google.common.base.a.g(aVar.f1280j.f1291b);
        g3.hashCode();
        char c4 = 65535;
        switch (g3.hashCode()) {
            case -1922091719:
                if (g3.equals("MPEG4-GENERIC")) {
                    c4 = 0;
                    break;
                }
                break;
            case 64593:
                if (g3.equals("AC3")) {
                    c4 = 1;
                    break;
                }
                break;
            case 2194728:
                if (g3.equals("H264")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1340a == hVar.f1340a && this.f1341b == hVar.f1341b && this.f1342c.equals(hVar.f1342c) && this.f1343d.equals(hVar.f1343d);
    }

    public int hashCode() {
        return ((((((217 + this.f1340a) * 31) + this.f1341b) * 31) + this.f1342c.hashCode()) * 31) + this.f1343d.hashCode();
    }
}
