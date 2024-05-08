package b5;

import com.google.android.exoplayer2.util.j0;
import java.util.UUID;

/* compiled from: FrameworkMediaCrypto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w implements v {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1264d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f1265a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1266b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1267c;

    static {
        boolean z10;
        if ("Amazon".equals(j0.f22992c)) {
            String str = j0.f22993d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z10 = true;
                f1264d = z10;
            }
        }
        z10 = false;
        f1264d = z10;
    }

    public w(UUID uuid, byte[] bArr, boolean z10) {
        this.f1265a = uuid;
        this.f1266b = bArr;
        this.f1267c = z10;
    }
}
