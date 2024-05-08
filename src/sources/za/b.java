package za;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f55041a;

    public static Context a() {
        return f55041a;
    }

    public static void b(Context context) {
        if (context == null || f55041a != null) {
            return;
        }
        f55041a = context.getApplicationContext();
    }
}
