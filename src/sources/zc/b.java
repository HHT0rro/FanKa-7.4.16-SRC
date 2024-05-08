package zc;

import com.wangmai.appsdkdex.crypt.StringFogImpl;

/* compiled from: StringFog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final StringFogImpl f55052a = new StringFogImpl();

    public static String a(String str) {
        return f55052a.decrypt(str, "WM");
    }
}
