package va;

import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final String f54063b = "RootKeyUtil";

    /* renamed from: a, reason: collision with root package name */
    public byte[] f54064a = null;

    public static d d(String str, String str2, String str3, String str4) {
        d dVar = new d();
        dVar.a(str, str2, str3, str4);
        return dVar;
    }

    public final void a(String str, String str2, String str3, String str4) {
        b(str, str2, str3, c.b(str4));
    }

    public final void b(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            f.d(f54063b, "initRootKey: sha1");
            this.f54064a = a.h(str, str2, str3, bArr, false);
        } else {
            f.d(f54063b, "initRootKey: sha256");
            this.f54064a = a.h(str, str2, str3, bArr, true);
        }
    }

    public byte[] c() {
        return (byte[]) this.f54064a.clone();
    }
}
