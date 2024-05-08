package kc;

import android.text.TextUtils;
import com.xiaomi.push.p0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static long f50817a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f50818b = "";

    public static String a() {
        if (TextUtils.isEmpty(f50818b)) {
            f50818b = p0.a(4);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f50818b);
        long j10 = f50817a;
        f50817a = 1 + j10;
        sb2.append(j10);
        return sb2.toString();
    }
}
